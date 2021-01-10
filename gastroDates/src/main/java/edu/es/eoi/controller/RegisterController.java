package edu.es.eoi.controller;

import java.util.Date;

import edu.es.eoi.enums.Gender;
import edu.es.eoi.main.MainApp;
import edu.es.eoi.service.RegisterService;
import edu.es.eoi.serviceImpl.RegisterServiceImpl;
import edu.es.eoi.ui.UserMainMenu;
import edu.es.eoi.ui.UserMainMenuWhithoutProfile;

public class RegisterController {

	protected static final RegisterService SERVICE = new RegisterServiceImpl();

	public void register(String name, String Surname, Date bdt, String username, String password, String mail,
			Gender gender, String adress, String phoneNumber) throws Exception {

		// Compruebo que como minimo para registrarse tiene que haber un nombre y una
		// contrasenya

		if (name.equalsIgnoreCase(null) || password.equals(null)) {
			throw new Exception("Ha habido un error con el nombre o la contraseña");
		} else {
			MainApp.user = SERVICE.userRegister(name, Surname, bdt, username, password, mail, gender, adress,
					phoneNumber);
			UserMainMenuWhithoutProfile.printMenuMain();
		}
	}

	// Esto se haría con javascript(PREGUNTA)
	public String usernameVerification(String username) {
		if (!SERVICE.usernameVerification(username)) {
			System.out.println("El usuario ya existe, por favor comprueba que se ha introducido uno nuevo");
			return null;
		} else {
			return username;
		}
	}

	public boolean passwordVerification(String password, String passwordRepeat) {
		if (password.equalsIgnoreCase(passwordRepeat)) {
			return true;
		} else {
			return false;
		}
	}
}