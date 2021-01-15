package edu.beca.es.eoi.profileRepositoryImplTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Profile;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.ProfileRepository;
import edu.beca.es.eoi.repositoryImpl.ProfileRepositoryJDBCImpl;

class ProfileRepositoryImplTest {

	@Test
	void testSave() {
		// TestPrepare
		ProfileRepository repository = new ProfileRepositoryJDBCImpl();
		User u = new User(2);
		Profile profile = new Profile("Alto, moreno, guapo", "oisadgkjlaksdfj0", "VEGANO", u.getIdUser());

		// Assert
		assertTrue(repository.save(profile));
	}

	@Test
	void testUpload() {

		// TestPrepare
		ProfileRepository repository = new ProfileRepositoryJDBCImpl();
		User u = new User(2);
		Profile newProfile = new Profile("Calvo, bajito, negro", "oisadgkjlaksdfj0", "VEGETARIANO");

		// Assert
		assertTrue(repository.upload(newProfile, u.getIdUser()));
	}

	@Test
	void testRead() {
		// TestPrepare
		ProfileRepository repository = new ProfileRepositoryJDBCImpl();
		User u = new User(2);

		// Assert
		Profile profile = repository.read(u.getIdUser());
		assertNotNull(profile);

	}

}
