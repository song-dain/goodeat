package com.greedy.goodeat.user.productdetail.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.common.dto.ProductDTO;
import com.greedy.goodeat.common.entity.Product;
import com.greedy.goodeat.user.productdetail.repository.ProductRepository;


@Service
public class ProductService {
	
	private final ModelMapper modelMapper;
	private final ProductRepository productRepository;

	public ProductService (ProductRepository productRepository, ModelMapper modelMapper) {
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}
	
	public ProductDTO selectProduct(Integer productCode) {
		
		Product product = productRepository.findByProductCode(productCode);
		
		return modelMapper.map(product, ProductDTO.class);
	}

}