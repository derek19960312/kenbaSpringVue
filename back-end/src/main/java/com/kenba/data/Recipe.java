package com.kenba.data;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "recipe")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	@NotBlank(message = "名稱請勿空白")
	private String name;
	
	@NotNull(message = "數量請勿空白")
	@Positive(message = "數量請為非0之正數")
	@Column(name = "count")
	private Integer count;
	
	@OneToMany(mappedBy="recipe")
	@NotEmpty(message = "請至少輸入一項食材")
	@Valid
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
