package edu.beca.es.eoi.controller;

import java.util.ArrayList;
import java.util.List;

import edu.beca.es.eoi.entity.Message;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.service.ChatService;
import edu.beca.es.eoi.service.LoginService;
import edu.beca.es.eoi.serviceImpl.ChatServiceImpl;
import edu.beca.es.eoi.serviceImpl.LoginServiceImpl;

public class ChatController {
	public static final ChatService SERVICECHAT = new ChatServiceImpl();
	public static final LoginService SERVICEPERSON = new LoginServiceImpl();

	// TODO: Hacer test para el controlador de chat add Logger;
	public boolean chat(User origin, String usernameDestination, String message) throws Exception {
		boolean sendOK = false;
		// Declarations
		User destination = (User) SERVICEPERSON.read(usernameDestination);
		if (destination != null) {
			sendOK = SERVICECHAT.chat(origin, destination, message);
		} else {
			throw new Exception("No se ha podido encontrar el usuario que desea enviar un mensaje");
		}
		return sendOK;
	}

	public List<Message> readAllMessageByReaded(Person e, boolean mStatement) throws Exception {
		// Declaration
		List<Message> messages = new ArrayList<Message>();

		// Implementation

		if (e != null) {
			messages = SERVICECHAT.readAllMessageIsReaded(e, mStatement);
		} else {
			throw new Exception("No se ha encontrado el usurio del que desea el mensaje");
		}
		return messages;
	}

	public List<Message> readAllMessageFromUser(String originUsername) throws Exception {
		// Declaration
		List<Message> messages = new ArrayList<Message>();

		// Implementation
		Person origin = SERVICEPERSON.read(originUsername);

		if (origin != null) {
			messages = SERVICECHAT.readAllMessageFromUser(origin);
		} else {
			throw new Exception("No se ha encontrado el usurio del que desea el mensaje");
		}
		return messages;
	}

	public Message read(int idMessage, String usernameOrigin) throws Exception {
		// Declaration
		Message msn = null;

		// Implementation
		User origin = (User) SERVICEPERSON.read(usernameOrigin);

		// Return
		if (origin != null) {
			msn = SERVICECHAT.read(idMessage, origin);
		} else {
			throw new Exception("No se ha encontrado el usurio del que desea el mensaje");
		}
		return msn;
	}

	public boolean delete(int id, String usernameOrigin) throws Exception {
		Message msn = read(id, usernameOrigin);
		boolean deleteOK = false;
		if (msn != null) {
			deleteOK = SERVICECHAT.delete(msn);
		} else {
			throw new Exception("No se ha podido borrar el mensaje");
		}

		return deleteOK;
	}
}
