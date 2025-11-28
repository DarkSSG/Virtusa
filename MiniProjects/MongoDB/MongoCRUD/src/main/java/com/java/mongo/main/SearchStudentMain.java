package com.java.mongo.main;

import com.java.mongo.bal.StudentBal;
import com.java.mongo.model.Student;

import java.util.Scanner;

public class SearchStudentMain {
  public static void main(String[] args) {
    StudentBal studentBal = new StudentBal();
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Roll: ");
    int roll = sc.nextInt();

    Student s = studentBal.searchStudentBal(roll);

    if (s == null) {
      System.out.println("Student Not Found.");
    }
    else {
      System.out.println(s);
    }
  }
}
