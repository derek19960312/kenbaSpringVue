package com.kenba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenba.data.Ingredient;
import com.kenba.exception.NotFoundException;
import com.kenba.repository.IngredientRepository;
import com.kenba.serviceInterface.IIngredientService;

@Service
public class IngredientService implements IIngredientService {
	
	@Autowired
	IngredientRepository ingredientRepository;

	@Override
	public Ingredient getIngredient(int id) {
		return ingredientRepository.findById(id).orElseThrow(() -> new NotFoundException("Can't find ingredient."));
	}

	@Override
	public List<Ingredient> getIngredients() {
		return (List<Ingredient>)ingredientRepository.findAll();
	}

	@Override
	public void saveIngredient(Ingredient ingredient) {
		ingredientRepository.save(ingredient);

	}

	@Override
	public void deleteIngredient(int id) {
		
		ingredientRepository.deleteById(id);
	}

}
