package com.spring.inventory.api.service;

import java.util.List;

import com.spring.inventory.api.model.request.ProductTypeRequest;
import com.spring.inventory.api.model.response.GenericResponse;
import com.spring.inventory.api.model.response.ProductTypeResponse;

public interface ProductTypeService {
    
    public List<ProductTypeResponse> getAllProductTypes();
    
    public GenericResponse addProductType(ProductTypeRequest productTypeRequest);
}
