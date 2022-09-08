package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.example.config.beans.DataSource;

//@Profile("dev")
@Configuration
@PropertySource({"application-dev.properties","application.properties"})
@Import(AppExternalBeans.class)
@ComponentScan(basePackages = "com.app")
public class ApplicationBeansConfig {
	
	@Value("${db.type}")
	private String dbType;
	
	@Scope(scopeName = "prototype")
	@Bean
	public DataSource getDataSource() {
		
		DataSource dataSource = new DataSource();
		dataSource.setUsername("testDB");
		dataSource.setPassword("testDbPassword");
		dataSource.setDbType(dbType);
		
		return dataSource;
	}
	
	
	
}
