package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductDTO;
import com.example.service.ProductService;

import lombok.experimental.PackagePrivate;

@RestController
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// Rest client - ARC, postman   // /product//newProduct
	@PostMapping(value = "/newProduct", consumes = "application/json")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO){
		
		System.out.println(productDTO);
		
		
		Integer productId = productService.createProduct(productDTO);
	
		String response = "product is save with id : "+productId;
		
		/*
		 * if(true) { throw new NullPointerException("test"); }
		 */
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
		
	}

	@GetMapping(value="/products" , produces  = "application/json")
	public List getAllProducts(){
		
		List products = productService.getAllProducts();
		
		return products;
	}
	
	
	@PutMapping(value = "/updateProduct", consumes = "application/json")
	public ResponseEntity<ProductDTO> updateProductInfo(@RequestBody ProductDTO productDTO) {
		
		ProductDTO productResponse = productService.updateProductInfo(productDTO);
		
		return new ResponseEntity<ProductDTO>(productResponse,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteProduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable(name = "id",required = false) Integer id) {
		
		String reponse = productService.deleteProduct(id);
		return new ResponseEntity<String>(reponse,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchByName/{name}")
	public ResponseEntity<List<ProductDTO>> searchProductByname(@PathVariable(name = "name") String name){
		
		List<ProductDTO> list = productService.searchProductByname(name);
		
		return new ResponseEntity<List<ProductDTO>>(list,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
