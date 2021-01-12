package edu.beca.es.eoi.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.beca.es.eoi.main.MainApp;

public class UserMainMenuWhithoutProfile {

	public static final int SAVEPERFIL = 1;
	public static final int PUBLISHRECIPE = 2;
	public static final int VALORATERECIPE = 3;
	public static final int SHOWRECIPES = 4;
	public static final int EXIT = 5;

	public static final Scanner ESCANER = new Scanner(System.in);

	public static int opcionUsuario;

	public static void printMenuMain() {

		System.out.println("         Bienvenido " + MainApp.user.getName() + " al menu principal de GastroDates  ");
		System.out.println("*************************************************************************************");
		System.out.println(" 1.- Crear perfil");
		System.out.println(" 2.- Publicar receta");
		System.out.println(" 3.- Compartir receta");
		System.out.println(" 4.- Valorar receta");
		System.out.println(" 5.- Ver todas las recetas");
		System.out.println(" 6.- Cerrar session");
		System.out.println("*************************************************************************************");

		try {
			opcionUsuario = ESCANER.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("La opcion elegida no es valida, por favor inténtelo de nuevo");
			UserMainMenu.printMenuMain();
		}

		switch (opcionUsuario) {

		case SAVEPERFIL:
			SaveProfileMenu.printSaveProfileMenu();
			break;
		case PUBLISHRECIPE:
//			RecipeMenu.printPublishRecipeMenu();
			UserMainMenuWhithoutProfile.printMenuMain();
			break;
		case VALORATERECIPE:
//			RecipeMenu.printValorateRecipeMenu();
			UserMainMenu.printMenuMain();
			break;
		case SHOWRECIPES:
//			RecipeMenu.printAllRecipes();
			UserMainMenuWhithoutProfile.printMenuMain();
			break;
		case EXIT:
			MainApp.user = null;
			GeneralMenu.printGeneralMenu();
			break;
		}
		ESCANER.close();
	}

}
