package com.spring.inventory.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spring.inventory.api.exception.response.BusinessException;
import com.spring.inventory.api.mapper.request.ProductTypeRequestMapper;
import com.spring.inventory.api.mapper.response.ProductTypeResponseMapper;
import com.spring.inventory.api.model.ProductType;
import com.spring.inventory.api.model.request.ProductTypeRequest;
import com.spring.inventory.api.model.response.GenericResponse;
import com.spring.inventory.api.model.response.ProductTypeResponse;
import com.spring.inventory.api.repository.ProductTypeRepository;
import com.spring.inventory.api.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    
    private ProductTypeRepository productTypeRepository;
    private ProductTypeResponseMapper responseMapper;
    private ProductTypeRequestMapper requestMapper;
    
    @Autowired
    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository, ProductTypeResponseMapper responseMapper, ProductTypeRequestMapper requestMapper) {
        this.productTypeRepository = productTypeRepository;
        this.responseMapper = responseMapper;
        this.requestMapper = requestMapper;
    }
    
    @Override
    public List<ProductTypeResponse> getAllProductTypes() {
        List<ProductType> productTypes = new ArrayList<>();
        
        this.productTypeRepository.findAll().forEach(productTypes::add);
        
        return responseMapper.mapResponse(productTypes);
    }
    
    @Override
    public GenericResponse addProductType(ProductTypeRequest productTypeRequest) throws BusinessException {
        ProductType productType = requestMapper.mapRequest(productTypeRequest);
        
        ProductType newProductType = productTypeRepository.save(productType);
        
        if(null != newProductType) {
            GenericResponse genericResponse = new GenericResponse();
            genericResponse.setMessage("Successfully added product type to database");
            genericResponse.setStatus(HttpStatus.OK.value());
            return genericResponse;
        }
        
        throw new BusinessException(null, "Failed to add owner to database", null);
    }
}
