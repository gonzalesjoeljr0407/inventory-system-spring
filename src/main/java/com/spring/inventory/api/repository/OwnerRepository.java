package com.spring.inventory.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.inventory.api.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{
}
