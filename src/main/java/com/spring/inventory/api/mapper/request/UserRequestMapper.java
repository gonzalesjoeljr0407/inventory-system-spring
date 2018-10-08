package com.spring.inventory.api.mapper.request;

import org.springframework.stereotype.Component;

import com.spring.inventory.api.model.Owner;
import com.spring.inventory.api.model.User;
import com.spring.inventory.api.model.request.UserRequest;

@Component
public class UserRequestMapper {
    
    public User mapRequest(UserRequest userRequest) {
        User user = new User();
        if(null != userRequest) {
            user.setUsername(userRequest.getUsername());
            user.setPassword(userRequest.getPassword());
            
            Owner owner = new Owner();
            owner.setId(userRequest.getOwnerId());
            user.setOwner(owner);
            
            return user;
        }
        
        return null;
    }
}
