package com.greedy.goodeat.user.cart;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greedy.goodeat.common.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	Page<Cart> findByBoardTypeAndBoardStatus(int i, String string, Pageable pageable);


	
}
