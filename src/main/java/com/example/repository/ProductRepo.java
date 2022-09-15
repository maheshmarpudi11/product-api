package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.ProductDTO;

@Repository
public interface ProductRepo extends CrudRepository<ProductDTO,Integer>{

}
