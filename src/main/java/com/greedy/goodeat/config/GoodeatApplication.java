package com.greedy.goodeat.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.greedy.goodeat"})
public class GoodeatApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodeatApplication.class, args);
	}

}
