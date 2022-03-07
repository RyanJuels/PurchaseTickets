/**
 * @author Ryan Juelsgaard - rjuelsgaard
 * CIS175 - Spring 2022
 * Mar 7, 2022
 */
package main.java.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.model.Tickets;

public class PurchaseTicketHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PurchaseTickets");
	
	public void insertTickets(Tickets ticket) {	
		EntityManager em	 = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ticket);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Tickets> showAllGames() {
		EntityManager em = emfactory.createEntityManager();
		List<Tickets> tickets = em.createQuery("SELECT i FROM Tickets i").getResultList();
		return tickets;
	}
}
