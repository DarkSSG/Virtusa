CREATE database employee_payroll_db;
USE employee_payroll_db;

CREATE TABLE employee_payroll(
  emp_id INT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  department VARCHAR(50) NOT NULL,
  gender VARCHAR(10) NOT NULL,
  basic_salary DOUBLE NOT NULL,
  hra DOUBLE NOT NULL,
  da DOUBLE NOT NULL,
  deductions DOUBLE NOT NULL,
  net_salary DOUBLE NOT NULL
);

INSERT INTO employee_payroll (emp_id, name, department, gender, basic_salary, hra, da, deductions, net_salary)
VALUES (?,?,?,?,?,?,?,?,?);

SELECT * FROM employee_payroll WHERE emp_id = ?;

SELECT * FROM employee_payroll ORDER BY emp_id;

UPDATE employee_payroll SET name = ?, department = ?, gender = ?,
basic_salary = ?, hra = ?, da = ?, deductions = ?, net_salary = ?
WHERE emp_id = ?

DELETE FROM employee_payroll WHERE emp_id = ?;
