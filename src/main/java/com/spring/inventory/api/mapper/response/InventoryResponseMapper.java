package com.spring.inventory.api.mapper.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.inventory.api.model.Inventory;
import com.spring.inventory.api.model.response.InventoryResponse;

@Component
public class InventoryResponseMapper {
    
    private ProductResponseMapper productResponseMapper;
    
    @Autowired
    public InventoryResponseMapper(ProductResponseMapper productResponseMapper) {
        this.productResponseMapper = productResponseMapper;
    }
    
    public List<InventoryResponse> mapInventoryList(List<Inventory> inventories) {
        List<InventoryResponse> responses = new ArrayList<>();
        
        for(Inventory inventory: inventories) {
            if(null != inventory && null != inventory.getProduct()) {
                InventoryResponse inventoryResponse = new InventoryResponse();
                inventoryResponse.setProduct(productResponseMapper.mapToResponse(inventory.getProduct()));
                inventoryResponse.setQuantity(inventory.getQuantity());
                
                responses.add(inventoryResponse);
            }
        }
        
        return responses;
    }
}
