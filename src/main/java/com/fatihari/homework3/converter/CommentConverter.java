package com.fatihari.homework3.converter;

import com.fatihari.homework3.entity.ProductComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.fatihari.homework3.dto.ProductCommentDTO;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentConverter 
{
	public CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);
	
	@Mapping(source="user_account_id", target = "user_account_id") // source => ProductCommentDTO, target=> ProductComment
	@Mapping(source="product_id", target = "product_id") // source => ProductCommentDTO, target=> ProductComment
	ProductComment convertFromCommentDtoToComment(ProductCommentDTO productCommentDTO);
	

}
