package com.kenba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kenba.data.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer>{
	
}
