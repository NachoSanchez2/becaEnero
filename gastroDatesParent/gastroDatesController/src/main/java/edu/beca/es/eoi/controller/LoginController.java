package edu.beca.es.eoi.controller;

import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.main.MainApp;
import edu.beca.es.eoi.service.LoginService;
import edu.beca.es.eoi.serviceImpl.LoginServiceImpl;
import edu.beca.es.eoi.ui.LoginMenu;
import edu.beca.es.eoi.ui.UserMainMenu;
import edu.beca.es.eoi.ui.UserMainMenuWhithoutProfile;

//Controlador o intermediario entra la logica de empresa y la peticion del usuario
public class LoginController {
	public static final LoginService SERVICE = new LoginServiceImpl();

	public void login(String user, String password) throws Exception {

		if (password.length() <= 4) {
			throw new Exception("Formato de password incorrecto");
		}

		if (SERVICE.login(user, password) != null) {
			if (((User) SERVICE.login(user, password)).getProfile() != null) {
				UserMainMenu.printMenuMain();
			} else {
				MainApp.user = (User) SERVICE.login(user, password);
				UserMainMenuWhithoutProfile.printMenuMain();
			}
		} else {
			System.out.println("usuario no encontrado");
			LoginMenu.printMenuLogin();
		}
	}
}
