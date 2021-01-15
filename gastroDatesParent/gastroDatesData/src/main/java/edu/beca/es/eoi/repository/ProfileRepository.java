package edu.beca.es.eoi.repository;

import edu.beca.es.eoi.entity.Profile;

public interface ProfileRepository {

	boolean save(Profile e);

	public Profile read(int id);

	boolean upload(Profile e, int id);
}
