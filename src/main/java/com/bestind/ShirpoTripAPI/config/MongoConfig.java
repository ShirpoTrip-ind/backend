package com.bestind.ShirpoTripAPI.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    @Value("${database.mongo.scheme}")
    private String mongoScheme;
  
    private static final Logger fileLogger = LoggerFactory.getLogger(MongoConfig.class);

    String connectionString = "mongodb://AYUd65aef78BYVndug45SAFbuw8dwYG78JBSV267:MbvtVYvyt4516789IJhsyfSBUihysfqwYF6s78st7@80.76.60.28:27017";
    ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(connectionString))
            .serverApi(serverApi)
            .build();
    @Bean
    MongoClient mongoClient() {
        return MongoClients.create(settings);
    }

    @Bean
    MongoTemplate mongoTemplate(MongoClient mongoClient) {
        if (mongoScheme.equals("prod")) {
            fileLogger.info("Connected to prod database");
            return new MongoTemplate(mongoClient, "shirpotrip");
        }
        fileLogger.info("Connected to test database");
        return new MongoTemplate(mongoClient, "shirpotrip-test");
    }
}