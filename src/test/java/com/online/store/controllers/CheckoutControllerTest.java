package com.online.store.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.store.model.CheckoutRequest;
import com.online.store.model.CheckoutRequest.ProductInfo;

@SpringBootTest
@AutoConfigureMockMvc
class CheckoutControllerTest {

	@Autowired
    private MockMvc mockMvc;
	    
	@BeforeEach
	void setUp() {
		System.out.println("Testing Homepage Controller");
	}
	
	@Test
	void testCheckout() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.post("/checkout")
				.content(asJsonString(new CheckoutRequest("firstName1", "lastName1", "email4@mail.com", "123 San Jose", null, "1111222233334444")))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
