package com.nt.Services;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nt.Binding.CreateUserBind;
import com.nt.Entity.IESUsersEntity;
import com.nt.Repository.IESUserRepo;

@WebMvcTest(AccountServiceImp.class)
public class AccountServiceImpTest {

	@InjectMocks
    private AccountServiceImp accountService;
	
	@MockBean
	private IESUserRepo iesUserRepo;
	
	
	
	@Test
	public void testCreateUser01() {
		
		CreateUserBind createUserBind = new CreateUserBind();
        createUserBind.setEmail("test@example.com");
        when(iesUserRepo.findByEmail(createUserBind.getEmail())).thenReturn(new IESUsersEntity());
      
        boolean result = accountService.createUser(createUserBind);
    
        assertFalse(result);
       
	}
	
}
