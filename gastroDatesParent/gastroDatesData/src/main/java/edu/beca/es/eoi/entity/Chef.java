package edu.beca.es.eoi.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chef extends Person {

	private String restaurant;	
	private String phone;
	private String mail;
	private String web;
	private List<Recipe> recipes;

}
