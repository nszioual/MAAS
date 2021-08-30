package eu.arrowhead.api.commons.config;

import eu.arrowhead.api.commons.mapper.MetadataDTOMapperImpl;
import eu.arrowhead.api.commons.mapper.ModelDTOMapperImpl;
import eu.arrowhead.api.commons.mapper.TransformationDTOMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappingConfig {
    @Bean
    public ModelDTOMapperImpl modelDTOMapper() {
        return new ModelDTOMapperImpl();
    }

    @Bean
    public MetadataDTOMapperImpl metadataDTOMapper() {
        return new MetadataDTOMapperImpl();
    }

    @Bean
    public TransformationDTOMapperImpl transformationDTOMapper() {
        return new TransformationDTOMapperImpl();
    }
}
