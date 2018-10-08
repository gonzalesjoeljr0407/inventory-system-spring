package com.spring.inventory.api.service;

import java.util.List;

import com.spring.inventory.api.model.request.OwnerRequest;
import com.spring.inventory.api.model.response.GenericResponse;
import com.spring.inventory.api.model.response.OwnerResponse;

public interface OwnerService {
    
    public List<OwnerResponse> getAllOwner();
    
    public GenericResponse addOwner(OwnerRequest ownerRequest);
}
