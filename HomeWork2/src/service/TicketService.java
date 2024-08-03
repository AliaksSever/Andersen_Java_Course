package service;

import module.Ticket;
import module.Admin;
import module.Client;
import module.TicketSector;

public class TicketService {
	public static void main(String[] args) {
		Ticket emptyTicket = new Ticket();
		Ticket limitedTicket = new Ticket("CarnegHall", 234, 1703483430);
		Ticket fullTicket = new Ticket(
				"CarnegHall",
				846,
				1721643666,
				true,
				TicketSector.C,
				1.5f
				);
		
		emptyTicket.shared(375291234567l);
		limitedTicket.shared("testemail@gmail.com");
		
		Client client = new Client();
		Admin admin = new Admin();
		
		client.printRole();
		admin.printRole();
	}
}
