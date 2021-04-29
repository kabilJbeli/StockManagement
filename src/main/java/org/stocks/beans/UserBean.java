package org.stocks.beans;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

import org.stocks.services.UserService;

@SessionScoped
public class UserBean  implements Serializable {
private UserService service;

public UserService getService() {
	return service;
}

public void setService(UserService service) {
	this.service = service;
}
}
