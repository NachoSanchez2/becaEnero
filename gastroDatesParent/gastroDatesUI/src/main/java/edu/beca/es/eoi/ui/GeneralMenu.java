package edu.beca.es.eoi.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class GeneralMenu {
	// Constantes
	public static final int GUEST = 1;
	public static final int LOGIN = 2;
	public static final int REGISTER = 3;

	public static final Scanner ESCANER = new Scanner(System.in);
	public static Logger logger = Logger.getLogger(GeneralMenu.class);

	// Declaracion de variables estaticas
	public static int visitCounter = 0;
	public static int userOption = 0;

	public static void printGeneralMenu() {
		System.out.println("  Bienvenido a GASTRODATE  ");
		System.out.println("***************************");
		System.out.println(" 1.- Seguir como invitado");
		System.out.println(" 2.- Entrar");
		System.out.println(" 3.- Registrarse");
		System.out.println("***************************");

		// Hay que probar esta parte
		try {
			userOption = ESCANER.nextInt();
		} catch (InputMismatchException e) {
			logger.debug("La opcion introducida no es correcta, porfavor vuelva a intentarlo");
			GeneralMenu.printGeneralMenu();
		}

		switch (userOption) {
		case GUEST:
			logger.info("Entro en la opcion GUEST");
			visitCounter++;
			GuestMainMenu.printGuestMenu(GuestMainMenu.createGuest(visitCounter));
			break;
		case LOGIN:
			logger.info("Entro en la opcion LOGIN");
			LoginMenu.printMenuLogin();
			break;
		case REGISTER:
			logger.info("Entro en la opcion REGISTER");
			RegisterMenu.printMenuRegister();
			break;
		}
		ESCANER.close();
	}
}
