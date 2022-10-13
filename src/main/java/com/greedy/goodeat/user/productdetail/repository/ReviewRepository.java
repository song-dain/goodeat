package com.greedy.goodeat.user.productdetail.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.greedy.goodeat.common.entity.Review;
import com.greedy.goodeat.user.productdetail.hgentity.hgReview;

public interface ReviewRepository extends JpaRepository<hgReview, Integer> {

	@Query("SELECT r " +
			 "FROM Review r " +
			"WHERE (r.reviewTitle LIKE '%' || :searchValue || '%' " +
			   "OR r.reviewContent LIKE '%' || :searchValue || '%')")
	Page<hgReview> findBySearchValue(@Param("searchValue") String searchValue, Pageable pageable);

	Page<hgReview> findByReviewStatus(String activeStatus, Pageable pageable);

	void save(Review map);

	
	

}