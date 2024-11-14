package com.nt.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Binding.CreateUserBind;
import com.nt.Binding.UnlockAccountBind;
import com.nt.Constant.AppConstant;
import com.nt.Services.AccountService;

@RestController
public class AccountRestController {

	@Autowired
	private AccountService service;
	
	
	Logger logger=LoggerFactory.getLogger(AccountRestController.class);
	
	@PostMapping("/acc_user")
	public ResponseEntity<String>userAccount(@RequestBody CreateUserBind bind){
		boolean result=service.createUser(bind);
		logger.debug("Account Creation Process Started");
		if(result) {
			logger.info("Account Creation Successfully");
			return new ResponseEntity<>(AppConstant.ACCOUNT_CREATION,HttpStatus.CREATED);
		}
		logger.info("Account Creation Successfully");
		logger.debug("Account Creation Process End");
		return new ResponseEntity<>(AppConstant.ACCOUNT_CREATION_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<CreateUserBind>>getUsers(CreateUserBind bind){
		logger.debug("All Users Fetched Process Started...");
		List<CreateUserBind> userbind =service.viewUsers();
		logger.info("All Users Fetched..");
		logger.debug("All Users Fetched Process End...");
		return new ResponseEntity<>(userbind, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<CreateUserBind> getUser(@PathVariable("id") Integer id){
		logger.debug(" User Fetched Process Started...");
		CreateUserBind bind=service.getUserById(id);
		logger.info("User Fetched Successfully");
		logger.debug(" User Fetched Process End...");
		return new ResponseEntity<>(bind, HttpStatus.OK);
	}
	
	@PutMapping("/usersw/{id}")
	public ResponseEntity<List<CreateUserBind>>changeSw(@PathVariable("id") Integer id){
		logger.debug("Account Status Changed Process Started");
		service.changeAccStatus(id);
		logger.info("Account Status Changed Successfully");
		List<CreateUserBind> userbind =service.viewUsers();	
		logger.info("View Accounts Status Changed");
		logger.debug("Account Status Changed Process Started");
		return new ResponseEntity<>(userbind, HttpStatus.OK);
	}
	
	@PostMapping("/unlock")
	public ResponseEntity<String>unlockAcc(@RequestBody UnlockAccountBind accountBind){
		String result=service.unlockAcc(accountBind);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
}
