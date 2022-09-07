package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.ApplicationBeansConfig;
import com.example.config.beans.DataSource;

@SpringBootApplication
public class ProductApiApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		System.out.println("Application starts..");
		
		SpringApplication.run(ProductApiApplication.class, args);
		
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
		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource.getUsername());
		System.out.println(dataSource1);
		
	}

}
