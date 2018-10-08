package com.spring.inventory.api.mapper.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.inventory.api.model.Product;
import com.spring.inventory.api.model.response.ProductResponse;

@Component
public class ProductResponseMapper {
    
    private ProductTypeResponseMapper productTypeResponseMapper;
    
    @Autowired
    public ProductResponseMapper(ProductTypeResponseMapper productTypeResponseMapper) {
        this.productTypeResponseMapper = productTypeResponseMapper;
    }
    
    public List<ProductResponse> mapResponseList(List<Product> products) {
        List<ProductResponse> responses = new ArrayList<>();
        
        for(Product product: products) {
            ProductResponse productResponse = mapToResponse(product);
            
            responses.add(productResponse);
        }
        
        return responses;
    }
    
    public ProductResponse mapToResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductName(product.getProductName());
        productResponse.setProductCode(product.getProductCode());
        
        if(null != product.getProductType()) {
            productResponse.setProductType(productTypeResponseMapper.mapToResponse(product.getProductType()));
        }
        
        return productResponse;
    }
}
