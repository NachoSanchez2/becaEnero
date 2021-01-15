package edu.beca.es.eoi.service;

public interface IngredientService {

	boolean save(String ingredientName, double amount, double price, int idRecipe);

	boolean update(int id, String newingredientName, double newAmount, double newPrice, int newIdRecipe);

	boolean delete(String ingredientName);
}