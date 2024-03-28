package com.bestind.ShirpoTripAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class ShirpoTripApiApplication {
	private static final Logger fileLogger = LoggerFactory.getLogger(ShirpoTripApiApplication.class);

	public static void main(String[] args) {
		fileLogger.info("Начинаем ширпотрипить...");
		SpringApplication.run(ShirpoTripApiApplication.class, args);
		fileLogger.info("Наширпотрипились, расходик");
	}
}
