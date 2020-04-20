package com.kenba.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kenba.data.Recipe;
import com.kenba.service.RecipeService;
import com.kenba.utils.LogUtils;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Recipe> getById(@PathVariable("id") int id) {
		Recipe recipe = recipeService.getRecipe(id);
		return ResponseEntity.ok(recipe);
	}
	
	@GetMapping()
	public ResponseEntity<List<Recipe>> getAll(){
		List<Recipe> recipes = recipeService.getRecipes();
		return ResponseEntity.ok(recipes);
	}
	
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody Recipe recipe){
		recipeService.saveRecipe(recipe);
		
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(recipe.getId())
                .toUri();
        
		return ResponseEntity.created(location).body(recipe);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Recipe recipe){
		LogUtils.d("recipe", recipe.toString());
		recipe.setId(id);
		recipeService.saveRecipe(recipe);
		return ResponseEntity.ok(recipe);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		recipeService.deleteRecipe(id);
		return ResponseEntity.noContent().build();
	}
}
