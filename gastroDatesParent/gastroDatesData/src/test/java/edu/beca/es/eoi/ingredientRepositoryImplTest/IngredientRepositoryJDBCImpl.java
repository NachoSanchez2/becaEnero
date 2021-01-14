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
		Ingredient i = new Ingredient("pulpo", 200.5, 1.2);
		IngredientRepository repository = new IngredientRepositoryJDBCImpl();
		Ingredient test = repository.read(i.getName());

		// Assert
		assertNotNull(test);
		// TODO: falta arreglar este test y acabar los metodos
	}

}
