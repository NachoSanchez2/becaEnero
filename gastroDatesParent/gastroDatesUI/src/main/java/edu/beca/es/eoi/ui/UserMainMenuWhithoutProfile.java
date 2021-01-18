package edu.beca.es.eoi.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.main.MainApp;

public class UserMainMenuWhithoutProfile {

	public static final int SAVEPERFIL = 1;
	public static final int PUBLISHRECIPE = 2;
	public static final int VALORATERECIPE = 3;
	public static final int SHOWRECIPES = 4;
	public static final int EXIT = 5;

	public static final Scanner ESCANER = new Scanner(System.in);

	public static Logger logger = Logger.getLogger(GeneralMenu.class);
	public static int opcionUsuario;

	public static void printMenuMain() {

		logger.info("Entra en el menu general sin perfil");

		System.out.println("         Bienvenido " + MainApp.user.getName() + " al menu principal de GastroDates  ");
		System.out.println("*************************************************************************************");
		System.out.println(" 1.- Crear perfil");
		System.out.println(" 2.- Publicar receta");
		System.out.println(" 3.- Valorar receta");
		System.out.println(" 4.- Ver todas las recetas");
		System.out.println(" 5.- Cerrar session");
		System.out.println("*************************************************************************************");

		try {
			opcionUsuario = ESCANER.nextInt();
		} catch (InputMismatchException e) {
			logger.debug("La opcion elegida no es valida, por favor intÃ©ntelo de nuevo");
			UserMainMenu.printMenuMain();
		}

		switch (opcionUsuario) {

		case SAVEPERFIL:
			logger.info("Entra en la opcion crear perfil");
			SaveProfileMenu.printSaveProfileMenu();
			break;
		case PUBLISHRECIPE:
			logger.info("Entra en la opcion publicar receta");
			RecipeMenu.printPublishRecipeMenu();
			UserMainMenuWhithoutProfile.printMenuMain();
			break;
		case VALORATERECIPE:
			logger.info("Entra en la opcion valorar receta");
			RecipeMenu.printValorateRecipeMenu();
			UserMainMenu.printMenuMain();
			break;
		case SHOWRECIPES:
			logger.info("Entra en la opcion enseñar recetas");
			RecipeMenu.printAllRecipes();
			UserMainMenuWhithoutProfile.printMenuMain();
			break;
		case EXIT:
			logger.info("Sale de las opciones");
			MainApp.user = null;
			GeneralMenu.printGeneralMenu();
			break;
		}
		ESCANER.close();
	}

}
