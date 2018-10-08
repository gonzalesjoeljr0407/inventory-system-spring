package com.spring.inventory.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.inventory.api.model.request.OwnerRequest;
import com.spring.inventory.api.model.response.GenericResponse;
import com.spring.inventory.api.model.response.OwnerResponse;
import com.spring.inventory.api.service.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    
    private OwnerService ownerService;
    
    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    
    @GetMapping("/getAll")
    public List<OwnerResponse> getAllOwner() {
        return this.ownerService.getAllOwner();
    }
    
    @PostMapping("/addOwner")
    public GenericResponse addOwner(@RequestBody OwnerRequest request) {
        return this.ownerService.addOwner(request);
    }
}
