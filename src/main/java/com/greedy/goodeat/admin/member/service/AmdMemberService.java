package com.greedy.goodeat.admin.member.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.admin.member.dto.AdmJyMemberDTO;
import com.greedy.goodeat.admin.member.entity.AdmJyMember;
import com.greedy.goodeat.admin.member.repository.AdmMemberRepository;
import com.greedy.goodeat.admin.product.dto.KjyProductDTO;
import com.greedy.goodeat.admin.product.entity.KjyProduct;
import com.greedy.goodeat.admin.product.repository.AdmProductRepository;

@Service
public class AmdMemberService {
	
	public static final int TEXT_PAGE_SIZE = 10;
	public static final int THUMBNAIL_PAGE_SIZE = 9;
	public static final String SORT_BY = "memberNo";
	
	private final AdmMemberRepository admMemberRepository;
	private final ModelMapper modelMapper;
	
	public AmdMemberService (AdmMemberRepository admMemberRepository, ModelMapper modelMapper) {
		
		this.admMemberRepository = admMemberRepository;
		this.modelMapper = modelMapper;
	}
	
	@Transactional
	public Page<AdmJyMemberDTO> findProductList(int page, String searchValue) {

		Pageable pageable = PageRequest.of(page - 1, TEXT_PAGE_SIZE, Sort.by(SORT_BY).descending());
		Page<AdmJyMember> memberList = null;
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			memberList = admMemberRepository.finBySearchValue(searchValue, pageable);
		} else {
			memberList = admMemberRepository.findAll(pageable);
		}
		
		return memberList.map(member -> modelMapper.map(member, AdmJyMemberDTO.class));
	}

}
