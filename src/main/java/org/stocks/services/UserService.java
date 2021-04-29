package org.stocks.services;

import org.stocks.dao.UserDAO;

public class UserService implements IUserService {
private UserDAO userDAO;

public UserDAO getUserDAO() {
	return userDAO;
}

public void setUserDAO(UserDAO userDAO) {
	this.userDAO = userDAO;
}
}
