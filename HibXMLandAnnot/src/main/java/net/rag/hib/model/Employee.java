package net.rag.hib.model;

import java.sql.Date;
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


@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int empId;
	String name;
//	String lastName;
//	Date createdDate;
//	Date updatedDate;

//	 @OneToOne(cascade = CascadeType.ALL)
//	 @PrimaryKeyJoinColumn
//	EmployeeDetail employeeDetail;

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name = "empl_proj", joinColumns = { @JoinColumn(name = "empId") }, inverseJoinColumns = {
//			@JoinColumn(name = "projId") })
//	Set<Project> projs = new HashSet<Project>();

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
//	public EmployeeDetail getEmployeeDetail() {
//		return employeeDetail;
//	}
//	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
//		this.employeeDetail = employeeDetail;
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
