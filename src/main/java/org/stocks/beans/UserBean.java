package org.stocks.beans;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import org.stocks.entities.User;
import org.stocks.services.UserService;

@SessionScoped
public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService service;
	private UserCommandBean userCommandBean = new UserCommandBean();
	private String password;
	private String lastname;
	private String username;
	private boolean isAdmin;
	private String msg;
	private String msgCreation;

	public String getMsgCreation() {
		return msgCreation;
	}

	public void setMsgCreation(String msgCreation) {
		this.msgCreation = msgCreation;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public boolean createUser() {
		User user = new User();
		user.setLastname(lastname);
		user.setPassword(password);
		user.setUsername(username);
		if(isAdmin) {
			user.setIsAdmin(1);
		}
		lastname=null;
		password=null;
		username=null;
		msgCreation="User Created With Success";
		return service.setUser(user);
	}
	
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

	
	public String validateUsernamePassword() {
		boolean valid = service.validate(username, password);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", username);
			User user = service.getUser(username,password);
			userCommandBean.setUserId(user.getIduser());
			if(user.getIsAdmin() == 1) {
			return "admin";
			}
			else {
				return "regular";
			}
		} else {
			msg = "Incorrect Username and Passowrd";
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
			//		"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "login";
		}
	}
	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
}
