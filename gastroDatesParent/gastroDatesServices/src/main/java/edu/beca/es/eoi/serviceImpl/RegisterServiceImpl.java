package edu.beca.es.eoi.serviceImpl;

import java.util.Date;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.enums.Gender;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;

public class RegisterServiceImpl implements edu.beca.es.eoi.service.RegisterService {

	@Override
	public Person userRegister(String name, String surname, Date bdt, String username, String password, String mail,
			Gender gender, String address, String phoneNumber) {

		PersonRepository repository = new PersonRepositoryJDBCImpl();
		Person entity = new User(name, surname, username, password, mail, address, phoneNumber);
		repository.save(entity);

		return entity;
	}

}
