package edu.beca.es.eoi.entity;

import java.util.List;
import java.util.Set;

import edu.beca.es.eoi.enums.CookPreferences;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Profile {

	private String description;
	private String photo;
	private Set<CookPreferences> cookPreferences;
	private List<Recipe> preferedRecipes;

	public Profile(String description, String photo, Set<CookPreferences> cookPreferences) {
	}
}
