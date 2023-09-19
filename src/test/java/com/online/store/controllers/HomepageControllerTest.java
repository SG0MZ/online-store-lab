
package com.online.store.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class HomepageControllerTest {
           
	@Autowired
    private MockMvc mockMvc;
	    
	@BeforeEach
	void setUp() {
		System.out.println("Testing Homepage Controller");
	}
	
//	@Disabled
	@Test
	void testGetProductCategories() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/categories"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("toys,electronics,art,music,apparel,jewelry"))
		.andDo(MockMvcResultHandlers.print());
	}

//	@Disabled
	@Test
	void testGetDealsOfTheDay() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/deals_of_the_day/{number_of_products}",1))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.products").exists())
	    .andExpect(MockMvcResultMatchers.jsonPath("$.products[*].id").isNotEmpty())
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	void testGetProductsForCategory() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get("/products").param("category","toys"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.products[*].category").isArray())
		.andDo(MockMvcResultHandlers.print());
	}
	
}
