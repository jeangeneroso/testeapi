package com.example.corretora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public enum AppConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}

}
