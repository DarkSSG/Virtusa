package com.java.EmployPayrollProject.main;

import com.java.EmployPayrollProject.bal.EmployeePayrollBal;
import com.java.EmployPayrollProject.model.EmployeePayroll;
import com.java.EmployPayrollProject.model.Gender;
import com.java.EmployPayrollProject.util.CSVUtil;

import java.util.List;
import java.util.Scanner;

public class EmployeePayrollMain {
  static Scanner sc = new Scanner(System.in);
  static EmployeePayrollBal employeePayrollBal = new EmployeePayrollBal();

  public static int readInt (String message) {
    while(true) {
      System.out.println(message);
      try {
        return Integer.parseInt(sc.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a valid number.");
      }
    }
  }

  public static double readDouble(String message) {
    while (true) {
      System.out.println(message);
      try {
        return Double.parseDouble(sc.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a valid decimal number.");
      }
    }
  }

  public static String readString(String message) {
    System.out.println(message);
    return sc.nextLine().trim();
  }

  public static Gender readGender(String message) {
    while (true) {
      System.out.println(message + " (MALE / FEMALE): ");
      String input = sc.nextLine().trim().toUpperCase();
      try {
        return Gender.valueOf(input);
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid gender. Please enter MALE or FEMALE.");
      }
    }
  }

  public static void exportCSVMain() {
    List<EmployeePayroll> list = employeePayrollBal.getAllEmployeesBal();
    String fileName = "CSV/employee_payroll.csv";
    System.out.println(CSVUtil.exportToCSV(list));
  }

  public static void printSalarySlip(EmployeePayroll emp) {

    System.out.println("\n---------------------- SALARY SLIP ----------------------");
    System.out.printf("Employee ID     : %d%n", emp.getEmpId());
    System.out.printf("Name            : %s%n", emp.getName());
    System.out.printf("Department      : %s%n", emp.getDepartment());
    System.out.printf("Gender          : %s%n", emp.getGender());
    System.out.println("---------------------------------------------------------");
    System.out.printf("Basic Salary    : %.2f%n", emp.getBasicSalary());
    System.out.printf("HRA             : %.2f%n", emp.getHra());
    System.out.printf("DA              : %.2f%n", emp.getDa());
    System.out.printf("Deductions      : %.2f%n", emp.getDeductions());
    System.out.println("---------------------------------------------------------");
    System.out.printf("NET SALARY      : %.2f%n", emp.getNetSalary());
    System.out.println("---------------------------------------------------------\n");
  }

  public static void getAllEmployeesMain() {
    List<EmployeePayroll> employeePayrollList = employeePayrollBal.getAllEmployeesBal();

    System.out.printf("%-6s %-20s %-12s %-8s %-10s %-10s %-10s %-12s %-10s%n",
      "ID", "Name", "Department", "Gender", "Basic", "HRA", "DA", "Deductions", "Net Salary");
    System.out.println("---------------------------------------------------------------------------------------------");

    for (EmployeePayroll emp : employeePayrollList) {
      System.out.printf("%-6d %-20s %-12s %-8s %-10.2f %-10.2f %-10.2f %-12.2f %-10.2f%n",
        emp.getEmpId(),
        emp.getName(),
        emp.getDepartment(),
        emp.getGender(),
        emp.getBasicSalary(),
        emp.getHra(),
        emp.getDa(),
        emp.getDeductions(),
        emp.getNetSalary()
      );
    }
  }

  public static void searchEmployeeMain() {
    int empId = readInt("Enter Employee ID: ");
    EmployeePayroll employeePayroll = employeePayrollBal.searchEmployeeBal(empId);
    if (employeePayroll == null) {
      System.out.println("Employee Not Found for Employee ID: " +empId);
    }
    else {
      System.out.println(employeePayroll);
      System.out.println("Do you want to view Salary Slip? (yes/no)");
      String choice = sc.nextLine().trim().toLowerCase();

      if (choice.equals("yes")) {
        printSalarySlip(employeePayroll);
      }
    }
  }

  public static void salarySlipMain() {
    int empId = readInt("Enter Employee ID: ");
    EmployeePayroll employeePayroll = employeePayrollBal.searchEmployeeBal(empId);
    if (employeePayroll == null) {
      System.out.println("Employee Not Found for Employee ID: " +empId);
    }
    else {
      printSalarySlip(employeePayroll);
    }
  }

  public static void addEmployeeMain() {
    EmployeePayroll employeePayroll = new EmployeePayroll();

    employeePayroll.setEmpId(readInt("Enter Employee ID: "));
    employeePayroll.setName(readString("Enter Employee Name: "));
    employeePayroll.setDepartment(readString("Enter Department: "));
    employeePayroll.setGender(readGender("Enter Gender"));
    employeePayroll.setBasicSalary(readDouble("Enter Basic Salary: "));
    employeePayroll.setHra(readDouble("Enter Home Rental Allowance: "));
    employeePayroll.setDa(readDouble("Enter Dearness Allowance: "));
    employeePayroll.setDeductions(readDouble("Enter Deductions: "));

    System.out.println(employeePayrollBal.addEmployeeBal(employeePayroll));
  }

  public static void updateEmployeeMain() {
    EmployeePayroll employeePayroll = new EmployeePayroll();

    employeePayroll.setEmpId(readInt("Enter Employee ID: "));
    employeePayroll.setName(readString("Enter Employee Name: "));
    employeePayroll.setDepartment(readString("Enter Department: "));
    employeePayroll.setGender(readGender("Enter Gender"));
    employeePayroll.setBasicSalary(readDouble("Enter Basic Salary: "));
    employeePayroll.setHra(readDouble("Enter Home Rental Allowance: "));
    employeePayroll.setDa(readDouble("Enter Dearness Allowance: "));
    employeePayroll.setDeductions(readDouble("Enter Deductions: "));

    System.out.println(employeePayrollBal.updateEmployeeBal(employeePayroll));
  }

  public static void deleteEmployeeMain() {
    int empId = readInt("Enter Employee ID: ");
    System.out.println(employeePayrollBal.deleteEmployeeBal(empId));
  }

  public static void main(String[] args) {
    int choice;

    do {
      System.out.println("OPTIONS for Employee Payroll:-");
      System.out.println("1. Add Employee Payroll.");
      System.out.println("2. Show All Employees Payroll.");
      System.out.println("3. Search Employee Payroll.");
      System.out.println("4. Show Salary Slip.");
      System.out.println("5. Export to CSV.");
      System.out.println("6. Update Employee Payroll.");
      System.out.println("7. Delete Employee Payroll.");
      System.out.println("8. Exit");

      choice = readInt("Enter Your Choice: ");

      switch (choice) {
        case 1:
          addEmployeeMain();
          break;
        case 2:
          getAllEmployeesMain();
          break;
        case 3:
          searchEmployeeMain();
          break;
        case 4:
          salarySlipMain();
          break;
        case 5:
          exportCSVMain();
          break;
        case 6:
          updateEmployeeMain();
          break;
        case 7:
          deleteEmployeeMain();
          break;
        case 8:
          System.exit(0);
        default:
          System.out.println("Invalid Choice!");
      }
    } while (true);
  }
}
