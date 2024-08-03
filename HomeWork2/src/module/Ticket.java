package module;

import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.time.Instant;
import java.time.LocalDateTime;

public class Ticket extends BaseModel implements Printer{
	
	private static Character[] sectors = {'A', 'B', 'C'};
	
	private String concertHall;
	
	private int eventCode;
	
	private LocalDateTime time;
	
	private boolean isPromo;
	
	private char stadiumSector;
	
	private float maxWeight;
	
	private final LocalDateTime creationTime = LocalDateTime.now();
	
	private float price;
	
	
	public Ticket() {};
	
	public Ticket(String concertHall, int eventCode, long time) {
		createLimitedTicket(concertHall, eventCode, time);
	};
	
	public Ticket(
			String concertHall,
			int eventCode,
			long time,
			boolean isPromo,
			char stadiumSector,
			float maxWeight
			) {
		createLimitedTicket(concertHall, eventCode, time);
		this.isPromo = isPromo;
		setStadiumSector(stadiumSector);
		this.maxWeight = maxWeight;
	};
	
	
	public String getConcertHall() {
		return concertHall;
	}
	private void setConcertHall(String concertHall) {
		if (concertHall.length() <= 10) {
			this.concertHall = concertHall;
		}
	}
	
	public int getEventCode() {
		return eventCode;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(long unixTimeStamp) {
		this.time = LocalDateTime.ofInstant(
				Instant.ofEpochSecond(unixTimeStamp),
				TimeZone.getDefault().toZoneId()
				);
	}
	
	public boolean getIsPromo() {
		return isPromo;
	}
	
	public char getStadiumSector() {
		return stadiumSector;
	}
	public void setStadiumSector(char stadiumSector) {
		List<Character> secotrsList = Arrays.asList(sectors);
		if (secotrsList.contains(stadiumSector)) {
			this.stadiumSector = stadiumSector;
		}
	}
	
	public float getMaxWeight() {
		return maxWeight;
	}
	
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	
	public float getPrice() {
		return price;
	}
	public void savePrice(float price) {
		this.price = price;
	}

	private boolean digitsChekc(int value, int number) {
		return String.valueOf(value).length() <= number;
	}
	
	private void createLimitedTicket(String concertHall, int eventCode, long time) {
		setID();
		setConcertHall(concertHall);
		if (digitsChekc(eventCode, 3)) {
			this.eventCode = eventCode;
		}
		this.time = LocalDateTime.ofInstant(
				Instant.ofEpochSecond(time),
				TimeZone.getDefault().toZoneId()
				);
	}
	
	public void shared(long phoneNumber) {
		System.out.println("Ticket shared by phone: "+phoneNumber);
	}
	
	public void shared(String email) {
		System.out.println("Ticket shared by email: "+email);
	}
	
	@Override
	public String toString() {
		String result = "Ticket with id " + getID();
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Ticket that = (Ticket) o;

		if (this.eventCode != that.eventCode) return false;
		if (!this.time.isEqual(that.time)) return false;
		if (this.stadiumSector != that.stadiumSector) return false;
		
		return this.concertHall.equals(that.concertHall);
	}
	
	@Override
	public int hashCode() {
		int result = concertHall == null? 0 : concertHall.hashCode();
		result+=eventCode;
		result+=stadiumSector;
		return result;
	}
}