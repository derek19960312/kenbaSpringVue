package com.kenba.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "名稱請勿空白")
	@Column(name = "name")
	private String name;
	
	@NotBlank(message = "單位請勿空白")
	@Column(name = "unit")
	private String unit;

	@OneToMany(mappedBy = "ingredient")
	private Set<RecipeIngredient> reciepIngredients;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	public Set<RecipeIngredient> getReciepIngredients() {
		return reciepIngredients;
	}
	@JsonBackReference
	public void setReciepIngredients(Set<RecipeIngredient> reciepIngredients) {
		this.reciepIngredients = reciepIngredients;
	}

}
