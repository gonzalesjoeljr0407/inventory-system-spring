package com.spring.inventory.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {
    
    @Id
    @Column(name="owner_id")
    private long id;
    @Column(name="owner_name")
    private String ownerName;
    
    public long getId() {
        return id;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
