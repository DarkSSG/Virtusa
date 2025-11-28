package com.java.mongo.main;

import com.java.mongo.bal.StudentBal;
import com.java.mongo.model.Student;

import java.util.List;
import java.util.Scanner;

public class ListTopStudentsMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StudentBal studentBal = new StudentBal();

    System.out.print("Enter how many top students you want to display: ");
    int limit = sc.nextInt();

    if (limit <= 0) {
      System.out.println("Limit must be greater than 0.");
      return;
    }

    List<Student> studentList = studentBal.listTopStudentsBal(limit);

    if (studentList == null || studentList.isEmpty()) {
      System.out.println("No students found.");
      return;
    }

    studentList.forEach(System.out::println);
  }
}
