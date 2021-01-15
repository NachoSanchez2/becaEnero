package edu.beca.es.eoi.recipeRepositoryImplTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Recipe;
import edu.beca.es.eoi.repository.RecipeRepository;
import edu.beca.es.eoi.repositoryImpl.RecipeRepositoryJDBCImpl;

class RecipeRepositoryJDBCImplTest {

	@Test
	void testSave() {
		// TestPrepare
		Recipe recipe = new Recipe(13, "Test", "Test muy rico", "/ashdghhhg/ASL", 2.0);
		RecipeRepository repository = new RecipeRepositoryJDBCImpl();

		// Asserts
		assertTrue(repository.save(recipe));
	}

	@Test
	void testUpdate() {
		// TestPrepare
		Recipe recipe = new Recipe(18);
		Recipe recipeTest = new Recipe("Macarrones con queso", "Macarrones con queso parmesano", "askdgjaksdgn", 10.0);
		RecipeRepository repository = new RecipeRepositoryJDBCImpl();

		// Asserts
		assertTrue(repository.update(recipeTest, recipe.getId()));
	}

	@Test
	void testRead() {
		// TestPrepare
		String sf = "pulpo a la gallega";
		Recipe recipe = null;
		RecipeRepositoryJDBCImpl repository = new RecipeRepositoryJDBCImpl();
		recipe = repository.read(sf);

		// Asserts
		assertNotNull(recipe);
	}

	@Test
	void testDelete() {
		// TestPrepare
		Recipe recipe = new Recipe(16);
		RecipeRepository repository = new RecipeRepositoryJDBCImpl();

		// Asserts
		assertTrue(repository.delete(recipe));
	}

}
