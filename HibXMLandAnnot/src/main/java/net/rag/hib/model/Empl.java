package net.rag.hib.model;

import java.sql.Date;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "empl")
public class Empl {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int empId;
	String name;
//	String lastName;
	//@Temporal(TemporalType.DATE)
	LocalDateTime createdDate = LocalDateTime.now();
	//@Temporal(TemporalType.TIME)
	LocalDateTime updatedDate = LocalDateTime.now(Clock.systemUTC());

	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="detId", referencedColumnName = "emplDtlId")
	EmplDetl emplDetl;

	public EmplDetl getEmplDetl() {
		return emplDetl;
	}

	public void setEmplDetl(EmplDetl emplDetl) {
		this.emplDetl = emplDetl;
	}
	

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "empl_workstn", joinColumns = {
//			@JoinColumn(name = "empId", referencedColumnName = "empId") }, inverseJoinColumns = {
//					@JoinColumn(name = "workstnId", referencedColumnName = "workstnId") })
//	Workstation workstation;
//	public Workstation getWorkstation() {
//		return workstation;
//	}
//
//	public void setWorkstation(Workstation workstation) {
//		this.workstation = workstation;
//	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	// public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//	public Date getUpdatedDate() {
//		return updatedDate;
//	}
//	public void setUpdatedDate(Date updatedDate) {
//		this.updatedDate = updatedDate;
//	}

//	public Set<Project> getProjs() {
//		return projs;
//	}
//
//	public void setProjs(Set<Project> projs) {
//		this.projs = projs;
//	}
//
//	public void addProject(Project project) {
//		projs.add(project);
//	}
	
}
