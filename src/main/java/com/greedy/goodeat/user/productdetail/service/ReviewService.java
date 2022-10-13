package com.greedy.goodeat.user.productdetail.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.user.productdetail.hgdto.hgReviewDTO;
import com.greedy.goodeat.user.productdetail.hgentity.hgReview;
import com.greedy.goodeat.user.productdetail.repository.ReviewRepository;


import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
@Transactional
public class ReviewService {
	
	public static final int TEXT_PAGE_SIZE = 7;
	public static final String SORT_BY = "reviewCode";
	public static final String ACTIVE_STATUS = "정상";
	
	private final ModelMapper modelMapper;
	private final ReviewRepository reviewRepository;
	

	public ReviewService(ModelMapper modelMapper,
			ReviewRepository reviewRepository) {
		this.modelMapper = modelMapper;
		this.reviewRepository = reviewRepository;
		
	}


	public Page<hgReviewDTO> selectReviewList(int page, String searchValue) {
		
		Pageable pageable = PageRequest.of(page - 1, TEXT_PAGE_SIZE, Sort.by(SORT_BY).descending());
		Page<hgReview> reviewList = null;
		
		if(searchValue != null && !searchValue.isEmpty()) {
			
		} else {
			reviewList = reviewRepository.findByReviewStatus(ACTIVE_STATUS, pageable);
		}
		
		log.info("reviewList : {}", reviewList.getContent());
		
		return reviewList.map(review -> modelMapper.map(review, hgReviewDTO.class));
	}

	//등록
	public void registReview(hgReviewDTO review) {
		
		reviewRepository.save(modelMapper.map(review, hgReview.class));
		
	}
	
	//상세
	public hgReviewDTO selectReviewDetail(Integer reviewCode) {
		
		hgReview review = reviewRepository.findByReviewCode(reviewCode);
		return modelMapper.map(review, hgReviewDTO.class);
	}
	
	
	 //수정 
	public void modifyReview(hgReviewDTO review) {
	
	  log.info("[ReviewService] foundReview:{} ", review); 
	  hgReview foundReview = reviewRepository.findByReviewCode(review.getReviewCode());
	  
	  //log.info("[ReviewService] foundReview:{} ", foundReview);
	  
	  foundReview.setReviewCode(review.getReviewCode());
	  foundReview.setReviewContent(review.getReviewContent());
	  foundReview.setReviewTitle(review.getReviewTitle());
	  
	  }
	 
	//삭제
	public void deleteReview(Integer reviewCode) {
		hgReview deleteReview = reviewRepository.findById(reviewCode).get();
		reviewRepository.delete(deleteReview);
	}
	
}