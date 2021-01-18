package edu.beca.es.eoi.service;

import edu.beca.es.eoi.entity.Ingredient;

public interface IngredientService {

	boolean update(int id, String newingredientName, double newAmount, double newPrice);

	boolean delete(String ingredientName);

	boolean save(Ingredient ingredientName, int idRecipe);
}