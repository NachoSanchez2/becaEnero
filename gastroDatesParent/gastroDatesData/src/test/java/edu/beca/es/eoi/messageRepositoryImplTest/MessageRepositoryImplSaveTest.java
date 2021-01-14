package edu.beca.es.eoi.messageRepositoryImplTest;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Message;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.MessageRepository;
import edu.beca.es.eoi.repositoryImpl.MessageRepositoryJDBCImpl;

class MessageRepositoryImplSaveTest {

	@Test
	void testSave() {

		// TestPrepare
		Person origin = new User(3);
		Person destination = new User(1);
		Message message = new Message(((User) origin), ((User) destination), "HEY", null, false);
		MessageRepository repository = new MessageRepositoryJDBCImpl();

		// Asserts
		assertTrue(repository.save(message));

	}

}
