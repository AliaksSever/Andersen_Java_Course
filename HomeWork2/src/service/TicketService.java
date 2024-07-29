package service;

import module.Ticket;

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
	}
}
