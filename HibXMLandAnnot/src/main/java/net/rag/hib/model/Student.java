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
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long studId;
	String name;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name="stud_course", joinColumns = @JoinColumn(name="studId"), inverseJoinColumns = @JoinColumn(name="courseId"))
//	Set<Course> courses= new HashSet<>();

	// using compositeKey for many to many .. replacing above commented code
	@OneToMany(mappedBy = "student")
	Set<CourseRating> ratings = new HashSet<CourseRating>();

//	public void addCourse(Course course) {
//		courses.add(course);
//	}

	public void addCourseRating(CourseRating courseRating) {
		ratings.add(courseRating);
	}

	public Student() {

	}

	public Student(String name) {
		this.name = name;
	}

	public long getStudId() {
		return studId;
	}

	public void setStudId(long studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CourseRating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<CourseRating> ratings) {
		this.ratings = ratings;
	}

//	public Set<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(Set<Course> courses) {
//		this.courses = courses;
//	}

}
