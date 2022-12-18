package com.chary.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class HolidaySchedulingWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolidaySchedulingWithMongoDbApplication.class, args);
	}

}
