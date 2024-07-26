package service;

import module.Ticket;

public class TicketService {
	public static void main(String[] args) {
		Ticket[] ticketStorage;
		
		Ticket tOne = new Ticket();
		Ticket tTwo = new Ticket("CarnegHall", (short)234, 1721643666);
		Ticket tThree = new Ticket(
				(short) 111,
				"CarnegHall",
				(short) 846,
				1721643666,
				true,
				'C',
				1.5f
				);
		Ticket t4 = new Ticket();
		Ticket t5 = new Ticket("MDHall", (short)544, 1721643666);
		Ticket t6 = new Ticket();
		Ticket t7 = new Ticket();
		Ticket t8 = new Ticket();
		Ticket t9 = new Ticket("GreenHall", (short)956, 1721643666);
		Ticket t10 = new Ticket();
		
		ticketStorage = new Ticket[] {
				tOne,tTwo,tThree,t4,t5,t6,t7,t8,t9,t10
		};
		
	}
}
