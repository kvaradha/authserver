package com.learning.tweety.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learning.tweety.authserver.service.JWTTokeService;

@RestController
@RequestMapping("/authserver")
public class AccessTokenController {

	@Autowired
	public JWTTokeService jwtTokenService;
	
	@GetMapping("/getaccesstoken/{userName}")
	public String getAccessToken(@PathVariable String userName) {
		return jwtTokenService.buildJWTToken(userName);
	}
}