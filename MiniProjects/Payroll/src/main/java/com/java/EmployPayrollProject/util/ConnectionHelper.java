package com.java.EmployPayrollProject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHelper {
  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    Class.forName(resourceBundle.getString("driver"));
    return DriverManager.getConnection(
      resourceBundle.getString("url"),
      resourceBundle.getString("user"),
      resourceBundle.getString("password")
    );
  }
}
