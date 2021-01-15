package edu.beca.es.eoi.service;

import java.util.Date;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.enums.Gender;

public interface RegisterService {

	public Person userRegister(String name, String surname, Date bdt, String username, String password, String mail,
			Gender gender, String address, String phoneNumber);

//	public Chef chefRegister();
}
