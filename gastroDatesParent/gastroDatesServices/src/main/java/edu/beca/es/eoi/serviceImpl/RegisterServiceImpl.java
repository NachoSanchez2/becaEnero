package edu.beca.es.eoi.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;
import edu.beca.es.eoi.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

	public static final PersonRepository REPOSITORY = new PersonRepositoryJDBCImpl();

	public Person userRegister(String name, String surname, String username, String password, String mail,
			String address, String phoneNumber) {

		Person entity = new User(name, surname, username, password, mail, address, phoneNumber);
		REPOSITORY.save(entity);

		return entity;
	}

	public List<String> readAll() {
		List<String> usernames = new ArrayList<String>();
		usernames = REPOSITORY.readAll();
		return usernames;
	}

}
