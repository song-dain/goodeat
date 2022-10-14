package com.greedy.goodeat.user.productdetail.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import com.greedy.goodeat.common.entity.Product;
import com.greedy.goodeat.user.productdetail.hgdto.hgProductDTO;
import com.greedy.goodeat.user.productdetail.repository.ProductdetailRepository;


@Service
public class ProductdetailService {
	
	private final ModelMapper modelMapper;
	private final ProductdetailRepository productdetailRepository;

	public ProductdetailService (ProductdetailRepository productRepository, ModelMapper modelMapper) {
		this.productdetailRepository = productRepository;
		this.modelMapper = modelMapper;
	}
	
	public hgProductDTO selecthgProduct(Integer productCode) {
		
		Product product = productdetailRepository.findByProductCode(productCode);
		
		return modelMapper.map(product, hgProductDTO.class);
	}

}