package net.rag.hib.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order2")
public class Order {

	@Id()
	@GeneratedValue
	@Column(name="orderId")
	int orderId;
	
	@Column(name="name")
	String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	
	//@JoinColumn(name="addId")
	Address address;
	


	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
