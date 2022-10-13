package com.greedy.goodeat.admin.review.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.goodeat.common.entity.Review;

public interface AdmReviewRepository extends JpaRepository<Review, Integer> {

	@Query("SELECT r " +
			 "FROM Review r " +
			"WHERE (r.reviewTitle LIKE '%' || :searchValue || '%' " +
			   "OR r.reviewContent LIKE '%' || :searchValue || '%'" +
			   "OR r.member.memberId LIKE '%' || :searchValue || '%')")
	Page<Review> finBySearchValue(String searchValue, Pageable pageable);
}
