package com.fatihari.homework3.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.fatihari.homework3.entity.DatabaseSequence;
import com.fatihari.homework3.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatihari.homework3.dao.UserAccountRepository;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Transactional
@Service
public class UserAccountService implements IUserAccountService 
{
	@Autowired
	private UserAccountRepository userAccountRepository;
	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	public UserAccountService(UserAccountRepository userAccountRepository) {
		this.userAccountRepository = userAccountRepository;
	}
	
	@Override
	public List<UserAccount> findAll() 
	{
		return this.userAccountRepository.findAll();
	}
	
	@Override
	public UserAccount findById(String userId) {
		Optional<UserAccount> result = this.userAccountRepository.findById(userId);
		UserAccount userAccount = null;
		
		if(result.isPresent())
			userAccount = result.get();
		else
			throw new RuntimeException("Did not find user id - " + userId);
		return userAccount;
	}

	@Override
	public UserAccount save(UserAccount userAccount) {
		return this.userAccountRepository.save(userAccount);
	}

	@Override
	public void deleteById(String userId) {
		this.userAccountRepository.deleteById(userId);
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
