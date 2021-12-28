package com.fatihari.homework3.service;

import com.fatihari.homework3.entity.ProductComment;
import com.fatihari.homework3.entity.UserAccount;

import java.util.List;

public interface IUserAccountService 
{
	public List<UserAccount> findAll();
	public UserAccount findById(String userId);
	public UserAccount save(UserAccount userAccount);
	public void deleteById(String userId);
	public long generateSequence(String seqName); // for auto increment

}
