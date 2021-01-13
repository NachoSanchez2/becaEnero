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

	private String id;
	private String name;
	private double amount;
	private double price;

	public Ingredient(String name, double amount, double price) {
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

}
