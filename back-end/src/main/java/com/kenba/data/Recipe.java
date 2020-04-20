package com.kenba.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "count")
	private Integer count;
	
	@OneToMany(mappedBy="recipe")
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Set<RecipeIngredient> getReciepIngredients() {
		return reciepIngredients;
	}

	public void setReciepIngredients(Set<RecipeIngredient> reciepIngredients) {
		this.reciepIngredients = reciepIngredients;
	}

}
