package eu.arrowhead.model.filter.provider;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.common.dto.shared.ServiceRegistryRequestDTO;
import eu.arrowhead.common.dto.shared.ServiceSecurityType;
import eu.arrowhead.common.dto.shared.SystemRequestDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import eu.arrowhead.client.library.ArrowheadService;
import eu.arrowhead.client.library.config.ApplicationInitListener;
import eu.arrowhead.client.library.util.ClientCommonConstants;
import eu.arrowhead.model.filter.provider.security.FilterProviderSecurityConfig;
import eu.arrowhead.common.CommonConstants;
import eu.arrowhead.common.Utilities;
import eu.arrowhead.common.core.CoreSystem;
import eu.arrowhead.common.exception.ArrowheadException;

@Component
public class FilterProviderApplicationInitListener extends ApplicationInitListener {

    //=================================================================================================
    // members

    private final Logger logger = LogManager.getLogger(FilterProviderApplicationInitListener.class);

    @Autowired
    private ArrowheadService arrowheadService;

    @Autowired
    private FilterProviderSecurityConfig filterProviderSecurityConfig;

    @Value(ClientCommonConstants.$TOKEN_SECURITY_FILTER_ENABLED_WD)
    private boolean tokenSecurityFilterEnabled;

    @Value(CommonConstants.$SERVER_SSL_ENABLED_WD)
    private boolean sslEnabled;

    @Value(ClientCommonConstants.$CLIENT_SYSTEM_NAME)
    private String mySystemName;

    @Value(ClientCommonConstants.$CLIENT_SERVER_ADDRESS_WD)
    private String mySystemAddress;

    @Value(ClientCommonConstants.$CLIENT_SERVER_PORT_WD)
    private int mySystemPort;

    //=================================================================================================
    // methods

    //-------------------------------------------------------------------------------------------------
    @Override
    protected void customInit(final ContextRefreshedEvent event) {

        //Checking the availability of necessary core systems
        checkCoreSystemReachability(CoreSystem.SERVICE_REGISTRY);
        if (sslEnabled && tokenSecurityFilterEnabled) {
            checkCoreSystemReachability(CoreSystem.AUTHORIZATION);

            //Initialize Arrowhead Context
            arrowheadService.updateCoreServiceURIs(CoreSystem.AUTHORIZATION);

            setTokenSecurityFilter();

        } else {
            logger.info("TokenSecurityFilter in not active");
        }

        checkCoreSystemReachability(CoreSystem.ORCHESTRATOR);
        arrowheadService.updateCoreServiceURIs(CoreSystem.ORCHESTRATOR);

        final ServiceRegistryRequestDTO filterService = createServiceRegistryRequest(ApiConstants.MODEL_FILTER_SERVICE, ApiConstants.MODEL_FILTER_URI, HttpMethod.GET);
        arrowheadService.forceRegisterServiceToServiceRegistry(filterService);
        logger.info("Service registered: {}", ApiConstants.MODEL_FILTER_SERVICE);
    }

    //-------------------------------------------------------------------------------------------------
    @Override
    public void customDestroy() {
        arrowheadService.unregisterServiceFromServiceRegistry(ApiConstants.MODEL_FILTER_SERVICE);
        logger.info("Service unregistered: {}", ApiConstants.MODEL_FILTER_SERVICE);
    }

    //=================================================================================================
    // assistant methods

    //-------------------------------------------------------------------------------------------------
    private void setTokenSecurityFilter() {
        final PublicKey authorizationPublicKey = arrowheadService.queryAuthorizationPublicKey();
        if (authorizationPublicKey == null) {
            throw new ArrowheadException("Authorization public key is null");
        }

        KeyStore keystore;
        try {
            keystore = KeyStore.getInstance(sslProperties.getKeyStoreType());
            keystore.load(sslProperties.getKeyStore().getInputStream(), sslProperties.getKeyStorePassword().toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException ex) {
            throw new ArrowheadException(ex.getMessage());
        }
        final PrivateKey providerPrivateKey = Utilities.getPrivateKey(keystore, sslProperties.getKeyPassword());

        filterProviderSecurityConfig.getTokenSecurityFilter().setAuthorizationPublicKey(authorizationPublicKey);
        filterProviderSecurityConfig.getTokenSecurityFilter().setMyPrivateKey(providerPrivateKey);
    }

    private ServiceRegistryRequestDTO createServiceRegistryRequest(final String serviceDefinition, final String serviceUri, final HttpMethod httpMethod) {
        final ServiceRegistryRequestDTO serviceRegistryRequest = new ServiceRegistryRequestDTO();
        serviceRegistryRequest.setServiceDefinition(serviceDefinition);
        final SystemRequestDTO systemRequest = new SystemRequestDTO();
        systemRequest.setSystemName(mySystemName);
        systemRequest.setAddress(mySystemAddress);
        systemRequest.setPort(mySystemPort);

        if (tokenSecurityFilterEnabled) {
            systemRequest.setAuthenticationInfo(Base64.getEncoder().encodeToString(arrowheadService.getMyPublicKey().getEncoded()));
            serviceRegistryRequest.setSecure(ServiceSecurityType.TOKEN);
            serviceRegistryRequest.setInterfaces(List.of(ApiConstants.INTERFACE_INSECURE));
        } else if (sslEnabled) {
            systemRequest.setAuthenticationInfo(Base64.getEncoder().encodeToString(arrowheadService.getMyPublicKey().getEncoded()));
            serviceRegistryRequest.setSecure(ServiceSecurityType.CERTIFICATE);
            serviceRegistryRequest.setInterfaces(List.of(ApiConstants.INTERFACE_INSECURE));
        } else {
            serviceRegistryRequest.setSecure(ServiceSecurityType.NOT_SECURE);
            serviceRegistryRequest.setInterfaces(List.of(ApiConstants.INTERFACE_INSECURE));
        }
        serviceRegistryRequest.setProviderSystem(systemRequest);
        serviceRegistryRequest.setServiceUri(serviceUri);
        serviceRegistryRequest.setMetadata(new HashMap<>());
        serviceRegistryRequest.getMetadata().put("http-method", httpMethod.name());
        return serviceRegistryRequest;
    }
}
