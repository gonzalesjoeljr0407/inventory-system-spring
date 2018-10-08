package com.spring.inventory.api.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.inventory.api.model.LoginUser;
import com.spring.inventory.api.model.request.UserRequest;
import com.spring.inventory.api.model.response.GenericResponse;
import com.spring.inventory.api.model.response.UserResponse;

public interface UserService {
    
    public List<UserResponse> getAllUser();
    
    public GenericResponse addUser(UserRequest userRequest);
    
    public User login(UserRequest userRequest, HttpSession session);
}
