package edu.beca.es.eoi.controller;

import java.util.List;

import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.main.MainApp;
import edu.beca.es.eoi.service.RegisterService;
import edu.beca.es.eoi.serviceImpl.RegisterServiceImpl;
import edu.beca.es.eoi.ui.UserMainMenuWhithoutProfile;

public class RegisterController {
	// TODO: Hacer test para el controlador de registro add Logger;

	protected static final RegisterService REGISTERSERVICE = new RegisterServiceImpl();

	public void register(String name, String Surname, String username, String password, String mail, String adress,
			String phoneNumber) throws Exception {

		if (name.equalsIgnoreCase(null) || password.equals(null)) {
			throw new Exception("Ha habido un error con el nombre o la contraseña");
		} else {
			MainApp.user = (User) REGISTERSERVICE.userRegister(name, Surname, username, password, mail, adress,
					phoneNumber);
			UserMainMenuWhithoutProfile.printMenuMain();
		}
	}

	// Esto se haría con javascript(PREGUNTA)
	public boolean usernameVerification(String username) throws Exception {
		List<String> usernames = REGISTERSERVICE.readAll();
		boolean usernameOK = false;
		for (String AUXusername : usernames) {
			if (AUXusername.equalsIgnoreCase(username)) {
				usernameOK = true;
			} else {
				throw new Exception("El usuario que intenta registrar ya se encuentra registrado");
			}
		}
		return usernameOK;
	}

	public boolean passwordVerification(String password, String passwordRepeat) {
		if (password.equalsIgnoreCase(passwordRepeat)) {
			return true;
		} else {
			return false;
		}
	}
}