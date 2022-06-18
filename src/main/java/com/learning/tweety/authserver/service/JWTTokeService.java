package com.learning.tweety.authserver.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Service
public class JWTTokeService {
	//Secret should be stored in wallet.
	String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
	@Autowired
	YamlPropertiesService properties;
	
	public String buildJWTToken(String userName) {
		Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(properties.getJwtTokenSecret()), 
				SignatureAlgorithm.HS256.getJcaName());
		Instant now = Instant.now();
		String jwtToken = Jwts.builder()
				.claim("username", userName)
				.setSubject(userName)
				.setId(UUID.randomUUID().toString())
				.setIssuedAt(Date.from(now))
				.setExpiration(Date.from(now.plus(Long.valueOf(properties.getExpirationTime()), ChronoUnit.MINUTES)))
				.signWith(hmacKey)
				.compact();
		return jwtToken;
	}
	
	public boolean isValidToken(String jwtString) {
		try {
			Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), 
					SignatureAlgorithm.HS256.getJcaName());
			Jwts.parserBuilder().setSigningKey(hmacKey).build().parseClaimsJws(jwtString);
			return true;
		} catch(Exception ex) {
			return false;
		}
	}

}
