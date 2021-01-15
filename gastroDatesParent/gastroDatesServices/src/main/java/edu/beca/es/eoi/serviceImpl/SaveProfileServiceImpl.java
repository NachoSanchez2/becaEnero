package edu.beca.es.eoi.serviceImpl;

import edu.beca.es.eoi.entity.Profile;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.ProfileRepository;
import edu.beca.es.eoi.repositoryImpl.ProfileRepositoryJDBCImpl;
import edu.beca.es.eoi.service.SaveProfileService;

public class SaveProfileServiceImpl implements SaveProfileService {

	@Override
	public boolean saveProfile(User user, String description, String photo, String cookPreferences) {
		// Declaration
		ProfileRepository repository = new ProfileRepositoryJDBCImpl();
		Profile profile = new Profile(description, photo, cookPreferences, user.getIdUser());

		// Implementation
		user.setProfile(profile);
		boolean saveOK = repository.save(profile);

		return saveOK;
	}

	@Override
	public boolean uploadProfile(User user, String newdescription, String newPhoto, String newCookPreferences) {
		// Declaration
		ProfileRepository repository = new ProfileRepositoryJDBCImpl();
		Profile newProfile = new Profile(newdescription, newPhoto, newCookPreferences);

		// Implementation
		boolean uploadOK = repository.upload(newProfile, user.getIdUser());
		return uploadOK;
	}

	@Override
	public Profile readProfile(User e) {
		// Declaration
		ProfileRepository repository = new ProfileRepositoryJDBCImpl();

		// Implementation
		Profile profile = repository.read(e.getIdUser());

		return profile;
	}

}
