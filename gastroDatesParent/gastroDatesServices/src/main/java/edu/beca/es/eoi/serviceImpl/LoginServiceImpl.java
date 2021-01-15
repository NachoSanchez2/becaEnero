package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;
import edu.beca.es.eoi.service.LoginService;

//Implementacion de la logica de empresa
public class LoginServiceImpl implements LoginService {

	@Override
	public User login(String user, String password) {

		PersonRepository repository = new PersonRepositoryJDBCImpl();

		User entity = (User) repository.read(user);

		if (entity != null && entity.getPassword().equals(password)) {
			return entity;
		} else {
			return null;
		}
	}

}
