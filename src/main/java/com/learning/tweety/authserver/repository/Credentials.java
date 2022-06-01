package com.learning.tweety.authserver.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credentials")
public class Credentials {
	@Column(name = "credentials_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long credentialsId;
	@Column(name = "servername")
	private String serverName;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String passWord;
	@Column(name = "serverurl")
	private String serverUrl;
	
	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	protected Credentials() {
		
	}
	
	public Long getCredentialsId() {
		return credentialsId;
	}
	public void setCredentialsId(Long credentialsId) {
		this.credentialsId = credentialsId;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
