package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = com.example.demo.controller.DemoController.class)
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void greeting() throws Exception {
		mockMvc.perform(get("/greeting"))
				.andExpect(content().string(containsString("Hola, Mundo!")));
	}
	
	@Test
	public void greetingWithUser() throws Exception {
		mockMvc.perform(get("/greeting").param("name", "Briant"))
				.andExpect(content().string(containsString("Hola, Briant!")));
	}

}
