package com.greedy.goodeat.admin.post.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.admin.post.repository.AdmPostRepository;
import com.greedy.goodeat.common.dto.PostDTO;
import com.greedy.goodeat.common.entity.Post;
import com.greedy.goodeat.common.entity.Product;


@Transactional
@Service
public class AdmPostService {
	
	private final ModelMapper modelMapper;
	private final AdmPostRepository admPostRepository;
	
	@Autowired
	public AdmPostService(ModelMapper modelMapper,
						  AdmPostRepository admPostRepository) {
		this.modelMapper = modelMapper;
		this.admPostRepository = admPostRepository;
		
	}

	public Page<PostDTO> findPostList(Pageable pageable) {
		
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
								  pageable.getPageSize(), 
								  Sort.by("postCode").descending());
		
		Page<Post> postList = admPostRepository.findAll(pageable);
		
		return postList.map(post -> modelMapper.map(post, PostDTO.class));
	}

}
