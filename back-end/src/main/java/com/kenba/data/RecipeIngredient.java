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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

	@NotNull(message = "數量請勿空白")
	@Positive(message = "數量請為非0之正數")
	@Column(name = "ri_count")
	private Integer riCount;

	@NotNull(message = "金額請勿空白")
	@Positive(message = "金額請為非0之正數")
	@Column(name = "ri_price")
	private Integer riPrice;

	
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

	public Integer getRiCount() {
		return riCount;
	}

	public void setRiCount(Integer riCount) {
		this.riCount = riCount;
	}

	public Integer getRiPrice() {
		return riPrice;
	}

	public void setRiPrice(Integer riPrice) {
		this.riPrice = riPrice;
	}
	
	

}
