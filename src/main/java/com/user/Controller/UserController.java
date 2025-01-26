package com.user.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.user.Modals.Users;
import com.user.Repository.UserRepository;
import com.user.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
			return new ResponseEntity<>("This Email is already exist", HttpStatus.CONFLICT);
		}

		Users existUserphoneno = userRepository.findByPhoneNo(users.getPhoneNo());
		if (existUserphoneno != null) {
			return new ResponseEntity<>("This Phone Number is already exist", HttpStatus.CONFLICT);
		}
		userService.createUser(users);
		return new ResponseEntity<>("User Successfully Added", HttpStatus.CREATED);
	}

	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestBody Users users) throws Exception {
		Users user = userRepository.findByEmail(users.getEmail());
		if (user != null && user.getPassword().matches(users.getPassword())) {
			return new ResponseEntity<>("Login Successfull", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("Invalid Email Or Password",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/user/{userId}")
	public Users getUserByUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}
	
	@DeleteMapping("/user/delete/{userId}")
	public Users deleteUser(@PathVariable Long userId) {
		 return userService.deleteUser(userId);
	}
	
	@PutMapping("/user/update/{userId}")
	public Users updateUser(@RequestBody Users users,@PathVariable Long userId) {
		 return userService.updateUsers(users, userId);
	}

}
