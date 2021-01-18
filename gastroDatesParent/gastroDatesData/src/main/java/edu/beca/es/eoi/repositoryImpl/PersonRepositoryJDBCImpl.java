package edu.beca.es.eoi.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.PersonRepository;

public class PersonRepositoryJDBCImpl implements PersonRepository {

	private Logger logger = Logger.getLogger(PersonRepositoryJDBCImpl.class);
	private static final boolean isTEST = false;

	public boolean save(Person e) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Save");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO");
		sql.append(" user(personName,personSurname,username,pass,mail,address,phoneNumber)");
		sql.append(" VALUES(?,?,?,?,?,?,?)");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, ((User) e).getName());
				pst.setString(2, ((User) e).getSurname());
				pst.setString(3, ((User) e).getUsername());
				pst.setString(4, ((User) e).getPassword());
				pst.setString(5, ((User) e).getMail());
				pst.setString(6, ((User) e).getAddress());
				pst.setString(7, ((User) e).getPhoneNumber());

				try {
					logger.info("Se ejecuta la peticion");
					int line = pst.executeUpdate();
					logger.debug("Se ha ejecutado: " + line + " vez");
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

	public boolean update(Person e, int idUser) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Delete");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean updateOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE user ");
		sql.append(
				"SET personName = ?, personSurname = ?, username = ?, pass = ?, mail = ?, address = ?, phoneNumber = ? ");
		sql.append("WHERE idUser = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, ((User) e).getName());
				pst.setString(2, ((User) e).getSurname());
				pst.setString(3, ((User) e).getUsername());
				pst.setString(4, ((User) e).getPassword());
				pst.setString(5, ((User) e).getMail());
				pst.setString(6, ((User) e).getAddress());
				pst.setString(7, ((User) e).getPhoneNumber());
				pst.setInt(8, idUser);

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

	public Person read(String sf) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Read");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Person e = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT personName,personSurname,username,mail,address,phoneNumber ");
		sql.append("FROM user WHERE ");
		sql.append("username = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, sf);

				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						e = new User(rs.getString("personName"), rs.getString("personSurname"),
								rs.getString("username"), rs.getString("mail"), rs.getString("address"),
								rs.getString("phoneNumber"));

						logger.debug("El usuario encontrado es: " + "NAME: " + ((User) e).getName() + "SURNAME: "
								+ ((User) e).getSurname() + "USERNAME: " + ((User) e).getUsername() + "MAIL: "
								+ ((User) e).getMail() + "ADDRESS: " + ((User) e).getAddress() + "PHONENUMBER: "
								+ ((User) e).getPhoneNumber());
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

	// TODO:test readById
	public Person readById(int id) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Read");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Person e = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT username,mail,address,phoneNumber ");
		sql.append("FROM user WHERE ");
		sql.append("idUser = ?");
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
						e = new User(rs.getString("username"), rs.getString("mail"), rs.getString("address"),
								rs.getString("phoneNumber"));

						logger.debug("El usuario encontrado es: USERNAME: " + ((User) e).getUsername() + "MAIL: "
								+ ((User) e).getMail() + "ADDRESS: " + ((User) e).getAddress() + "PHONENUMBER: "
								+ ((User) e).getPhoneNumber());
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

	// TODO: test de readAll
	public List<String> readAll() {
		// Declaracion de variables
		logger.info("Entramos en el metodo Read");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		List<String> usernames = new ArrayList<String>();

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT username FROM user ");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						usernames.add(rs.getString("username"));
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
		return usernames;
	}

	public boolean delete(Person e) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Delete");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean deleteOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM user ");
		sql.append("WHERE username = ? ");
		sql.append("AND pass = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, ((User) e).getUsername());
				pst.setString(2, ((User) e).getPassword());
				try {
					logger.info("Se ejecuta la peticion");
					int line = pst.executeUpdate();
					logger.debug("Se ha ejecutado: " + line + " vez");
					if (line != 0) {
						deleteOK = true;
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
		return deleteOK;
	}

}
