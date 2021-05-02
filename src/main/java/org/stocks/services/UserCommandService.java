package org.stocks.services;

import java.util.List;

import org.stocks.dao.UserCommandDAO;
import org.stocks.entities.UserCommand;
import org.stocks.enums.Status;

public class UserCommandService implements IUserCommandService {

	private UserCommandDAO userCommandDAO;

	public UserCommandDAO getUserCommandDAO() {
		return userCommandDAO;
	}

	public void setUserCommandDAO(UserCommandDAO userCommandDAO) {
		this.userCommandDAO = userCommandDAO;
	}

	@Override
	public boolean createCommand(UserCommand command) {
		// TODO Auto-generated method stub
		return userCommandDAO.setCommand(command);
	}

	
	@Override
	public List<UserCommand> getUserCommands(int iduser) {
		// TODO Auto-generated method stub
		return userCommandDAO.getUserCommands(iduser);
	}

	@Override
	public void updateOrder(int idcommand, Status status) {
		// TODO Auto-generated method stub
		userCommandDAO.updateOrder(idcommand,status);
	}
}
