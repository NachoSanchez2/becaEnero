//package edu.beca.es.eoi.controller;
//
//import java.util.Set;
//
//import edu.beca.es.eoi.entity.Ingredient;
//import edu.beca.es.eoi.main.MainApp;
//import edu.beca.es.eoi.service.RecipeService;
//import edu.beca.es.eoi.serviceImpl.RecipeServiceImpl;
//import edu.beca.es.eoi.ui.RecipeMenu;
//
//public class RecipeController {
//	public static RecipeService SERVICE = new RecipeServiceImpl();
//	public static int numRecipes;
//
//	public void publishRecipe(String name, String description, String photo, Set<Ingredient> ingredients) {
//		numRecipes = MainApp.recipes.size();
//		String id = Integer.toString(numRecipes++);
//		if (name != null && ingredients != null) {
//			SERVICE.publishRecipe(id, name, description, photo, ingredients);
//		} else {
//			RecipeMenu.printPublishRecipeMenu();
//		}
//	}
//
//	public void shareRecipe() {
//
//	}
//
//	public void valorateRecipe() {
//
//	}
//}
