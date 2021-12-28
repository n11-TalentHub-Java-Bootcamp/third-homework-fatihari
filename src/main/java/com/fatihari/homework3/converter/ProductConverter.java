package com.fatihari.homework3.converter;

import com.fatihari.homework3.dto.ProductDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fatihari.homework3.dto.ProductDTO;
import com.fatihari.homework3.entity.Product;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

	ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

	@Mapping(target = "productName", source = "name")
	@Mapping(target = "productPrice", source = "price")
	ProductDetailDTO convertProductToProductDetailDto(Product product);

	@Mapping(target = "productName", source = "name")
	@Mapping(target = "productPrice", source = "price")
	List<ProductDetailDTO> convertAllProductListToProductDetailDtoList(List<Product> product);

	@Mapping(source="category_id", target = "category_id") // source => ProductDTO, target=> Product
	Product convertFromProductDtoToProduct(ProductDTO productDto);


//    @AfterMapping
//    default void setCategoryName(@MappingTarget final ProductDetailDto productDetailDto,
//                                 Product product){
//        if (product.getCategoryId() == null){
//            urun.setKategori(null);
//        }
//    }
}