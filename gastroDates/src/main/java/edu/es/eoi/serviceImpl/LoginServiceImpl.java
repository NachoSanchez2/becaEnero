package edu.es.eoi.serviceImpl;

import edu.es.eoi.entity.User;
import edu.es.eoi.repository.PersonRepository;
import edu.es.eoi.repositoryImpl.PersonRepositoryMemoryImpl;
import edu.es.eoi.service.LoginService;

//Implementacion de la logica de empresa
public class LoginServiceImpl implements LoginService {

	@Override
	public User login(String user, String password) {

		PersonRepository repository = new PersonRepositoryMemoryImpl();
		User entity = (User) repository.read(user);

		if (entity != null && entity.getPassword().equals(password)) {
			return entity;
		} else {
			return null;
		}
	}

}
