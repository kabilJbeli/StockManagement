package org.stocks.dao;

import java.util.List;

import org.stocks.entities.UserCommand;
import org.stocks.enums.Status;

public interface IUserCommand {
public boolean setCommand(UserCommand command);
public List<UserCommand> getUserCommands(int iduser);
public void updateOrder(int idcommand, Status status);
public UserCommand getOrder(int id);
}
