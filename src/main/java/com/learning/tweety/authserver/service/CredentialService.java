package com.learning.tweety.authserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.tweety.authserver.repository.Credentials;
import com.learning.tweety.authserver.repository.CredentialsRepository;

@Service
public class CredentialService {
	
	@Autowired
    private CredentialsRepository credentialsRepository;
	
	public Credentials getCredentials(String serverName) {
		return credentialsRepository.findByServerName(serverName);
	}
	
	public Iterable<Credentials> getCredentials() {
		return credentialsRepository.findAll();
	}
	
	public Credentials create(Credentials credentials){
        return credentialsRepository.save(credentials);
    }
	
    public Credentials update(String id, Credentials credentials){
        Long credsId = Long.parseLong(id);
        Credentials creds = credentialsRepository.findByCredentialsId(credsId);
        if(creds != null) {
        	credentialsRepository.save(credentials);
        }
        return credentials;
    }

}
