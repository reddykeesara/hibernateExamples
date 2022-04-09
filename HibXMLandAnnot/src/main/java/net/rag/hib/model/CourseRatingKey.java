package net.rag.hib.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CourseRatingKey implements Serializable{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 3888645408819007441L;
	@Column(name="studId")
	long studId;
	@Column(name="courseId")
	long courseId;
	
	public long getStudId() {
		return studId;
	}
	public void setStudId(long studId) {
		this.studId = studId;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public CourseRatingKey() {
	}
	public CourseRatingKey(long studId, long courseId) {
		super();
		this.studId = studId;
		this.courseId = courseId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(courseId, studId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseRatingKey other = (CourseRatingKey) obj;
		return courseId == other.courseId && studId == other.studId;
	}
	
	
}
