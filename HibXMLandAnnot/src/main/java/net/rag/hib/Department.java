package net.rag.hib;

import java.util.Set;

public class Department {


	int deptId;
	String deptName;
	//Set<Student> students;
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
//	public Set<Student> getStudents() {
//		return students;
//	}
//	public void setStudents(Set<Student> students) {
//		this.students = students;
//	}	
}
