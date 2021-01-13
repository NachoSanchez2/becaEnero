package edu.personrepositoryImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;

class PersonRepositoryJDBCImplSaveTest {

	@Test
	void testSave() {
		// Declaracion de variables
		Person e = new User("test", "test", "test", "test", "test@gmail.com", "av/test", "test12345");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection();
		int line = 0;
		// Construccion de la peticion
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append("user(personName,personSurname,username,pass,mail,address,phoneNumber) ");
		sql.append("VALUES(?,?,?,?,?,?,?)");
		try {
			PreparedStatement pst = conn.prepareStatement(sql.toString());
			pst.setString(1, ((User) e).getName());
			pst.setString(2, ((User) e).getSurname());
			pst.setString(3, ((User) e).getUsername());
			pst.setString(4, ((User) e).getPassword());
			pst.setString(5, ((User) e).getMail());
			pst.setString(6, ((User) e).getAddress());
			pst.setString(7, ((User) e).getPhoneNumber());
			line = pst.executeUpdate();
			pst.close();
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		assertEquals(1, line);
	}
}
