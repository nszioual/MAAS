package eu.arrowhead.repository.manager.service;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.dto.TransformationDTO;
import eu.arrowhead.api.commons.dto.TransformationListDTO;
import eu.arrowhead.client.library.ArrowheadService;
import eu.arrowhead.common.SSLProperties;
import eu.arrowhead.common.dto.shared.*;
import eu.arrowhead.common.exception.ArrowheadException;
import eu.arrowhead.common.exception.InvalidParameterException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowAutomationDriver {

    private final Logger logger = LogManager.getLogger(ProcessTransformationService.class);

    private final ArrowheadService arrowheadService;

    protected SSLProperties sslProperties;

    @Autowired
    public WorkflowAutomationDriver(ArrowheadService arrowheadService, SSLProperties sslProperties) {
        this.arrowheadService = arrowheadService;
        this.sslProperties = sslProperties;
    }

    public List<TransformationDTO> getProcessModels(final String format) {
        final OrchestrationResultDTO orchestrationResult = orchestrate(ApiConstants.MODEL_TRANSFORMER_SERVICE);
        return consumeTransformationService(orchestrationResult, format).getTransformations();
    }

    private OrchestrationResultDTO orchestrate(String serviceDefinition) {
        final ServiceQueryFormDTO serviceQueryForm = new ServiceQueryFormDTO.Builder(serviceDefinition)
                .interfaces(getInterface())
                .build();

        final OrchestrationFormRequestDTO.Builder orchestrationFormBuilder = arrowheadService.getOrchestrationFormBuilder();
        final OrchestrationFormRequestDTO orchestrationFormRequest = orchestrationFormBuilder.requestedService(serviceQueryForm)
                .flag(OrchestrationFlags.Flag.MATCHMAKING, true)
                .flag(OrchestrationFlags.Flag.OVERRIDE_STORE, true)
                .build();

        final OrchestrationResponseDTO orchestrationResponse = arrowheadService.proceedOrchestration(orchestrationFormRequest);

        if (orchestrationResponse == null) {
            logger.info("No orchestration response received");
        } else if (orchestrationResponse.getResponse().isEmpty()) {
            logger.info("No provider found during the orchestration");
        } else {
            final OrchestrationResultDTO orchestrationResult = orchestrationResponse.getResponse().get(0);
            validateOrchestrationResult(orchestrationResult, serviceDefinition);
            return orchestrationResult;
        }
        throw new ArrowheadException("Unsuccessful orchestration: " + serviceDefinition);
    }

    private TransformationListDTO consumeTransformationService(OrchestrationResultDTO orchestrationResult, String format) {
        final String token = orchestrationResult.getAuthorizationTokens() == null ? null : orchestrationResult.getAuthorizationTokens().get(getInterface());
        final String[] queryParam = {orchestrationResult.getMetadata().get(ApiConstants.REQUEST_PARAM_KEY_FORMAT), String.valueOf(format)};
        return arrowheadService.consumeServiceHTTP(TransformationListDTO.class, HttpMethod.valueOf(orchestrationResult.getMetadata().get(ApiConstants.HTTP_METHOD)),
                orchestrationResult.getProvider().getAddress(), orchestrationResult.getProvider().getPort(), orchestrationResult.getServiceUri(),
                getInterface(), token, null, queryParam);
    }

    private String getInterface() {
        return sslProperties.isSslEnabled() ? ApiConstants.INTERFACE_SECURE : ApiConstants.INTERFACE_INSECURE;
    }

    private void validateOrchestrationResult(final OrchestrationResultDTO orchestrationResult, final String serviceDefinition) {
        if (!orchestrationResult.getService().getServiceDefinition().equalsIgnoreCase(serviceDefinition)) {
            throw new InvalidParameterException("Requested and orchestrated service definition do not match");
        }

        boolean hasValidInterface = false;
        for (final ServiceInterfaceResponseDTO serviceInterface : orchestrationResult.getInterfaces()) {
            if (serviceInterface.getInterfaceName().equalsIgnoreCase(getInterface())) {
                hasValidInterface = true;
                break;
            }
        }
        if (!hasValidInterface) {
            throw new InvalidParameterException("Requested and orchestrated interface do not match");
        }
    }
}
