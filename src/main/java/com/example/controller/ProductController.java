package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductDTO;
import com.example.service.ProductService;

@RestController
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// Rest client - ARC, postman   // /product//newProduct
	@PostMapping(value = "/newProduct", consumes = "application/json")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO){
		
		System.out.println(productDTO);
	
		String response = "product is save with id : "+productDTO.getProductId();
		
		/*
		 * if(true) { throw new NullPointerException("test"); }
		 */
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
		
	}

}
