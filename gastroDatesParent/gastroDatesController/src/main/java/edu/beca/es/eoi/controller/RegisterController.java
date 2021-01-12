package edu.beca.es.eoi.controller;

import java.util.Date;

import edu.beca.es.eoi.enums.Gender;
import edu.beca.es.eoi.main.MainApp;
import edu.beca.es.eoi.service.RegisterService;
import edu.beca.es.eoi.serviceImpl.RegisterServiceImpl;
import edu.beca.es.eoi.ui.UserMainMenuWhithoutProfile;

public class RegisterController {

	protected static RegisterService SERVICE = new RegisterServiceImpl();

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
	public boolean usernameVerification(String username) {
		if (MainApp.users.get(username) != null) {
			System.out.println("El usuario ya existe, por favor comprueba que se ha introducido uno nuevo");
			return false;
		}
		return true;
	}

	public boolean passwordVerification(String password, String passwordRepeat) {
		if (password.equalsIgnoreCase(passwordRepeat)) {
			return true;
		} else {
			return false;
		}
	}
}