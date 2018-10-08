package com.spring.inventory.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.inventory.api.model.ProductType;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long>{
}
