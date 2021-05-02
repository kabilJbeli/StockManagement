package org.stocks.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.stocks.enums.Status;


/**
 * The persistent class for the user_command database table.
 * 
 */
@Entity
@Table(name="user_command")
@NamedQuery(name="UserCommand.findAll", query="SELECT u FROM UserCommand u")
public class UserCommand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcommand;

	private int quantity;

	@Enumerated(EnumType.ORDINAL)
    private Status status =Status.PENDING;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="idproduct")
	private Product product;

	public UserCommand() {
	}

	public int getIdcommand() {
		return this.idcommand;
	}

	public void setIdcommand(int idcommand) {
		this.idcommand = idcommand;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}