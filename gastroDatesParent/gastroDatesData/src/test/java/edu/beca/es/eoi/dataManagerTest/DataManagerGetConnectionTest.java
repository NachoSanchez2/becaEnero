package edu.beca.es.eoi.dataManagerTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

class DataManagerGetConnectionTest {
	@Test
	void getConnection() {
		String dbUrl = "jdbc:mysql://localhost:3306/pruebasservlet?serverTimezone=UTC";
		String dbUser = "root";
		String dbPass = "1234";
		Logger logger = Logger.getLogger(DataManagerGetConnectionTest.class);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			assertNotNull(conn);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			logger.debug("No se ha podido generar la conexion: " + e.getStackTrace());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.debug("No se ha podido cerrar la conexion: " + e.getStackTrace());
			}
		}
	}
}
