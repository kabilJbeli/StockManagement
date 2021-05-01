package org.stocks.beans;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

import org.stocks.entities.User;
import org.stocks.services.UserService;

@SessionScoped
public class UserBean implements Serializable {
	private UserService service;

	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	private String password;
	private String lastname;

	public boolean createUser() {
		User user = new User();
		user.setLastname(lastname);
		user.setPassword(password);
		user.setUsername(username);
		lastname=null;
		password=null;
		username=null;
		return service.setUser(user);
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
}
