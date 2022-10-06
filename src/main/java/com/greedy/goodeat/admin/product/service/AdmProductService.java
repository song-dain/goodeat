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
		
	public static final int TEXT_PAGE_SIZE = 10;
	public static final int THUMBNAIL_PAGE_SIZE = 9;
	public static final int TEXT_PRODUCT_TYPE = 1;
	public static final int THUMBNAIL_PRODUCT_TYPE = 2;
	public static final String SORT_BY = "produceCode";
	public static final String PRODUCT_STATUS = "Y";
	
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

	public Page<ProductDTO> selectThumbnailList(int page) {
		Pageable pageable = PageRequest.of(page - 1 , THUMBNAIL_PAGE_SIZE, Sort.by(SORT_BY).descending());
		Page<Product> thumbnailList = admProductRepository.findByProductStatus(PRODUCT_STATUS, pageable);
		
		return thumbnailList.map(product -> modelMapper.map(product, ProductDTO.class));
	}

	public void registThumbnail(ProductDTO product) {
		
		product.setProductStatus(PRODUCT_STATUS);
		admProductRepository.save(modelMapper.map(product, Product.class));
		
	}



//	public List<ProductCategoryDTO> findAllCategory(){
//		
//		List<ProductCategory> categoryList = productCategoryRepository.findAll();
//		
//		return categoryList.stream().map(productCategory -> modelMapper.map(productCategory, ProductCategoryDTO.class)).collect(Collectors.toList());
//	}
//	



	
	
	
	
}
