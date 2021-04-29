package org.stocks.beans;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

import org.stocks.services.TypeService;

@SessionScoped
public class TypeBean  implements Serializable{
private TypeService service;

public TypeService getService() {
	return service;
}

public void setService(TypeService service) {
	this.service = service;
}
}
