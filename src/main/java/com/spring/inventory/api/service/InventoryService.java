package com.spring.inventory.api.service;

import java.util.List;

import com.spring.inventory.api.model.request.InventoryRequest;
import com.spring.inventory.api.model.response.InventoryResponse;

public interface InventoryService {
    
    public List<InventoryResponse> getAllInventory();
    
    public List<InventoryResponse> updateInventoryQuantityList(List<InventoryRequest> requests);
}
