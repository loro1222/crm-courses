package com.demo.crm.model.builder;

import com.demo.crm.model.CourseType;
import com.demo.crm.model.enums.CourseFormats;

import java.time.LocalTime;

public class CourseTypeBuilder {

    private Long id;
    private String typeName;
    private Integer durationOfCourse;
    private LocalTime durationOfLesson;
    private Integer lessonsPerWeek;
    private Double pricePerMonth;
    private Boolean isOffline;
    private CourseFormats format;


    public static CourseTypeBuilder builder() {
        return new CourseTypeBuilder();
    }

    public CourseTypeBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public CourseTypeBuilder typeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public CourseTypeBuilder durationOfCourse(Integer durationOfCourse) {
        this.durationOfCourse = durationOfCourse;
        return this;
    }

    public CourseTypeBuilder durationOfLesson(LocalTime durationOfLesson) {
        this.durationOfLesson = durationOfLesson;
        return this;
    }

    public CourseTypeBuilder lessonsPerWeek(Integer lessonsPerWeek) {
        this.lessonsPerWeek = lessonsPerWeek;
        return this;
    }

    public CourseTypeBuilder pricePerMonth(Double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
        return this;
    }

    public CourseTypeBuilder isOffline(Boolean isOffline) {
        this.isOffline = isOffline;
        return this;
    }

    public CourseTypeBuilder format(CourseFormats format) {
        this.format = format;
        return this;
    }

    public CourseType build() {
        return new CourseType(id, typeName, durationOfCourse, durationOfLesson, lessonsPerWeek, pricePerMonth, isOffline, format);
    }



    @Override
    public String toString() {
        return "CourseType{" +
                " id='" + id + '\'' +
                ", typeName=" + typeName +
                ", durationOfCourse=" + durationOfCourse +
                ", durationOfLesson=" + durationOfLesson +
                ", lessonsPerWeek=" + lessonsPerWeek +
                ", pricePerMonth=" + pricePerMonth +
                ", isOffline=" + isOffline +
                ", format=" + format +
                '}';
    }




}
