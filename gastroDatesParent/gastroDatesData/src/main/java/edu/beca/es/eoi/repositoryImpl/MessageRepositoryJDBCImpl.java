package edu.beca.es.eoi.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Message;
import edu.beca.es.eoi.entity.Person;
import edu.beca.es.eoi.entity.User;
import edu.beca.es.eoi.repository.MessageRepository;

public class MessageRepositoryJDBCImpl implements MessageRepository {
	public static final boolean isTEST = false;
	public static Logger logger = Logger.getLogger(MessageRepositoryJDBCImpl.class);

	public boolean save(Message e, java.sql.Date sqlDate) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Save");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO");
		sql.append(" message(origin, destination, message, datetimemessage,readed)");
		sql.append(" VALUES(?,?,?,?,?)");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pts = conn.prepareStatement(sql.toString());
				pts.setInt(1, e.getOrigin().getIdUser());
				pts.setInt(2, e.getDestination().getIdUser());
				pts.setString(3, e.getMessage());
				pts.setDate(4, sqlDate);
				// TODO: falta pasar el casteo este en el MessageServiceImpl
				pts.setBoolean(5, e.isReaded());
				try {
					logger.info("Se ejecuta la peticion");
					int line = pts.executeUpdate();
					if (line != 0) {
						saveOK = true;
					}
				} finally {
					logger.info("Se cierra la peticion a BBDD");
					pts.close();
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

	public List<Message> readAllMessageFromUser(Person d) {
		// Declaracion de variables
		logger.info("Entramos en el metodo readAllMessageFromUser");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Message message = null;
		List<Message> messages = new ArrayList<Message>();
		Person o;

		// CONSTRUCCION DE LA PETICION

		/*
		 * Seleccionar la id,el mensaje, el nombre,mail y telefono del usuario origen y
		 * si está leído, del mensaje dónde el usuario destino sea el usuario cuyo
		 * username sea del user que entra por parametro
		 */

		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT m.id,m.message,o.username,o.personName,o.mail,o.phoneNumber,m.readed");
		sql.append(" FROM message m");
		sql.append(" JOIN user o ON o.idUser = m.origin");
		sql.append(" JOIN user d ON d.idUser = m.destination");
		sql.append(" WHERE d.username = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pts = conn.prepareStatement(sql.toString());
				pts.setString(1, ((User) d).getUsername());
				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pts.executeQuery();
					while (rs.next()) {
						o = new User(rs.getString("username"), rs.getString("o.personName"), rs.getString("o.mail"),
								rs.getString("o.phoneNumber"));
						logger.debug("Se crea el usuario origen del mensaje: " + ((User) o).getName() + " "
								+ ((User) o).getMail() + " " + ((User) o).getPhoneNumber());
						message = new Message(rs.getInt("m.id"), (User) o, (User) d, rs.getString("message"),
								rs.getBoolean("readed"));
						messages.add(message);
					}
				} finally {
					logger.info("Se cierra la peticion a BBDD");
					pts.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				logger.info("Se llama al metodo closeConnection");
				dataManager.closeConnection(conn);
			}
		}
		return messages;
	}

	public List<Message> readAllMessageIsReaded(Person d, boolean mStatement) {
		// Declaracion de variables
		logger.info("Entramos en el metodo readAllMessageIsReaded");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Message message = null;
		List<Message> messages = new ArrayList<Message>();
		Person o;
		// CONSTRUCCION DE LA PETICION

		/*
		 * Seleccionar la id,el mensaje, el nombre,mail y telefono del usuario origen y
		 * del mensaje dónde el usuario destino sea el usuario cuyo username sea del
		 * user que entra por parametro y si esta leído o no
		 */

		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT m.id,m.message,m.datetimemessage,o.username,o.personName,o.mail,o.phoneNumber");
		sql.append(" FROM message m");
		sql.append(" JOIN user o ON o.idUser = m.origin");
		sql.append(" JOIN user d ON d.idUser = m.destination");
		sql.append(" WHERE d.username = ?");
		sql.append(" AND   m.readed = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pts = conn.prepareStatement(sql.toString());
				pts.setString(1, ((User) d).getUsername());
				pts.setBoolean(2, mStatement);
				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pts.executeQuery();
					while (rs.next()) {

						o = new User(rs.getString("o.username"), rs.getString("personName"), rs.getString("mail"),
								rs.getString("phoneNumber"));
						logger.debug("Se crea el usuario origen del mensaje: " + ((User) o).getName() + " "
								+ ((User) o).getMail() + " " + ((User) o).getPhoneNumber());

						// TODO: Faltaría también traer la fecha de envío y cómo pasar esta lógica al
						// MessageService
						message = new Message(rs.getInt("m.id"), (User) o, (User) d, rs.getString("message"),
								rs.getDate("m.datetimemessage"));
						messages.add(message);
					}
				} finally {
					logger.info("Se cierra la peticion a BBDD");
					pts.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				logger.info("Se llama al metodo closeConnection");
				dataManager.closeConnection(conn);
			}
		}
		return messages;
	}

	public Message read(int id, Person d) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Delete");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Message message = null;
		Person o;

		// CONSTRUCCION DE LA PETICION

		/*
		 * Seleccionar la id,el mensaje, el nombre,mail y telefono del usuario origen y
		 * si está leído, del mensaje dónde el usuario destino sea el usuario cuyo
		 * username sea del user que entra por parametro
		 */

		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT m.message,m.datetimemessage,o.username,o.personName,o.mail,o.phoneNumber,m.readed");
		sql.append(" WHERE m.id = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			PreparedStatement pst;
			try {
				pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, id);

				ResultSet rs = pst.executeQuery();
				try {
					while (rs.next()) {
						o = new User(rs.getString("o.username"), rs.getString("o.personName"), rs.getString("o.mail"),
								rs.getString("o.phoneNumber"));
						message = new Message(id, (User) o, (User) d, rs.getString("m.message"),
								rs.getDate("m.datetimemessage"), rs.getBoolean("m.readed"));
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
		return message;
	}

	public boolean delete(Message msn) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Save");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean deleteOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM message");
		sql.append(" WHERE id = ?");
		if (conn != null) {
			PreparedStatement pst;
			try {
				pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, msn.getId());
				try {
					int line = pst.executeUpdate();
					if (line != 0) {
						deleteOK = true;
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
		return deleteOK;
	}

}
