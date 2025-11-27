package com.java.EmployPayrollProject.bal;

import com.java.EmployPayrollProject.dao.EmployeePayrollDao;
import com.java.EmployPayrollProject.dao.impl.EmployeePayrollDaoImpl;
import com.java.EmployPayrollProject.model.EmployeePayroll;

import java.util.List;

public class EmployeePayrollBal {
  private final EmployeePayrollDao employeePayrollDao;

  public EmployeePayrollBal() {
    employeePayrollDao = new EmployeePayrollDaoImpl();
  }

  public String addEmployeeBal(EmployeePayroll employeePayroll) {

    String validate = validateEmployee(employeePayroll);
    if (!validate.equals("OK")) {
      return validate;
    }
    if (employeePayrollDao.searchEmployeeDao(employeePayroll.getEmpId()) != null) {
      return "Employee Already Exists.";
    }
    calculateNetSalary(employeePayroll);
    return employeePayrollDao.addEmployeeDao(employeePayroll);
  }

  public EmployeePayroll searchEmployeeBal(int empId) {
    return employeePayrollDao.searchEmployeeDao(empId);
  }

  public List<EmployeePayroll> getAllEmployeesBal() {
    return employeePayrollDao.getAllEmployeesDao();
  }

  public String updateEmployeeBal(EmployeePayroll employeePayroll) {
    String validate = validateEmployee(employeePayroll);
    if (!validate.equals("OK")) {
      return validate;
    }
    if (employeePayrollDao.searchEmployeeDao(employeePayroll.getEmpId()) == null) {
      return "Employee Not Found.";
    }
    calculateNetSalary(employeePayroll);
    return employeePayrollDao.updateEmployeeDao(employeePayroll);
  }

  public String deleteEmployeeBal(int empId)  {
    if (employeePayrollDao.searchEmployeeDao(empId) == null) {
      return "Employee Not Found.";
    }
    return employeePayrollDao.deleteEmployeeDao(empId);
  }

  private void calculateNetSalary (EmployeePayroll employeePayroll) {
    double netSalary = employeePayroll.getBasicSalary() + employeePayroll.getHra() + employeePayroll.getDa() - employeePayroll.getDeductions();
    employeePayroll.setNetSalary(netSalary);
  }

  private String validateEmployee(EmployeePayroll employeePayroll) {
    StringBuilder sb = new StringBuilder();

    if (employeePayroll.getEmpId() <= 0) {
      sb.append("Employee ID should be greater than 0.\n");
    }
    if (employeePayroll.getName() == null || employeePayroll.getName().length() < 3) {
      sb.append("Employee Name should be at least 3 characters.\n");
    }
    if (employeePayroll.getDepartment() == null || employeePayroll.getDepartment().length() < 2) {
      sb.append("Department should be at least 2 characters.\n");
    }
    if (employeePayroll.getGender() == null) {
      sb.append("Gender cannot be NULL.\n");
    }
    if (employeePayroll.getBasicSalary() <= 0) {
      sb.append("Basic Salary should be greater than 0.\n");
    }
    if (employeePayroll.getHra() < 0) {
      sb.append("Home Rent Allowance cannot be Negative.\n");
    }
    if (employeePayroll.getDa() < 0) {
      sb.append("Dearness Allowance cannot be Negative.\n");
    }
    if (employeePayroll.getDeductions() < 0) {
      sb.append("Deduction cannot be Negative.\n");
    }

    return sb.length() == 0 ? "OK" : sb.toString();
  }
}
