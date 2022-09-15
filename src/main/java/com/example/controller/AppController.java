package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DemoController;
import com.example.config.beans.DataSource;

@RestController
public class AppController {
	
	/*
	@Autowired
	private DataSource dataSource1;
	
	@Autowired
	private DataSource dataSource2;
	
	@Autowired
	private DemoController demoController;
	
	
	@GetMapping("/dbInfo")
	public DataSource getDBInfo(){
		
		if(dataSource1 == dataSource2) {
			System.out.println("both are equal.");
		}
		
		return dataSource1;
	}
	*/

}
