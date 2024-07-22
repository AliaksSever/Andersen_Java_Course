package Ticket;

public class TicketService {
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
	}
}
