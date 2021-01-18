package edu.beca.es.eoi.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Recipe;
import edu.beca.es.eoi.repository.RecipeRepository;

public class RecipeRepositoryJDBCImpl implements RecipeRepository {

	private Logger logger = Logger.getLogger(RecipeRepositoryJDBCImpl.class);
	private static final boolean isTEST = false;

	public boolean save(Recipe e) {
		// Declaracion de variables
		logger.info("Entramos en el metodo save");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean saveOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO");
		sql.append(" recipe(recipeName,recipeDescription,photo,valoration,idUser)");
		sql.append(" VALUES(?,?,?,?,?)");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, e.getRecipeName());
				pst.setString(2, e.getRecipeDescription());
				pst.setString(3, e.getPhoto());
				pst.setDouble(4, e.getValoration());
				pst.setInt(5, e.getIdUser());

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

	public Recipe read(String sf) {
		// Declaracion de variables
		logger.info("Entramos en el metodo read");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		Recipe recipe = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT r.recipeName,r.recipeDescription,r.photo,r.valoration,");
		sql.append(" WHERE r.recipeName = ?");
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
						recipe = new Recipe(rs.getString("recipeName"), rs.getString("recipeDescription"),
								rs.getString("photo"), rs.getDouble("valoration"));
						logger.debug("RECETA: Nombre: " + recipe.getRecipeName() + "Description: "
								+ recipe.getRecipeDescription() + "Valoration: " + recipe.getValoration());
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
		return recipe;
	}

	// TODO: test readAll
	public List<Recipe> readAll() {
		// Declaracion de variables
		logger.info("Entramos en el metodo save");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		List<Recipe> recipes = new ArrayList<Recipe>();

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT r.recipeName,r.recipeDescription,r.photo,r.valoration,");
		sql.append(" u.username,u.mail,u.phoneNumber FROM recipe r");
		sql.append(" JOIN user u ON r.idUser = u.idUser");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());

				try {
					logger.info("Se ejecuta la peticion");
					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						recipes.add(new Recipe(rs.getString("recipeName"), rs.getString("recipeDescription"),
								rs.getString("photo"), rs.getDouble("valoration"), rs.getInt("idUser")));
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
		return recipes;
	}

	public boolean delete(Recipe e) {
		// Declaracion de variables
		logger.info("Entramos en el metodo delete");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean deleteOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM recipe");
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

	public boolean update(Recipe e, int id) {

		// Declaracion de variables
		logger.info("Entramos en el metodo update");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection(isTEST);
		boolean updateOK = false;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE recipe ");
		sql.append("SET recipeName = ?, recipeDescription = ?, photo = ? , valoration = ? ");
		sql.append("WHERE id = ?");
		logger.debug("Peticion a BBDD: " + sql.toString());

		if (conn != null) {
			try {
				logger.info("Se perpara la peticion");
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, e.getRecipeName());
				pst.setString(2, e.getRecipeDescription());
				pst.setString(3, e.getPhoto());
				pst.setDouble(4, e.getValoration());
				pst.setInt(5, id);

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
