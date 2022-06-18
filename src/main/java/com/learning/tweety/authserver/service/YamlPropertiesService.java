package com.learning.tweety.authserver.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationPropertiesScan
@EnableConfigurationProperties
@ConfigurationProperties("spring")
public class YamlPropertiesService {
	@Value("${spring.jwt.tokenSecret}")
	private String jwtTokenSecret;
	@Value("${spring.jwt.tokenExpiration}")
	private String expirationTime;
	public String getJwtTokenSecret() {
		return jwtTokenSecret;
	}
	public void setJwtTokenSecret(String jwtTokenSecret) {
		this.jwtTokenSecret = jwtTokenSecret;
	}
	public String getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
}
