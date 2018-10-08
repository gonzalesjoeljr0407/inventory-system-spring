package com.spring.inventory.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.inventory.api.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
    @Query(value = "select * from user where username = :username and password = :password", nativeQuery = true)
    User getLoginUser(@Param("username") String username, @Param("password") String password);
    
    @Query(value = "select * from user where username = :username", nativeQuery = true)
    User getByUsername(@Param("username") String username);
}
