package edu.es.eoi.controller;

import java.util.Set;

import edu.es.eoi.entity.Ingredient;
import edu.es.eoi.service.RecipeService;
import edu.es.eoi.serviceImpl.RecipeServiceImpl;
import edu.es.eoi.ui.RecipeMenu;

public class RecipeController {
	public static RecipeService SERVICE = new RecipeServiceImpl();

	public void publishRecipe(String name, String description, String photo, Set<Ingredient> ingredients) {
		if (name != null && ingredients != null) {
			SERVICE.publishRecipe(name, description, photo, ingredients);
		} else {
			RecipeMenu.printPublishRecipeMenu();
		}
	}

	public void shareRecipe() {

	}

	public void valorateRecipe() {

	}
}
