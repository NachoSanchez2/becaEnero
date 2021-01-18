package edu.beca.es.eoi.repository;

import java.util.List;

import edu.beca.es.eoi.entity.Recipe;

public interface RecipeRepository extends CrudInterface<Recipe, String> {
	List<Recipe> readAll();

}
