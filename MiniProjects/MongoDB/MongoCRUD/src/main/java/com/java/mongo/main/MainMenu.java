package com.java.mongo.main;

import java.util.Scanner;

public class MainMenu {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int choice;

    while (true) {

      System.out.println("1. Add Student");
      System.out.println("2. Search Student");
      System.out.println("3. Update Student");
      System.out.println("4. Delete Student");
      System.out.println("5. List All Students");
      System.out.println("6. List Students by Course");
      System.out.println("7. List Top Students");
      System.out.println("8. Exit");
      System.out.print("Enter Your Choice: ");
      choice = sc.nextInt();
      switch (choice) {

        case 1:
          AddStudentMain.main(null);
          break;
        case 2:
          SearchStudentMain.main(null);
          break;
        case 3:
          UpdateStudentMain.main(null);
          break;
        case 4:
          DeleteStudentMain.main(null);
          break;
        case 5:
          ListAllStudentsMain.main(null);
          break;
        case 6:
          ListStudentsByCourseMain.main(null);
          break;
        case 7:
          ListTopStudentsMain.main(null);
          break;
        case 8:
          System.exit(0);

        default:
          System.out.println("Invalid choice!");
      }
    }
  }
}
