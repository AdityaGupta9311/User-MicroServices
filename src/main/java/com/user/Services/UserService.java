package com.user.Services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Modals.Users;
import com.user.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Users createUser(Users users) {
//		Users u1 = new Users();
//		u1.setEmail(users.getEmail());
//		u1.setPassowrd(users.getPassowrd());
		users.setCreatedAt(LocalDateTime.now());
		users.setUpdatedAt(LocalDateTime.now());
		return userRepository.save(users);
	}

	public Users loginUser(String email, String password) throws Exception {
		Users user = userRepository.findByEmail(email);
		if (user != null && user.getPassowrd().matches(password)) {
			return user;
		}
		throw new Exception("invalid");
	}
}
