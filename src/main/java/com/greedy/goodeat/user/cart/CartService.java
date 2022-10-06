package com.greedy.goodeat.user.cart;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.common.dto.CartDTO;
import com.greedy.goodeat.common.entity.Cart;

@Service
@Transactional
public class CartService {
	
	private CartRepository cartRepository;
	private ModelMapper modelMapper;
	
	public CartService(CartRepository cartRepository, ModelMapper modelMapper) {
		this.cartRepository = cartRepository;
		this.modelMapper = modelMapper;
	}

	public Page<CartDTO> slectCartList(int page, String searchValue) {
		
		Pageable pageable = PageRequest.of(page - 1, 10, Sort.by("memberNo").descending());
		
		Page<Cart> cartList = cartRepository.findByBoardTypeAndBoardStatus(1, "Y", pageable);
		
		return cartList.map(cart -> modelMapper.map(cart, CartDTO.class));
	}

}
