package net.rag.hib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="workstn")
public class Workstation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long workstnId;
	
	String name;
	
	@OneToOne(mappedBy = "workstation")
	private Empl empl;

	public long getWorkstnId() {
		return workstnId;
	}

	public void setWorkstnId(long workstnId) {
		this.workstnId = workstnId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Empl getEmpl() {
		return empl;
	}

	public void setEmpl(Empl empl) {
		this.empl = empl;
	}
	
	
}
