package edu.beca.es.eoi.serviceImpl;

import java.util.List;

import edu.beca.es.eoi.entity.Recipe;
import edu.beca.es.eoi.repository.RecipeRepository;
import edu.beca.es.eoi.repositoryImpl.RecipeRepositoryJDBCImpl;
import edu.beca.es.eoi.service.RecipeService;

public class RecipeServiceImpl implements RecipeService {

	private static final RecipeRepository REPOSITORY = new RecipeRepositoryJDBCImpl();

	@Override
	public int saveRecipe(Recipe recipe) {

		// Declaration

		boolean saveOK = false;
		int idRecipe = 0;
		// Implementation
		saveOK = REPOSITORY.save(recipe);
		if (saveOK) {
			idRecipe = REPOSITORY.read(recipe.getRecipeName()).getId();
		}
		return idRecipe;
	}

	@Override
	public boolean deleteRecipe(String recipeName) {

		// Declaration
		RecipeRepository repository = new RecipeRepositoryJDBCImpl();

		// Implementation
		Recipe recipe = repository.read(recipeName);
		boolean deleteOK = repository.delete(recipe);

		return deleteOK;
	}

	@Override
	public boolean updateRecipe(int id, String newRecipeName, String newDescriptionRecipe, String newPhoto,
			double newValoration) {

		// Declaration
		RecipeRepository repository = new RecipeRepositoryJDBCImpl();
		Recipe newrecipe = new Recipe(newRecipeName, newDescriptionRecipe, newPhoto, newValoration);

		// Implementation
		boolean updateOK = repository.update(newrecipe, id);
		return updateOK;
	}

	@Override
	public Recipe readRecipe(String recipeName) {
		// Declaration
		RecipeRepository repository = new RecipeRepositoryJDBCImpl();

		// Implementation
		Recipe recipe = repository.read(recipeName);

		return recipe;

	}

	public List<Recipe> readAll() {
		return REPOSITORY.readAll();
	}
}
