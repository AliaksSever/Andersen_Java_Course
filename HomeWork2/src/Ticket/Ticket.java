package Ticket;

import java.util.Date;
import java.util.Arrays;
import java.util.List;

public class Ticket {
	
	private static Character[] sectors = {'A', 'B', 'C'};
	
	public short id;
	
	private String concertHall;
	
	protected short eventCode;
	
	protected long time;
	
	protected boolean isPromo;
	
	private char stadiumSector;
	
	protected float maxWeight;
	
	private Date creationTime;
	
	private float price;
	
	public Ticket() {
		creationTime = getCreationTime();
	};
	
	public Ticket(String concertHall, short eventCode, long time) {
		setConcertHall(concertHall);
		this.eventCode = eventCode;
		this.time = time;
		creationTime = getCreationTime();
	};
	
	public Ticket(
			short id,
			String concertHall,
			short eventCode,
			long time,
			boolean isPromo,
			char stadiumSector,
			float maxWeight
			) {
		this.id = id;
		setConcertHall(concertHall);
		this.eventCode = eventCode;
		this.time = time;
		this.isPromo = isPromo;
		setStadiumSector(stadiumSector);
		this.maxWeight = maxWeight;
		creationTime = getCreationTime();
	};
	
	private Date getCreationTime() {
		return new Date();
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getConcertHall() {
		return concertHall;
	}
	public void setConcertHall(String concertHall) {
		if (concertHall.length() <= 10) {
			this.concertHall = concertHall;
		}
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
	
}