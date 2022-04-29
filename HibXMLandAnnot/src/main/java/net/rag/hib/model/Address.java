package net.rag.hib.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address2")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int addId;
	@Column(name = "city")
	String city;
	@Column(name = "zip")
	int zipCode;
	
	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name="addId")
	private Set<Order> orders = new HashSet();
	
	public void addOrders(Order order) {
		orders.add(order);
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
