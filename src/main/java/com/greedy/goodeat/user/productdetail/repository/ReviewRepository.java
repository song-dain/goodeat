package com.greedy.goodeat.user.productdetail.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greedy.goodeat.common.dto.ReviewDTO;
import com.greedy.goodeat.common.entity.Post;
import com.greedy.goodeat.common.entity.Review;




public interface ReviewRepository extends JpaRepository<Review, Integer> {

	Page<Review> findByReviewStatus(String reviewStatus, Pageable pageable);

	void save(ReviewDTO map);

	@Query("SELECT r " +
	         "FROM Review r " +
			"WHERE r.reviewCode = :reviewCode " +
	          "AND (r.reviewTitle LIKE '%' || :searchValue || '%' )")
	Page<Review> findBySearchValue(@Param("reviewCode") Integer reviewCode, @Param("searchValue") String searchValue, Pageable pageable);
	
	Post findByReviewCode(Integer reviewCode);
	

}