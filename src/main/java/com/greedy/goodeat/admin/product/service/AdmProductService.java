package com.greedy.goodeat.admin.product.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.admin.product.repository.AdmProductCategoryRepository;
import com.greedy.goodeat.admin.product.repository.AdmProductRepository;
import com.greedy.goodeat.common.dto.ProductDTO;
import com.greedy.goodeat.common.entity.Product;

@Transactional
@Service
public class AdmProductService {
		
	private final AdmProductRepository admProductRepository;
	private final AdmProductCategoryRepository admPproductCategoryRepository;
	private final ModelMapper modelMapper;
	
	public AdmProductService (AdmProductRepository admProductRepository, AdmProductCategoryRepository admPproductCategoryRepository, ModelMapper modelMapper) {
		
		this.admProductRepository = admProductRepository;
		this.admPproductCategoryRepository = admPproductCategoryRepository;
		this.modelMapper = modelMapper;
	}

	public Page<ProductDTO> findProductList(Pageable pageable) {
		
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
				pageable.getPageSize(), 
				Sort.by("productCode").descending());
		
		Page<Product> productList = admProductRepository.findAll(pageable);
		
		return productList.map(product -> modelMapper.map(product, ProductDTO.class));
	}

	public void registProduct(ProductDTO newProduct) {
		
		admProductRepository.save(modelMapper.map(newProduct, Product.class));
	}

//	public List<ProductCategoryDTO> findAllCategory(){
//		
//		List<ProductCategory> categoryList = productCategoryRepository.findAll();
//		
//		return categoryList.stream().map(productCategory -> modelMapper.map(productCategory, ProductCategoryDTO.class)).collect(Collectors.toList());
//	}
//	



	
	
	
	
}
