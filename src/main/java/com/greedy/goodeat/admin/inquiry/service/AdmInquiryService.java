package com.greedy.goodeat.admin.inquiry.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.admin.inquiry.dto.SYInquiryDTO;
import com.greedy.goodeat.admin.inquiry.entity.SYInquiry;
import com.greedy.goodeat.admin.inquiry.repository.AdmInquiryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class AdmInquiryService {
	
	public static final int TEXT_PAGE_SIZE = 5;
	public static final int THUMBNAIL_PAGE_SIZE = 9;
	public static final String SORT_BY = "InquiryCode";

	private final ModelMapper modelMapper;
	private final AdmInquiryRepository admInquiryRepository;
	
	public AdmInquiryService (ModelMapper modelMapper,
			AdmInquiryRepository admInquiryRepository) {
		
		this.admInquiryRepository = admInquiryRepository;
		this.modelMapper = modelMapper;
		
	}

	public Page<SYInquiryDTO> findInqList(int page, String searchValue) {
		
		Pageable pageable = PageRequest.of(page - 1, TEXT_PAGE_SIZE, Sort.by(SORT_BY).descending());
		Page<SYInquiry> inquiryList = null;
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			inquiryList = admInquiryRepository.finBySearchValue(searchValue, pageable);
		} else {
			inquiryList = admInquiryRepository.findAll(pageable);
		}
		return inquiryList.map(inquiry -> modelMapper.map(inquiry, SYInquiryDTO.class));
	}

	public SYInquiryDTO selectInqDetail(Integer inquiryCode) {
		SYInquiry inq = admInquiryRepository.findById(inquiryCode).get();
		
		return modelMapper.map(inq, SYInquiryDTO.class);
	}

	public void deleteInquiry(Integer inquiryCode) {
		SYInquiry inquiry = admInquiryRepository.findById(inquiryCode).get();
		admInquiryRepository.delete(inquiry);
	}
}
