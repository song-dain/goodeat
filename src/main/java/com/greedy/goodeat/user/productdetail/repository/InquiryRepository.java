package com.greedy.goodeat.user.productdetail.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greedy.goodeat.admin.inquiry.entity.SYInquiry;
import com.greedy.goodeat.common.entity.Inquiry;
import com.greedy.goodeat.user.productdetail.hgentity.hgReview;



public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {

	@Query("SELECT i " +
			 "FROM Inquiry i " +
			"WHERE (i.inquiryTitle LIKE '%' || :searchValue || '%' " +
			   "OR i.inquiryContent LIKE '%' || :searchValue || '%' )")
	Page<Inquiry> findBySearchValue(@Param("searchValue")String searchValue, Pageable pageable);

	Page<Inquiry> findByInquiryStatus(String activeStatus, Pageable pageable);

	Inquiry findByInquiryCode(Integer inquiryCode);

	


	
	

}