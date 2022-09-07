package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.example.config.beans.DataSource;

@Configuration
@PropertySource("application.properties")
@Import(AppExternalBeans.class)
public class ApplicationBeansConfig {
	
	@Value("${db.type}")
	private String dbType;
	
	@Bean
	public DataSource getDataSource() {
		
		DataSource dataSource = new DataSource();
		dataSource.setUsername("testDB");
		dataSource.setPassword("testDbPassword");
		dataSource.setDbType(dbType);
		
		return dataSource;
	}
	
	
	
}
