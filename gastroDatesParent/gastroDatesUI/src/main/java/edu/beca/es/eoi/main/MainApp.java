package edu.beca.es.eoi.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.entity.Guest;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.ui.GeneralMenu;

public class MainApp {

	// Declaracion de variables estaticas
	public static Map<Integer, Guest> guests = new HashMap<Integer, Guest>();
	public static Guest guest;
	public static User user;
	private static Logger logger = Logger.getLogger(MainApp.class);
	private static Properties properties = new Properties();

	// Metodo main
	public static void main(String[] args) {
		logger.info("Empieza a funcionar la app");

		// Encendemos la app
		GeneralMenu.printGeneralMenu();
		logger.info("La app para de funcionar");
	}

	public static void readProperties() throws IOException {

		logger.info("Entro en el metodo readProperties de mi aplicacion:");
		logger.debug("Ruta del archivo: " + "src/main/resources/application.properties");

		FileInputStream input = new FileInputStream(new File("src/main/resources/application.properties"));

		properties.load(input);
		logger.info("Salgo del metodo readProperties de mi aplicacion:");

	}
}
