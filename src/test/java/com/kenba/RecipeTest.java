package com.kenba;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RecipeTest {

	private HttpHeaders httpHeaders;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void init() {
		httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");
	}

	@Test
	public void testCreateRecipe() throws Exception {

		JSONObject request = new JSONObject();
		request.put("name", "Harry Potter");
		request.put("price", 450);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products").headers(httpHeaders)
				.content(request.toString());

		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").hasJsonPath())
				.andExpect(jsonPath("$.name").value(request.getString("name")))
				.andExpect(jsonPath("$.price").value(request.getInt("price"))).andExpect(header().exists("Location"))
				.andExpect(header().string("Content-Type", "application/json;charset=UTF-8"));
	}

}
