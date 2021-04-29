package org.stocks.beans;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

import org.stocks.services.UserCommandService;

@SessionScoped
public class UserCommandBean  implements Serializable{
private UserCommandService service;

public UserCommandService getService() {
	return service;
}

public void setService(UserCommandService service) {
	this.service = service;
}
}
