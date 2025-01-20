package com.user.Modals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	private String name;
	
	private String email;
	
	private String passowrd;
	
	private String city;
	
	private long phoneNo;
	

	
}
