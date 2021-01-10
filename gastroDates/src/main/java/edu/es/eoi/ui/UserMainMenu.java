package edu.es.eoi.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.es.eoi.main.MainApp;

public class UserMainMenu {

	public static final int PUBLISHRECIPE = 1;
	public static final int SHOWRECIPES = 2;
	public static final int MATCH = 3;
	public static final int UPDATEPERFIL = 4;
	public static final int EXIT = 5;
	public static final Scanner ESCANERENTEROS = new Scanner(System.in);

	public static int opcionUsuario;

	public static void printMenuMain() {
		System.out.println("/nBienvenido " + MainApp.user.getName() + " al menu principal de GastroDates");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
		System.out.println(" 1.- Publicar receta" + " 2.- Ver todas las recetas" + " 3.- Comprobar Match"
				+ " 4.- Modificar perfil" + " 5.- Cerrar session");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");

		try {
			opcionUsuario = ESCANERENTEROS.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("La opcion elegida no es valida, por favor inténtelo de nuevo");
			UserMainMenu.printMenuMain();
		}

		switch (opcionUsuario) {

		case PUBLISHRECIPE:
			
			break;
			
		case SHOWRECIPES:

			break;
			
		case MATCH:

			break;
			
		case UPDATEPERFIL:

			break;
			
		case EXIT:

			break;
		}
	}

}
