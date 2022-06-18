package com.learning.tweety.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.learning.tweety.authserver.service.YamlPropertiesService;


@SpringBootApplication
@EnableJpaRepositories("com.learning.tweety")
@EntityScan("com.learning.tweety")
@ComponentScan("com.learning.tweety")
@EnableConfigurationProperties(YamlPropertiesService.class)
@EnableTransactionManagement
public class AuthServer {
	public static void main(String[] args) {
		SpringApplication.run(AuthServer.class, args);
	}
}
