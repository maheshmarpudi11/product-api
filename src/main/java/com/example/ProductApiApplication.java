package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.ApplicationBeansConfig;
import com.example.config.beans.DataSource;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Product API", version = "1.0", description = "Product Information"))
public class ProductApiApplication  implements CommandLineRunner
{
	static Logger logger = LoggerFactory.getLogger(ProductApiApplication.class);
	
	public static void main(String[] args) {
		System.out.println("Application starts..");
		logger.info("ProductApiApplication -> main method : starts");
		
		SpringApplication.run(ProductApiApplication.class, args);
		logger.info("ProductApiApplication -> main method : ends");
	}

	
	// field based injection
	/*@Autowired
	  private DataSource dataSource1;
	*/
	
	
	//using constructor injection
	
	 private DataSource dataSource1;
	 
	 public ProductApiApplication(DataSource dataSource) {
		this.dataSource1 = dataSource;
	 }
	 
	
	// using setter method.
	
	  private DataSource dataSource;
	  
	  @Autowired 
	  public void setDataSource(DataSource dataSource) { 
		  this.dataSource = dataSource; 
	  }
	  
	  @Autowired 
	  private String env;
	 	 
	 
	@Override
	public void run(String... args) throws Exception {
		System.out.println("=================> run method..");
	    //System.out.println(dataSource);
		
	//	System.out.println("========>" +env);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationBeansConfig.class);
		DataSource dataSource1 = context.getBean(DataSource.class);
		DataSource dataSource2 = context.getBean(DataSource.class);
		System.out.println(dataSource1.toString());
		System.out.println(dataSource2.toString());
		
	}
	
}
