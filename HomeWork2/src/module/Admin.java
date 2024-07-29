package module;

public class Admin extends user{
	
	@Override
	public void printRole() {
		System.out.println("This is Admin: " + getClass());
	}
	
	public boolean checkTicket(Ticket ticket, int id) {
		return ticket.getID() == id;
	}
}
