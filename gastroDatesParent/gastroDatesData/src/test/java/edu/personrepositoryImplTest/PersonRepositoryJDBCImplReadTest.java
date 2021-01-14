package edu.personrepositoryImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.PersonRepository;
import edu.beca.es.eoi.repositoryImpl.PersonRepositoryJDBCImpl;

class PersonRepositoryJDBCImplReadTest {

	@Test
	void testRead() {
		// Declaracion de variables
		String sf = "pepe";
		Person e = new User();
		PersonRepository repository = new PersonRepositoryJDBCImpl();
		repository.read(sf);
		assertNotNull(e);
	}

}
