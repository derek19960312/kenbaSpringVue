package com.kenba.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenba.data.Recipe;
import com.kenba.data.RecipeIngredient;
import com.kenba.exception.NotFoundException;
import com.kenba.repository.RecipeRepository;
import com.kenba.serviceInterface.IRecipeService;

@Service
public class RecipeService implements IRecipeService {
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	RecipeIngredientService recipeIngredientService;
	
	public Recipe getRecipe(int id) {
		return recipeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Can't find recipe."));
	}
	
	public List<Recipe> getRecipes() {
		return (List<Recipe>)recipeRepository.findAll();
	}
	
	public void saveRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
		Set<RecipeIngredient> ris = recipe.getReciepIngredients();
		ris.stream().forEach(ri -> ri.setRecipe(recipe));
		recipeIngredientService.saveRecipeIngredients(ris);
	}
	
	@Transactional
	public void deleteRecipe(int id) {
		recipeIngredientService.deleteRecipeIngredientByRecipeId(id);
		recipeRepository.deleteById(id);
	}
	
}
