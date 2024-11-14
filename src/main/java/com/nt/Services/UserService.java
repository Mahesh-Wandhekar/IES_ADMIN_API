package com.nt.Services;


import org.springframework.stereotype.Service;

import com.nt.Binding.CreateUserBind;
import com.nt.Binding.UserDashBoard;
import com.nt.Binding.UserLogin;

@Service
public interface UserService {

	
	public String login(UserLogin userLogin);
	
	public UserDashBoard getDashboard();
	
	public CreateUserBind getByEmail(String email);
	
	public boolean  recoverPwd(String email);
	
}
