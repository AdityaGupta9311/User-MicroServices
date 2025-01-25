package com.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.user.Modals.Users;
import com.user.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/create")
	public ResponseEntity<?> registerUser(@RequestBody Users users) {
		return userService.createUser(users);
	}

	@GetMapping("/login")
	public Users login(@RequestBody Users users) throws Exception {
		return userService.loginUser(users.getEmail(), users.getPassword());
	}

}
