package com.fatihari.homework3.controller;

import java.util.List;

import com.fatihari.homework3.entity.ProductComment;
import com.fatihari.homework3.entity.UserAccount;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fatihari.homework3.exception.NotFoundException;
import com.fatihari.homework3.service.IUserAccountService;

@RestController
@RequestMapping("/api/users")
public class UserAccountRestController {
	
	@Autowired
	private IUserAccountService iUserAccountService;
		
	//	quick and dirty: inject user service (use constructor injection)
	@Autowired
	public UserAccountRestController(IUserAccountService iUserAccountService)
	{
		this.iUserAccountService = iUserAccountService;
	}
	
	//  pojo to json
	//	expose "api/users/" and return list of users 
	
	@GetMapping("/")
	public List<UserAccount> findAll()
	{
		return iUserAccountService.findAll();
	}
	
	//	add mapping for GET api/users/{userId}
	@GetMapping("/{userId}") //username parameter
	public UserAccount findById(@PathVariable String userId)
	{
		UserAccount userAccount = iUserAccountService.findById(userId);
		
		if(userAccount == null)
			throw new NotFoundException("userId is not found - " + userId);
		return userAccount;
	}

	//	add mapping for POST "api/users" - add new user
	@PostMapping("/")
	public UserAccount save(@RequestBody UserAccount userAccount)
	{
		//FOR AUTO INCREMENT
		userAccount.set_id(String.valueOf(this.iUserAccountService.generateSequence(ProductComment.SEQUENCE_NAME)));
		iUserAccountService.save(userAccount);
		return userAccount;
	}

	//	add mapping for DELETE api/users/{userId} - delete comment
	@DeleteMapping("/{userId}")
	public String delete(@PathVariable String userId)
	{
		UserAccount userAccount = iUserAccountService.findById(userId);

		//throw exception if null
		if(userAccount == null)
		{
			throw new NotFoundException("User id is not found - " + userId);
		}
		iUserAccountService.deleteById(userId);
		return "Delete user id - " + userId;
	}

}
