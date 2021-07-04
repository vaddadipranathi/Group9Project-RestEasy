package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Cart;

@Repository
public interface ICartDAO extends JpaRepository<Cart, Integer> {

}
