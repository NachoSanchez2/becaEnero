package edu.beca.es.eoi.messageRepositoryImplTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.entity.Message;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.MessageRepository;
import edu.beca.es.eoi.repositoryImpl.MessageRepositoryJDBCImpl;

class MessageRepositoryJDBCImplTest {

	@Test
	void testSave() {

		// TestPrepare
		Person origin = new User(3);
		Person destination = new User(1);
		Message message = new Message(((User) origin), ((User) destination), "HEY", null, false);
		MessageRepository repository = new MessageRepositoryJDBCImpl();

		java.util.Date date = Calendar.getInstance().getTime();
		Date dateSql = new Date(date.getTime());

		// Asserts
		assertTrue(repository.save(message, dateSql));

	}

	@Test
	void testReadAllMessageIsReaded() {

		// TESTpreparation
		Person destination = new User("pepe", "pepe", "pepe", "pepe", "pepe@gmail.com", "av/pepe", "pepe12345");
		boolean isRead = false;
		MessageRepository repository = new MessageRepositoryJDBCImpl();
		List<Message> messages = repository.readAllMessageIsReaded(destination, isRead);

		// Asserts
		assertNotNull(messages);

	}

	@Test
	void testReadAllMessageFromUser() {

		// TestPrepare
		Person destination = new User("pepe", "pepe", "pepe", "pepe", "pepe@gmail.com", "av/pepe", "pepe12345");
		MessageRepository repository = new MessageRepositoryJDBCImpl();
		List<Message> messages = repository.readAllMessageFromUser(destination);

		// Assert
		assertNotNull(messages);

	}

	@Test
	void testDelete() {
		// TestPrepare
		Person origin = new User(3);
		Person destination = new User(1);
		Message message = new Message(36, (User) origin, (User) destination, "HEY");
		MessageRepository repository = new MessageRepositoryJDBCImpl();

		// Asserts
		assertTrue(repository.delete(message));
	}

}
