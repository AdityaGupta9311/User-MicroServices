package com.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.Modals.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByEmail(String email);
	
	public Users findByPhoneNo(Long phoneno);
}
