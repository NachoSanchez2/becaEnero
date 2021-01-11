package edu.es.eoi.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.es.eoi.main.MainApp;

public class UserMainMenu {

	public static final int PUBLISHRECIPE = 1;
	public static final int SHARERECIPE = 2;
	public static final int VALORATERECIPE = 3;
	public static final int SHOWRECIPES = 4;
	public static final int MATCH = 5;
	public static final int UPDATEPERFIL = 6;
	public static final int EXIT = 7;
	public static final Scanner ESCANER = new Scanner(System.in);

	public static int opcionUsuario;

	public static void printMenuMain() {
		System.out.println("/nBienvenido " + MainApp.user.getName() + " al menu principal de GastroDates");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
		System.out.println(" 1.- Publicar receta");
		System.out.println(" 2.- Compartir receta");
		System.out.println(" 3.- Valorar receta");
		System.out.println(" 4.- Ver todas las recetas");
		System.out.println(" 5.- Comprobar Match");
		System.out.println(" 6.- Modificar perfil");
		System.out.println(" 7.- Cerrar session");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");

		try {
			opcionUsuario = ESCANER.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("La opcion elegida no es valida, por favor inténtelo de nuevo");
			UserMainMenu.printMenuMain();
		}

		switch (opcionUsuario) {

		case PUBLISHRECIPE:
			RecipeMenu.printPublishRecipeMenu();
			UserMainMenu.printMenuMain();
			break;

		case SHARERECIPE:
			RecipeMenu.printShareRecipeMenu();
			UserMainMenu.printMenuMain();
			break;
		case VALORATERECIPE:
			RecipeMenu.printValorateRecipeMenu();
			UserMainMenu.printMenuMain();
			break;
		case SHOWRECIPES:
			RecipeMenu.printAllRecipes();
			UserMainMenu.printMenuMain();
			break;
		case MATCH:

			break;

		case UPDATEPERFIL:

			break;

		case EXIT:
			MainApp.user = null;
			GeneralMenu.printGeneralMenu();
			break;
		}

		ESCANER.close();
	}

}
