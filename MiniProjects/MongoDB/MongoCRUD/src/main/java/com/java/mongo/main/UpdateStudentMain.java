package com.java.mongo.main;

import com.java.mongo.bal.StudentBal;
import com.java.mongo.model.Course;
import com.java.mongo.model.Student;

import java.util.Scanner;

public class UpdateStudentMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StudentBal studentBal = new StudentBal();

    System.out.print("Enter Roll to Update: ");
    int roll = sc.nextInt();
    sc.nextLine();

    Student existing = studentBal.searchStudentBal(roll);

    if (existing == null) {
      System.out.println("Student Not Found.");
      return;
    }

    System.out.println("Existing Name  : " + existing.getName());
    System.out.println("Existing Course: " + existing.getCourse());
    System.out.println("Existing Marks : " + existing.getMarks());
    System.out.println("Existing City  : " + existing.getCity());

    Student s = new Student();
    s.setRoll(roll);

    System.out.println("***Enter New Data***");

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

    System.out.println(studentBal.updateStudentBal(s));
  }
}
