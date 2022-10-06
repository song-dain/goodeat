package com.greedy.goodeat.admin.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.goodeat.common.entity.Product;


public interface AdmProductRepository extends JpaRepository<Product, Integer>{


}