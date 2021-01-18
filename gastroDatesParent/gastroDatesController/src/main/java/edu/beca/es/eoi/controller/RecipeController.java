package edu.beca.es.eoi.controller;

import java.util.List;

import edu.beca.es.eoi.entity.Ingredient;
import edu.beca.es.eoi.entity.Recipe;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.service.IngredientService;
import edu.beca.es.eoi.service.RecipeService;
import edu.beca.es.eoi.serviceImpl.IngredientServiceImpl;
import edu.beca.es.eoi.serviceImpl.RecipeServiceImpl;
import edu.beca.es.eoi.ui.UserMainMenuWhithoutProfile;

public class RecipeController {
	// TODO: Hacer test para el controlador de recipe add Logger;
	public static final RecipeService SERVICERECIPE = new RecipeServiceImpl();
	public static final IngredientService SERVICEINGREDIENT = new IngredientServiceImpl();

	public void publishRecipe(User user, String name, String description, String photo, String ingredientName,
			double amount, double price) throws Exception {
		// Declaration
		int idRecipe = 0;
		Ingredient ingredient = new Ingredient(ingredientName, amount, price);
		Recipe recipe = new Recipe(name, description, photo, user.getIdUser());

		// Implementation
		if (name != null && ingredient != null) {
			idRecipe = SERVICERECIPE.saveRecipe(recipe);
			if (idRecipe != 0) {
				SERVICEINGREDIENT.save(ingredient, idRecipe);
			} else {
				throw new Exception("No se ha podido agregar la receta");
			}

			// Return
		} else {
			UserMainMenuWhithoutProfile.printMenuMain();
		}
	}

	public void valorateRecipe(Recipe recipe, double valoration) throws Exception {
		// Declaration
		Recipe newValoratedRecipe = null;

		// Implementation

		if (recipe != null) {
			newValoratedRecipe = SERVICERECIPE.readRecipe(recipe.getRecipeName());
			newValoratedRecipe.setValoration(valoration);
			SERVICERECIPE.saveRecipe(newValoratedRecipe);
		} else {
			throw new Exception("Ha ocurrido un error al valorar la receta, vuelva a intentarlo");
		}

	}

	public void uploadRecipe(String recipeName, String newRecipeName, String newDescriptionRecipe, String newPhoto,
			double newValoration, String newIngredientName, double newAmount, double newPrice) throws Exception {

		// Implementation
		int idRecipe = SERVICERECIPE.readRecipe(recipeName).getId();
		boolean uploadOK = SERVICERECIPE.updateRecipe(idRecipe, newRecipeName, newDescriptionRecipe, newPhoto,
				newValoration);

		boolean uploadIngredientOK = SERVICEINGREDIENT.update(idRecipe, newIngredientName, newAmount, newPrice);

		// Return
		if (uploadIngredientOK && uploadOK) {

		} else {
			throw new Exception("No se ha podido realizar los cambios");
		}
	}

	public Recipe readRecipe(String recipeName) throws Exception {
		Recipe recipe = SERVICERECIPE.readRecipe(recipeName);
		if (recipe != null) {
			return recipe;
		} else {
			throw new Exception("Ha habido un error al encontrar la receta");
		}
	}

	public List<Recipe> readAll() {
		return SERVICERECIPE.readAll();
	}
}
