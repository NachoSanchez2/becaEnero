package edu.beca.es.eoi.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.controller.RegisterController;

public class RegisterMenu {
	// TODO: Faltan los test e introducir la fecha de nacimiento y el genero
	public static final Scanner ESCANER = new Scanner(System.in);
	public static final RegisterController CONTROLLER = new RegisterController();
	public static Logger logger = Logger.getLogger(RegisterMenu.class);

	public static void printMenuRegister() {

		System.out.println(" Enhorabuena ya has dado el primer paso ");
		System.out.println("****************************************");
		System.out.println("¿Cual es tu nombre?");
		String name = ESCANER.nextLine();
		System.out.println("y ¿tus apellidos?");
		String surname = ESCANER.nextLine();

		String username = usernameValidation();

		String password = passwordValidation();

		System.out.println("Introduce un email");
		String mail = ESCANER.nextLine();

		// FALTA EL GENERO

		System.out.println("¿Donde vives?");
		String address = ESCANER.nextLine();

		System.out.println("¿Cual es tu telefono mobil?");
		String phoneNumber = ESCANER.nextLine();

		try {
			CONTROLLER.register(name, surname, username, password, mail, address, phoneNumber);
		} catch (Exception e) {
			logger.debug("Ha habido un error al intentar registrar el usuario, por favor intentelo de nuevo");
			RegisterMenu.printMenuRegister();
		}
		ESCANER.close();
	}

	private static String passwordValidation() {
		String password;
		String passwordRepeat;

		System.out.println("Escribe una contraseña");
		password = ESCANER.nextLine();
		System.out.println("Vuelve a introducir la contraseÃ±a");
		passwordRepeat = ESCANER.nextLine();
		try {
			CONTROLLER.passwordVerification(password, passwordRepeat);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("La contraseña que intenta introducir no concuerda con la anterior, vuelvalo a intentar");
			passwordValidation();
		}

		return password;

	}

	private static String usernameValidation() {
		String username;

		System.out.println("Introduce un nombre de usuario que sea bonito");
		username = ESCANER.nextLine();

		try {
			CONTROLLER.usernameVerification(username);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("El usuario que intenta añadir ya está registrado, intentelo de nuevo");
			usernameValidation();
		}

		return username;

	}

//	private static Date parseDate() {
//
//		// SE HACE ASI LA FECHA DE NACIMIENTO (PREGUNTA)
//		System.out.println("¿Cual es tu fecha de nacimiento? dd/MM/yyyy ");
//		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//
//		String dd = ESCANER.nextLine();
//		String MM = ESCANER.nextLine();
//		String yyyy = ESCANER.nextLine();
//		String date = dd.concat("/".concat(MM)).concat("/".concat(yyyy));
//
//		Date bdt = null;
//		try {
//			bdt = formato.parse(date);
//		} catch (ParseException e) {
//			System.out.println("Ha habido un problema con la fecha de nacimiento");
//			RegisterMenu.printMenuRegister();
//		}
//		return bdt;
//	}
}