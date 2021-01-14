package edu.personrepositoryImplTest;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;

class PersonRepositoryJDBCImplDeleteTest {

	@Test
	void testDelete() {
		Person e = new User("test", "test", "test", "test", "test@gmail.com", "av/test", "test12345");
		PersonRepository repository = new PersonRepositoryJDBCImpl();
		assertTrue(repository.delete(e));
	}

}
