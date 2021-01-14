package edu.beca.es.eoi.messageRepositoryImplTest;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Message;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.MessageRepository;
import edu.beca.es.eoi.repositoryImpl.MessageRepositoryJDBCImpl;

class MessageRepositoryImplReadAllMessageFromUserTest {

	@Test
	void testReadAllMessageFromUser() {

		// TestPrepare
		Person destination = new User("pepe", "pepe", "pepe", "pepe", "pepe@gmail.com", "av/pepe", "pepe12345");
		Message message = null;
		MessageRepository repository = new MessageRepositoryJDBCImpl();
		message = repository.readAllMessageFromUser(destination);

		// Assert
		assertNotNull(message);

	}

}
