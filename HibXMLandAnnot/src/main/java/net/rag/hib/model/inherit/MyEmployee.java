package net.rag.hib.model.inherit;

import javax.persistence.Entity;

@Entity
public class MyEmployee extends Person{

	private String company;

	public MyEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MyEmployee(long personId, String name, String company) {
		super(personId, name);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
