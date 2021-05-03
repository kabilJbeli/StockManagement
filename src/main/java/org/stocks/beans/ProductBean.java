package org.stocks.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.stocks.entities.Product;
import org.stocks.entities.Type;
import org.stocks.services.ProductService;

@SessionScoped
public class ProductBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService service;

	int productType;
	int selectedUser;
	Product updateProduct = null;

	public Product getUpdateProduct() {
		return updateProduct;
	}

	public void setUpdateProduct(Product updateProduct) {
		this.updateProduct = updateProduct;
	}

	public int getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(int selectedUser) {
		this.selectedUser = selectedUser;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
		Product product = null;
		product = service.getProduct(productType);
		if (product != null) {
			productname = product.getProductname();
			quantity = Integer.parseInt(product.getQuantity());
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
		price = 0;
		quantity = 0;
		productname = null;
		return service.setProduct(product);
	}

	public String updateSelectedProduct() {
		System.out.println("dfkllj");
		Type type = new Type();
		type.setIdtype(productType);
		updateProduct.setType(type);
		service.updateProduct(updateProduct);
		return "/index.xhtml?faces-redirect=true";

	}

	public String edit(int id) {
		try {
			updateProduct = service.getProduct(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "/edit.xhtml?faces-redirect=true";
	}

}
