package com.java.student.main;

import com.java.student.bal.StudentBal;
import com.java.student.exception.StudentException;
import com.java.student.model.Gender;
import com.java.student.model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentMain {

    static StudentBal studentBal;
    static {
        studentBal = new StudentBal();
    }

    public static void showStudentsMain() {
        List<Student> studentList =  studentBal.showStudentBal();
        studentList.forEach(System.out::println);
    }

    public static void addStudentMain() throws StudentException {
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        System.out.println("Enter Roll: ");
        student.setRoll(sc.nextInt());

        System.out.println(("Enter Name: "));
        student.setName(sc.next());

        System.out.println("Enter Gender: ");
        student.setGender(Gender.valueOf(sc.next().toUpperCase()));

        System.out.println("Enter Course: ");
        student.setCourse(sc.next());

        System.out.println("Enter Marks: ");
        student.setMarks(sc.nextInt());

        System.out.println(studentBal.addStudentBal(student));
    }

    public static void searchStudentMain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll: ");
        int roll = sc.nextInt();
        Student student = studentBal.searchStudentBal(roll);
        if (student != null) {
            System.out.println(student);
        }
        else {
            System.out.println("Student Not Found...");
        }
    }

    public static void deleteStudentMain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll: ");
        int roll = sc.nextInt();
        System.out.println(studentBal.deleteStudentBal(roll));
    }

    public static void updateStudentMain() throws StudentException {
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        System.out.println("Enter Roll: ");
        student.setRoll(sc.nextInt());

        System.out.println(("Enter Name: "));
        student.setName(sc.next());

        System.out.println("Enter Gender: ");
        student.setGender(Gender.valueOf(sc.next().toUpperCase()));

        System.out.println("Enter Course: ");
        student.setCourse(sc.next());

        System.out.println("Enter Marks: ");
        student.setMarks(sc.nextInt());

        System.out.println(studentBal.updateStudentBal(student));
    }

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("O P T I O N S");
            System.out.println("1. Add Student");
            System.out.println("2. Show Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        addStudentMain();
                    } catch (StudentException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    showStudentsMain();
                    break;
                case 3:
                    searchStudentMain();
                    break;
                case 4:
                    try {
                        updateStudentMain();
                    } catch (StudentException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    deleteStudentMain();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }
}



//        this.roll = roll;
//        this.name = name;
//        this.course = course;
//        this.marks = marks;
//        this.grade = grade;
//        this.gender = gender;