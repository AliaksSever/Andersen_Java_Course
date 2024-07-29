package module;

public class Client extends user{
	
	private Ticket ticket;
	
	@Override
	public void printRole() {
		System.out.println("This is User: " + getClass());
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	
}
