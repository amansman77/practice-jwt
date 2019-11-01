package com.ho.practice.jwt.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuController.class)
public class MenuControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	private static final String serviceUrl ="/menu/v0.1";
	
	@Test
	public void testGetMenu() throws Exception {
		//given
//		given().willReturn();
		
		//when
		final ResultActions actions = mockMvc.perform(get(serviceUrl + "/")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
				)
				.andDo(print());
		
		//then
		actions
			.andExpect(status().isOk())
			.andExpect(content().string("menu"))
		;
	}
	
}
