package net.rag.hib.model.inherit;

import javax.persistence.Entity;

@Entity
public class Bus extends Vehicle {

	private int noOfSeats;

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(long vehicleId, String manufacturer, int noOfSeats) {
		super(vehicleId, manufacturer);
		this.noOfSeats = noOfSeats;
	}

	public Bus(int noOfSeats) {
		super();
		this.noOfSeats = noOfSeats;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

}
