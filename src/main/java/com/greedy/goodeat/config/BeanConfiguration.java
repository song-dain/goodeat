package com.greedy.goodeat.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.greedy.goodeat"})
@EnableJpaRepositories(basePackages = "com.greedy.goodeat")

public class BeanConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

}
