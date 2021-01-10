package edu.es.eoi.entity;

import java.util.Date;
import java.util.List;

import edu.es.eoi.enums.Gender;
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
	private Gender gender;
	private String address;
	private String phoneNumber;
	private List<Recipe> recipes;
	private Profile profile;

	public User(String name,String surname,Date birthDate,String username, String password, String mail, Gender gender, String address, String phoneNumber) {
		super(name,surname,birthDate);
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

}
