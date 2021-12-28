package com.fatihari.homework3.dao;

import com.fatihari.homework3.dto.ProductDetailDTO;
import com.fatihari.homework3.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>
{
    //List<Product> findAllByCategory_id(String categoryId);

    List<ProductDetailDTO> findProductDetailDtoBy_id(String productId);
}
