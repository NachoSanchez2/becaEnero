package edu.es.eoi.service;

import java.util.Set;

import edu.es.eoi.enums.CookPreferences;

public interface SaveProfileService {

	boolean saveProfile(String description, String photo, Set<CookPreferences> cookPreferences);

}
