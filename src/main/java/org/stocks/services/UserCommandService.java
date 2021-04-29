package org.stocks.services;

import org.stocks.dao.UserCommandDAO;

public class UserCommandService implements IUserCommandService {

	private UserCommandDAO userCommandDAO;

	public UserCommandDAO getUserCommandDAO() {
		return userCommandDAO;
	}

	public void setUserCommandDAO(UserCommandDAO userCommandDAO) {
		this.userCommandDAO = userCommandDAO;
	}
}
