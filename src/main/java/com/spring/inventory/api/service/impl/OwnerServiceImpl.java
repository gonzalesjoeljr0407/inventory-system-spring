package com.spring.inventory.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spring.inventory.api.exception.response.BusinessException;
import com.spring.inventory.api.mapper.request.OwnerRequestMapper;
import com.spring.inventory.api.mapper.response.OwnerResponseMapper;
import com.spring.inventory.api.model.Owner;
import com.spring.inventory.api.model.request.OwnerRequest;
import com.spring.inventory.api.model.response.GenericResponse;
import com.spring.inventory.api.model.response.OwnerResponse;
import com.spring.inventory.api.repository.OwnerRepository;
import com.spring.inventory.api.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {
    
    private OwnerRepository ownerRepository;
    private OwnerResponseMapper responseMapper;
    private OwnerRequestMapper requestMapper;
    
    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerResponseMapper responseMapper, OwnerRequestMapper requestMapper) {
        this.ownerRepository = ownerRepository;
        this.responseMapper = responseMapper;
        this.requestMapper = requestMapper;
    }
    
    @Override
    public List<OwnerResponse> getAllOwner() {
        List<Owner> owners = new ArrayList<>();
        
        this.ownerRepository.findAll().forEach(owners::add);
        
        return responseMapper.mapOwnerList(owners);
    }
    
    @Override
    public GenericResponse addOwner(OwnerRequest ownerRequest) throws BusinessException {
        Owner owner = requestMapper.mapRequest(ownerRequest);
        
        if(null != owner) {
            Owner newOwner = ownerRepository.save(owner);
            
            if(null != newOwner) {
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setMessage("Successfully added owner to database");
                genericResponse.setStatus(HttpStatus.OK.value());
                return genericResponse;
            }
        }
    
        throw new BusinessException(null, "Failed to add owner to database", null);
    }
}
