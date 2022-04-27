package net.rag.hib.model.inherit;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {
	
	private int noOfSeats;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(long vehicleId, String manufacturer, int noOfSeats) {
		super(vehicleId, manufacturer);
		this.noOfSeats = noOfSeats;	}

	public Car(int noOfSeats) {
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
