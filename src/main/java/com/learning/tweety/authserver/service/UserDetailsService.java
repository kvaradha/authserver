package com.learning.tweety.authserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.tweety.authserver.repository.Users;
import com.learning.tweety.authserver.repository.UsersRepository;

@Service
public class UserDetailsService {
	
	@Autowired
    private UsersRepository usersRepository;
	
	public boolean isValidUser(String userName, String password) {
		Users user = getUserDetails(userName);
		return password.equals(user.getPassWord());
	}
	
	public Users getUserDetails(String userName) {
		return usersRepository.findByUserName(userName);
	}

}
