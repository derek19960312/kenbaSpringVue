package com.kenba.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ingredient_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Ingredient ingredient;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipe_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Recipe recipe;

	@Column(name = "ri_count")
	private String riCount;

	@Column(name = "ri_price")
	private String riPrice;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}
	
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Recipe getRecipe() {
		return recipe;
	}
	@JsonBackReference
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public String getRiCount() {
		return riCount;
	}

	public void setRiCount(String riCount) {
		this.riCount = riCount;
	}

	public String getRiPrice() {
		return riPrice;
	}

	public void setRiPrice(String riPrice) {
		this.riPrice = riPrice;
	}
	
	

}
