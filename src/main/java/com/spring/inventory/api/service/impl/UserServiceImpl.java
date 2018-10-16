package com.spring.inventory.api.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.inventory.api.exception.response.BusinessException;
import com.spring.inventory.api.exception.response.DataException;
import com.spring.inventory.api.mapper.request.UserRequestMapper;
import com.spring.inventory.api.mapper.response.UserResponseMapper;
import com.spring.inventory.api.model.LoginUser;
import com.spring.inventory.api.model.User;
import com.spring.inventory.api.model.request.UserRequest;
import com.spring.inventory.api.model.response.GenericResponse;
import com.spring.inventory.api.model.response.UserResponse;
import com.spring.inventory.api.repository.UserRepository;
import com.spring.inventory.api.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService{
    
    private UserRepository userRepository;
    private UserResponseMapper responseMapper;
    private UserRequestMapper requestMapper;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserResponseMapper responseMapper, UserRequestMapper requestMapper) {
        this.userRepository = userRepository;
        this.responseMapper = responseMapper;
        this.requestMapper = requestMapper;
    }
    
    @Override
    public List<UserResponse> getAllUser() {
        List<User> user = new ArrayList<>();
        
        this.userRepository.findAll().forEach(user::add);
        
        return responseMapper.mapUserList(user);
    }
    
    @Override
    public GenericResponse addUser(UserRequest userRequest) {
        User user = requestMapper.mapRequest(userRequest);
        
        if(null != user) {
            User newUser = userRepository.save(user);
            
            if(null != newUser) {
                GenericResponse genericResponse = new GenericResponse();
                genericResponse.setMessage("Successfully added user to database");
                genericResponse.setStatus(HttpStatus.OK.value());
                return genericResponse;            
            }
        }
    
        throw new BusinessException(null, "Failed to add user to database", null);
    }
    
    @Override
    public org.springframework.security.core.userdetails.User login(UserRequest userRequest, HttpSession session) throws DataException {
        String username = userRequest.getUsername();
        String password = userRequest.getPassword();
        User user = this.userRepository.getLoginUser(username, password);
        
        if(null != user) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorization("ADMIN"));
        }
        
        throw new DataException(null, "Incorrect username/password.", null);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username: " + username);
        User user = userRepository.getByUsername(username);
        if (user == null){
            System.out.println("user null");
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                getAuthorization("ADMIN"));
    }
    
    private Collection<SimpleGrantedAuthority> getAuthorization(String auth) {
        return Arrays.asList(new SimpleGrantedAuthority(auth));
    }
}
