package com.java.student.model;

public class Student {
    private int roll;
    private String name;
    private String course;
    private int marks;
    private Grade grade;
    private Gender gender;

    public Student() {
    }

    public Student(int roll, String name, String course, int marks, Grade grade, Gender gender) {
        this.roll = roll;
        this.name = name;
        this.course = course;
        this.marks = marks;
        this.grade = grade;
        this.gender = gender;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", course='" + course + '\'' +
                ", marks=" + marks +
                ", grade=" + grade.getLabel() +
                '}';
    }
}
