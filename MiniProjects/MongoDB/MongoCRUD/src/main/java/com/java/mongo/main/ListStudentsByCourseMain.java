package com.java.mongo.main;

import com.java.mongo.bal.StudentBal;
import com.java.mongo.model.Student;

import java.util.List;
import java.util.Scanner;

public class ListStudentsByCourseMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StudentBal studentBal = new StudentBal();

    System.out.print("Enter Course (JAVA / PYTHON / MONGODB / AI / DSA): ");
    String courseInput = sc.nextLine().toUpperCase();

    List<Student> studentList = studentBal.listStudentsByCourseBal(courseInput);

    if (studentList == null) {
      System.out.println("Invalid Course!");
      return;
    }

    if (studentList.isEmpty()) {
      System.out.println("No students found for course: " + courseInput);
      return;
    }

    studentList.forEach(System.out::println);
  }
}
