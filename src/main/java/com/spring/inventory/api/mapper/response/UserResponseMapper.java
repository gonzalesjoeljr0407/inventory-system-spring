package com.spring.inventory.api.mapper.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.inventory.api.model.User;
import com.spring.inventory.api.model.response.UserResponse;

@Component
public class UserResponseMapper {
    
    public List<UserResponse> mapUserList(List<User> users) {
        List<UserResponse> response = new ArrayList<>();
        
        for(User user: users) {
            response.add(mapToDataObject(user));
        }
        
        return response;
    }
    
    public UserResponse mapToDataObject(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(user.getUsername());
        if(null != user.getOwner()) {
            userResponse.setOwnerName(user.getOwner().getOwnerName());
        }
        
        return userResponse;
    }
}
