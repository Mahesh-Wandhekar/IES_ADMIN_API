package com.nt.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Binding.CreateUserBind;
import com.nt.Binding.UserDashBoard;
import com.nt.Binding.UserLogin;
import com.nt.Services.UserService;

@RestController
public class UserRestController {

	Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private UserService userService;

	@PostMapping("login")
	public String login(@RequestBody UserLogin login) {
		logger.debug("User Login Process Started");
		
		String status = userService.login(login);
		if ("Success".contains(status)) {
			logger.info("User Login Successfully");
			return "redirect:/dashboard?email=" + login.getEmail();
		}
		logger.info("User Login Failed");
		logger.debug("User Login Process Started");
		return status;
	}

	@GetMapping("/dashboard")
	public ResponseEntity<UserDashBoard> getDashBoard(@RequestParam("email") String email) {
		logger.debug("Display User DashBoard Process Started..");
		CreateUserBind userBind = userService.getByEmail(email);
		logger.info("Display User Base On Email");		
		UserDashBoard board = userService.getDashboard();
		logger.info("User DashBoard Display Successfully");
		board.setUserBind(userBind);
		logger.debug("Display User DashBoard Process End..");
		return new ResponseEntity<>(board, HttpStatus.OK);
	}

	@GetMapping("/forgotpwd/{email}")
	public ResponseEntity<String> recoverPassword(@PathVariable("email") String email) {
		logger.debug("Recover Password Proccess Started..");
		boolean status = userService.recoverPwd(email);
		if (status) {
			logger.info("Recover Password Successfully..");
			return new ResponseEntity<>("Password Send ON Email", HttpStatus.OK);
		}
		logger.info("Recover Password Failed..");
		logger.debug("Recover Password Proccess Started..");
		return new ResponseEntity<>("Action Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
