package org.stocks.services;

import java.util.List;

import org.stocks.dao.UserDAO;
import org.stocks.entities.User;

public class UserService implements IUserService {
private UserDAO userDAO;

public UserDAO getUserDAO() {
	return userDAO;
}

public void setUserDAO(UserDAO userDAO) {
	this.userDAO = userDAO;
}

@Override
public boolean setUser(User user) {
	// TODO Auto-generated method stub
	return userDAO.setUser(user);
}

@Override
public List<User> getAll() {
	// TODO Auto-generated method stub
	return userDAO.getAll();
}

@Override
public boolean updateUser(User user) {
	// TODO Auto-generated method stub
	return userDAO.updateUser(user);
}

@Override
public boolean removeUser(int id) {
	// TODO Auto-generated method stub
	return userDAO.removeUser(id);
}

@Override
public User getUser(String Name) {
	// TODO Auto-generated method stub
	return userDAO.getUser(Name);
}

@Override
public User getUser(int id) {
	// TODO Auto-generated method stub
	return userDAO.getUser(id);
}
}
