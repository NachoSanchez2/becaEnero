package edu.beca.es.eoi.repository;

import edu.beca.es.eoi.entity.Person;

public interface PersonRepository extends CrudInterface<Person, String> {

	boolean save(Person e);

	Person read(String sf);

	boolean delete(Person e);

}
