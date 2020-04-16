package com.example.statements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StatementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatementsApplication.class, args);
	}

}
