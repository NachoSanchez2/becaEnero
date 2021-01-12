package edu.beca.es.eoi.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
	
	private String id;
	private User from;
	private User to;
	private String message;
	private Date date;
	private boolean readed;

}
