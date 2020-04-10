package com.kenba.controller;

import java.util.List;

import org.hibernate.query.QueryParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenba.data.Recipe;
import com.kenba.repository.RecipeRepository;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@GetMapping()
	public ResponseEntity<List<Recipe>> getIngredients (@ModelAttribute QueryParameter param) {
		
		List<Recipe> ingredients = recipeRepository.findAll();
		return ResponseEntity.ok().body(ingredients);

	}
}
