package com.spring.inventory.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @Column(name="user_id")
    private long id;
    @Column(name="username", updatable=false)
    private String username;
    @Column(name="password")
    private String password;
    @OneToOne
    @JoinColumn(name="owner_id", updatable=false)
    private Owner owner;
    
    public long getId() {
        return id;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Owner getOwner() {
        return owner;
    }
    
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
