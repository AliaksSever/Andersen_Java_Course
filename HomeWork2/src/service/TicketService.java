package service;

import module.Ticket;
import module.Admin;
import module.Client;

public class TicketService {
	public static void main(String[] args) {
		Ticket tOne = new Ticket();
		Ticket tTwo = new Ticket("CarnegHall", 234, 1703483430);
		Ticket tThree = new Ticket(
				"CarnegHall",
				846,
				1721643666,
				true,
				'C',
				1.5f
				);
		
		tOne.shared(375291234567l);
		tTwo.shared("testemail@gmail.com");
		
		Client client = new Client();
		Admin admin = new Admin();
		
		client.printRole();
		admin.printRole();
	}
}
