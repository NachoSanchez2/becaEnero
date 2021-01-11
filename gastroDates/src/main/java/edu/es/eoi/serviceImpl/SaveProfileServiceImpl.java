package edu.es.eoi.serviceImpl;

import java.util.Set;

import edu.es.eoi.entity.Profile;
import edu.es.eoi.enums.CookPreferences;
import edu.es.eoi.main.MainApp;
import edu.es.eoi.service.SaveProfileService;

public class SaveProfileServiceImpl implements SaveProfileService {

	@Override
	public boolean saveProfile(String description, String photo, Set<CookPreferences> cookPreferences) {
		boolean saveOK = false;
		Profile profile = new Profile(description, photo, cookPreferences);
		if (profile != null) {
			MainApp.user.setProfile(profile);
			saveOK = true;
		}
		return saveOK;
	}

}
