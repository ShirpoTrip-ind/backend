package com.bestind.ShirpoTripAPI.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class MapperConfig {
    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;
    @Bean
    ObjectMapper mapper() {
        final ObjectMapper objectMapper = mapperBuilder.build();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        return objectMapper;
    }
}
