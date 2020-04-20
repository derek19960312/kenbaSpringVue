package com.kenba.serviceInterface;

import java.util.List;
import java.util.Set;

import com.kenba.data.RecipeIngredient;

public interface IRecipeIngredientService {

	public RecipeIngredient getRecipeIngredient(int id);
	
	public List<RecipeIngredient> getRecipeIngredients();
	
	public void saveRecipeIngredients(Set<RecipeIngredient> recipeIngredients);
	
	public void deleteRecipeIngredientByRecipeId(int id);
}
