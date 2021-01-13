package edu.beca.es.eoi.repository;

public interface CrudInterface<E, SEARCH_FIELD> {

	boolean save(E e);

	E read(SEARCH_FIELD sf);

	boolean delete(E e);

	E update(E e, SEARCH_FIELD sf);

}
	