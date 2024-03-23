package com.bestind.ShirpoTripAPI.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    @Bean
    MongoClient mongoClient() {
        return MongoClients.create();
    }

    @Bean
    MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "shirpotrip");
    }
    @Bean
    MongoTemplate mongoTemplate(MongoClient mongoClient) {
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(factory), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "shirpotrip");
        mongoTemplate.setConverter(converter);

        return mongoTemplate;
    }

}