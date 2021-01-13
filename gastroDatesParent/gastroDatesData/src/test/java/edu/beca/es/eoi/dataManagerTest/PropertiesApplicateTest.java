package edu.beca.es.eoi.dataManagerTest;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class PropertiesApplicateTest {

	String dbUrl;
	String dbUser;
	String dbPass;

	@Test
	void testPropertiesAplicate() {
		Properties properties = new Properties();
		try {
			FileInputStream input = new FileInputStream(new File("src/test/resources/application.properties"));
			properties.load(input);
		} catch (IOException e) {

		}
		setDbUrl(properties.getProperty("BBDD.url"));
		setDbUser(properties.getProperty("BBDD.user"));
		setDbPass(properties.getProperty("BBDD.pass"));

		assertNotNull(properties);
		assertNotNull(dbUrl);
		assertNotNull(dbUser);
		assertNotNull(dbPass);

	}

}
