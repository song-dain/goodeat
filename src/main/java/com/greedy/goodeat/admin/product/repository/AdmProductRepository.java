package com.greedy.goodeat.admin.product.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.goodeat.common.entity.Product;


public interface AdmProductRepository extends JpaRepository<Product, Integer>{

	@Query("SELECT p " +
			 "FROM Product p " + 
			"WHERE p.productName LIKE '%' || :searchValue || '%'")
	Page<Product> finBySearchValue(String searchValue, Pageable pageable);
	
	



}