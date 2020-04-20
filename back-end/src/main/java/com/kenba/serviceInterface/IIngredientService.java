package com.kenba.serviceInterface;

import java.util.List;

import com.kenba.data.Ingredient;

public interface IIngredientService {
	
	public Ingredient getIngredient(int id);
	
	public List<Ingredient> getIngredients();
	
	public void saveIngredient(Ingredient ingredient);
	
	public void deleteIngredient(int id);
}
