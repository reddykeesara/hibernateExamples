package net.rag.hib.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long courseId;
	String courseName;
	
	public Course() {
		
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

//	@ManyToMany( cascade = CascadeType.ALL)
//	@JoinTable(name="stud_course", joinColumns = @JoinColumn(name="courseId"), inverseJoinColumns = @JoinColumn(name="studId"))
//	Set<Student> students = new HashSet<>();

	@OneToMany(mappedBy = "course")
	Set<CourseRating> ratings = new HashSet<CourseRating>();

	public void addRating(CourseRating rating) {
		ratings.add(rating);
	}

//	public void addStudent(Student student) {
//		students.add(student);
//	}

	public Set<CourseRating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<CourseRating> ratings) {
		this.ratings = ratings;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

//	public long getCourseId() {
//		return courseId;
//	}
//
//	public void setCourseId(long courseId) {
//		this.courseId = courseId;
//	}
//
//	public String getCourseName() {
//		return courseName;
//	}
//
//	public void setCourseName(String courseName) {
//		this.courseName = courseName;
//	}

//	public Set<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(Set<Student> students) {
//		this.students = students;
//	}

}
