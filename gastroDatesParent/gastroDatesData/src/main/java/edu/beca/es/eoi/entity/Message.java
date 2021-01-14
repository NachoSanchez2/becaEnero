package edu.beca.es.eoi.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

	private int id;
	private User origin;
	private User destination;
	private String message;
	private Date date;
	private boolean readed;

	public Message(User origin, User destination, String message, Date date, boolean readed) {
		this.message = message;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.readed = readed;
	}

	public Message(int id, User destination, User origin, String message, boolean readed) {
		this.id = id;
		this.destination = destination;
		this.origin = origin;
		this.message = message;
		this.readed = readed;
	}

	public Message(int id, User origin, User destination, String message) {
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.message = message;
	}

}
