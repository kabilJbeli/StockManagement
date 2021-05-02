package org.stocks.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.stocks.entities.User;
import org.stocks.entities.UserCommand;
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

}
