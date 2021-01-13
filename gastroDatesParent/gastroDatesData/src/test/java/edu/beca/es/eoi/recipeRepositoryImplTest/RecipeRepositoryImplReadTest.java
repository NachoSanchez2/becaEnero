package edu.beca.es.eoi.recipeRepositoryImplTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import edu.beca.es.eoi.dataManager.DataManager;
import edu.beca.es.eoi.entity.Recipe;

class RecipeRepositoryImplReadTest {

	@Test
	void testRead() {
		// Declaracion de variables
		DataManager dataManager = new DataManager();
		Connection conn = dataManager.getConnection();
		String sf = "pulpo a la gallega";
		Recipe recipe = null;

		// Construccion de la peticion
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT r.recipeName,r.recipeDescription,r.url,r.valoration,");
		sql.append("i.ingredientName,i.amount,i.price");
		sql.append(" FROM recipe r JOIN ingredient i");
		sql.append(" ON i.id = r.id");
		sql.append(" WHERE r.recipeName = ?");

		if (conn != null) {
			try {
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				pst.setString(1, sf);
				try {
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						recipe = new Recipe(rs.getString("recipeName"), rs.getString("recipeDescription"),
								rs.getString("url"), rs.getDouble("valoration"), rs.getString("ingredientName"),
								rs.getDouble("amount"), rs.getDouble("price"));
					}
				} finally {
					pst.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				dataManager.closeConnection(conn);
			}
		}
		assertNotNull(recipe);
	}

}
