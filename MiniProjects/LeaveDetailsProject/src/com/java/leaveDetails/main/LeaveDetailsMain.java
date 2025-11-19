package com.java.leaveDetails.main;

import com.java.leaveDetails.bal.LeaveDetailsBal;
import com.java.leaveDetails.exception.LeaveDetailsException;
import com.java.leaveDetails.model.LeaveDetails;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LeaveDetailsMain {
    static LeaveDetailsBal leaveDetailsBal;
    static {
        leaveDetailsBal = new LeaveDetailsBal();
    }

    public static void showLeaveDetailsMain() {
        List<LeaveDetails> leaveDetailsList = leaveDetailsBal.showLeaveDetailsBal();
        leaveDetailsList.forEach(System.out::println);
    }

    private static Date scanDate(String msg, Scanner sc) {
        System.out.println(msg + " (yyyy-MM-dd): ");
        String dt = sc.next();  // read user input as string

        LocalDate ld = LocalDate.parse(dt);  // convert string → LocalDate

        return Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static void addLeaveDetailsMain() throws LeaveDetailsException {
        Scanner sc = new Scanner(System.in);
        LeaveDetails leaveDetails = new LeaveDetails();

        System.out.println("Enter Leave ID: ");
        leaveDetails.setLeaveId(sc.nextInt());

        System.out.println("Enter Employee ID: ");
        leaveDetails.setEmpId(sc.nextInt());

        leaveDetails.setLeaveStartDate(scanDate("Enter Leave Start Date ", sc));

        leaveDetails.setLeaveEndDate(scanDate("Enter Leave End Date ", sc));

        System.out.println("Enter Leave Reason: ");
        sc.nextLine();
        leaveDetails.setLeaveReason(sc.nextLine());

        System.out.println(leaveDetailsBal.addLeaveDetailsBal(leaveDetails));
    }

    public static void searchLeaveDetailsMain() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Leave ID: ");
        int leaveId = sc.nextInt();
        LeaveDetails leaveDetails = leaveDetailsBal.searchLeaveDetailsBal(leaveId);
        if (leaveDetails != null) {
            System.out.println(leaveDetails);
        }
        else {
            System.out.println("Leave Details Not Found.");
        }
    }

    public static void deleteLeaveDetailsMain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Leave ID: ");
        int roll = sc.nextInt();
        System.out.println(leaveDetailsBal.deleteLeaveDetailsBal(roll));
    }

    public static void updateLeaveDetailsMain() throws LeaveDetailsException {
        Scanner sc = new Scanner(System.in);
        LeaveDetails leaveDetails = new LeaveDetails();

        System.out.println("Enter Leave ID: ");
        leaveDetails.setLeaveId(sc.nextInt());

        leaveDetails.setLeaveStartDate(scanDate("Enter Leave Start Date ", sc));

        leaveDetails.setLeaveEndDate(scanDate("Enter Leave End Date ", sc));

        System.out.println("Enter Leave Reason: ");
        sc.nextLine();
        leaveDetails.setLeaveReason(sc.nextLine());

        System.out.println(leaveDetailsBal.updateLeaveDetailsBal(leaveDetails));
    }

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("O P T I O N S");
            System.out.println("1. Add Leave Details");
            System.out.println("2. Show Leave Details");
            System.out.println("3. Search Leave Detail");
            System.out.println("4. Update Leave Details");
            System.out.println("5. Delete Leave Details");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        addLeaveDetailsMain();
                    } catch (LeaveDetailsException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    showLeaveDetailsMain();
                    break;
                case 3:
                    searchLeaveDetailsMain();
                    break;
                case 4:
                    try {
                        updateLeaveDetailsMain();
                    } catch (LeaveDetailsException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    deleteLeaveDetailsMain();
                    break;
                case 6:
                    System.exit(0);
            }

        } while(true);
    }
}
