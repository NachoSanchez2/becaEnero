package edu.beca.es.eoi.recipeRepositoryImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Recipe;
import edu.beca.es.eoi.repositoryImpl.RecipeRepositoryJDBCImpl;

class RecipeRepositoryImplReadTest {

	@Test
	void testRead() {
		String sf = "pulpo a la gallega";
		Recipe recipe = null;
		RecipeRepositoryJDBCImpl repository = new RecipeRepositoryJDBCImpl();
		repository.read(sf);
		assertNotNull(recipe);
	}

}
