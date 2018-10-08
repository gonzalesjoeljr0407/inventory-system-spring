package com.spring.inventory.api.model.response;

public class InventoryResponse {
    
    private ProductResponse product;
    private long quantity;
    
    public ProductResponse getProduct() {
        return product;
    }
    
    public void setProduct(ProductResponse product) {
        this.product = product;
    }
    
    public long getQuantity() {
        return quantity;
    }
    
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
