package edu.beca.es.eoi.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.controller.RecipeController;
import edu.beca.es.eoi.entity.Ingredient;
import edu.beca.es.eoi.entity.Recipe;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.main.MainApp;

public class RecipeMenu {

	public static final int NEWINGREDIENT = 1;
	public static final int EXIT = 2;
	public static final Scanner ESCANERENTEROS = new Scanner(System.in);
	public static final Scanner ESCANERSTRINGS = new Scanner(System.in);
	public static final Scanner ESCANERDOUBLES = new Scanner(System.in);
	public static final RecipeController CONTROLLER = new RecipeController();

	public static Logger logger = Logger.getLogger(RecipeMenu.class);

	public static void printPublishRecipeMenu() {
		// DECLARATION
		double price = 0.0;
		double amount = 0.0;
		User user = MainApp.user;
		logger.info("Entro en el metodo printPublishRecipe");

		System.out.println("     Nueva receta     ");
		System.out.println("**********************");
		System.out.println("Nombre de la receta");
		String nameRecipe = ESCANERSTRINGS.nextLine();
		System.out.println("Decribe un poco la receta");
		String description = ESCANERSTRINGS.nextLine();
		System.out.println("Una imagen vale mas que mil palabras, introduce una imagen");
		String photo = ESCANERSTRINGS.nextLine();
		System.out.println("Nombre del ingrediente");
		String ingredientName = ESCANERSTRINGS.nextLine();
		System.out.println("Cantidad necesaria");
		try {
			amount = ESCANERDOUBLES.nextDouble();
		} catch (InputMismatchException e) {
			logger.debug("La cantidad introducida no es valida, asegurese de poner ,0 si la cantidad es exacta");
			RecipeMenu.printPublishRecipeMenu();
		}
		System.out.println("Que precio tiene la unidad?");
		try {
			price = ESCANERDOUBLES.nextDouble();
		} catch (InputMismatchException e) {
			logger.debug("El precio introducido no es valido, asegurese de poner ,0 si el precio es exacto");
			RecipeMenu.printPublishRecipeMenu();
		}

		try {
			CONTROLLER.publishRecipe(user, nameRecipe, description, photo, ingredientName, amount, price);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("Ha habido un error al intentar publicar la receta");
			printPublishRecipeMenu();
		}
		logger.info("Salgo del metodo printPublishRecipe y cierro los escaner");
		ESCANERENTEROS.close();
		ESCANERSTRINGS.close();
		ESCANERDOUBLES.close();
	}

//	private static Set<Ingredient> printIngredientsMenu() {
//		Set<Ingredient> ingredients = new HashSet<Ingredient>();
//		int userOption = 0;
//		System.out.println("INGREDIENTES");
//		System.out.println("************");
//		System.out.println("1.- Añadir Ingrediente");
//		System.out.println("2.- Salir");
//
//		try {
//			userOption = ESCANERENTEROS.nextInt();
//		} catch (InputMismatchException e) {
//			logger.debug("La opcion elegida no es correcta");
//			RecipeMenu.printIngredientsMenu();
//		}
//		switch (userOption) {
//		case NEWINGREDIENT:
//			ingredients.add(newIngredient());
//			RecipeMenu.printIngredientsMenu();
//			break;
//		case EXIT:
//			break;
//		}
//		return ingredients;
//	}
//
//	private static Ingredient newIngredient() {
//		double price = 0.0;
//		double amount = 0.0;
//		System.out.println("Nombre del ingrediente");
//		String ingredientName = ESCANERSTRINGS.nextLine();
//		System.out.println("Cantidad necesaria");
//		try {
//			amount = ESCANERDOUBLES.nextDouble();
//		} catch (InputMismatchException e) {
//			logger.debug("La cantidad introducida no es valida, asegurese de poner ,0 si la cantidad es exacta");
//			RecipeMenu.printIngredientsMenu();
//		}
//		System.out.println("Que precio tiene la unidad?");
//		try {
//			price = ESCANERDOUBLES.nextDouble();
//		} catch (InputMismatchException e) {
//			logger.debug("El precio introducido no es valido, asegurese de poner ,0 si el precio es exacto");
//			RecipeMenu.printIngredientsMenu();
//		}
//		return new Ingredient(ingredientName, amount, price);
//	}
//
//	public static void printShareRecipeMenu() {
//
//	}

	public static void printValorateRecipeMenu() {
		System.out.println("¿Que receta quieres valorar? Introduce el nombre de la receta");
		String recipeName = ESCANERSTRINGS.nextLine();
		Recipe recipeToValore = null;

		try {
			recipeToValore = CONTROLLER.readRecipe(recipeName);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("No se ha encontrado la receta que intenta valorar");
			printValorateRecipeMenu();
		}

		if (recipeToValore != null) {
			System.out.println("RECETA");
			System.out.println(recipeToValore.getRecipeName());
			System.out.println("*****************************");
			System.out.println(
					"Que valoracion quieres ponerle? Recuerda que el valor introducido va en forma decimal y separado con coma");
			double valoration = ESCANERDOUBLES.nextDouble();

			try {
				CONTROLLER.valorateRecipe(recipeToValore, valoration);
			} catch (Exception e) {
				e.printStackTrace();
				logger.debug("Ha habido un error al intentar valorar esta receta");
				printValorateRecipeMenu();
			}
		}

	}

	public static void printAllRecipes() {
		List<Recipe> recipes = CONTROLLER.readAll();

		for (Recipe recipe : recipes) {
			System.out.println("\n" + recipe.getRecipeName());
			System.out.println("*****************************");
			System.out.println("	Valoration: " + recipe.getValoration());
			System.out.println("***********************************");
			System.out.println("	Ingredients:");
			System.out.println("***********************************");
			Ingredient ingredient = recipe.getIngredients();
			System.out.println(ingredient.getName());
			System.out.println(Double.toString(ingredient.getAmount()).concat(" g"));
			System.out.println(Double.toString(ingredient.getPrice()).concat(" EUR"));
			System.out.println("*****************************");
		}
	}
}
