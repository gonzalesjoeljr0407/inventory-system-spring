package com.spring.inventory.api.mapper.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.inventory.api.model.Owner;
import com.spring.inventory.api.model.response.OwnerResponse;

@Component
public class OwnerResponseMapper {
    
    public List<OwnerResponse> mapOwnerList(List<Owner> owners) {
        List<OwnerResponse> response = new ArrayList<>();
        for(Owner owner: owners) {
            response.add(mapToResponse(owner));
        }
        
        return response;
    }
    
    public OwnerResponse mapToResponse(Owner owner) {
        OwnerResponse ownerResponse = new OwnerResponse();
        ownerResponse.setOwnerName(owner.getOwnerName());
        
        return ownerResponse;
    }
}
