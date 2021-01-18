package edu.beca.es.eoi.service;

import java.util.List;

import edu.beca.es.eoi.entity.Recipe;

public interface RecipeService {

	int saveRecipe(Recipe recipe);

	boolean deleteRecipe(String recipeName);

	boolean updateRecipe(int id, String newRecipeName, String newDescriptionRecipe, String newPhoto,
			double newValoration);

	Recipe readRecipe(String recipeName);

	List<Recipe> readAll();

}
