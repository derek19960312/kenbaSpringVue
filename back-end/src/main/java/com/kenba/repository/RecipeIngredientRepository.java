package com.kenba.repository;

import org.springframework.data.repository.CrudRepository;

import com.kenba.data.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Integer> {

	public void deleteRecipeIngredientByRecipeId (int id);
}
