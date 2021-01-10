package edu.es.eoi.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.es.eoi.main.MainApp;

public class UserMainMenuWhithoutProfile {

	public static final int SAVEPERFIL = 1;
	public static final int PUBLISHRECIPE = 2;
	public static final int SHOWRECIPES = 3;
	public static final int EXIT = 4;
	public static final Scanner ESCANERENTEROS = new Scanner(System.in);

	public static int opcionUsuario;

	public static void printMenuMain() {

		System.out.println("/nBienvenido " + MainApp.user.getName() + " al menu principal de GastroDates");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
		System.out.println(
				" 1.- Crear perfil" + " 2.- Publicar receta" + " 3.- Ver todas las recetas" + " 4.- Cerrar session");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");

		try {
			opcionUsuario = ESCANERENTEROS.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("La opcion elegida no es valida, por favor inténtelo de nuevo");
			UserMainMenu.printMenuMain();
		}

		switch (opcionUsuario) {

		case SAVEPERFIL:
			
			break;
		
		case PUBLISHRECIPE:
			
			break;

		case SHOWRECIPES:

			break;

		case EXIT:

			break;
		}
	}

}
