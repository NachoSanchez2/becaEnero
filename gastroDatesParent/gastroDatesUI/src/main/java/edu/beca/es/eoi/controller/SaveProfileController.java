package edu.beca.es.eoi.controller;

import java.util.Scanner;
import java.util.Set;

import edu.beca.es.eoi.enums.CookPreferences;
import edu.beca.es.eoi.service.SaveProfileService;
import edu.beca.es.eoi.serviceImpl.SaveProfileServiceImpl;
import edu.beca.es.eoi.ui.UserMainMenu;

public class SaveProfileController {

	public static final Scanner ESCANER = new Scanner(System.in);
	public static SaveProfileService SERVICE = new SaveProfileServiceImpl();

	public void saveProfileMenu(String description, String photo, Set<CookPreferences> cookPreferences)
			throws Exception {
		if (SERVICE.saveProfile(description, photo, cookPreferences)) {
			System.out.println("Perfecto, ha configurado el perfil correctamente");
			UserMainMenu.printMenuMain();
		} else {
			throw new Exception("Ha habido un problema con su configuracion por favor, inténtelo de nuevo");
		}

	}
}
