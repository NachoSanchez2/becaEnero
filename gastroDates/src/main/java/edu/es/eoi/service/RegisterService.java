package edu.es.eoi.service;

import java.util.Date;

import edu.es.eoi.entity.User;
import edu.es.eoi.enums.Gender;

public interface RegisterService {
	
	public User userRegister(String name, String surname, Date bdt, String username, String password, String mail,
			Gender gender, String address, String phoneNumber);

	public boolean usernameVerification(String username);

//	public Chef chefRegister();
}
