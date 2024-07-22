package Ticket;

public class TicketService {
	public static void main(String[] args) {
		Ticket tOne = new Ticket();
		Ticket tTwo = new Ticket("Carnegie Hall", (short)234, 1721643666);
		Ticket tThree = new Ticket(
				(short) 111,
				"Carnegie Hall",
				(short) 846,
				1721643666,
				true,
				'A',
				1.5f
				);
	}
}
