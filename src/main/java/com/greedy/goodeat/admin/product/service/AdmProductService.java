package com.greedy.goodeat.admin.product.service;



import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greedy.goodeat.admin.product.dto.KjyProductDTO;
import com.greedy.goodeat.admin.product.entity.KjyProduct;
import com.greedy.goodeat.admin.product.entity.KjyProductCategory;
import com.greedy.goodeat.admin.product.repository.AdmProductRepository;


@Service
public class AdmProductService {
		
	public static final int TEXT_PAGE_SIZE = 10;
	public static final int THUMBNAIL_PAGE_SIZE = 9;
	public static final String SORT_BY = "productCode";
	
	private final AdmProductRepository admProductRepository;
	private final ModelMapper modelMapper;
	
	public AdmProductService (AdmProductRepository admProductRepository, ModelMapper modelMapper) {
		
		this.admProductRepository = admProductRepository;
		this.modelMapper = modelMapper;
	}
	@Transactional
	public Page<KjyProductDTO> findProductList(int page, String searchValue) {
		
		Pageable pageable = PageRequest.of(page - 1, TEXT_PAGE_SIZE, Sort.by(SORT_BY).descending());
		Page<KjyProduct> productList = null;
		
		if(searchValue !=null && !searchValue.isEmpty()) {
			productList = admProductRepository.finBySearchValue(searchValue, pageable);
		} else {
			productList = admProductRepository.findAll(pageable);
		}
		
		return productList.map(product -> modelMapper.map(product, KjyProductDTO.class));
	}

	
	@Transactional
	public void registProduct(KjyProductDTO newProduct) {
		
		admProductRepository.save(modelMapper.map(newProduct, KjyProduct.class));
	}


	@Transactional
	public void deleteProduct(KjyProductDTO product) {
		
		KjyProduct deleteProduct = admProductRepository.findById(product.getProductCode()).get();
		
		admProductRepository.delete(modelMapper.map(deleteProduct, KjyProduct.class));

		
	}

	public KjyProductDTO selectProductList(Integer productCode) {
		
		KjyProduct product = admProductRepository.findById(productCode).get();
		
		return modelMapper.map(product, KjyProductDTO.class);
	}

	@Transactional
	public void modifyProduct(KjyProductDTO product) {
		
		KjyProduct selecetProduct = admProductRepository.findById(product.getProductCode()).get();
		selecetProduct.setProductName(product.getProductName());
		selecetProduct.setProductCategory(modelMapper.map(product.getProductCategory(), KjyProductCategory.class));
		selecetProduct.setProductPrice(product.getProductPrice());
		selecetProduct.setProductInventory(product.getProductInventory());
		selecetProduct.setProductStatus(product.getProductStatus());
	
		
		
	}




	
}
