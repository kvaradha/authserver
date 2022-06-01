package com.learning.tweety.authserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository extends CrudRepository<Credentials, Long> {
	
	Credentials findByServerName(String serverName);
	
	Credentials findByCredentialsId(Long credentialsId);

}
