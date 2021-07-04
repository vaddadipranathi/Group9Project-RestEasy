package com.hcl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Address;

@Repository
public interface IAddressDAO extends CrudRepository<Address, Integer> {

}
