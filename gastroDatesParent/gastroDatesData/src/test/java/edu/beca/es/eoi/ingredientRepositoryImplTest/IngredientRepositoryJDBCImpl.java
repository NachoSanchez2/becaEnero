package edu.beca.es.eoi.ingredientRepositoryImplTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Ingredient;
import edu.beca.es.eoi.repository.IngredientRepository;
import edu.beca.es.eoi.repositoryImpl.IngredientRepositoryJDBCImpl;

class IngredientRepositoryJDBCImplTest {

	@Test
	void testSave() {
		// TestPrepare
		Ingredient i = new Ingredient("CEBOLLA", 130.5, 0.25);
		IngredientRepository repository = new IngredientRepositoryJDBCImpl();

		// Assert
		assertTrue(repository.save(i));
	}

	@Test
	void testRead() {
		// TestPrepare
		Ingredient i = new Ingredient("pulpo", 200.5, 1.2);
		IngredientRepository repository = new IngredientRepositoryJDBCImpl();
		Ingredient test = repository.read(i.getName());

		// Assert
		assertNotNull(test);
	}

	@Test
	void testDelete() {
		// TestPrepare
		Ingredient i = new Ingredient(13);
		IngredientRepository repository = new IngredientRepositoryJDBCImpl();

		// Assert
		assertTrue(repository.delete(i));
	}

	@Test
	void testUpdate() {

		// TestPrepare
		Ingredient i = new Ingredient(2);
		Ingredient j = new Ingredient("pollo", 150.5, 0.4);
		IngredientRepository repository = new IngredientRepositoryJDBCImpl();

		// Assert
		assertTrue(repository.update(j, i.getId()));

	}

}
