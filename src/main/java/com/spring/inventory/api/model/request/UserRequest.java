package com.spring.inventory.api.model.request;

public class UserRequest {
    
    private String username;
    private String password;
    private long ownerId;
    
    public long getOwnerId() {
        return ownerId;
    }
    
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
}
