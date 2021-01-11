package edu.es.eoi.repositoryImpl;

import edu.es.eoi.entity.Person;
import edu.es.eoi.entity.User;
import edu.es.eoi.main.MainApp;
import edu.es.eoi.repository.PersonRepository;

public class PersonRepositoryMemoryImpl implements PersonRepository {

	@Override
	public void save(Person e) {
		if (e instanceof User) {
			MainApp.users.put(((User) e).getUsername(), (User) e);
		}
	}

	@Override
	public Person read(String sf) {
		return MainApp.users.get(sf);
	}

	@Override
	public void delete(Person e) {
		MainApp.users.remove(((User) e).getUsername());
	}

	@Override
	public Person update(Person e) {
		return e;

	}

}
