package com.spring.inventory.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.inventory.api.model.request.ProductTypeRequest;
import com.spring.inventory.api.model.response.GenericResponse;
import com.spring.inventory.api.model.response.ProductTypeResponse;
import com.spring.inventory.api.service.ProductTypeService;

@RestController
@RequestMapping("/product/types")
public class ProductTypeController {
    
    private ProductTypeService productTypeService;
    
    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }
    
    @GetMapping("/getAll")
    public List<ProductTypeResponse> getAllProductTypes() {
        return this.productTypeService.getAllProductTypes();
    }
    
    @PutMapping("/add")
    public GenericResponse addProductType(@RequestBody ProductTypeRequest request) {
        return this.productTypeService.addProductType(request);
    }
}
