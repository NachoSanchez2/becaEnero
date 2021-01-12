package edu.beca.es.eoi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Guest {
	private int id;
	private String name;

	public Guest(int id) {
		this.id = id;
		this.name = "Guest";
	}

	public String toString() {
		return this.name.concat(" ".concat(Integer.toString(this.id)));
	}

}
