package edu.beca.es.eoi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

	private int id;
	private String name;
	private double amount;
	private double price;
	private int idRecipe;

	public Ingredient(String name, double amount, double price, int idRecipe) {
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.idRecipe = idRecipe;
	}

	public Ingredient(int id) {
		this.id = id;
	}

	public Ingredient(String ingredientName, double amount, double prices) {
	}

}
