package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ProductService;

@RestController
@RequestMapping("/product/")
public class ProductController {
	
	@Lazy
	@Autowired
	private ProductService productService;
	
	//@GetMapping("/")
	public void getProducts(){
		
		productService.getProducts();  // null pointer exception
	}

}
