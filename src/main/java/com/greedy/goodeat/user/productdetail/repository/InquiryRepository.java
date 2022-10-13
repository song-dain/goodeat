package com.greedy.goodeat.user.productdetail.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.goodeat.admin.inquiry.entity.SYInquiry;
import com.greedy.goodeat.common.entity.Inquiry;



public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {

	@Query("SELECT i " +
			 "FROM Inquiry i " +
			"WHERE (i.inquiryTitle LIKE '%' || :searchValue || '%' " +
			   "OR i.inquiryContent LIKE '%' || :searchValue || '%'" +
			   "OR i.member.memberId LIKE '%' || :searchValue || '%')")
	Page<SYInquiry> findBySearchValue(String searchValue, Pageable pageable);

	

	
	

}