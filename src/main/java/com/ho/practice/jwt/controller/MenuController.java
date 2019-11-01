package com.ho.practice.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 메뉴정보 관리를 위한 컨트롤러
 * 
 * @author hhsung
 *
 */
@RestController
@RequestMapping("/menu/v0.1")
public class MenuController {
	
	/**
	 * 메뉴정보 조회
	 * @return
	 */
	@GetMapping(value = "/")
	public String getMenu() {
		return "menu";
	}
	
}
