package edu.beca.es.eoi.controller;

import java.util.Scanner;

import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.service.SaveProfileService;
import edu.beca.es.eoi.serviceImpl.SaveProfileServiceImpl;
import edu.beca.es.eoi.ui.UserMainMenu;

public class ProfileController {
	// TODO: Hacer test para el controlador de SaveProfile add Logger;

	public static final Scanner ESCANER = new Scanner(System.in);
	public static final SaveProfileService SERVICE = new SaveProfileServiceImpl();

	public void saveProfile(User user, String description, String photo, String cookPreferences) throws Exception {
		boolean saveOK = SERVICE.saveProfile(user, description, photo, cookPreferences);
		if (saveOK) {
			System.out.println("Perfecto, ha configurado el perfil correctamente");
			UserMainMenu.printMenuMain();
		} else {
			throw new Exception("Ha habido un problema con su configuracion por favor, inténtelo de nuevo");
		}
	}

	public void update(User user, String newDescription, String newPhoto, String newCookPreferences) throws Exception {
		boolean uploadOK = SERVICE.uploadProfile(user, newDescription, newPhoto, newCookPreferences);

		if (uploadOK) {
			System.out.println("Perfecto, ha modificado corréctamente el perfil");
			UserMainMenu.printMenuMain();
		} else {
			throw new Exception("Ha habido un problema con su configuracion por favor, inténtelo de nuevo");
		}
	}
}
