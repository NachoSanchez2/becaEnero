package edu.beca.es.eoi.enums;

import lombok.Getter;

@Getter
public enum CookPreferences {
	MEAT(1, "MEAT"), FISH(2, "FISH"), SHELLFISH(3, "SHELLFISH"), SEAFOOD(4, "SEAFOOD"), DESSERT(5, "DESSERT"),
	VEGETABLES(6, "VEGETABLES"), FRUITS(7, "FRUITS"), GRAINS(8, "GRAINS"), POULTRY(9, "POULTRY"),
	VEGANFOOD(10, "VEGANFOOD"), FITFOOD(11, "FITFOOD");

	private int index;
	private String literal;

	CookPreferences(int index, String literal) {
		this.index = index;
		this.literal = literal;
	}

}
