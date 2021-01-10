package edu.es.eoi.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuGeneral {
	// Constantes
	public static final int GUEST = 1;
	public static final int LOGIN = 2;
	public static final int REGISTER = 3;
	public static final Scanner ESCANERENTEROS = new Scanner(System.in);

	// Declaracion de variables estaticas
	public static int visitCounter = 0;
	public static int userOption = 0;

	public static void menuGeneralPrint() {
		System.out.println("  Bienvenido a GASTRODATE  ");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
		System.out.println(" 1.- Seguir como invitado");
		System.out.println(" 2.- Entrar");
		System.out.println(" 3.- Registrarse");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");

		// Hay que probar esta parte
		try {
			userOption = ESCANERENTEROS.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("La opcion introducida no es correcta, porfavor vuelva a intentarlo");
			MenuGeneral.menuGeneralPrint();
		}

		switch (userOption) {
		case GUEST:
			visitCounter++;
			GuestMainMenu.printMenuGuest(GuestMainMenu.createGuest(visitCounter));
			break;
		case LOGIN:
			LoginMenu.printMenuLogin();
			break;
		case REGISTER:
			RegisterMenu.printMenuRegister();
			break;
		}
	}
}
