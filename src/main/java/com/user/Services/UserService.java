package com.user.Services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Modals.Users;
import com.user.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Users createUser(Users users) {
		users.setCreatedAt(LocalDateTime.now());
		users.setUpdatedAt(LocalDateTime.now());
		return userRepository.save(users);
	}

	public Users deleteUser(Long id) {
		Users user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
		userRepository.deleteById(id);
		return user;
	}
	
	public Users updateUsers(Users users, Long id) {
		Optional<Users> user = userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new RuntimeException("User not found with ID: " + id);
		}
		
		Users oldUsers = user.get();
		
		if(oldUsers.getCity() != null) {
			oldUsers.setCity(users.getCity());
		}
		
		return userRepository.save(oldUsers);
	}
	
}
