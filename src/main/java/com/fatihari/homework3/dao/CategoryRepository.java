package com.fatihari.homework3.dao;

import com.fatihari.homework3.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>
{
	
}
