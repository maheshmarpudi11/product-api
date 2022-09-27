package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/com/example/properties/env.properties")
public class AppExternalBeans {
	
	@Value("${app.env}")
	private String environment;

	@Bean("env")
	public String getValue() {
		return environment;
	}
	
}
