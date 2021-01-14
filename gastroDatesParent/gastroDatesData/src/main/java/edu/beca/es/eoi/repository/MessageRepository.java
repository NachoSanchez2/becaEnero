package edu.beca.es.eoi.repository;

import java.util.List;

import edu.beca.es.eoi.entity.Message;
import edu.beca.es.eoi.entity.Person;

public interface MessageRepository {
	boolean save(Message e);

	Message readAllMessageFromUser(Person e);

	List<Message> readAllMessageIsReaded(Person e, boolean mStatement);

	boolean delete(Message e);
}
