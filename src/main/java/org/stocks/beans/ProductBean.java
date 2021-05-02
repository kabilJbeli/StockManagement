package org.stocks.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;

import org.stocks.entities.Product;
import org.stocks.entities.Type;
import org.stocks.services.ProductService;


@SessionScoped
public class ProductBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService service;

	int productType;
	
	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
		Product product = null;
		product = service.getProduct(productType);
		if(product != null) {
			productname = product.getProductname();
			quantity =Integer.parseInt(product.getQuantity());
			price = Integer.parseInt(product.getPrice());
			
		}
	}

	String productname;
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	int quantity;
	int price;
	public ProductService getService() {
		return service;
	}

	public void setService(ProductService service) {
		this.service = service;
	}
	
	  public List<Product> getProducts() {
	        return service.getAll();
	    }
	  
	  public boolean removeProduct(int id) {
		  return service.removeProduct(id);
	  }
	  
	  public boolean createProduct() {
		  Product product = new Product();
		  Type type = new Type();
		  type.setIdtype(productType);
		  product.setPrice(String.valueOf(price));
		  product.setQuantity(String.valueOf(quantity));
		  product.setProductname(productname);		  
		  product.setType(type);
		  price=0;
		  quantity=0;
		  productname=null;		  
		  return service.setProduct(product);
	  }
	    
}
