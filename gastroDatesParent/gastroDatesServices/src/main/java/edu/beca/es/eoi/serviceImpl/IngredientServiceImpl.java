package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Ingredient;
import edu.beca.es.eoi.repository.IngredientRepository;
import edu.beca.es.eoi.repositoryImpl.IngredientRepositoryJDBCImpl;
import edu.beca.es.eoi.service.IngredientService;

public class IngredientServiceImpl implements IngredientService {

	@Override
	public boolean save(Ingredient ingredient, int idRecipe) {

		// Declaration
		IngredientRepository repository = new IngredientRepositoryJDBCImpl();
		ingredient.setIdRecipe(idRecipe);

		// Implementation
		boolean saveOK = repository.save(ingredient);

		return saveOK;
	}

	@Override
	public boolean update(int id, String newingredientName, double newAmount, double newPrice) {

		// Declaration
		Ingredient newIngredient = new Ingredient(newingredientName, newAmount, newPrice, id);
		IngredientRepository repository = new IngredientRepositoryJDBCImpl();

		// Implementation
		boolean updateOK = repository.update(newIngredient, id);

		return updateOK;
	}

	@Override
	public boolean delete(String ingredientName) {
		// Declaration
		IngredientRepository repository = new IngredientRepositoryJDBCImpl();

		// Implementation
		Ingredient ingredient = repository.read(ingredientName);
		boolean deleteOK = repository.delete(ingredient);
		return deleteOK;
	}

}
