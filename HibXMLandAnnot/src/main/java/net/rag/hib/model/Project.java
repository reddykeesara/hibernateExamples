package net.rag.hib.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="proj")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int projId;
	String projName;
	
	@ManyToMany(mappedBy = "projs")
	Set<Employee> emps = new HashSet();

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public Set<Employee> getEmps() {
		return emps;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}

	public void addEmployee(Employee employee) {
		emps.add(employee);
	}

	
}
