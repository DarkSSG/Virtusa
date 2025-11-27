package com.java.EmployPayrollProject.util;

import com.java.EmployPayrollProject.model.EmployeePayroll;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CSVUtil {
  public static String exportToCSV(List<EmployeePayroll> list) {
    String timestamp = LocalDateTime.now()
      .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

    // Final filename with timestamp
    String folderPath = "src/main/java/com/java/EmployPayrollProject/CSV";

    java.io.File dir = new java.io.File(folderPath);
    if (!dir.exists()) {
      dir.mkdirs();
    }

    String fileName = folderPath + "/employee_payroll_" + timestamp + ".csv";
    try (FileWriter writer = new FileWriter(fileName)) {
      writer.append("EmpID,Name,Department,Gender,Basic Salary,HRA,DA,Deductions,Net Salary\n");

      for (EmployeePayroll employeePayroll : list) {
        writer.append(employeePayroll.getEmpId() + ",")
          .append(employeePayroll.getName() + ",")
          .append(employeePayroll.getDepartment() + ",")
          .append(employeePayroll.getGender().name() + ",")
          .append(employeePayroll.getBasicSalary() + ",")
          .append(employeePayroll.getHra() + ",")
          .append(employeePayroll.getDa() + ",")
          .append(employeePayroll.getDeductions() + ",")
          .append(employeePayroll.getNetSalary() + "\n");
      }

      return "CSV Export Successful! Saved as: " + fileName;
    }
    catch (IOException e) {
      return "Error exporting CSV: " + e.getMessage();
    }
  }
}
