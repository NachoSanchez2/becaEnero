package edu.beca.es.eoi.service;

import java.util.Set;

import edu.beca.es.eoi.enums.CookPreferences;

public interface SaveProfileService {

	boolean saveProfile(String description, String photo, Set<CookPreferences> cookPreferences);

}
