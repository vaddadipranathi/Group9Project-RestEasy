package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.OrderDetails;

@Repository
public interface IOrderDAO extends JpaRepository<OrderDetails, Integer> {

}
