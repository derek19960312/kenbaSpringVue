package com.kenba.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.kenba.data.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe , Integer>{

}
