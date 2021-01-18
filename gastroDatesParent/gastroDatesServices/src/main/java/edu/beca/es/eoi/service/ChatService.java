package edu.beca.es.eoi.service;

import java.util.List;

import edu.beca.es.eoi.entity.Message;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;

public interface ChatService {

	boolean chat(User origin, User destination, String message);

	List<Message> readAllMessageIsReaded(Person e, boolean mStatement);

	List<Message> readAllMessageFromUser(Person o);

	Message read(int id, Person o);

	boolean delete(Message msn);

}
