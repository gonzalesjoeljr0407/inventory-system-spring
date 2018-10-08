package com.spring.inventory.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.inventory.api.model.request.InventoryRequest;
import com.spring.inventory.api.model.response.InventoryResponse;
import com.spring.inventory.api.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    
    private InventoryService inventoryService;
    
    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    
    @GetMapping("/getAll")
    public List<InventoryResponse> getAllInventory() {
        return this.inventoryService.getAllInventory();
    }
    
    @PostMapping("/updateList")
    public List<InventoryResponse> updateInventoryQuantityList(@RequestBody List<InventoryRequest> request) {
        return this.inventoryService.updateInventoryQuantityList(request);
    }
}
