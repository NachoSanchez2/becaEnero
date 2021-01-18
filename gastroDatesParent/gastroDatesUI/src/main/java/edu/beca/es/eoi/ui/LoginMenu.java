package edu.beca.es.eoi.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.controller.LoginController;

public class LoginMenu {
	// TODO: Faltan los test de LoginMenu
	public static final Scanner ESCANER = new Scanner(System.in);
	public static final LoginController CONTROLLER = new LoginController();

	public static Logger logger = Logger.getLogger(LoginMenu.class);

	public static void printMenuLogin() {

		System.out.println("Bienvenido al menu Login de GastroDates");
		System.out.println("***************************************");
		System.out.println("Introduzca nombre de usuario: ");
		String user = ESCANER.nextLine();

		System.out.println("Introduzca la contraseña: ");
		String password = ESCANER.nextLine();

		try {
			CONTROLLER.login(user, password);
		} catch (Exception e) {
			logger.debug("Se ha producido un error,la longitud de la contraseña no es válida");
			printMenuLogin();
		}
		ESCANER.close();
	}
}
