//package edu.beca.es.eoi.ui;
//
//import java.util.HashSet;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//import java.util.Set;
//
//import edu.beca.es.eoi.controller.RecipeController;
//import edu.beca.es.eoi.entity.Ingredient;
//import edu.beca.es.eoi.entity.Recipe;
//import edu.beca.es.eoi.main.MainApp;
//
//public class RecipeMenu {
//
//	public static final int NEWINGREDIENT = 1;
//	public static final int EXIT = 2;
//	public static final Scanner ESCANERENTEROS = new Scanner(System.in);
//	public static final Scanner ESCANERSTRINGS = new Scanner(System.in);
//	public static final Scanner ESCANERDOUBLES = new Scanner(System.in);
//
//	public static void printPublishRecipeMenu() {
//		RecipeController controller = new RecipeController();
//		System.out.println("     Nueva receta     ");
//		System.out.println("**********************");
//		System.out.println("Nombre de la receta");
//		String nameRecipe = ESCANERSTRINGS.nextLine();
//		System.out.println("Decribe un poco la receta");
//		String description = ESCANERSTRINGS.nextLine();
//		System.out.println("Una imagen vale más que mil palabras, introduce una imagen");
//		String photo = ESCANERSTRINGS.nextLine();
//		Set<Ingredient> ingredients = printIngredientsMenu();
//
//		controller.publishRecipe(nameRecipe, description, photo, ingredients);
//
//		ESCANERENTEROS.close();
//		ESCANERSTRINGS.close();
//		ESCANERDOUBLES.close();
//	}
//
//	private static Set<Ingredient> printIngredientsMenu() {
//		Set<Ingredient> ingredients = new HashSet<Ingredient>();
//		int userOption = 0;
//		System.out.println("INGREDIENTES");
//		System.out.println("************");
//		System.out.println("1.- A�adir Ingrediente");
//		System.out.println("2.- Salir");
//		try {
//			userOption = ESCANERENTEROS.nextInt();
//		} catch (InputMismatchException e) {
//			System.out.println("La opcion elegida no es correcta");
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
//			System.out.println("La cantidad introducida no es valida, asegurese de poner ,0 si la cantidad es exacta");
//			RecipeMenu.printIngredientsMenu();
//		}
//		System.out.println("Qué precio tiene la unidad?");
//		try {
//			price = ESCANERDOUBLES.nextDouble();
//		} catch (InputMismatchException e) {
//			System.out.println("El precio introducido no es valido, asegurese de poner ,0 si el precio es exacto");
//			RecipeMenu.printIngredientsMenu();
//		}
//		return new Ingredient(ingredientName, amount, price);
//	}
//
//	public static void printShareRecipeMenu() {
//
//	}
//
//	public static void printValorateRecipeMenu() {
//		System.out.println("�Que receta quieres valorar? Introduce el nombre de la receta");
//		String nombreReceta = ESCANERSTRINGS.nextLine();
//		Recipe recipeToValore = null;
//		for (Recipe recipe : MainApp.recipes.values()) {
//			recipe.getRecipeName().equalsIgnoreCase(nombreReceta);
//			recipeToValore = recipe;
//		}
//		if (recipeToValore != null) {
//			System.out.println("RECETA");
//			System.out.println(recipeToValore.getRecipeName());
//			System.out.println("*****************************");
//			System.out.println(recipeToValore.getValoration());
//			System.out.println("INGREDIENTS:");
//			System.out.println("*****************************");
//			for (Ingredient ingredient : recipeToValore.getIngredients()) {
//				System.out.println(ingredient.getName());
//				System.out.println(Double.toString(ingredient.getAmount()).concat(" g"));
//				System.out.println(Double.toString(ingredient.getPrice()).concat(" EUR"));
//			}
//			System.out.println("*****************************");
//			System.out.println(
//					"¿Qué valoración quieres ponerle? Recuerda que el valor introducido va en forma decimal y separado con coma");
//			double valoracion = ESCANERDOUBLES.nextDouble();
//			recipeToValore.setValoration(valoracion);
//			
//		} else {
//			System.out.println("No se ha encontrado una receta con ese nombre, prueba de nuevo");
//			RecipeMenu.printValorateRecipeMenu();
//		}
//	}
//
//	public static void printAllRecipes() {
//		for (Recipe recipe : MainApp.recipes.values()) {
//			System.out.println(recipe.getRecipeName());
//			System.out.println("*****************************");
//			System.out.println(recipe.getValoration());
//			System.out.println("INGREDIENTS:");
//			System.out.println("*****************************");
//			for (Ingredient ingredient : recipe.getIngredients()) {
//				System.out.println(ingredient.getName());
//				System.out.println(Double.toString(ingredient.getAmount()).concat(" g"));
//				System.out.println(Double.toString(ingredient.getPrice()).concat(" EUR"));
//			}
//			System.out.println("*****************************");
//
//		}
//	}
//}
