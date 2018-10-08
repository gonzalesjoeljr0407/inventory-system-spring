package com.spring.inventory.api.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.inventory.api.exception.response.BusinessException;
import com.spring.inventory.api.exception.response.DataException;
import com.spring.inventory.api.model.LoginUser;
import com.spring.inventory.api.model.request.UserRequest;
import com.spring.inventory.api.model.response.GenericResponse;
import com.spring.inventory.api.model.response.UserResponse;
import com.spring.inventory.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/getAll")
    public List<UserResponse> getAllUsers() {
        return this.userService.getAllUser();
    }
    
    @PostMapping("/addUser")
    public GenericResponse addUser(@RequestBody UserRequest request) {
        return this.userService.addUser(request);
    }
    
    @PostMapping("/login")
    public User login(@RequestBody UserRequest request, HttpSession session) throws DataException {
        System.out.println("login");
        User loginUser = this.userService.login(request, session);
        
        return loginUser;
    }
    
    @GetMapping("/login/fail")
    public void failedLogin() throws BusinessException {
        throw new BusinessException(null, "Fail to authenticate user.", null);
    }
}
