package edu.beca.es.eoi.service;

import java.util.List;

import edu.beca.es.eoi.entity.Person;

public interface RegisterService {

	Person userRegister(String name, String surname, String username, String password, String mail, String address,
			String phoneNumber);

	List<String> readAll();
//	public Chef chefRegister();
}
