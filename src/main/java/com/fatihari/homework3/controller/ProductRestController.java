package com.fatihari.homework3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatihari.homework3.converter.ProductConverter;
import com.fatihari.homework3.dto.ProductDTO;
import com.fatihari.homework3.dto.ProductDetailDTO;
import com.fatihari.homework3.entity.Category;
import com.fatihari.homework3.entity.Product;
import com.fatihari.homework3.exception.NotFoundException;
import com.fatihari.homework3.service.ICategoryService;
import com.fatihari.homework3.service.IProductService;

@RestController
@RequestMapping("/api/products/")
public class ProductRestController {
	
	@Autowired
	private IProductService iProductService;
	@Autowired
	private ICategoryService iCategoryService;
		
	//	quick and dirty: inject product dao (use constructor injection)
	@Autowired
	public ProductRestController(IProductService iProductService, ICategoryService iCategoryService)
	{
		this.iProductService = iProductService;
		this.iCategoryService = iCategoryService;
		
	}
	
	//  pojo to json
	//	expose "/products" and return list of products 
	
	@GetMapping("")
	public List<Product> findAllProducts()
	{
		return iProductService.findAll();
	}
	
	//	add mapping for GET /products/{productId}
	@GetMapping("{productId}") //productId parameter
	public EntityModel<Product> getProductById(@PathVariable String productId)
	{
		Product product = iProductService.findById(productId);
		if(product == null)
			throw new NotFoundException("Product id is not found - " + productId);
		
		// Added hateoas dependency for linking.
		WebMvcLinkBuilder linkToProduct = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAllProducts());
		EntityModel entityModel = EntityModel.of(product);
		entityModel.add(linkToProduct.withRel("all-products"));
		return entityModel;
	}
	
	//	add mapping for GET /products/dto/{productId}
	@GetMapping("dto/{productId}") //productId parameter
	public ProductDetailDTO findProductDtoById(@PathVariable String productId)
	{
		Product product = iProductService.findById(productId);
		ProductDetailDTO productDetailDTO = convertProductToProductDetailDto(product);
		
		if(product == null)
			throw new NotFoundException("Product id is not found - " + productId);
		return productDetailDTO;
	}
	
	private ProductDetailDTO convertProductToProductDetailDto(Product product) 
	{
		ProductDetailDTO productDetailDTO = new ProductDetailDTO();
		Category category = iCategoryService.findById(product.getCategory_id());
		productDetailDTO.setProductName(product.getName());
		productDetailDTO.setCategoryName(category.getName());
		productDetailDTO.setProductPrice(product.getPrice());
		
		return productDetailDTO;
	}
	
	//	add mapping for POST /products - add new product
	@PostMapping("")
	public Product saveProduct(@RequestBody ProductDTO productDto) 
	{		
		//	also just in case they pass id in JSON ... set id to 0
		//	this is to force a save of new item, instead of update.
		
		Product product = ProductConverter.INSTANCE.convertFromProductDtoToProduct(productDto);
		//Product product = convertFromProductDtoToProduct(productDto);
		//product.setId(0);
		iProductService.saveOrUpdate(product);
		return product;
	}
	
	private Product convertFromProductDtoToProduct(ProductDTO productDto) 
	{
		Category category = iCategoryService.findById(productDto.getCategory_id());
		Product product = new Product();
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setRegistration_date(productDto.getRegistration_date());
		product.setCategory_id(category.get_id());
		return product;
	}
	
	//	add mapping for PUT /products - update existing product
	
	@PutMapping("")
	public Product updateProduct(@RequestBody Product product) 
	{
		iProductService.saveOrUpdate(product);
		return product;
	}
	
	//	add mapping for DELETE /products/{productsId} - delete product
	
	@DeleteMapping("{productId}")
	public String deleteProduct(@PathVariable String productId)
	{
		Product product = iProductService.findById(productId);
		
		//throw exception if null
		if(product == null)
		{
			throw new NotFoundException("Product id is not found - " + productId);
		}
		iProductService.deleteById(productId);
		return "Delete product id - " + productId; 
	}
}
