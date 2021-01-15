package edu.beca.es.eoi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Profile {

	private int id;
	private int idUser;
	private String description;
	private String photo;
	private String cookPreferences;
//	private List<Recipe> preferedRecipes;
	// TODO: hay que mejorar esto para que sea una lista de preferencias

	public Profile(String description, String photo, String cookPreferences, int idUser) {
		this.description = description;
		this.photo = photo;
		this.cookPreferences = cookPreferences;
		this.idUser = idUser;
	}

	public Profile(int id) {
		this.id = id;
	}

	public Profile(String description, String photo, String cookPreferences) {
		this.description = description;
		this.photo = photo;
		this.cookPreferences = cookPreferences;
	}
}
