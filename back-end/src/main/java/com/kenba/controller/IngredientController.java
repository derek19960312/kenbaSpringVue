package com.kenba.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.kenba.data.Ingredient;
import com.kenba.service.IngredientService;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
	
	@Autowired
	IngredientService ingredientService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Ingredient> getById(@PathVariable("id") int id) {
		Ingredient ingredient = ingredientService.getIngredient(id);
		return ResponseEntity.ok(ingredient);
	}
	
	@GetMapping()
	public ResponseEntity<List<Ingredient>> getAll(){
		List<Ingredient> ingredients = ingredientService.getIngredients();
		return ResponseEntity.ok(ingredients);
	}
	
	@PostMapping()
	public ResponseEntity<?> create(@Valid @RequestBody Ingredient ingredient){
		ingredientService.saveIngredient(ingredient);
		
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ingredient.getId())
                .toUri();
        
		return ResponseEntity.created(location).body(ingredient);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Ingredient ingredient){
		ingredient.setId(id);
		ingredientService.saveIngredient(ingredient);
		return ResponseEntity.ok(ingredient);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		ingredientService.deleteIngredient(id);
		return ResponseEntity.noContent().build();
	}
}
