package net.rag.hib.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="course_rating")
public class CourseRating {

	@EmbeddedId
	CourseRatingKey crId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@MapsId("studId")
	@JoinColumn(name="studId")
	Student student;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@MapsId("courseId")
	@JoinColumn(name="courseId")
	Course course;
	
	int rating;
	
	public  CourseRating() {
		
	}
	public  CourseRating(Student student, Course course) {
		this.student = student;
		this.course = course;
	}
	public CourseRatingKey getCrId() {
		return crId;
	}
	public void setCrId(CourseRatingKey crId) {
		this.crId = crId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
