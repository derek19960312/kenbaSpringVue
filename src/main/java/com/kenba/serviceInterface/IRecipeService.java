package com.kenba.serviceInterface;

import java.util.List;

import com.kenba.data.Recipe;

public interface IRecipeService {
	
	public Recipe getRecipe(int id);
	
	public List<Recipe> getRecipes();
	
	public void saveRecipe(Recipe recipe);
	
	public void deleteRecipe(int id);
}
