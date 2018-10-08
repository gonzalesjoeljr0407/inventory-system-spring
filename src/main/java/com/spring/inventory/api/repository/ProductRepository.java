package com.spring.inventory.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.inventory.api.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    
    @Query(value = "SELECT * FROM product WHERE product_code LIKE CONCAT('%',:productCode,'%')", nativeQuery = true)
    Iterable<Product> findByProductCode(@Param("productCode") String productCode);
    
    @Query(value = "SELECT * FROM product WHERE product_name LIKE CONCAT('%',:productName,'%')", nativeQuery = true)
    Iterable<Product> findByProductName(@Param("productName") String productName);
}
