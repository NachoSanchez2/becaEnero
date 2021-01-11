package edu.es.eoi.controller;

import edu.es.eoi.main.MainApp;
import edu.es.eoi.service.LoginService;
import edu.es.eoi.serviceImpl.LoginServiceImpl;
import edu.es.eoi.ui.LoginMenu;
import edu.es.eoi.ui.UserMainMenu;
import edu.es.eoi.ui.UserMainMenuWhithoutProfile;

//Controlador o intermediario entra la logica de empresa y la peticion del usuario
public class LoginController {

	public void login(String user, String password) throws Exception {

		if (password.length() <= 4) {
			throw new Exception("Formato de password incorrecto");
		}

		LoginService service = new LoginServiceImpl();

		if (service.login(user, password) != null) {
			if (service.login(user, password).getProfile() != null) {
				MainApp.user = service.login(user, password);
				UserMainMenu.printMenuMain();
			} else {
				MainApp.user = service.login(user, password);
				UserMainMenuWhithoutProfile.printMenuMain();
			}
		} else {
			System.out.println("usuario no encontrado");
			LoginMenu.printMenuLogin();
		}
	}
}
