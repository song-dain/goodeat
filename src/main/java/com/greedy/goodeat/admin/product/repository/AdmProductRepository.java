package com.greedy.goodeat.admin.product.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.goodeat.admin.product.entity.KjyProduct;



public interface AdmProductRepository extends JpaRepository<KjyProduct, Integer>{

	@Query("SELECT p " +
			 "FROM KjyProduct p " + 
			"WHERE p.productName LIKE '%' || :searchValue || '%'")
	Page<KjyProduct> finBySearchValue(String searchValue, Pageable pageable);
	
	



}