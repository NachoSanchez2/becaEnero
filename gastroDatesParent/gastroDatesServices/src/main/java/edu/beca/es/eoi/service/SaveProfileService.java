package edu.beca.es.eoi.service;

import edu.beca.es.eoi.entity.Profile;
import edu.beca.es.eoi.entity.User;

public interface SaveProfileService {

	boolean saveProfile(User user, String description, String photo, String cookPreferences);

	boolean uploadProfile(User user, String newdescription, String newPhoto, String newCookPreferences);

	Profile readProfile(User e);

}
