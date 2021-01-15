package edu.beca.es.eoi.service;

import edu.beca.es.eoi.entity.Recipe;

public interface RecipeService {

	boolean saveRecipe(int id, String recipeName, String description, String photo, double Valoration);

	boolean deleteRecipe(String recipeName);

	boolean updateRecipe(int id, String newRecipeName, String newDescriptionRecipe, String newPhoto,
			double newValoration);

	Recipe readRecipe(String recipeName);

}
