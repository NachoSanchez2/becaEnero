package edu.personrepositoryImplTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;

class PersonRepositoryJDBCImplDeleteTest {

	@Test
	void testDelete() {
		Person e = new User("test", "test", "test", "test", "test@gmail.com", "av/test", "test12345");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection();
		int line = 0;

		// Construccion de la peticion
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM user ");
		sql.append("WHERE username = ? ");
		sql.append("AND pass = ?");

		if (conn != null) {
			try {
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, ((User) e).getUsername());
				pst.setString(2, ((User) e).getPassword());
				try {
					line = pst.executeUpdate();
				} finally {
					pst.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				dataManager.closeConnection(conn);
			}
		}
		assertEquals(1, line);
	}

}
