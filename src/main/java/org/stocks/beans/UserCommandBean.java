package org.stocks.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import org.stocks.entities.Product;
import org.stocks.entities.User;
import org.stocks.entities.UserCommand;
import org.stocks.services.UserCommandService;

@SessionScoped
public class UserCommandBean implements Serializable {
	private UserCommandService service;
	private int productType;
	private int quantity;
	public static int userId;

	public int getUserId() {
		HttpSession session = SessionUtils.getSession();

		return (int) session.getAttribute("userId");
	}

	public void setUserId(int userId) {
		this.userId = userId;
		HttpSession session = SessionUtils.getSession();
		session.setAttribute("userId", userId);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int producttype) {
		this.productType = producttype;
	}

	public UserCommandService getService() {
		return service;
	}

	public void setService(UserCommandService service) {
		this.service = service;
	}

	public boolean createCommand() {
		UserCommand command = new UserCommand();
		Product product = new Product();
		User user = new User();
		product.setIdproduct(productType);
		command.setProduct(product);
		command.setQuantity(quantity);
		user.setIduser(userId);
		command.setUser(user);

		return service.createCommand(command);
	}
	
	public List<UserCommand> getCommandsByUserId() {
		HttpSession session = SessionUtils.getSession();

		return service.getUserCommands((int) session.getAttribute("userId"));	
		}
}
