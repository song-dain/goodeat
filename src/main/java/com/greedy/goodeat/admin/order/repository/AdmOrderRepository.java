package com.greedy.goodeat.admin.order.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.goodeat.admin.order.entity.JyOrder;



public interface AdmOrderRepository extends JpaRepository<JyOrder, Integer>{

	@EntityGraph(attributePaths = {"product","orderProduct"})
	@Query("SELECT o " +
			"FROM JyOrder o " + 
			"WHERE o.orderNo LIKE '%' || :searchValue || '%'")
	Page<JyOrder> finBySearchValue(String searchValue, Pageable pageable);



}
