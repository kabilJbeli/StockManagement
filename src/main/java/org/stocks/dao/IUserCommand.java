package org.stocks.dao;

import java.util.List;

import org.stocks.entities.UserCommand;

public interface IUserCommand {
public boolean setCommand(UserCommand command);
public List<UserCommand> getUserCommands(int iduser);
}
