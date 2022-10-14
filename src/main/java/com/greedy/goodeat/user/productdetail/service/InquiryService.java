package com.greedy.goodeat.user.productdetail.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.admin.inquiry.dto.SYInquiryDTO;
import com.greedy.goodeat.admin.inquiry.entity.SYInquiry;
import com.greedy.goodeat.common.dto.InquiryDTO;
import com.greedy.goodeat.common.entity.Inquiry;
import com.greedy.goodeat.user.productdetail.hgdto.hgReviewDTO;
import com.greedy.goodeat.user.productdetail.hgentity.hgReview;
import com.greedy.goodeat.user.productdetail.repository.InquiryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class InquiryService {
	
	public static final int TEXT_PAGE_SIZE = 5;
	public static final String SORT_BY = "InquiryCode";
	
	private final ModelMapper modelMapper;
	private final InquiryRepository inquiryRepository;
	
	public InquiryService (ModelMapper modelMapper,
			InquiryRepository inquiryRepository) {
		
		this.inquiryRepository = inquiryRepository;
		this.modelMapper = modelMapper;
		
	}

public Page<SYInquiryDTO> findInquiryList(int page, String searchValue) {
		
		Pageable pageable = PageRequest.of(page - 1, TEXT_PAGE_SIZE, Sort.by(SORT_BY).descending());
		Page<SYInquiry> inquiryList = null;
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			
		} else {
			inquiryList = inquiryRepository.findBySearchValue(searchValue, pageable);
		}
		return inquiryList.map(inquiry -> modelMapper.map(inquiry, SYInquiryDTO.class));
	}




	
}
