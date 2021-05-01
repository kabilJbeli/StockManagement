package org.stocks.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.stocks.entities.Type;
import org.stocks.utils.HibernateUtils;


public class TypeDAO implements IType {

	@Override
	public boolean setType(Type type) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.persist(type);
			tx.commit();
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
	public List<Type> getAll() {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = null;
		List<Type> types = new ArrayList<Type>();
		try {
			tx = session.beginTransaction();
			 Criteria criteria =session.createCriteria(Type.class);
			types = criteria.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();

		}
		session.close();
		return types;
	}

	@Override
	public boolean updateType(Type type) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		boolean update = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(type);
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
	public boolean removeType(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx=null;
		boolean removed = false;
		try {
			tx = session.beginTransaction();
			Type type = new Type();
			type = getType(id);
			session.remove(type);
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
	public Type getType(String Name) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Type type = new Type();
		try {
			session.getTransaction().begin();
			type = session.find(Type.class, Name);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return type;
	}

	@Override
	public Type getType(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		Type type = new Type();
		try {
			tx = session.beginTransaction();
			type = session.find(Type.class, id);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		return type;
	}

}
