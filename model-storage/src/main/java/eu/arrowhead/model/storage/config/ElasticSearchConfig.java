package eu.arrowhead.model.storage.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "eu.arrowhead.model.storage.repository")
@EnableElasticsearchAuditing
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Value("${elastic_search_address}")
    private String elasticSearchAddress;

    @Value("${elastic_search_port}")
    private String elasticSearchPort;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticSearchAddress + ":" + elasticSearchPort)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
