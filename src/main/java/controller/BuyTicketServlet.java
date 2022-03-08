package main.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.model.Tickets;


/**
 * Servlet implementation class BuyTicketServlet
 */
@WebServlet("/buyTicketServlet")
public class BuyTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String email = request.getParameter("email");
		Integer numTickets = Integer.parseInt(request.getParameter("tickets"));
		Tickets ticket = new Tickets(fName, lName, email, numTickets);
		PurchaseTicketHelper pth = new PurchaseTicketHelper();
		pth.insertTickets(ticket);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
