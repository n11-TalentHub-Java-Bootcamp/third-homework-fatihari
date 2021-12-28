package com.fatihari.homework3.service;

import java.util.List;


import com.fatihari.homework3.dto.ProductDetailDTO;
import com.fatihari.homework3.entity.Product;

public interface IProductService 
{
	public List<Product> findAll();
	public Product findById(String productId);
	public Product saveOrUpdate(Product product);
	public void delete(Product product);
	public void deleteById(String productId);
	public List<ProductDetailDTO> findProductDetailDTOById(String productId);
}
