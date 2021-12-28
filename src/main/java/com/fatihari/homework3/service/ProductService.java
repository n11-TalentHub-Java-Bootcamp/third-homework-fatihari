package com.fatihari.homework3.service;

import java.util.List;
import java.util.Optional;

import com.fatihari.homework3.converter.ProductConverter;
import com.fatihari.homework3.dto.ProductDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatihari.homework3.dao.ProductRepository;

import com.fatihari.homework3.entity.Product;

@Service
public class ProductService implements IProductService 
{
	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<Product> findAll() 
	{
		return this.productRepository.findAll();
	}

	@Override
	public Product findById(String productId)
	{
		Optional<Product> result = this.productRepository.findById(productId);
		Product product = null;
		
		if(result.isPresent())
			product = result.get();
		else
			throw new RuntimeException("Did not find product id - " + productId);
		return product;
	}
	
	@Override
	public Product saveOrUpdate(Product product) 
	{
		return this.productRepository.save(product);
	}
	
	public void delete(Product product) 
	{
		this.productRepository.delete(product);
	}

	@Override
	public void deleteById(String productId)
	{	
		this.productRepository.deleteById(productId);
	}

	@Override
	public List<ProductDetailDTO> findProductDetailDTOById(String productId) {
		return productRepository.findProductDetailDtoBy_id(productId);
	}


}
