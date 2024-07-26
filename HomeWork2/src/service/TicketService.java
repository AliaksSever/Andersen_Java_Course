package service;

import module.Ticket;

public class TicketService {
	
	private static Ticket[] ticketStorage;
	
	public static void main(String[] args) {
		
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
		Ticket t5 = new Ticket(
				(short) 112,
				"MDHall", (short)544, 
				1721643666,
				false,
				'A',
				2f
				);
		Ticket t6 = new Ticket();
		Ticket t7 = new Ticket();
		Ticket t8 = new Ticket();
		Ticket t9 = new Ticket("GreenHall", (short)956, 1721643666);
		Ticket t10 = new Ticket();
		
		ticketStorage = new Ticket[] {
				tOne,tTwo,tThree,t4,t5,t6,t7,t8,t9,t10
		};
		
	}
	
	private static Ticket getTicketById (short id) {
		for (int i=0; i<ticketStorage.length; i++) {
			if (ticketStorage[i].id == id) {
				return ticketStorage[i];
			}
		}
		return new Ticket();
	}
}
