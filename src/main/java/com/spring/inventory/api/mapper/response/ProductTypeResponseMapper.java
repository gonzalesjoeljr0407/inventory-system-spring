package com.spring.inventory.api.mapper.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.inventory.api.model.ProductType;
import com.spring.inventory.api.model.response.ProductTypeResponse;

@Component
public class ProductTypeResponseMapper {
    
    public List<ProductTypeResponse> mapResponse(List<ProductType> productTypes) {
        List<ProductTypeResponse> responses = new ArrayList<>();
        
        for(ProductType productType: productTypes) {
            responses.add(mapToResponse(productType));
        }
        
        return responses;
    }
    
    public ProductTypeResponse mapToResponse(ProductType productType) {
        ProductTypeResponse productTypeResponse = new ProductTypeResponse();
        productTypeResponse.setProductType(productType.getProductType());
        
        return productTypeResponse;
    }
}
