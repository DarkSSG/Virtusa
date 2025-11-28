package com.java.mongo.main;

import com.java.mongo.bal.StudentBal;
import com.java.mongo.model.Student;

import java.util.List;

public class ListAllStudentsMain {
  public static void main(String[] args) {

    StudentBal studentBal = new StudentBal();

    List<Student> studentList = studentBal.listAllStudentsBal();
    studentList.forEach(System.out::println);
  }
}
