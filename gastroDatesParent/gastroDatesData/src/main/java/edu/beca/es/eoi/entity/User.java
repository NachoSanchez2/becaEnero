package edu.beca.es.eoi.entity;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User extends Person {
	private String username;
	private String password;
	private String mail;
//	private String gender;
	private String address;
	private String phoneNumber;
	private List<Recipe> recipes;
	private Profile profile;

	public User(String name, String surname, String username, String password, String mail, String address,
			String phoneNumber) {
		super(name, surname);
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public User(String name, String surname, String username, String mail, String address, String phoneNumber) {
		super(name, surname);
	}

}
