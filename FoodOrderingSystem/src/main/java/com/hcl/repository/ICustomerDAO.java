package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Customer;

@Repository
public interface ICustomerDAO extends JpaRepository<Customer, Integer> {

	public Customer findByEmailAndPassword(String email, String password);

	public Customer findByEmail(String email);
}
