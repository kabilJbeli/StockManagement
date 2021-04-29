package org.stocks.services;

import java.util.List;

import org.stocks.dao.ProductDAO;
import org.stocks.entities.Product;

public class ProductService implements IProductService {
	private ProductDAO productDAO;

	public boolean setProduct(Product product) {
		return productDAO.setProduct(product);

	};

	public List<Product> getAll() {
		return productDAO.getAll();
	};

	public boolean updateProduct(Product product) {
		return productDAO.updateProduct(product);

	};

	public boolean removeProduct(int id) {
		return productDAO.removeProduct(id);

	};

	public Product getProduct(String Name) {
		return productDAO.getProduct(Name);

	};

	public Product getProduct(int id) {
		return productDAO.getProduct(id);

	};

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

}
