package org.stocks.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.stocks.entities.Product;
import org.stocks.entities.Type;
import org.stocks.services.TypeService;

@SessionScoped
public class TypeBean implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private TypeService service;
	private String typename;
	private Type updateType;

	public Type getUpdateType() {
		return updateType;
	}

	public void setUpdateType(Type updateType) {
		this.updateType = updateType;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public TypeService getService() {
		return service;
	}

	public void setService(TypeService service) {
		this.service = service;
	}

	public List<Type> getTypes() {
		return service.getAll();
	}

	public boolean createType() {
		Type type = new Type();
		type.setTypename(typename);
		return service.setType(type);
	}

	public boolean removeType(int idtype) {
		return service.removeType(idtype);
	}
	
	public String updateSelectedType() {
		service.updateType(updateType);
		return "/types.xhtml?faces-redirect=true";

	}


	public String edit(int id) {
		try {
			updateType = service.getType(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "/editType.xhtml?faces-redirect=true";
	}

}
