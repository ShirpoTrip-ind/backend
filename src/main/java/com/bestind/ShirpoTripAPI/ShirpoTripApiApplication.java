package com.bestind.ShirpoTripAPI;

import com.bestind.ShirpoTripAPI.config.ZonedDateTimeReadConverter;
import com.bestind.ShirpoTripAPI.config.ZonedDateTimeWriteConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableMongoRepositories
public class ShirpoTripApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShirpoTripApiApplication.class, args);
	}
}
