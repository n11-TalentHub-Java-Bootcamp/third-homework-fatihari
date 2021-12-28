package com.fatihari.homework3.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fatihari.homework3.entity.DatabaseSequence;
import com.fatihari.homework3.entity.ProductComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatihari.homework3.dao.CommentRepository;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;


@Service
public class CommentService implements ICommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private MongoOperations mongoOperations;
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Transactional
	@Override
	public ProductComment save(ProductComment productComment) {
		return this.commentRepository.save(productComment);
	}

	@Override
	public List<ProductComment> findAll() {
		return this.commentRepository.findAll();
	}

	@Override
	public ProductComment findById(String commentId) {
		Optional<ProductComment> result = this.commentRepository.findById(commentId);
		ProductComment comment = null;
		
		if(result.isPresent())
			comment = result.get();
		else
			throw new RuntimeException("Did not find comment id - " + commentId);
		return comment;
	}

	@Override
	public void deleteById(String commentId)
	{
		this.commentRepository.deleteById(commentId);
	}

	@Override
	public long generateSequence(String seqName) {
		Query query = new Query(Criteria.where("_id").is(seqName));
		Update update = new Update().inc("seq", 1);
		DatabaseSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),
				DatabaseSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}



}
