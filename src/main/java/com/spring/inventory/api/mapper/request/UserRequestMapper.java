package com.spring.inventory.api.mapper.request;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
            user.setPassword(encryptPassword(userRequest.getPassword()));
            
            Owner owner = new Owner();
            owner.setId(userRequest.getOwnerId());
            user.setOwner(owner);
            
            return user;
        }
        
        return null;
    }
    
    private String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
