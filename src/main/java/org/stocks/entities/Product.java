package org.stocks.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idproduct;

	private String price;

	private String productname;

	private String quantity;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="idtype")
	private Type type;

	//bi-directional many-to-one association to UserCommand
	@OneToMany(mappedBy="product")
	private List<UserCommand> userCommands;

	public Product() {
	}

	public int getIdproduct() {
		return this.idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<UserCommand> getUserCommands() {
		return this.userCommands;
	}

	public void setUserCommands(List<UserCommand> userCommands) {
		this.userCommands = userCommands;
	}

	public UserCommand addUserCommand(UserCommand userCommand) {
		getUserCommands().add(userCommand);
		userCommand.setProduct(this);

		return userCommand;
	}

	public UserCommand removeUserCommand(UserCommand userCommand) {
		getUserCommands().remove(userCommand);
		userCommand.setProduct(null);

		return userCommand;
	}

}