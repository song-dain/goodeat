package com.greedy.goodeat.admin.review.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.admin.inquiry.dto.ReplyDTO;

import com.greedy.goodeat.admin.inquiry.dto.SYInquiryDTO;

import com.greedy.goodeat.admin.inquiry.entity.Reply;
import com.greedy.goodeat.admin.inquiry.repository.AdmReplyRepository;
import com.greedy.goodeat.admin.review.repository.AdmReviewRepository;
import com.greedy.goodeat.common.dto.ReviewDTO;
import com.greedy.goodeat.common.entity.Review;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class AdmReviewService {
	
	public static final int TEXT_PAGE_SIZE = 5;
	public static final int THUMBNAIL_PAGE_SIZE = 9;
	public static final String SORT_BY = "reviewCode";
	
	private final ModelMapper modelMapper;
	private final AdmReviewRepository admReviewRepository;
	private final AdmReplyRepository admReplyRepository;
	
	public AdmReviewService(ModelMapper modelMapper,
			AdmReviewRepository admReviewRepository,
			AdmReplyRepository admReplyRepository) {
		
		this.admReplyRepository = admReplyRepository;
		this.admReviewRepository = admReviewRepository;
		this.modelMapper = modelMapper;
	}

	public Page<ReviewDTO> findReviewList(int page, String searchValue) {
		
		Pageable pageable = PageRequest.of(page - 1, TEXT_PAGE_SIZE, Sort.by(SORT_BY).descending());
		Page<Review> reviewList = null;

		if(searchValue !=null && !searchValue.isEmpty()) {
			reviewList = admReviewRepository.finBySearchValue(searchValue, pageable);
		} else {
			reviewList = admReviewRepository.findAll(pageable);
		}
		return reviewList.map(review -> modelMapper.map(review, ReviewDTO.class));
	}

	public ReviewDTO selectReviewDetail(Integer reviewCode) {
		
		Review reivew = admReviewRepository.findById(reviewCode).get();
		return modelMapper.map(reivew, ReviewDTO.class);
	}


	public void deleteReview(Integer reviewCode) {
		Review deleteReview = admReviewRepository.findById(reviewCode).get();
		admReviewRepository.delete(deleteReview);
		
	}

	public void registReply(ReplyDTO registReply) {
		admReplyRepository.save(modelMapper.map(registReply, Reply.class));
		
	}

	public List<ReplyDTO> loadReply(ReplyDTO loadReply) {
		List<Reply> replyList
		= admReplyRepository.findByRefInquiryNo(loadReply.getRefInquiryNo());
		
		return replyList.stream().map(reply -> modelMapper.map(reply, ReplyDTO.class)).collect(Collectors.toList());
	}

	public void removeReply(ReplyDTO removeReply) {
		Reply foundReply = admReplyRepository.findByReplyNo(removeReply.getReplyNo());
		admReplyRepository.delete(foundReply);
		
	}

	

	

}
