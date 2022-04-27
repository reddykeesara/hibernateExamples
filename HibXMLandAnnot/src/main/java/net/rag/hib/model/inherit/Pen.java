package net.rag.hib.model.inherit;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Pen extends Stationery {

	private String color;

	
	public Pen() {
		super();
	}

	public Pen(long productId, String name, String color) {
		super(productId, name);
		this.color = color;
	}

	public Pen(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
