package edu.beca.es.eoi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

	protected String name;
	protected String surname;
//	protected Date birthDate;

	public Person(String name) {
		this.name = name;
	}
}
