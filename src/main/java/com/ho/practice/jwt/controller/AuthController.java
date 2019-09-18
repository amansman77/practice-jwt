package com.ho.practice.jwt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 사용자 인증 및 권한 관리를 위한 컨트롤러
 * 
 * @author hhsung
 *
 */
@RestController
@RequestMapping("/auth/v0.1")
public class AuthController {
	
	/**
	 * 로그인</br>
	 * access token 발급</br>
	 * </br>
	 * 로그아웃(access token 제거)에 대한 기능을 불필요</br>
	 * 서버에서는 token정보를 저장하지 않기 때문에 클라이언트에서 token을 제거하면 동일한 기능으로 동작</br>
	 * 
	 * @return
	 */
	@PostMapping(value = "/")
	public String login(@RequestHeader String Authorization) {
		return "accesstoken";
	}
	
	/**
	 * 토큰갱신
	 * @return
	 */
	@PutMapping(value = "/")
	public String refreshToken() {
		return "accesstoken";
	}
	
}
