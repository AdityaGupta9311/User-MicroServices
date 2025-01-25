package com.user.Services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.user.Modals.Users;
import com.user.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<?> createUser(Users users) {
		Users existUseremail = userRepository.findByEmail(users.getEmail());
		if (existUseremail != null) {
			return new ResponseEntity<>("This Email is already exist",HttpStatus.CONFLICT);
		}
		
		Users existUserphoneno = userRepository.findByPhoneNo(users.getPhoneNo());
		if (existUserphoneno != null) {
			return new ResponseEntity<>("This Phone Number is already exist",HttpStatus.CONFLICT);
		}
		
		users.setCreatedAt(LocalDateTime.now());
		users.setUpdatedAt(LocalDateTime.now());
		return new ResponseEntity<>("User Successfully Added",HttpStatus.CREATED);
	}

	public Users loginUser(String email, String password) throws Exception {
		Users user = userRepository.findByEmail(email);
		if (user != null && user.getPassword().matches(password)) {
			return user;
		}
		throw new Exception("invalid");
	}
}
