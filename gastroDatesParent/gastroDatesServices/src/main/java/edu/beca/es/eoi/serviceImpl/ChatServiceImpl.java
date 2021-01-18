package edu.beca.es.eoi.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.beca.es.eoi.entity.Message;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.MessageRepository;
import edu.beca.es.eoi.repositoryImpl.MessageRepositoryJDBCImpl;
import edu.beca.es.eoi.service.ChatService;

public class ChatServiceImpl implements ChatService {
	public static final MessageRepository REPOSITORY = new MessageRepositoryJDBCImpl();

	// TODO: FALTA hacer el test de este servicio
	@Override
	public boolean chat(User origin, User destination, String msn) {

		// Declaration
		java.util.Date date = Calendar.getInstance().getTime();
		Date dateSql = new Date(date.getTime());
		Message message = new Message(origin, destination, msn, false);

		// Implementation
		boolean saveOK = REPOSITORY.save(message, dateSql);

		return saveOK;
	}

	@Override
	public List<Message> readAllMessageIsReaded(Person e, boolean mStatement) {

		// DECLARATION
		List<Message> messages = new ArrayList<Message>();

		// IMPLEMENTATION
		messages = REPOSITORY.readAllMessageIsReaded(e, mStatement);

		return messages;
	}

	@Override
	public List<Message> readAllMessageFromUser(Person o) {

		// DECLARATION
		List<Message> messages = new ArrayList<Message>();

		// IMPLEMENTATION
		messages = REPOSITORY.readAllMessageFromUser(o);

		return messages;
	}

	@Override
	public Message read(int id, Person o) {
		return REPOSITORY.read(id, o);
	}

	@Override
	public boolean delete(Message msn) {

		// IMPLEMENTATION
		boolean deleteOK = REPOSITORY.delete(msn);

		return deleteOK;
	}
}
