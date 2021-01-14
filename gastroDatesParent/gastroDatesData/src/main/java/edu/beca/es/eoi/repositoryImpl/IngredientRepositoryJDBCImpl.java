package edu.beca.es.eoi.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Ingredient;
import edu.beca.es.eoi.repository.IngredientRepository;

public class IngredientRepositoryJDBCImpl implements IngredientRepository {
	private Logger logger = Logger.getLogger(IngredientRepositoryJDBCImpl.class);
	private static final boolean isTEST = false;

	public boolean save(Ingredient e) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Save");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO");
		sql.append(" ingredient (ingredientName,amount,price)");
		sql.append(" VALUES(?,?,?)");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, e.getName());
				pst.setDouble(2, e.getAmount());
				pst.setDouble(3, e.getPrice());

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

	public Ingredient read(String sf) {
		// Declaracion de variables
		logger.info("Entramos en el metodo read");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Ingredient ingredient = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT i.ingredientName,i.amount,i.price");
		sql.append(" ingredient i WHERE ingredientName = ?");

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, sf);
				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						ingredient = new Ingredient(rs.getString("ingredientName"), rs.getDouble("amount"),
								rs.getDouble("price"));
						logger.debug("INGREDIENTE: name: " + rs.getString("ingredientName") + " amount: "
								+ rs.getDouble("amount") + " price: " + rs.getDouble("price"));
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
		return ingredient;
	}

	public boolean delete(Ingredient e) {
		// Declaracion de variables
		logger.info("Entramos en el metodo delete");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean deleteOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ingredient");
		sql.append(" WHERE id = ?");
		if (conn != null) {
			PreparedStatement pst;
			try {
				pst = conn.prepareStatement(sql.toString());
				pst.setInt(1, e.getId());
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

	public boolean update(Ingredient e, int id) {

		// Declaracion de variables
		logger.info("Entramos en el metodo Update");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean updateOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ingredient ");
		sql.append("SET ingredientName = ?, amount = ?, price = ? ");
		sql.append("WHERE id = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, e.getName());
				pst.setDouble(2, e.getAmount());
				pst.setDouble(3, e.getPrice());
				pst.setInt(4, e.getId());

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

}
