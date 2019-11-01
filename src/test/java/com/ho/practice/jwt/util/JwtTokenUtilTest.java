package com.ho.practice.jwt.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTokenUtilTest {

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Test
	public void generateTokenTest() {
		//given
		
		//when
		String token = jwtTokenUtil.generateToken(
				Stream.of(new Object[][] {
				    { "userId", "testid" }
				}).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]))
				);
		
		String userId = (String) jwtTokenUtil.getAllClaimsFromToken(token).get("userId");
		
		//then
		assertThat(token).isNotNull();
		assertThat(token.length()).isGreaterThan(0);
		
		assertThat(userId).isEqualTo("testid");
		
	}
	
}
