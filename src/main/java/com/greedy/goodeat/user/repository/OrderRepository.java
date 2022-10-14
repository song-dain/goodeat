package com.greedy.goodeat.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.goodeat.common.entity.Order;

public interface OrderRepository extends JpaRepository<Order , Integer>{

}
