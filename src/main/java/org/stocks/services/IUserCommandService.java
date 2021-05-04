package org.stocks.services;

import java.util.List;

import org.stocks.entities.UserCommand;
import org.stocks.enums.Status;

public interface IUserCommandService {
	public boolean createCommand(UserCommand command);

	public List<UserCommand> getUserCommands(int iduser);

	public void updateOrder(int idcommand, Status status);
	public List<UserCommand> getApprovedCommandsByProductId(int productId);

}
