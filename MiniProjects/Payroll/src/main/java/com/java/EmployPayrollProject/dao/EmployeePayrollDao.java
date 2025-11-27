package com.java.EmployPayrollProject.dao;

import com.java.EmployPayrollProject.model.EmployeePayroll;

import java.util.List;

public interface EmployeePayrollDao {
  String addEmployeeDao(EmployeePayroll employeePayroll);
  EmployeePayroll searchEmployeeDao(int empId);
  List<EmployeePayroll> getAllEmployeesDao();
  String updateEmployeeDao(EmployeePayroll employeePayroll);
  String deleteEmployeeDao(int empId);
}
