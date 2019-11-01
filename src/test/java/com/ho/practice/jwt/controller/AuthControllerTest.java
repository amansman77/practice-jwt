package com.ho.practice.jwt.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ho.practice.jwt.util.JwtTokenUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthController.class)
public class AuthControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@MockBean
	private JwtTokenUtil jwtTokenUtil;
	
	private static final String serviceUrl ="/auth/v0.1";
	
	@Test
	public void testLogin() throws Exception {
		//given
		LonginReqDto longinReqDto = new LonginReqDto();
		longinReqDto.setId("testid");
		longinReqDto.setPw("testpw");

		given(
				jwtTokenUtil.generateToken(
						Stream.of(new Object[][] {
						    { "userId", longinReqDto.getId() },
						    { "userAuth", "admin" }
						}).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]))
						, 10000)
				).willReturn("accesstoken");
		
		//when
		final ResultActions actions = mockMvc.perform(post(serviceUrl + "/")
//					.header("Authorization", "")
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(objectMapper.writeValueAsString(longinReqDto))
				)
				.andDo(print());
		
		//then
		actions
			.andExpect(status().isOk())
			.andExpect(content().string("accesstoken"))
		;
	}
	
}
