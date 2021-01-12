package edu.beca.es.eoi.entity;

import java.util.List;
import java.util.Set;

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
	private Set<Ingredient> ingredients;
	private double valoration;
	private List<String> comments;

	public Recipe(String id, String recipeName, String description, String photo, Set<Ingredient> ingredients) {
		this.id = id;
		this.recipeName = recipeName;
		this.description = description;
		this.photo = photo;
		this.ingredients = ingredients;

	}

}