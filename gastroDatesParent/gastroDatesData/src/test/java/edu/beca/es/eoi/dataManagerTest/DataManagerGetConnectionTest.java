package edu.beca.es.eoi.dataManagerTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.dataManager.DataManager;

class DataManagerGetConnectionTest {
	private static final boolean isTEST = true;

	@Test
	void getConnection() {
		Connection conn = null;
		DataManager dataManager = new DataManager();
		conn = dataManager.getConnection(isTEST);
		assertNotNull(conn);
		if (conn != null) {
			dataManager.closeConnection(conn);
		}
	}
}
