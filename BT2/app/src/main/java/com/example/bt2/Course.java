package com.example.bt2;

public class Course {
    private String nameCourse;
    private String priceCourse;
    private String imgCourse;

    public Course(String nameCourse, String priceCourse, String imgCourse) {
        this.nameCourse = nameCourse;
        this.priceCourse = priceCourse;
        this.imgCourse = imgCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getPriceCourse() {
        return priceCourse;
    }

    public void setPriceCourse(String priceCourse) {
        this.priceCourse = priceCourse;
    }

    public String getImgCourse() {
        return imgCourse;
    }

    public void setImgCourse(String imgCourse) {
        this.imgCourse = imgCourse;
    }
}
