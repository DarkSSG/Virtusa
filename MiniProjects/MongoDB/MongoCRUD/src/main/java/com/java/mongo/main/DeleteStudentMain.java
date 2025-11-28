package com.java.mongo.main;

import com.java.mongo.bal.StudentBal;

import java.util.Scanner;

public class DeleteStudentMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StudentBal bal = new StudentBal();

    System.out.print("Enter Roll: ");
    int roll = sc.nextInt();

    String result = bal.deleteStudentBal(roll);

    System.out.println(result);
  }
}
