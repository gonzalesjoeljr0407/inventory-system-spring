package com.spring.inventory.api.service;

import java.util.List;

import com.spring.inventory.api.model.response.ProductResponse;

public interface ProductService {
    
    public List<ProductResponse> getAllProduct();
    
    public List<ProductResponse> findByProductCode(String productCode);
    
    public List<ProductResponse> findByProductName(String productName);
}
