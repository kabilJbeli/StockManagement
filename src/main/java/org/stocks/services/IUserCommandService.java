package org.stocks.services;

import java.util.List;

import org.stocks.entities.UserCommand;

public interface IUserCommandService {
	public boolean createCommand(UserCommand command);
	public List<UserCommand> getUserCommands(int iduser);

}
