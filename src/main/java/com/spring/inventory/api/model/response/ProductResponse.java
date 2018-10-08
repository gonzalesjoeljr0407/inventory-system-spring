package com.spring.inventory.api.model.response;

public class ProductResponse {
    
    public String productName;
    public String productCode;
    public ProductTypeResponse productType;
    
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
    
    public ProductTypeResponse getProductType() {
        return productType;
    }
    
    public void setProductType(ProductTypeResponse productType) {
        this.productType = productType;
    }
}
