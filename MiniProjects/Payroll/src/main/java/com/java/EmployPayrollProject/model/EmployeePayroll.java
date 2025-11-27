package com.java.EmployPayrollProject.model;

public class EmployeePayroll {
  private int empId;
  private String name;
  private String department;
  private Gender gender;      // ENUM
  private double basicSalary;
  private double hra;
  private double da;
  private double deductions;
  private double netSalary;   // auto-calculated in BAL

  public EmployeePayroll() {

  }

  public EmployeePayroll(int empId, String name, String department, Gender gender, double basicSalary, double hra, double da, double deductions) {
    this.empId = empId;
    this.name = name;
    this.department = department;
    this.gender = gender;
    this.basicSalary = basicSalary;
    this.hra = hra;
    this.da = da;
    this.deductions = deductions;
  }

  public int getEmpId() {
    return empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public double getBasicSalary() {
    return basicSalary;
  }

  public void setBasicSalary(double basicSalary) {
    this.basicSalary = basicSalary;
  }

  public double getHra() {
    return hra;
  }

  public void setHra(double hra) {
    this.hra = hra;
  }

  public double getDa() {
    return da;
  }

  public void setDa(double da) {
    this.da = da;
  }

  public double getDeductions() {
    return deductions;
  }

  public void setDeductions(double deductions) {
    this.deductions = deductions;
  }

  public double getNetSalary() {
    return netSalary;
  }

  public void setNetSalary(double netSalary) {
    this.netSalary = netSalary;
  }

  @Override
  public String toString() {
    return "EmployeePayroll [" +
      "empId=" + empId +
      ", name='" + name + '\'' +
      ", department='" + department + '\'' +
      ", gender=" + gender +
      ", basicSalary=" + basicSalary +
      ", hra=" + hra +
      ", da=" + da +
      ", deductions=" + deductions +
      ", netSalary=" + netSalary +
      ']';
  }
}
