//package com.greedy.goodeat.user.postdetail.service;
//
//import java.awt.print.Pageable;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.greedy.goodeat.common.entity.Review;
//
//public interface ReviewRepository extends JpaRepository<Review, Long> {
//
//	@EntityGraph(attributePaths = {"attachmentList"})
//	Page<Review> findByBoardTypeAndBoardStatus(int reviewType, String reviewStatus, Pageable pageable);
//	
//	@EntityGraph(attributePaths = {"attachmentList"})
//	@Query("SELECT r " +
//	         "FROM Review r " +
//			"WHERE r.reviewType = :reviewType " +
//	          "AND r.reviewStatus = :reviewStatus " +
//			  "AND (r.reviewTitle LIKE '%' || :searchValue || '%' " +
//			   "OR r.reviewBody LIKE '%' || :searchValue || '%')")
//	Page<Review> findBySearchValue(@Param("reviewType") int reviewType, @Param("reviewStatus") String reviewStatus, @Param("searchValue") String searchValue, Pageable pageable);
//
//	Review findByReviewCodeAndReviewTypeAndReviewStatus(Long reviewCode, int reviewType, String reviewStatus);
//
//	
//}
