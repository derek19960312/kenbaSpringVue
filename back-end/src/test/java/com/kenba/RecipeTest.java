package com.kenba;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.kenba.main.KenbaApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KenbaApplication.class)
@AutoConfigureMockMvc
public class RecipeTest {

	private HttpHeaders httpHeaders;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void init() {
		httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json;charset=utf-8");
	}

	@Test
	public void testCreateRecipe() throws Exception {

		JSONObject request = new JSONObject();
		request.put("name", "Apple Pie");
		request.put("count", 123);
		
		JSONArray recipeIngredients = new JSONArray();
		
		JSONObject recipeIngredient1 = new JSONObject();
		recipeIngredient1.put("riCount", 200);
		recipeIngredient1.put("riPrice", 16);
		JSONObject ingredient = new JSONObject();
		ingredient.put("id", 1);
		recipeIngredient1.put("ingredient",ingredient);
		recipeIngredients.put(recipeIngredient1);
		
		JSONObject recipeIngredient2 = new JSONObject();
		recipeIngredient2.put("riCount", 100);
		recipeIngredient2.put("riPrice", 1600);
		JSONObject ingredient2 = new JSONObject();
		ingredient2.put("id", 2);
		recipeIngredient2.put("ingredient",ingredient2);
		recipeIngredients.put(recipeIngredient2);
		
		request.put("reciepIngredients", recipeIngredients);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/recipe").headers(httpHeaders)
				.content(request.toString());

		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").hasJsonPath())
				.andExpect(jsonPath("$.name").value(request.getString("name")))
				.andExpect(jsonPath("$.count").value(request.getInt("count")))
				.andExpect(header().exists("Location"))
				.andExpect(header().string("Content-Type", "application/json"));
	}
	
	@Test
	public void testGetRecipe() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/recipe/1").headers(httpHeaders);

		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").hasJsonPath())
				.andExpect(jsonPath("$.count").value(30))
				.andExpect(jsonPath("$.name").value("蘋果派"));
				
		RequestBuilder requestBuilder2 = MockMvcRequestBuilders.get("/recipe/10").headers(httpHeaders);
		
		mockMvc.perform(requestBuilder2)
				.andDo(print())
				.andExpect(status().isNotFound());
	}

}
