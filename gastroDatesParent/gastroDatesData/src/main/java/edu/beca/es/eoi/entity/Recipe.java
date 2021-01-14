package edu.beca.es.eoi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Recipe {

	private int id;
	private String recipeName;
	private String recipeDescription;
	private String photo;
	private Ingredient ingredients;
	private double valoration;
//	private List<String> comments;

	public Recipe(int id, String recipeName, String recipeDescription, String photo, Ingredient ingredients) {
		this.id = id;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.photo = photo;
		this.ingredients = ingredients;

	}

	public Recipe(String recipeName, String recipeDescription, String photo, double valoration, String ingredientName,
			double amount, double price) {
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.photo = photo;
		this.valoration = valoration;
		this.ingredients = new Ingredient(ingredientName, amount, price);
	}

	public Recipe(int id) {
		this.id = id;
	}

	public Recipe(int id, String recipeName, String recipeDescription, String photo, double valoration) {
		this.id = id;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.photo = photo;
		this.valoration = valoration;
	}

	public Recipe(String recipeName, String recipeDescription, String photo, double valoration) {
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.photo = photo;
		this.valoration = valoration;
	}
}