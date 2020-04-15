package com.kenba.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenba.data.RecipeIngredient;
import com.kenba.repository.RecipeIngredientRepository;
import com.kenba.serviceInterface.IRecipeIngredientService;

@Service
public class RecipeIngredientService implements IRecipeIngredientService {
	
	@Autowired
	RecipeIngredientRepository recipeIngredientRepository;

	@Override
	public RecipeIngredient getRecipeIngredient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecipeIngredient> getRecipeIngredients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
		recipeIngredientRepository.saveAll(recipeIngredients);
	}

	@Override
	public void deleteRecipeIngredientByRecipeId(int id) {
		recipeIngredientRepository.deleteRecipeIngredientByRecipeId(id);
	}

}
