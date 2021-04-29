package org.stocks.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.stocks.entities.Product;
import org.stocks.services.ProductService;


@SessionScoped
public class ProductBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService service;

	public ProductService getService() {
		return service;
	}

	public void setService(ProductService service) {
		this.service = service;
	}
	
	  public List<Product> getProducts() {
	        return service.getAll();
	    }
	    
}
