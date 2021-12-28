package com.fatihari.homework3.dao;

import java.util.List;

import com.fatihari.homework3.entity.DatabaseSequence;
import com.fatihari.homework3.entity.ProductComment;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<ProductComment, String>
{
}
