/**
 * @author Ryan Juelsgaard - rjuelsgaard
 * CIS175 - Spring 2022
 * Mar 3, 2022
 */
package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Tickets {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	int id;
	@Column(name="FIRSTNAME")
	String firstName;
	@Column(name="LASTNAME")
	String lastName;
	@Column(name="NUMTICKETS")
	int numTickets;
	@Column(name="EMAIL")
	String email;
	
	public Tickets() {
		super();
	}
	
	public Tickets(String firstName, String lastName, String email, int numTickets) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.numTickets = numTickets;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the numTickets
	 */
	public int getNumTickets() {
		return numTickets;
	}

	/**
	 * @param numTickets the numTickets to set
	 */
	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String returnPurchaseInfo() {
		return "Tickets [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", numTickets="
				+ numTickets + ", email=" + email + "]";
	}
	
	
}
