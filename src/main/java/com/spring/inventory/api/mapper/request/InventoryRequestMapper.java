package com.spring.inventory.api.mapper.request;

import org.springframework.stereotype.Component;

import com.spring.inventory.api.model.Inventory;
import com.spring.inventory.api.model.Product;
import com.spring.inventory.api.model.request.InventoryRequest;

@Component
public class InventoryRequestMapper {
    
    public Inventory mapToDataObject(InventoryRequest request) {
        if(null != request) {
            Inventory inventory = new Inventory();
            
            Product product = new Product();
            product.setId(request.getProductId());
            
            inventory.setProduct(product);
            inventory.setQuantity(request.getQuantity());
        
            return inventory;
        }
        
        return null;
    }
}
