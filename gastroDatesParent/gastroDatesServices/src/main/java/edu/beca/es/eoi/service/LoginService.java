package edu.beca.es.eoi.service;

import edu.beca.es.eoi.entity.Person;

public interface LoginService {

	public Person login(String user, String password);

	public Person read(String username);

}
