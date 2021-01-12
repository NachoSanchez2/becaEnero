package edu.beca.es.eoi.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.entity.Guest;
import edu.beca.es.eoi.entity.Ingredient;
import edu.beca.es.eoi.entity.Recipe;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.ui.GeneralMenu;

public class MainApp {

	// Declaracion de variables estaticas
	public static Map<String, User> users = new HashMap<String, User>();
	public static Map<String, Recipe> recipes = new HashMap<String, Recipe>();
	public static Map<Integer, Guest> guests = new HashMap<Integer, Guest>();
	public static Guest guest;
	public static User user;
	private static Logger logger = Logger.getLogger(MainApp.class);
	private static Properties properties = new Properties();

	// Metodo main
	public static void main(String[] args) {
		logger.info("Empieza a funcionar la app");
		// Esto se quitara cuando se conecte a la BBDD
		initUsers();
		initRecipes();

		// Encendemos la app
		GeneralMenu.printGeneralMenu();
		logger.info("La app para de funcionar");
	}

	private static void initUsers() {

		User person = new User();
		person.setName("Pepe");
		person.setSurname("Palotes");
		person.setUsername("pepeKitchenLover");
		person.setPassword("password");

		users.put(person.getUsername(), person);

		User person2 = new User();
		person2.setName("Marta");
		person2.setSurname("Martinez");
		person2.setUsername("hummusLover");
		person2.setPassword("password");

		users.put(person2.getUsername(), person2);
	}

	private static void initRecipes() {
		Recipe recipe = new Recipe();
		recipe.setId("1");
		recipe.setRecipeName("Pollo con patatas");
		recipe.setDescription("Pollo con patatas al horno, mitad pollo, mitad patatas, mitad horno");
		Set<Ingredient> ingredients = new HashSet<Ingredient>();
		ingredients.add(new Ingredient("Pollo", 200.1, 1.12));
		ingredients.add(new Ingredient("Patata", 300.5, 2.2));
		ingredients.add(new Ingredient("Cebolla", 150.5, 1.0));
		recipe.setIngredients(ingredients);
		recipe.setPhoto("URL");
		recipes.put(recipe.getId(), recipe);

		Recipe recipe2 = new Recipe();
		recipe.setId("2");
		recipe2.setRecipeName("Gazpacho Andaluz");
		recipe2.setDescription("Gazpacho de tomate, verduras triturado a nivel II");
		Set<Ingredient> ingredients2 = new HashSet<Ingredient>();
		ingredients2.add(new Ingredient("Tomate", 200.1, 1.12));
		ingredients2.add(new Ingredient("Calabacín", 300.5, 2.2));
		ingredients2.add(new Ingredient("Cebolla", 150.5, 1.0));
		recipe2.setIngredients(ingredients2);
		recipe2.setPhoto("URL");
		recipes.put(recipe2.getId(), recipe2);
	}

	public static void readProperties() throws IOException {

		logger.info("Entro en el metodo readProperties de mi aplicacion:");
		logger.debug("Ruta del archivo: " + "src/main/resources/application.properties");

		FileInputStream input = new FileInputStream(new File("src/main/resources/application.properties"));

		properties.load(input);
		logger.info("Salgo del metodo readProperties de mi aplicacion:");

	}
}
