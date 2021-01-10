package edu.es.eoi.serviceImpl;

import java.util.Date;

import edu.es.eoi.entity.Person;
import edu.es.eoi.entity.User;
import edu.es.eoi.enums.Gender;
import edu.es.eoi.main.MainApp;
import edu.es.eoi.repository.PersonRepository;
import edu.es.eoi.repositoryImpl.PersonRepositoryMemoryImpl;
import edu.es.eoi.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

	@Override
	public User userRegister(String name, String surname, Date bdt, String username, String password, String mail,
			Gender gender, String address, String phoneNumber) {

		PersonRepository repository = new PersonRepositoryMemoryImpl();
		Person entity = new User(name, surname, bdt, username, password, mail, gender, address, phoneNumber);
		repository.save(entity);
		return (User) entity;
	}
	@Override
	public boolean usernameVerification(String username) {
		if (MainApp.users.get(username) != null) {
			return false;
		}
		return true;
	}

}
