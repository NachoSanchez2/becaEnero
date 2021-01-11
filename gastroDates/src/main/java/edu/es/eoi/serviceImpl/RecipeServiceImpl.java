package edu.es.eoi.serviceImpl;

import java.util.Set;

import edu.es.eoi.entity.Ingredient;
import edu.es.eoi.entity.Recipe;
import edu.es.eoi.main.MainApp;
import edu.es.eoi.repository.RecipeRepository;
import edu.es.eoi.repositoryImpl.RecipeRepositoryImpl;
import edu.es.eoi.service.RecipeService;

public class RecipeServiceImpl implements RecipeService {
	public static int numRecipes;

	@Override
	public void publishRecipe(String recipeName, String description, String photo, Set<Ingredient> ingredients) {
		RecipeRepository repository = new RecipeRepositoryImpl();
		numRecipes = MainApp.recipes.size();
		String id = Integer.toString(numRecipes++);
		Recipe recipe = new Recipe(id, recipeName, description, photo, ingredients);
		repository.save(recipe);
	}

	@Override
	public void shareRecipe(Recipe recipe) {

	}

	@Override
	public void valorateRecipe() {

	}

}
