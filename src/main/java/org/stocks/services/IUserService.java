package org.stocks.services;

import java.util.List;

import org.stocks.entities.User;

public interface IUserService {
	public boolean setUser(User user);
	public List<User> getAll();
	public boolean updateUser(User user);
	public boolean removeUser(int id);
	public User getUser(String Name);	
	public User getUser(int id);
	public boolean validate(String login, String password);
	public User getUser(String username, String password);
}
