package edu.beca.es.eoi.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import edu.beca.es.eoi.controller.RegisterController;

public class RegisterMenu {

	public static final Scanner ESCANER = new Scanner(System.in);

	public static void printMenuRegister() {

		RegisterController controller = new RegisterController();

		System.out.println(" Enhorabuena ya has dado el primer paso ");
		System.out.println("****************************************");
		System.out.println("¿Cual es tu nombre?");
		String name = ESCANER.nextLine();
		System.out.println("y ¿tus apellidos?");
		String surname = ESCANER.nextLine();

		Date bdt = parseDate();

		String username = usernameValidation(controller);

		String password = passwordValidation(controller);

		System.out.println("Introduce un email");
		String mail = ESCANER.nextLine();

		// FALTA EL GENERO

		System.out.println("¿Donde vives?");
		String address = ESCANER.nextLine();

		System.out.println("¿Cual es tu telefono mobil?");
		String phoneNumber = ESCANER.nextLine();

		try {
			controller.register(name, surname, bdt, username, password, mail, null, address, phoneNumber);
		} catch (Exception e) {
			System.out.println("Ha habido un error al intentar registrar el usuario, por favor intentelo de nuevo");
			RegisterMenu.printMenuRegister();
		}
		ESCANER.close();
	}

	private static String passwordValidation(RegisterController controller) {
		String password;
		String passwordRepeat;
		do {
			System.out.println("Escribe una contraseÃ±a");
			password = ESCANER.nextLine();
			System.out.println("Vuelve a introducir la contraseÃ±a");
			passwordRepeat = ESCANER.nextLine();
		} while (!controller.passwordVerification(password, passwordRepeat));
		return password;
	}

	private static String usernameValidation(RegisterController controller) {
		String username;
		do {
			System.out.println("Elige un nombre de usuario");
			username = ESCANER.nextLine();
		} while (!controller.usernameVerification(username));
		return username;
	}

	private static Date parseDate() {

		// SE HACE ASÃ? LA FECHA DE NACIMIENTO (PREGUNTA)
		System.out.println("¿Cual es tu fecha de nacimiento? dd/MM/yyyy ");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		String dd = ESCANER.nextLine();
		String MM = ESCANER.nextLine();
		String yyyy = ESCANER.nextLine();
		String date = dd.concat("/".concat(MM)).concat("/".concat(yyyy));

		Date bdt = null;
		try {
			bdt = formato.parse(date);
		} catch (ParseException e) {
			System.out.println("Ha habido un problema con la fecha de nacimiento");
			RegisterMenu.printMenuRegister();
		}
		return bdt;
	}
}