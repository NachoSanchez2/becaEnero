package edu.beca.es.eoi.messageRepositoryImplTest;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Message;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.MessageRepository;
import edu.beca.es.eoi.repositoryImpl.MessageRepositoryJDBCImpl;

class MessageRepositoryImplReadAllMessageIsReadedTest {

	@Test
	void testReadAllMessageIsReaded() {

		// TESTpreparation
		Person destination = new User("pepe", "pepe", "pepe", "pepe", "pepe@gmail.com", "av/pepe", "pepe12345");
		boolean isRead = false;
		MessageRepository repository = new MessageRepositoryJDBCImpl();
		List <Message> messages = repository.readAllMessageIsReaded(destination, isRead);

		// Asserts
		assertNotNull(messages);

	}

}
