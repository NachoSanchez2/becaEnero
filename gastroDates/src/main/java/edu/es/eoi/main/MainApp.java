package edu.es.eoi.main;

import java.util.HashMap;
import java.util.Map;

import edu.es.eoi.entity.Guest;
import edu.es.eoi.entity.User;
import edu.es.eoi.ui.MenuGeneral;

public class MainApp {

	// Declaracion de variables estaticas
	public static Map<String, User> users = new HashMap<String, User>();
	public static Map<Integer,Guest> guests = new HashMap<Integer,Guest>();
	public static Guest guest;
	public static User user;

	// Metodo main
	public static void main(String[] args) {
		// Esto se quitara cuando se conecte a la BBDD
		initUsers();
		//Encendemos la app
		MenuGeneral.menuGeneralPrint();
	}

	private static void initUsers() {

		User person = new User();
		person.setName("Pepe");
		person.setSurname("Palotes");
		person.setUsername("pepeKitchenLover");
		person.setPassword("password");

		users.put(person.getUsername(), person);

		person = new User();
		person.setName("Marta");
		person.setSurname("Martinez");
		person.setUsername("hummusLover");
		person.setPassword("password");

		users.put(person.getUsername(), person);
	}
}
