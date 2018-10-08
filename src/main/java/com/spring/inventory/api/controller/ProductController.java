package com.spring.inventory.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.inventory.api.model.response.ProductResponse;
import com.spring.inventory.api.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    private ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/getAll")
    public List<ProductResponse> getAllProduct() {
        return this.productService.getAllProduct();
    }
    
    @GetMapping("/findByCode")
    public List<ProductResponse> getProductsByCode(@RequestParam(name="productCode", required=true) String productCode) {
        return this.productService.findByProductCode(productCode);
    }
    
    @GetMapping("/findByName")
    public ResponseEntity<?> getProductsByName(@RequestParam(name="productName", required=true) String productName) {
        List<ProductResponse> products = this.productService.findByProductName(productName);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
