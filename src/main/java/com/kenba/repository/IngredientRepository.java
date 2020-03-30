package com.kenba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenba.data.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
	
	List<Ingredient> findAll();
	
	List<Ingredient> findByName(String name);
}
