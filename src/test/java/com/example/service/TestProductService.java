package com.example.service;

import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dto.ProductDTO;
import com.example.repository.ProductRepo;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestProductService {
	
	@InjectMocks
	private ProductService productService;
	
	@Mock
	private ProductRepo productRepo;

	public ProductDTO requestProductDTO;
	
	public ProductDTO responseProductDTO;
	
	@Before
	public void init() {
		requestProductDTO = new ProductDTO();
		requestProductDTO.setProductCost("1000");
		requestProductDTO.setProductCount(3);
		requestProductDTO.setProductDesc("test product");
		requestProductDTO.setProductName("test");
		
		responseProductDTO = new ProductDTO();
		responseProductDTO.setProductId(001);
		responseProductDTO.setProductCost("1000");
		responseProductDTO.setProductCount(3);
		responseProductDTO.setProductDesc("test product");
		responseProductDTO.setProductName("test");
		
	}
	
	@Test
	public void createProductTest() {
		when(productRepo.save(requestProductDTO)).thenReturn(responseProductDTO); // mock 
		Integer repsonse = productService.createProduct(requestProductDTO);
		
		Assert.assertEquals(Integer.valueOf(001), repsonse);
		
	}
	
	@After
	public void destroy() {
		requestProductDTO = null;
		responseProductDTO = null;
	}
}
