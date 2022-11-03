package com.demo.crm.model.builder;

import com.demo.crm.model.Course;
import com.demo.crm.model.CourseType;

public class CourseBuilder {
	private Long id;
	private String courseName;
	private CourseType courseType;

	public static CourseBuilder builder() {
		return new CourseBuilder();
	}

	public CourseBuilder id(Long id) {
		this.id = id;
		return this;
	}

	public CourseBuilder courseName(String courseName) {
		this.courseName = courseName;
		return this;
	}

	public CourseBuilder courseType(CourseType courseType) {
		this.courseType = courseType;
		return this;
	}

	public Course build() {
		return new Course(id, courseName, courseType);
	}

	@Override
	public String toString() {
		return "CourseBuilder{" +
				"id=" + id +
				", courseName='" + courseName + '\'' +
				", courseType=" + courseType +
				'}';
	}
}

