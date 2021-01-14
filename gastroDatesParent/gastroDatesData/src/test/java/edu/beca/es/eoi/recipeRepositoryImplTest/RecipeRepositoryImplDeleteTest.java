package edu.beca.es.eoi.recipeRepositoryImplTest;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Recipe;
import edu.beca.es.eoi.repository.RecipeRepository;
import edu.beca.es.eoi.repositoryImpl.RecipeRepositoryJDBCImpl;

class RecipeRepositoryImplDeleteTest {

	@Test
	void testDelete() {
		// TestPrepare
		Recipe recipe = new Recipe(1);
		RecipeRepository repository = new RecipeRepositoryJDBCImpl();

		// Asserts
		assertTrue(repository.delete(recipe));
	}

}
