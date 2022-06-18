package com.learning.tweety.authserver.repository;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
	//Find user details by user name.
	Users findByUserName(String serverName);
}
