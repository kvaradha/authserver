package com.learning.tweety.authserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.learning.tweety.authserver.repository.Credentials;
import com.learning.tweety.authserver.service.CredentialService;

@RestController
@RequestMapping("/authserver/creds")
public class CredentialController {
	@Autowired
	public CredentialService credentialService;

	@GetMapping("/getcredentials/{serverName}")
	public Credentials getCredentials(@PathVariable String serverName) {
		return credentialService.getCredentials(serverName);
	}
	
	@GetMapping("/getallcredentials")
	public Iterable<Credentials> getCredentials() {
		return credentialService.getCredentials();
	}
	
	@PostMapping("/createcredentials")
	public Credentials createCredentials(@RequestBody Credentials credentials) {
		return credentialService.create(credentials);
	}
}