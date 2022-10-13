package com.greedy.goodeat.user.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.common.dto.CartListDTO;
import com.greedy.goodeat.common.entity.Cart;
import com.greedy.goodeat.user.repository.CartRepository;

@Service
@Transactional
public class CartService {

	public static final int MEMBERID = 2;
	
	private final CartRepository cartRepository;
	private final ModelMapper modelMapper;
	
	public CartService(CartRepository cartRepository, ModelMapper modelMapper) {
		this.cartRepository = cartRepository;
		this.modelMapper = modelMapper;
	}

	public List<CartListDTO> selectCartList() {
		List<Cart> cartList = cartRepository.findByMember(MEMBERID);
		
		return cartList.stream().map(cart -> modelMapper.map(cart, CartListDTO.class)).collect(Collectors.toList());
	}

	public void updateCartList(CartListDTO updateCart) {
		
		Cart savedCart = cartRepository.findBycartCode(updateCart.getCartCode());
		savedCart.setProductAmount(updateCart.getProductAmount());
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
