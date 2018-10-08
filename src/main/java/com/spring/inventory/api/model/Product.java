package com.spring.inventory.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    
    @Id
    @Column(name="product_id")
    private long id;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_code")
    private String productCode;
    @OneToOne
    @JoinColumn(name="product_type_id")
    private ProductType productType;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getProductCode() {
        return productCode;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    
    public ProductType getProductType() {
        return productType;
    }
    
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    
}
