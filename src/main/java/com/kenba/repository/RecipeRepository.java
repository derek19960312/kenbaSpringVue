package com.kenba.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kenba.data.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe , Integer>{

}
