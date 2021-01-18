package edu.beca.es.eoi.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.controller.ProfileController;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.enums.CookPreferences;
import edu.beca.es.eoi.main.MainApp;

public class SaveProfileMenu {
	public static final int MEAT = 1;
	public static final int FISH = 2;
	public static final int SHELLFISH = 3;
	public static final int SEAFOOD = 4;
	public static final int DESSERT = 5;
	public static final int VEGETABLES = 6;
	public static final int FRUITS = 7;
	public static final int GRAINS = 8;
	public static final int POULTRY = 9;
	public static final int VEGANFOOD = 10;
	public static final int FITFOOD = 11;
	public static final int EXIT = 12;

	public static final Scanner ESCANER = new Scanner(System.in);
	public static final ProfileController CONTROLLER = new ProfileController();
	public static Logger logger = Logger.getLogger(GeneralMenu.class);

	public static void printSaveProfileMenu() {
		logger.info("Entro en el menu de saveProfile");
		System.out.println("Ha entrado en el menu de creacion del Perfil");
		System.out.println("*************************************************");
		System.out.println("Diganos algo sobre usted, para poder encontrar preferencias de su agrado");
		String description = ESCANER.nextLine();
		System.out.println("Introduzca la foto de perfil");
		String photo = ESCANER.nextLine();
		String cookPreference = printCookPreferencesMenu();
		User user = MainApp.user;
		try {
			CONTROLLER.saveProfile(user, description, photo, cookPreference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			SaveProfileMenu.printSaveProfileMenu();
		}
		logger.info("Sale del menu saveProfile");
		ESCANER.close();
	}

	private static String printCookPreferencesMenu() {
		logger.info("Entra en el menu de eleccion de preferencias");
		String cookPreference = "";

		System.out.println("Elija la opcion que mas le guste");
		System.out.println("**********************************");
		System.out.println(" 1.- Carne");
		System.out.println(" 2.- Pescado");
		System.out.println(" 3.- Marisco");
		System.out.println(" 4.- Moluscos");
		System.out.println(" 5.- Postres");
		System.out.println(" 6.- Verduras");
		System.out.println(" 7.- Frutas");
		System.out.println(" 8.- Semolas");
		System.out.println(" 9.- Aves de corral");
		System.out.println("10.- Comida vegana");
		System.out.println("11.- Comida fit");
		System.out.println("12.- EXIT");
		try {
			int userOption = ESCANER.nextInt();
			cookPreferencesOptions(cookPreference, userOption);
		} catch (InputMismatchException e) {
			System.out.println("La opcion que ha seleccionado no corresponde, pruebe de nuevo");
			SaveProfileMenu.printCookPreferencesMenu();
		}
		logger.info("sale del menu de eleccion de preferencias");
		return cookPreference;
	}

	private static void cookPreferencesOptions(String cookPreference, int userOption) {
		switch (userOption) {

		case MEAT:
			cookPreference = CookPreferences.MEAT.getLiteral();
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case FISH:
			cookPreference = CookPreferences.FISH.getLiteral();
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case SHELLFISH:
			cookPreference = CookPreferences.SHELLFISH.getLiteral();
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case SEAFOOD:
			cookPreference = CookPreferences.SEAFOOD.getLiteral();
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case DESSERT:
			cookPreference = CookPreferences.DESSERT.getLiteral();
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case VEGETABLES:
			cookPreference = CookPreferences.VEGETABLES.getLiteral();
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case FRUITS:
			cookPreference = CookPreferences.FRUITS.getLiteral();
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case GRAINS:
			cookPreference = CookPreferences.GRAINS.getLiteral();
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case POULTRY:
			cookPreference = CookPreferences.POULTRY.getLiteral();
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case VEGANFOOD:
			cookPreference = CookPreferences.VEGANFOOD.getLiteral();
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case FITFOOD:
			cookPreference = CookPreferences.FITFOOD.getLiteral();
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case EXIT:
			break;
		}
	}

	public static void printUploadProfileMenu() {
		logger.info("Entro en el menu de updateProfile");
		User user = MainApp.user;
		System.out.println("Ha entrado en el menu de configuracion del Perfil");
		System.out.println("*************************************************");
		System.out.println("Escriba la nueva descripcion, lo normal es que mejore la anterior");
		String newDescription = ESCANER.nextLine();
		System.out.println("Introduzca la nueva foto de perfil");
		String newPhoto = ESCANER.nextLine();
		String newCookPreference = printCookPreferencesMenu();
		try {
			CONTROLLER.saveProfile(user, newDescription, newPhoto, newCookPreference);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			SaveProfileMenu.printSaveProfileMenu();
		}
		logger.info("Sale del menu updateProfile");
		ESCANER.close();

	}
}
