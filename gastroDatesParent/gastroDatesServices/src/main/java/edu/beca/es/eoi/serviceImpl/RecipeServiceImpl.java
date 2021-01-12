//package edu.beca.es.eoi.serviceImpl;
//
//import java.util.Set;
//
//import edu.beca.es.eoi.entity.Ingredient;
//import edu.beca.es.eoi.entity.Recipe;
//import edu.beca.es.eoi.repository.RecipeRepository;
//import edu.beca.es.eoi.repositoryImpl.RecipeRepositoryImpl;
//import edu.beca.es.eoi.service.RecipeService;
//
//public class RecipeServiceImpl implements RecipeService {
//	@Override
//	public void publishRecipe(String id, String recipeName, String description, String photo,
//			Set<Ingredient> ingredients) {
//		RecipeRepository repository = new RecipeRepositoryImpl();
//		Recipe recipe = new Recipe(id, recipeName, description, photo, ingredients);
//		repository.save(recipe);
//	}
//
//	@Override
//	public void shareRecipe(Recipe recipe) {
//
//	}
//
//	@Override
//	public void valorateRecipe() {
//
//	}
//
//}
