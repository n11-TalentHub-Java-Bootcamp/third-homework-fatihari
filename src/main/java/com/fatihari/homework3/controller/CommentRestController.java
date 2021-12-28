package com.fatihari.homework3.controller;

import java.util.List;

import com.fatihari.homework3.entity.Category;
import com.fatihari.homework3.entity.ProductComment;
import com.fatihari.homework3.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatihari.homework3.converter.CommentConverter;
import com.fatihari.homework3.dto.ProductCommentDTO;
import com.fatihari.homework3.entity.Product;
import com.fatihari.homework3.exception.NotFoundException;
import com.fatihari.homework3.service.ICommentService;
import com.fatihari.homework3.service.IProductService;
import com.fatihari.homework3.service.IUserAccountService;


@RestController
@RequestMapping("/api/comments")
public class CommentRestController {
	
	@Autowired
	private ICommentService iCommentService;
	@Autowired
	private IUserAccountService iUserAccountService;
	@Autowired
	private IProductService iProductService;
	
	@Autowired
	public CommentRestController(ICommentService iCommentService, 
			IUserAccountService iUserAccountService, IProductService iProductService) 
	{
		this.iCommentService = iCommentService;
		this.iUserAccountService = iUserAccountService;
		this.iProductService = iProductService;
	}

	@GetMapping("")
	public List<ProductComment> findAll()
	{
		List<ProductComment> commentList = iCommentService.findAll();
		return commentList;
	}
	
	//  pojo to json
	//	add mapping for Get api/comments/{commentId} - get comment
	@GetMapping("/{id}")
	public ProductComment findById(@PathVariable String id) {
		return iCommentService.findById(id);
	}

	//	add mapping for POST "api/comments/" - add new comment
	@PostMapping("/")
	public ProductComment save(@RequestBody ProductCommentDTO productCommentDTO)
	{	
		ProductComment comment = CommentConverter.INSTANCE.convertFromCommentDtoToComment(productCommentDTO);
		//FOR AUTO INCREMENT
		comment.set_id(String.valueOf(this.iCommentService.generateSequence(ProductComment.SEQUENCE_NAME)));
		iCommentService.save(comment);
		return comment;
	}
	

	//	add mapping for DELETE api/comments/{commentId} - delete comment
	@DeleteMapping("/{commentId}")
	public String delete(@PathVariable String commentId)
	{
		ProductComment comment = iCommentService.findById(commentId);

		//throw exception if null
		if(comment == null)
		{
			throw new NotFoundException("Comment id is not found - " + commentId);
		}
		iCommentService.deleteById(commentId);
		return "Delete comment id - " + commentId;
	}

	
	


}
