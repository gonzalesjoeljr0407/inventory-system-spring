package com.spring.inventory.api.mapper.request;

import org.springframework.stereotype.Component;

import com.spring.inventory.api.model.Owner;
import com.spring.inventory.api.model.request.OwnerRequest;

@Component
public class OwnerRequestMapper {
    
    public Owner mapRequest(OwnerRequest request) {
        if(null != request) {
            Owner owner = new Owner();
            owner.setOwnerName(request.getOwnerName());
            
            return owner;
        }
        return null;
    }
}
