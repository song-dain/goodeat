package com.greedy.goodeat.user.product.orderby.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.common.dto.ProductDTO;
import com.greedy.goodeat.common.entity.Product;
import com.greedy.goodeat.common.entity.ProductCategory;
import com.greedy.goodeat.user.product.orderby.repository.ProductListRepository;

@Service
public class ProductListService {
	
	public static final int THUMBNAIL_PAGE_SIZE = 9;
	public static final String SORT_BY = "productCode";
	public static final String ACTIVE_STATUS = "Y";
	
	private final ModelMapper modelMapper;
	private final ProductListRepository productListRepository;
	
	public ProductListService(ModelMapper modelMapper, ProductListRepository productListRepository) {
		this.modelMapper = modelMapper;
		this.productListRepository = productListRepository;
	}

	public Page<ProductDTO> productList(int page, ProductCategory category) {
		
		Pageable pageable = PageRequest.of(page -1,  THUMBNAIL_PAGE_SIZE, Sort.by(SORT_BY).descending());
		
		Page<Product> productList = productListRepository.findByProductCategoryAndProductStatus(category, ACTIVE_STATUS, pageable);
		
		return productList.map(product -> modelMapper.map(product, ProductDTO.class));
	}
	


}
