package com.nt.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.Binding.CreateUserBind;
import com.nt.Binding.UnlockAccountBind;



@Service
public interface AccountService {

	public boolean createUser(CreateUserBind createUserBind);
	
	public CreateUserBind getUserById(Integer id);
	
	public List<CreateUserBind> viewUsers();
	
	public String changeAccStatus(Integer id);
	
	public String unlockAcc(UnlockAccountBind unlockAccountBind);
}
