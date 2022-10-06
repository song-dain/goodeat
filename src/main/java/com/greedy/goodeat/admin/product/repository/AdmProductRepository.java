package com.greedy.goodeat.admin.product.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.goodeat.common.entity.Product;


public interface AdmProductRepository extends JpaRepository<Product, Integer>{

	@EntityGraph(attributePaths = {"addfile"})
	Page<Product> findByProductStatus(String productStatus, Pageable pageable);


}