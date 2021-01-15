package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Recipe;
import edu.beca.es.eoi.repository.RecipeRepository;
import edu.beca.es.eoi.repositoryImpl.RecipeRepositoryJDBCImpl;
import edu.beca.es.eoi.service.RecipeService;

public class RecipeServiceImpl implements RecipeService {

	@Override
	public boolean saveRecipe(int id, String recipeName, String description, String photo, double valoration) {

		// Declaration
		RecipeRepository repository = new RecipeRepositoryJDBCImpl();
		Recipe recipe = new Recipe(id, recipeName, description, photo, valoration);

		// Implementation
		boolean saveOK = repository.save(recipe);
		return saveOK;
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

}
