package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;
import edu.beca.es.eoi.service.LoginService;

//Implementacion de la logica de empresa
public class LoginServiceImpl implements LoginService {

	public static final PersonRepository REPOSITORY = new PersonRepositoryJDBCImpl();

	@Override
	public User login(String user, String password) {

		User entity = (User) REPOSITORY.read(user);

		if (entity != null && entity.getPassword().equals(password)) {
			return entity;
		} else {
			return null;
		}
	}

	public User read(String username) {
		User entity = (User) REPOSITORY.read(username);
		if (entity != null) {
			return entity;
		} else {
			return null;
		}
	}
}
