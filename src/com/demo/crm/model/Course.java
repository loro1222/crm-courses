package com.demo.crm.model;

public class Course extends BaseModel {

    private String courseName;
    private CourseType courseType;

    public Course() {
    }

    public Course(Long id, String courseName, CourseType courseType) {
        super(id);
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "Course{" +
                " id = " + getId() +
                ", courseName = '" + courseName + '\'' +
                ", courseType = " + courseType +
                ", createDate = " + getCreateDate() +
                '}';
    }
}
