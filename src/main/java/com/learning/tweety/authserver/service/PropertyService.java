package com.learning.tweety.authserver.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "classpath:application.yaml", factory = YamlPropertySourceService.class)
public class PropertyService {

	public PropertyService() {
		// TODO Auto-generated constructor stub
	}

}
