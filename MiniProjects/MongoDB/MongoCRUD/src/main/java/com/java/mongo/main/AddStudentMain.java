package com.java.mongo.main;

import com.java.mongo.bal.StudentBal;
import com.java.mongo.model.Course;
import com.java.mongo.model.Student;

import java.util.Scanner;

public class AddStudentMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StudentBal studentBal = new StudentBal();
    Student s = new Student();

    System.out.print("Enter Roll: ");
    s.setRoll(sc.nextInt());
    sc.nextLine();

    System.out.print("Enter Name: ");
    s.setName(sc.nextLine());

    System.out.print("Enter Course (JAVA / PYTHON / MONGODB / AI / DSA): ");
    String courseInput = sc.next();

    try {
      s.setCourse(Course.valueOf(courseInput.toUpperCase()));
    } catch (IllegalArgumentException e) {
      System.out.println("Invalid Course!");
      return;
    }
    System.out.print("Enter Marks: ");
    s.setMarks(sc.nextInt());
    sc.nextLine();

    System.out.print("Enter City: ");
    s.setCity(sc.nextLine());

    System.out.println(studentBal.addStudentBal(s));
  }
}
