package org.stocks.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.stocks.entities.Product;
import org.stocks.entities.Type;
import org.stocks.entities.User;
import org.stocks.entities.UserCommand;
import org.stocks.enums.Status;
import org.stocks.utils.HibernateUtils;

public class UserCommandDAO implements IUserCommand {

	@Override
	public boolean setCommand(UserCommand command) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(command);
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
	public List<UserCommand> getUserCommands(int iduser) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List<UserCommand> commands = null;
		try {
			tx = session.beginTransaction();
			String sql = "Select u from UserCommand u Where u.user= :user";
			User user = new User();
			user.setIduser(iduser);
			Query<UserCommand> query = session.createQuery(sql);
			query.setParameter("user", user);

			tx.commit();
			commands = query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		session.close();
		return commands;
	}

	@Override
	public void updateOrder(int idcommand, Status status) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		boolean update = false;
		Transaction tx = null;
		UserCommand command = null;
		try {
			tx = session.beginTransaction();
			command = getOrder(idcommand);
			command.setStatus(status);
			session.update(command);
			tx.commit();
			update = true;

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
					}
		session.close();
	}

	@Override
	public UserCommand getOrder(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		UserCommand command = new UserCommand();
		try {
			tx = session.beginTransaction();
			command = session.find(UserCommand.class, id);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		return command;
	}

	@Override
	public List<UserCommand> getApprovedCommandsByProductId(int productId) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		List<UserCommand> commands = null;
		try {
			tx = session.beginTransaction();
			String sql = "Select u from UserCommand u Where u.product= :product and u.status = :status";
			Product product = new Product();
			product.setIdproduct(productId);
			Query<UserCommand> query = session.createQuery(sql);
			query.setParameter("product", product);
			query.setParameter("status", Status.APPROVED);

			tx.commit();
			commands = query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		session.close();
		return commands;
	}

}
