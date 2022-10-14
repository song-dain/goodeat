package com.greedy.goodeat.user.product.orderby.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.goodeat.common.entity.Product;
import com.greedy.goodeat.common.entity.ProductCategory;

public interface ProductListRepository extends JpaRepository<Product, Long> {

	@EntityGraph(attributePaths = {"AddfileList"})
	Page<Product> findByProductCategoryAndProductStatus(ProductCategory category, String activeStatus,
			Pageable pageable);
}
