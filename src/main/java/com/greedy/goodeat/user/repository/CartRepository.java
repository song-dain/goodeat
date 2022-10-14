package com.greedy.goodeat.user.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greedy.goodeat.common.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(value = "SELECT " +
		    "CART_CODE " +
		    ", MEMBER_NO " +
		    ", PRODUCT_CODE" +
		    ", PRODUCT_NAME " +
		    ", PRODUCT_AMOUNT " +
		    ", PRODUCT_PRICE " +
		    "FROM TBL_CART " +
		    "JOIN TBL_MEMBER USING(MEMBER_NO) " +
		    "JOIN TBL_PRODUCT USING(PRODUCT_CODE) " +
		    "WHERE MEMBER_NO = :memberid "
		    ,nativeQuery = true)
	List<Cart> findByMember(@Param("memberid") int memberid);


}
