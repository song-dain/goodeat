package com.greedy.goodeat.user.productdetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.goodeat.common.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByProductCode(Integer productCode);

	
}