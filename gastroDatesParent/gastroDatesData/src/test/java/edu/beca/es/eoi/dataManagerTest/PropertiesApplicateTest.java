package edu.beca.es.eoi.dataManagerTest;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.dataManager.DataManager;

class PropertiesApplicateTest {

	@Test
	void testPropertiesAplicate() {

		String dbUrl = null, dbUser = null, dbPass = null;

		DataManager dataManager = new DataManager();
		dataManager.propertiesAplicate();

		dbUrl = dataManager.getDbUrl();
		dbUser = dataManager.getDbUsuario();
		dbPass = dataManager.getDbPass();

		assertNotNull(dbUrl);
		assertNotNull(dbUser);
		assertNotNull(dbPass);

	}

}
