package edu.beca.es.eoi.repository;

import java.util.List;

import edu.beca.es.eoi.entity.Person;

public interface PersonRepository extends CrudInterface<Person, String> {
	List<String> readAll();

	Person readById(int id);
}
