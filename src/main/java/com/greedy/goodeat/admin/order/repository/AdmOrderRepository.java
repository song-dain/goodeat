package com.greedy.goodeat.admin.order.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.goodeat.common.entity.OrderProduct;

public interface AdmOrderRepository extends JpaRepository<OrderProduct, Integer>{

	@Query("SELECT o " +
			"FROM OrderProduct o " + 
			"WHERE o.order.orderNo LIKE '%' || :searchValue || '%'")
	Page<OrderProduct> finBySearchValue(String searchValue, Pageable pageable);



}
