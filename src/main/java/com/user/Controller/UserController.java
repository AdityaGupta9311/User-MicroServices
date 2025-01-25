package com.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.user.Modals.Users;
import com.user.Repository.UserRepository;
import com.user.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/create")
	public ResponseEntity<String> registerUser(@RequestBody Users users) {
		Users existUseremail = userRepository.findByEmail(users.getEmail());
		if (existUseremail != null) {
			return new ResponseEntity<>("This Email is already exist",HttpStatus.CONFLICT);
		}
		
		Users existUserphoneno = userRepository.findByPhoneNo(users.getPhoneNo());
		if (existUserphoneno != null) {
			return new ResponseEntity<>("This Phone Number is already exist",HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>("User Successfully Added",HttpStatus.CREATED);
	}

	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestBody Users users) throws Exception {
		return new ResponseEntity<>("Login Successfull",HttpStatus.ACCEPTED);
	}

}
