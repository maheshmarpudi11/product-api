package com.example.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.dto.ProductDTO;
import com.example.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class TestProductController {

	@Autowired
	public MockMvc mockMvc;
	
	@MockBean
	public ProductService productService;
	
	public ProductDTO requestProductDTO;
	
	@Before
	public void init() {
		
		requestProductDTO = new ProductDTO();
		requestProductDTO.setProductCost("1000");
		requestProductDTO.setProductCount(3);
		requestProductDTO.setProductDesc("test product");
		requestProductDTO.setProductName("test");
		
	}
	
	@Test
	public void createProductTest() throws Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/product/newProduct")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(requestProductDTO))
				.header("Authorization", "Basic YWRtaW46YWRtaW4=");
		
		
		
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
		
        Integer actualResponseStatus = mvcResult.getResponse().getStatus();
		
		Assert.assertEquals(Integer.valueOf(201), actualResponseStatus);
			
	}
	
	@After
	public void destroy() {
		
		requestProductDTO = null;
	}
	
}
