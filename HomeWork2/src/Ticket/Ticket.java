package Ticket;

import java.util.Date;

public class Ticket {
	
	public short id;
	
	protected String concertHall;
	
	protected short eventCode;
	
	protected long time;
	
	protected boolean isPromo;
	
	protected char stadiumSector;
	
	protected float maxWeight;
	
	private Date creationTime;
	
	public Ticket() {
		creationTime = getCreationTime();
	};
	
	public Ticket(String concertHall, short eventCode, long time) {
		this.concertHall = concertHall;
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
		this.concertHall = concertHall;
		this.eventCode = eventCode;
		this.time = time;
		this.isPromo = isPromo;
		this.stadiumSector = stadiumSector;
		this.maxWeight = maxWeight;
		creationTime = getCreationTime();
	};
	
	private Date getCreationTime() {
		return new Date();
	}
	
}