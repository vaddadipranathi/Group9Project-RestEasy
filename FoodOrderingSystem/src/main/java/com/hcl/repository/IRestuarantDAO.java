package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Restuarant;

@Repository
public interface IRestuarantDAO extends JpaRepository<Restuarant, Integer> {

	Restuarant findByRestuarantName(String name);
}
