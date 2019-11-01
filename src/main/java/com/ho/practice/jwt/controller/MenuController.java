package com.ho.practice.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ho.practice.jwt.util.JwtTokenUtil;

/**
 * 메뉴정보 관리를 위한 컨트롤러
 * 
 * @author hhsung
 *
 */
@RestController
@RequestMapping("/menu/v0.1")
public class MenuController {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	/**
	 * 메뉴정보 조회
	 * @return
	 */
	@GetMapping(value = "/")
	public String getMenu(@RequestHeader(required = false, value = "Authorization") String authorization) {
		return "menu";
	}
	
}
