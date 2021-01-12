package edu.beca.es.eoi.serviceImpl;

import java.util.Set;

import edu.beca.es.eoi.entity.Profile;
import edu.beca.es.eoi.enums.CookPreferences;
import edu.beca.es.eoi.service.SaveProfileService;

public class SaveProfileServiceImpl implements SaveProfileService {

	@Override
	public boolean saveProfile(String description, String photo, Set<CookPreferences> cookPreferences) {
		boolean saveOK = false;
		Profile profile = new Profile(description, photo, cookPreferences);
		if (profile != null) {
			// (MainApp.user.setProfile(profile))Esto hay que hacerlo llamando al
			// repository, no al main;
			saveOK = true;
		}
		return saveOK;
	}

}
