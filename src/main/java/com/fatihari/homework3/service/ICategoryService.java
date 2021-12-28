package com.fatihari.homework3.service;

import java.util.List;
import com.fatihari.homework3.entity.Category;

public interface ICategoryService 
{
	public List<Category> findAll();
	public Category findById(String categoryId);
	public Category save(Category category);
	public void delete(Category category);
	public void deleteById(String categoryId);
}
