package edu.beca.es.eoi.ui;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import edu.beca.es.eoi.controller.SaveProfileController;
import edu.beca.es.eoi.enums.CookPreferences;

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
	public static SaveProfileController controller = new SaveProfileController();

	public static void printSaveProfileMenu() {
		System.out.println("Ha entrado en el menu de configuracion del Perfil");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
		System.out.println("Díganos algo sobre usted, para poder encontrar preferencias de su agrado");
		String description = ESCANER.nextLine();
		System.out.println("Introduzca la foto de perfil");
		String photo = ESCANER.nextLine();
		Set<CookPreferences> cookPreferences = printCookPreferencesMenu();
		try {
			controller.saveProfileMenu(description, photo, cookPreferences);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			SaveProfileMenu.printSaveProfileMenu();
		}
		ESCANER.close();
	}

	private static Set<CookPreferences> printCookPreferencesMenu() {
		Set<CookPreferences> cookPreferences = new HashSet<CookPreferences>();
		System.out.println("Elija la opción que más le guste");
		System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
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
			cookPreferencesOptions(cookPreferences, userOption);
		} catch (InputMismatchException e) {
			System.out.println("La opcion que ha seleccionado no corresponde, pruebe de nuevo");
			SaveProfileMenu.printCookPreferencesMenu();
		}
		return cookPreferences;
	}

	private static void cookPreferencesOptions(Set<CookPreferences> cookPreferences, int userOption) {
		switch (userOption) {

		case MEAT:
			cookPreferences.add(CookPreferences.MEAT);
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case FISH:
			cookPreferences.add(CookPreferences.FISH);
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case SHELLFISH:
			cookPreferences.add(CookPreferences.SHELLFISH);
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case SEAFOOD:
			cookPreferences.add(CookPreferences.SEAFOOD);
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case DESSERT:
			cookPreferences.add(CookPreferences.DESSERT);
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case VEGETABLES:
			cookPreferences.add(CookPreferences.VEGETABLES);
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case FRUITS:
			cookPreferences.add(CookPreferences.FRUITS);
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case GRAINS:
			cookPreferences.add(CookPreferences.GRAINS);
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case POULTRY:
			cookPreferences.add(CookPreferences.POULTRY);
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case VEGANFOOD:
			cookPreferences.add(CookPreferences.VEGANFOOD);
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case FITFOOD:
			cookPreferences.add(CookPreferences.FITFOOD);
			SaveProfileMenu.printCookPreferencesMenu();
			break;
		case EXIT:
			break;
		}
	}
}
