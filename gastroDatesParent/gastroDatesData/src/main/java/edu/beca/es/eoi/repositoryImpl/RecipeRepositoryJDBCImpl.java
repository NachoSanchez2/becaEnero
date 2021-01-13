package edu.beca.es.eoi.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Recipe;
import edu.beca.es.eoi.repository.RecipeRepository;

public class RecipeRepositoryJDBCImpl implements RecipeRepository {

	private Logger logger = Logger.getLogger(RecipeRepositoryJDBCImpl.class);

	public boolean save(Recipe e) {
		// TODO: No se meter con algo relacionado;
		return false;
	}

	public Recipe read(String sf) {
		// Declaracion de variables
		logger.info("Entramos en el metodo Save");
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection();
		Recipe recipe = null;

		// Construccion de la peticion
		logger.info("Se genera la peticion a BBDD");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT r.recipeName,r.recipeDescription,r.url,r.valoration,");
		sql.append("i.ingredientName,i.amount,i.price");
		sql.append(" FROM recipe r JOIN ingredient i");
		sql.append(" ON i.id = r.id");
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
								rs.getString("url"), rs.getDouble("valoration"), rs.getString("ingredientName"),
								rs.getDouble("amount"), rs.getDouble("price"));
						logger.debug("RECETA: Nombre: " + recipe.getRecipeName() + "Description: "
								+ recipe.getDescription() + "Valoration: " + recipe.getValoration()
								+ "INGREDIENTE: NombreIngrediente: " + recipe.getIngredients().getName() + " Amount: "
								+ recipe.getIngredients().getAmount() + " Price: "
								+ recipe.getIngredients().getPrice());
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
		return recipe;
	}

	public boolean delete(Recipe e) {
		// TODO Auto-generated method stub
		return false;
	}

	public Recipe update(Recipe e, String sf) {
		// TODO Auto-generated method stub
		return null;
	}

}
