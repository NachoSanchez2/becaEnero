package edu.beca.es.eoi.personRepositoryImplTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;

class PersonRepositoryJDBCImplTest {

	@Test
	void testSave() {
		Person e = new User("test", "test", "test", "test", "test@gmail.com", "av/test", "test12345");
		PersonRepository repository = new PersonRepositoryJDBCImpl();
		boolean saveOK = repository.save(e);
		assertTrue(saveOK);
	}

	@Test
	void testUpdate() {
		Person e = new User(1);
		Person f = new User("test2", "test2", "test2", "test2", "test2@gmail.com", "av/test2", "test21234");
		PersonRepository repository = new PersonRepositoryJDBCImpl();
		boolean updateOK = repository.update(f, ((User) e).getIdUser());
		assertTrue(updateOK);
	}

	@Test
	void testRead() {
		// Declaracion de variables
		String sf = "pepe";
		Person e = new User();
		PersonRepository repository = new PersonRepositoryJDBCImpl();
		repository.read(sf);
		assertNotNull(e);
	}

	@Test
	void testDelete() {
		Person e = new User("test", "test", "test", "test", "test@gmail.com", "av/test", "test12345");
		PersonRepository repository = new PersonRepositoryJDBCImpl();
		assertTrue(repository.delete(e));
	}
}
