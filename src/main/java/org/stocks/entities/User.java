package org.stocks.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int iduser;

	private String lastname;

	private String password;

	private String username;

	private int isAdmin=0;
	
	
	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	//bi-directional many-to-one association to UserCommand
	@OneToMany(mappedBy="user")
	private List<UserCommand> userCommands;

	public User() {
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserCommand> getUserCommands() {
		return this.userCommands;
	}

	public void setUserCommands(List<UserCommand> userCommands) {
		this.userCommands = userCommands;
	}

	public UserCommand addUserCommand(UserCommand userCommand) {
		getUserCommands().add(userCommand);
		userCommand.setUser(this);

		return userCommand;
	}

	public UserCommand removeUserCommand(UserCommand userCommand) {
		getUserCommands().remove(userCommand);
		userCommand.setUser(null);

		return userCommand;
	}

}