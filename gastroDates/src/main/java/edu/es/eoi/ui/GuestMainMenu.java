package edu.es.eoi.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.es.eoi.entity.Guest;
import edu.es.eoi.main.MainApp;

public class GuestMainMenu {

	public static final int PUBLISH = 1;
	public static final int SEARCH = 2;
	public static final int REGISTER = 3;
	public static final int EXIT = 4;
	public static final Scanner ESCANER = new Scanner(System.in);

	public static int userOption = 0;

	public static void printMenuGuest(Guest guest) {
		System.out.println("Bienvenido " + MainApp.guest);
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
		System.out.println(" 1.- Publicar receta" + 
		"\n 2.- Buscar receta" + "\n 3.- Registrarse" + "\n 4.- Salir");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");

		// Probar que esto funciona
		try {
			userOption = ESCANER.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("La opcion que desea introducir no es correcta, por favor vuelva a intentarlo");
			GuestMainMenu.printMenuGuest(guest);
		}

		switch (userOption) {
		case PUBLISH:
			break;
		case SEARCH:
			break;
		case REGISTER:
			break;
		case EXIT:
			MainApp.guest = null;
			MenuGeneral.menuGeneralPrint();
			break;
		}
	}

	public static Guest createGuest(int visitCounter) {
		Guest guest = new Guest(visitCounter);
		MainApp.guests.put(guest.getId(), guest);
		MainApp.guest = guest;
		return guest;
	}

}
