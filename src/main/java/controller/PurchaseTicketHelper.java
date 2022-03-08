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
import javax.persistence.TypedQuery;

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
	
	public List<Tickets> showAllTickets() {
		EntityManager em = emfactory.createEntityManager();
		List<Tickets> tickets = em.createQuery("SELECT i FROM Tickets i").getResultList();
		return tickets;
	}
	
	public void deleteGame(Tickets deleted) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Tickets> typedQuery = em.createQuery("select ticket from Tickets ticket where ticket.firstName = :selectedFirstName and ticket.lastName = :selectedLastName and ticket.email = :selectedEmail and ticket.numTickets = :selectedNumTickets", Tickets.class);
		typedQuery.setParameter("selectedFirstName", deleted.getFirstName());
		typedQuery.setParameter("selectedLastName", deleted.getLastName());
		typedQuery.setParameter("selectedEmail", deleted.getEmail());
		typedQuery.setParameter("selectedNumTickets", deleted.getNumTickets());
		typedQuery.setMaxResults(1);
		try {
		Tickets result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println("That was not found in the database, please try again.\n");
		}
		em.close();
	}
	
	public Tickets searchForTicketsById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Tickets found = em.find(Tickets.class, idToEdit);
		em.close();
		return found;
	}
	public void updateItem(Tickets toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Tickets> searchForTicketByEmail(String email) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Tickets> typedQuery	= em.createQuery("select ticket from Tickets ticket where ticket.email = :selectedEmail", Tickets.class);
		typedQuery.setParameter("selectedEmail", email);
		List<Tickets> foundGames = typedQuery.getResultList();
		em.close();
		return foundGames;
	}
	
	public List<Tickets> searchForGameByName(String firstName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Tickets> typedQuery	= em.createQuery("select ticket from Tickets ticket where ticket.firstName = :selectedfirstName", Tickets.class);
		typedQuery.setParameter("selectedGameName", firstName);
		List<Tickets> foundTickets = typedQuery.getResultList();
		em.close();
		return foundTickets;
		
	}
	public void cleanUp() {
		emfactory.close();
	}
}
