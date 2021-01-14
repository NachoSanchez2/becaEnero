package edu.beca.es.eoi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User extends Person {
	private int idUser;
	private String username;
	private String password;
	private String mail;
//	private String gender;
	private String address;
	private String phoneNumber;
	private Recipe recipes;
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
		this.username = username;
		this.mail = mail;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public User(int idUser) {
		this.idUser = idUser;
	}

	public User(String personName, String mail, String phoneNumber) {
		super(personName);
		this.mail = mail;
		this.phoneNumber = phoneNumber;
	}

	public User(int idUser, String name, String surname, String username, String password, String mail, String address,
			String phoneNumber) {
		super(name, surname);
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

}
