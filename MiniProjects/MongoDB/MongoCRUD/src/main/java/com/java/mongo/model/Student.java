package com.java.mongo.model;

public class Student {
  private int roll;
  private String name;
  private Course course;
  private int marks;
  private String city;

  public Student() {
  }

  public Student(int roll, String name, Course course, int marks, String city) {
    this.roll = roll;
    this.name = name;
    this.course = course;
    this.marks = marks;
    this.city = city;
  }

  public int getRoll() {
    return roll;
  }

  public void setRoll(int roll) {
    this.roll = roll;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public int getMarks() {
    return marks;
  }

  public void setMarks(int marks) {
    this.marks = marks;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "Student{" +
      "roll=" + roll +
      ", name='" + name + '\'' +
      ", course=" + course +
      ", marks=" + marks +
      ", city='" + city + '\'' +
      '}';
  }
}
