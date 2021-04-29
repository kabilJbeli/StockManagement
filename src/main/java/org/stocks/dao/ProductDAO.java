package org.stocks.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.stocks.entities.Product;
import org.stocks.utils.HibernateUtils;


public class ProductDAO implements IProduct {

	@Override
	public boolean setProduct(Product product) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.persist(product);
			tx.commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			session.close();
			return false;
		}
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List<Product> products = new ArrayList<Product>();
		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Product.class);
			products = criteria.list();

			System.out.println("products" + products.toString());
			tx.commit();

			products.forEach((product) -> System.out.println(product.getProductname()));
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();

		}
		session.close();
		return products;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		boolean update = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(product);
			tx.commit();
			update = true;

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		return update;
	}

	@Override
	public boolean removeProduct(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		boolean removed = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Product product = new Product();
			product = getProduct(id);
			session.remove(product);
			tx.commit();
			removed = true;

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		return removed;
	}

	@Override
	public Product getProduct(String Name) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Product product = new Product();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			product = session.find(Product.class, Name);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		return product;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Product product = new Product();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			product = session.find(Product.class, id);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		return product;
	}

}
