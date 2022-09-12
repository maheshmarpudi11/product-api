package com.example.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

//@Component


/*@RestController   // rest api controller ( reques/ res)
@Service          // service logics 
@Repository
@ControllerAdvice
@Controller
@Configuration*/

// verifyLoan -- exisitng loan, cbil, local or non-local, business man/ salaries -- user is 

public class ProductService {

	public void getProducts(){
		
		System.out.println("productService --> getProducts()");
	}

}
