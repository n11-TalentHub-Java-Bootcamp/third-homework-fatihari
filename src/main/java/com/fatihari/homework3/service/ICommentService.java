package com.fatihari.homework3.service;

import com.fatihari.homework3.entity.ProductComment;

import java.util.List;

public interface ICommentService 
{
	public List<ProductComment> findAll();
	public ProductComment findById(String commentId);
	public ProductComment save(ProductComment productComment);
	public void deleteById(String commentId);
	public long generateSequence(String seqName); // for auto increment
}
