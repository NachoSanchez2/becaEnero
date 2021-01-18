package edu.beca.es.eoi.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.main.MainApp;

public class UserMainMenu {

	public static final int PUBLISHRECIPE = 1;
	public static final int SHARERECIPE = 2;
	public static final int VALORATERECIPE = 3;
	public static final int SHOWRECIPES = 4;
	public static final int MATCH = 5;
	public static final int UPDATEPERFIL = 6;
	public static final int EXIT = 7;
	public static final Scanner ESCANER = new Scanner(System.in);

	public static Logger logger = Logger.getLogger(GeneralMenu.class);
	public static int opcionUsuario;

	public static void printMenuMain() {
		logger.info("Entra en el menu general con perfil");
		System.out.println("Bienvenido " + MainApp.user.getName() + " al menu principal de GastroDates");
		System.out.println("***********************************************************************************");
		System.out.println(" 1.- Publicar receta");
		System.out.println(" 2.- Valorar receta");
		System.out.println(" 3.- Ver todas las recetas");
		System.out.println(" 4.- Modificar perfil");
		System.out.println(" 5.- Cerrar session");
		System.out.println("***********************************************************************************");

		try {
			opcionUsuario = ESCANER.nextInt();
		} catch (InputMismatchException e) {
			logger.debug("La opcion elegida no es valida, por favor intentelo de nuevo");
			UserMainMenu.printMenuMain();
		}

		switch (opcionUsuario) {

		case PUBLISHRECIPE:
			logger.info("Entra en la opcion publicar receta");
			RecipeMenu.printPublishRecipeMenu();
			UserMainMenu.printMenuMain();
			break;

		case VALORATERECIPE:
			logger.info("Entra en la opcion valorar receta");
			RecipeMenu.printValorateRecipeMenu();
			UserMainMenu.printMenuMain();
			break;
		case SHOWRECIPES:
			logger.info("Entra en la opcion enseñar recetas");
			RecipeMenu.printAllRecipes();
			UserMainMenu.printMenuMain();
			break;

		case UPDATEPERFIL:
			logger.info("Entra en la opcion modificar perfil");
			SaveProfileMenu.printUploadProfileMenu();
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
