package edu.personrepositoryImplTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;

class PersonRepositoryJDBCImplReadTest {

	@Test
	void testRead() {
		// Declaracion de variables
		String sf = "pepe";
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection();
		Person e = null;

		// Construccion de la peticion
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT personName,personSurname,username,mail,address,phoneNumber ");
		sql.append("FROM user WHERE ");
		sql.append("username = ?");

		if (conn != null) {
			try {
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, sf);

				try {
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						e = new User(rs.getString("personName"), rs.getString("personSurname"),
								rs.getString("username"), rs.getString("mail"), rs.getString("address"),
								rs.getString("phoneNumber"));
					}
				} finally {
					pst.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				dataManager.closeConnection(conn);
			}
		}
		assertNotNull(e);
	}

}
