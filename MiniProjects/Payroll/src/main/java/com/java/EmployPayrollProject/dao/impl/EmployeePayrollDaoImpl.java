package com.java.EmployPayrollProject.dao.impl;

import com.java.EmployPayrollProject.dao.EmployeePayrollDao;
import com.java.EmployPayrollProject.model.EmployeePayroll;
import com.java.EmployPayrollProject.model.Gender;
import com.java.EmployPayrollProject.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDaoImpl implements EmployeePayrollDao {
  @Override
  public String addEmployeeDao(EmployeePayroll employeePayroll) {
    String cmd = "insert into employee_payroll "
               + "(emp_id, name, department, gender, basic_salary, hra, da, deductions, net_salary) "
               + "values (?,?,?,?,?,?,?,?,?)";
    try (Connection connection = ConnectionHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {

      preparedStatement.setInt(1, employeePayroll.getEmpId());
      preparedStatement.setString(2, employeePayroll.getName());
      preparedStatement.setString(3, employeePayroll.getDepartment());
      preparedStatement.setString(4, String.valueOf(employeePayroll.getGender()));
      preparedStatement.setDouble(5, employeePayroll.getBasicSalary());
      preparedStatement.setDouble(6, employeePayroll.getHra());
      preparedStatement.setDouble(7, employeePayroll.getDa());
      preparedStatement.setDouble(8, employeePayroll.getDeductions());
      preparedStatement.setDouble(9, employeePayroll.getNetSalary());

      preparedStatement.executeUpdate();

      return "Employee Payroll Details Added Successfully.";
    }
    catch (SQLException | ClassNotFoundException e) {
      return "Error: " + e.getMessage();
    }
  }

  @Override
  public EmployeePayroll searchEmployeeDao(int empId) {
    EmployeePayroll employeePayroll = null;
    String cmd = "Select * from employee_payroll where emp_id = ?";
    try (Connection connection = ConnectionHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {

      preparedStatement.setInt(1, empId);
      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        employeePayroll = new EmployeePayroll(
          resultSet.getInt("emp_id"),
          resultSet.getString("name"),
          resultSet.getString("department"),
          Gender.valueOf(resultSet.getString("gender")),
          resultSet.getDouble("basic_salary"),
          resultSet.getDouble("hra"),
          resultSet.getDouble("da"),
          resultSet.getDouble("deductions")
        );
        employeePayroll.setNetSalary(resultSet.getDouble("net_salary"));
      }
    }
    catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    return employeePayroll;
  }

  @Override
  public List<EmployeePayroll> getAllEmployeesDao() {
    String cmd = "Select * from employee_payroll order by emp_id";
    List<EmployeePayroll> employeePayrollList = new ArrayList<>();

    try (Connection connection = ConnectionHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        EmployeePayroll employeePayroll = new EmployeePayroll(
          resultSet.getInt("emp_id"),
          resultSet.getString("name"),
          resultSet.getString("department"),
          Gender.valueOf(resultSet.getString("gender")),
          resultSet.getDouble("basic_salary"),
          resultSet.getDouble("hra"),
          resultSet.getDouble("da"),
          resultSet.getDouble("deductions")
        );
        employeePayroll.setNetSalary(resultSet.getDouble("net_salary"));

        employeePayrollList.add(employeePayroll);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return employeePayrollList;
  }

  @Override
  public String updateEmployeeDao(EmployeePayroll employeePayroll) {
    String cmd = "update employee_payroll set name = ?, department = ?, gender = ?, basic_salary = ?, hra = ?, da = ?, deductions = ?, net_salary = ? where emp_id = ?";

    try (Connection connection = ConnectionHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {

      preparedStatement.setString(1, employeePayroll.getName());
      preparedStatement.setString(2, employeePayroll.getDepartment());
      preparedStatement.setString(3, employeePayroll.getGender().name());
      preparedStatement.setDouble(4, employeePayroll.getBasicSalary());
      preparedStatement.setDouble(5, employeePayroll.getHra());
      preparedStatement.setDouble(6, employeePayroll.getDa());
      preparedStatement.setDouble(7, employeePayroll.getDeductions());
      preparedStatement.setDouble(8, employeePayroll.getNetSalary());
      preparedStatement.setInt(9, employeePayroll.getEmpId());

      preparedStatement.executeUpdate();

      return "Employee Payroll Details Updated Successfully.";
    }
    catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public String deleteEmployeeDao(int empId) {
    String cmd = "delete from employee_payroll where emp_id = ?";

    try (Connection connection = ConnectionHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {

      preparedStatement.setInt(1, empId);
      preparedStatement.executeUpdate();
      return "Employee Payroll Record Deleted Successfully.";

    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }
}
