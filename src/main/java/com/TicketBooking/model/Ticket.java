package com.TicketBooking.model;
import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;

		@Column(name = "fromlocation")
	    private String fromlocation;
	
	@Column(name = "toLocation")
	    private String toLocation;

	@Column(name = "fare")
	    private String fare;

	public Ticket() {
		super();
		}

	public Ticket(Long id, String fromlocation, String toLocation, String fare) {
		super();
		this.id = id;
		this.fromlocation = fromlocation;
		this.toLocation = toLocation;
		this.fare = fare;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromlocation() {
		return fromlocation;
	}

	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}
	

}
