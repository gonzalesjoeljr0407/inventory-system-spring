package com.spring.inventory.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.inventory.api.mapper.response.ProductResponseMapper;
import com.spring.inventory.api.model.Product;
import com.spring.inventory.api.model.response.ProductResponse;
import com.spring.inventory.api.repository.ProductRepository;
import com.spring.inventory.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    
    private ProductRepository productRepository;
    private ProductResponseMapper responseMapper;
    
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductResponseMapper responseMapper) {
        this.productRepository = productRepository;
        this.responseMapper = responseMapper;
    }
    
    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> products = new ArrayList<>();
        
        this.productRepository.findAll().forEach(products::add);
        
        return responseMapper.mapResponseList(products);
    }
    
    @Override
    public List<ProductResponse> findByProductCode(String productCode) {
        List<Product> products = new ArrayList<>();
        
        this.productRepository.findByProductCode(productCode).forEach(products::add);
        
        return responseMapper.mapResponseList(products);
    }
    
    @Override
    public List<ProductResponse> findByProductName(String productName) {
        List<Product> products = new ArrayList<>();
        
        this.productRepository.findByProductName(productName).forEach(products::add);
        
        return responseMapper.mapResponseList(products);
    }
}
