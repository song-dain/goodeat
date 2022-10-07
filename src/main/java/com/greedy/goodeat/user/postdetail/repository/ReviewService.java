//package com.greedy.goodeat.user.postdetail.repository;
//
//import java.awt.print.Pageable;
//
//import javax.transaction.Transactional;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import com.greedy.goodeat.common.dto.ReviewDTO;
//import com.greedy.goodeat.common.entity.Review;
//import com.greedy.goodeat.user.postdetail.service.ReviewRepository;
//
//@Service
//@Transactional
//public class ReviewService {
//	
//	public static final int TEXT_PAGE_SIZE = 10;
//	public static final int THUMBNAIL_PAGE_SIZE = 9;
//	public static final String SORT_BY = "reviewCode";
//	public static final int TEXT_BOARD_TYPE = 1;
//	public static final String ACTIVE_STATUS = "Y";
//	private final ModelMapper modelMapper;
//	private final ReviewRepository reviewRepository;
//	
//	public ReviewService(ReviewRepository reviewRepository, ModelMapper modelMapper) {
//		this.reviewRepository = reviewRepository;
//		this.modelMapper = modelMapper;
//	}
//
//	public Page<ReviewDTO> selectReviewList(int page, String searchValue) {
//		
//		Pageable pageable = PageRequest.of(page - 1, TEXT_PAGE_SIZE, Sort.by(SORT_BY).descending());
//		Page<Review> reviewList = null;
//		
//		if(searchValue != null && !searchValue.isEmpty()) {
//			reviewList = reviewRepository.findBySearchValue(TEXT_BOARD_TYPE, ACTIVE_STATUS, searchValue, pageable);
//		} else {
//			reviewList = reviewRepository.findByBoardTypeAndBoardStatus(TEXT_BOARD_TYPE, ACTIVE_STATUS, pageable);
//		}
//		
//		return reviewList.map(board -> modelMapper.map(review, ReviewDTO.class));
//	}
//
//	public ReviewDTO selectReviewDetail(Long reviewCode) {
//		
//		Review review = reviewRepository.findByReviewCodeAndBoardTypeAndReviewStatus(reviewCode, TEXT_BOARD_TYPE, ACTIVE_STATUS);
//		review.setReviewCount(review.getReviewCount() + 1);
//		
//		return modelMapper.map(review, ReviewDTO.class);
//	}
//	
//}