package com.fatihari.homework3.dao;

import com.fatihari.homework3.entity.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends MongoRepository<UserAccount, String>
{
	UserAccount findByUsername(String username);
	UserAccount findByPhone(String phone);
	UserAccount findByUsernameAndPhone(String username, String phone);
	void deleteByUsernameAndPhone(String username, String phone);
}
