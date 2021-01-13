package edu.beca.es.eoi.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Recipe {

	private String id;
	private String recipeName;
	private String description;
	private String photo;
	private Ingredient ingredients;
	private double valoration;
	private List<String> comments;

	public Recipe(String id, String recipeName, String description, String photo, Ingredient ingredients) {
		this.id = id;
		this.recipeName = recipeName;
		this.description = description;
		this.photo = photo;
		this.ingredients = ingredients;

	}

	public Recipe(String recipeName, String description, String photo, double valoration, String ingredientName,
			double amount, double price) {
		this.recipeName = recipeName;
		this.description = description;
		this.photo = photo;
		this.valoration = valoration;
		this.ingredients = new Ingredient(ingredientName, amount, price);
	}

}