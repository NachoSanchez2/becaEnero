package edu.beca.es.eoi.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Profile;
import edu.beca.es.eoi.repository.ProfileRepository;

public class ProfileRepositoryJDBCImpl implements ProfileRepository {
	private Logger logger = Logger.getLogger(PersonRepositoryJDBCImpl.class);
	private static final boolean isTEST = false;

	public boolean save(Profile e) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Save");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO");
		sql.append(" profile(description,photo,cookPreference,idUser)");
		sql.append(" VALUES(?,?,?,?)");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, e.getDescription());
				pst.setString(2, e.getPhoto());
				pst.setString(3, e.getCookPreferences());
				pst.setInt(4, e.getIdUser());

				try {
					logger.info("Se ejecuta la peticion");
					int line = pst.executeUpdate();
					if (line != 0) {
						saveOK = true;
					}
				} finally {
					logger.info("Se cierra la peticion a BBDD");
					pst.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				logger.info("Se llama al metodo closeConnection");
				dataManager.closeConnection(conn);
			}
		}
		return saveOK;
	}

	public boolean upload(Profile e, int id) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Delete");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean updateOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE profile");
		sql.append(" SET description = ?, photo = ?, cookPreference = ?");
		sql.append(" WHERE idUser = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, e.getDescription());
				pst.setString(2, e.getPhoto());
				pst.setString(3, e.getCookPreferences());
				pst.setInt(4, id);
				try {
					logger.info("Se ejecuta la peticion");
					int line = pst.executeUpdate();
					if (line != 0) {
						updateOK = true;
					}
				} finally {
					logger.info("Se cierra la peticion a BBDD");
					pst.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				logger.info("Se llama al metodo closeConnection");
				dataManager.closeConnection(conn);
			}
		}
		return updateOK;
	}

	public Profile read(int id) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Read");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Profile e = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.description,p.photo,p.cookPreference");
		sql.append(" FROM profile p");
		sql.append(" WHERE idUser = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, id);

				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						e = new Profile(rs.getString("description"), rs.getString("photo"),
								rs.getString("cookPreference"), id);

						logger.debug(
								"El perfil del usuario es: Descripcion: " + rs.getString("description") + " Photo: "
										+ rs.getString("photo") + " CookPreference: " + rs.getString("cookPreference"));
					}
				} finally {
					logger.info("Se cierra la peticion a BBDD");
					pst.close();
				}
			} catch (SQLException ex) {
				logger.debug("No se ha podido guardar el usuario: " + ex.getStackTrace());
			} finally {
				logger.info("Se llama al metodo closeConnection");
				dataManager.closeConnection(conn);
			}
		}
		return e;
	}

}