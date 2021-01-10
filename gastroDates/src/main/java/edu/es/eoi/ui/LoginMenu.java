package edu.es.eoi.ui;

import java.util.Scanner;

import edu.es.eoi.controller.LoginController;

public class LoginMenu {

	public static final Scanner ESCANER = new Scanner(System.in);

	public static void printMenuLogin() {

		LoginController controller = new LoginController();

		System.out.println("Bienvenido al menu Login de GastroDates");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
		System.out.println("Introduzca nombre de usuario: ");
		String user = ESCANER.nextLine();

		System.out.println("Introduzca la contraseña: ");
		String password = ESCANER.nextLine();

		try {
			controller.login(user, password);
		} catch (Exception e) {
			System.out.println("Error en la longitud minima del password");
			printMenuLogin();
		}
		ESCANER.close();
	}
}
