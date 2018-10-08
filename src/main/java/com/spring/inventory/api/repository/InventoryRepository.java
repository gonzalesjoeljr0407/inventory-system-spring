package com.spring.inventory.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.inventory.api.model.Inventory;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long>{
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update inventory set quantity = (quantity + :quantity) where product_id = :productId", nativeQuery = true)
    void addToInventory(@Param("quantity") long quantity, @Param("productId") long productId);
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update inventory set quantity = (quantity - :quantity) where product_id = :productId", nativeQuery = true)
    void subToInventory(@Param("quantity") long quantity, @Param("productId") long productId);
    
    @Query(value = "select * from inventory where product_id in :productIds", nativeQuery = true)
    Iterable<Inventory> getInventoryByProductId(@Param("productIds") List<Long> productIds);
}
