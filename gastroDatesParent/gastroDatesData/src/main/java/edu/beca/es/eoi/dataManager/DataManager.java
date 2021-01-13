package edu.beca.es.eoi.dataManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataManager {
	private Properties properties = new Properties();
	String dbUrl;
	String dbUsuario;
	String dbPass;
	Logger logger = Logger.getLogger(DataManager.class);

	public Connection getConnection() {
		logger.info("Entro en el metodo getConnection");
		logger.info("llamo al metodo propertiesAplicate");
		propertiesAplicate();

		Connection conn = null;
		logger.info("Aqui abro la conexion con un patron singletone");
		logger.debug("Los parametros de conexion son: Url: " + getDbUrl() + " User: " + getDbUsuario() + " Password: "
				+ getDbPass());
		try {
			conn = DriverManager.getConnection(getDbUrl(), getDbUsuario(), getDbPass());
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			logger.debug("Could not connect to DB: " + e.getStackTrace());
		}
		return conn;
	}

	public void propertiesAplicate() {
		logger.info("llamo al metodo readProperties");
		try {
			readProperties();
		} catch (IOException e1) {
			logger.debug("Could not found file .properties: " + e1.getStackTrace());
		}
		setDbUrl(properties.getProperty("BBDD.url"));
		setDbUsuario(properties.getProperty("BBDD.user"));
		setDbPass(properties.getProperty("BBDD.pass"));
	}

	public void readProperties() throws IOException {
		logger.info("Entro en el metodo readProperties de mi aplicacion:");
		logger.debug("Ruta del archivo: " + "src/main/resources/application.properties");

		FileInputStream input = new FileInputStream(new File("src/main/resources/application.properties"));

		properties.load(input);
		logger.info("Salgo del metodo readProperties de mi aplicacion:");

	}

	public void closeConnection(Connection conn) {
		logger.info("Se cierra la conexion");
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

}
