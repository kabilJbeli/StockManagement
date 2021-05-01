package org.stocks.dao;

import java.util.ArrayList;
import java.util.List;

import org.stocks.entities.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.stocks.entities.Type;
import org.stocks.utils.HibernateUtils;

public class UserDAO implements IUser {

	@Override
	public boolean setUser(User user) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		try {
			session.getTransaction().begin();
			session.persist(user);
			session.getTransaction().commit();
			session.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
			return false;
		}
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = null;
		List<User> user = new ArrayList<User>();
		try {
			tx = session.beginTransaction();
			 Criteria criteria =session.createCriteria(User.class);
			 user = criteria.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();

		}
		session.close();
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		boolean update = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
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
	public boolean removeUser(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx=null;
		boolean removed = false;
		try {
			tx = session.beginTransaction();
			User user = new User();
			user = getUser(id);
			session.remove(user);
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
	public User getUser(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		User user = new User();
		try {
			tx = session.beginTransaction();
			user = session.find(User.class, id);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		return user;
	}
	
	@Override
	public boolean validate(String login, String password) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			String sql = "Select u from User u Where u.username = :login and u.password = :password";
			Query<User> query = session.createQuery(sql);
			query.setParameter("login", login);
			query.setParameter("password", password);
			tx.commit();
			if (query.getSingleResult() != null) {
				session.close();

				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
			return false;
		}
		session.close();
		return false;
	}

	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		User user=null;
		try {
			tx = session.beginTransaction();
			String sql = "Select u from User u Where u.username = :login and u.password = :password";
			Query<User> query = session.createQuery(sql);
			query.setParameter("login", username);
			query.setParameter("password", password);
			tx.commit();
			user = query.getSingleResult();			
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		session.close();
		return user;
	}
}
