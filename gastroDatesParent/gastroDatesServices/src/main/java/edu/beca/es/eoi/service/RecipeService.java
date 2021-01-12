package edu.beca.es.eoi.service;

import java.util.Set;

import edu.beca.es.eoi.entity.Ingredient;
import edu.beca.es.eoi.entity.Recipe;

public interface RecipeService {

	void publishRecipe(String id,String recipeName, String description, String photo,Set<Ingredient>ingredients);

	void shareRecipe(Recipe recipe);

	void valorateRecipe();

}
