package com.spring.inventory.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.inventory.api.mapper.response.InventoryResponseMapper;
import com.spring.inventory.api.model.Inventory;
import com.spring.inventory.api.model.request.InventoryRequest;
import com.spring.inventory.api.model.response.InventoryResponse;
import com.spring.inventory.api.repository.InventoryRepository;
import com.spring.inventory.api.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
    
    private InventoryRepository inventoryRepository;
    private InventoryResponseMapper responseMapper;
    
    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository, InventoryResponseMapper responseMapper) {
        this.inventoryRepository = inventoryRepository;
        this.responseMapper = responseMapper;
    }
    
    @Override
    public List<InventoryResponse> getAllInventory() {
        List<Inventory> inventories = new ArrayList<>();
        
        this.inventoryRepository.findAll().forEach(inventories::add);
        
        return this.responseMapper.mapInventoryList(inventories);
    }
    
    @Override
    public List<InventoryResponse> updateInventoryQuantityList(List<InventoryRequest> requests) {
        List<Long> productIds = new ArrayList<>();
        
        for(InventoryRequest request: requests) {
            
            if(request.getTransType().equalsIgnoreCase("ADD")) {
                this.inventoryRepository.addToInventory(request.getQuantity(), request.getProductId());
            } else if(request.getTransType().equalsIgnoreCase("SUB")) {
                this.inventoryRepository.subToInventory(request.getQuantity(), request.getProductId());
            }
            
            productIds.add(request.getProductId());
        }
        
        List<Inventory> inventories = new ArrayList<>();
        
        this.inventoryRepository.getInventoryByProductId(productIds).forEach(inventories::add);
        
        return this.responseMapper.mapInventoryList(inventories);
    }
}
