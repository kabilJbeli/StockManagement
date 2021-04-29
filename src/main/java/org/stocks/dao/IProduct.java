package org.stocks.dao;

import java.util.List;

import org.stocks.entities.Product;


public interface IProduct {
	public boolean setProduct(Product product);
	public List<Product> getAll();
	public boolean updateProduct(Product product);
	public boolean removeProduct(int id);
	public Product getProduct(String Name);	
	public Product getProduct(int id);
}
