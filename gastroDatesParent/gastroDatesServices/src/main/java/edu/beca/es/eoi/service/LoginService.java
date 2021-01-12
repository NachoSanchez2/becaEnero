package edu.beca.es.eoi.service;

import edu.beca.es.eoi.entity.User;

public interface LoginService {
	
	public User login(String user,String password);

}
