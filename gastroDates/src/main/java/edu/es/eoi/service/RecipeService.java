package edu.es.eoi.service;

import java.util.Set;

import edu.es.eoi.entity.Ingredient;
import edu.es.eoi.entity.Recipe;

public interface RecipeService {

	void publishRecipe(String recipeName, String description, String photo,Set<Ingredient>ingredients);

	void shareRecipe(Recipe recipe);

	void valorateRecipe();

}
