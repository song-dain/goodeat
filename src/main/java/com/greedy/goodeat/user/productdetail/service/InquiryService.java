package com.greedy.goodeat.user.productdetail.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
	
	public static final int TEXT_PAGE_SIZE = 10;
	public static final String SORT_BY = "inquiryCode";
	public static final String ACTIVE_STATUS = "답변";
	
	private final ModelMapper modelMapper;
	private final InquiryRepository inquiryRepository;
	
	public InquiryService (ModelMapper modelMapper,
			InquiryRepository inquiryRepository) {
		this.modelMapper = modelMapper;
		this.inquiryRepository = inquiryRepository;
		
		
	}

public Page<InquiryDTO> selectInquiryList(int page, String searchValue) {
		
		Pageable pageable = PageRequest.of(page - 1, TEXT_PAGE_SIZE, Sort.by(SORT_BY).descending());
		Page<Inquiry> inquiryList = null;
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			
		} else {
			inquiryList = inquiryRepository.findByInquiryStatus(ACTIVE_STATUS, pageable);
		}
		
		log.info("inquiryList : {}", inquiryList.getContent());
		
		return inquiryList.map(inquiry -> modelMapper.map(inquiry, InquiryDTO.class));
	}

	//상세
	public InquiryDTO selectInquiryDetail(Integer inquiryCode) {
		
		Inquiry inquiry = inquiryRepository.findByInquiryCode(inquiryCode);
		return modelMapper.map(inquiry, InquiryDTO.class);
	}

	//등록
	public void registInquiry(InquiryDTO inquiry) {
			
			inquiryRepository.save(modelMapper.map(inquiry, Inquiry.class));
			
		}
	
	//수정
	public void modifyInquiry(InquiryDTO inquiry) {
		
		  log.info("[InquiryService] foundInquiry:{} ", inquiry); 
		  Inquiry foundInquiry = inquiryRepository.findByInquiryCode(inquiry.getInquiryCode());
		  
		//log.info("[ReviewService] foundReview:{} ", foundReview);
		  
		  foundInquiry.setInquiryCode(inquiry.getInquiryCode());
		  foundInquiry.setInquiryTitle(inquiry.getInquiryTitle());
		  foundInquiry.setInquiryContent(inquiry.getInquiryContent());
		  
		  
		  }

	//삭제
		public void deleteInquiry(Integer inquiryCode) {
			Inquiry deleteInquiry = inquiryRepository.findById(inquiryCode).get();
			inquiryRepository.delete(deleteInquiry);
		}

		public InquiryDTO selectInquiry(Integer inquiryCode) {
			// TODO Auto-generated method stub
			return null;
		}





	
}
