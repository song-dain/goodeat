package com.greedy.goodeat.user.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.common.dto.MemberDTO;
import com.greedy.goodeat.common.entity.Member;
import com.greedy.goodeat.user.repository.PaymentRepository;

@Service
@Transactional
public class PaymentService {
	
	private final PaymentRepository paymentRepository;
	private final ModelMapper modelMapper;
	
	public PaymentService(PaymentRepository paymentRepository, ModelMapper modelMapper) {
		this.paymentRepository = paymentRepository;
		this.modelMapper = modelMapper;
	}

	public MemberDTO selectMember(int memberNo) {
		
		Member member = paymentRepository.findById(memberNo);
		return modelMapper.map(member, MemberDTO.class);
	}

}