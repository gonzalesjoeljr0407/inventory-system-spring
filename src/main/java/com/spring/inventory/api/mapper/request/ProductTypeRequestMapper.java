package com.spring.inventory.api.mapper.request;

import org.springframework.stereotype.Component;

import com.spring.inventory.api.model.ProductType;
import com.spring.inventory.api.model.request.ProductTypeRequest;

@Component
public class ProductTypeRequestMapper {
    
    public ProductType mapRequest(ProductTypeRequest request) {
        if(null != request) {
            ProductType productType = new ProductType();
            productType.setProductType(request.getProductType());
            
            return productType;
        }
        
        return null;
    }
}
