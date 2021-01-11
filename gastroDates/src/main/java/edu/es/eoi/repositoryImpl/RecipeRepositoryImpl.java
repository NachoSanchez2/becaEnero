package edu.es.eoi.repositoryImpl;

import edu.es.eoi.entity.Recipe;
import edu.es.eoi.main.MainApp;
import edu.es.eoi.repository.RecipeRepository;

public class RecipeRepositoryImpl implements RecipeRepository {

	@Override
	public void save(Recipe r) {
		MainApp.recipes.put(r.getId(), r);
	}

	@Override
	public Recipe read(String sf) {

		return null;
	}

	@Override
	public void delete(Recipe e) {

	}

	@Override
	public Recipe update(Recipe e) {
		// TODO Auto-generated method stub
		return null;
	}

}
