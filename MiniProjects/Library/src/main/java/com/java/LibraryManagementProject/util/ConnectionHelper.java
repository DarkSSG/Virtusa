package com.java.LibraryManagementProject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHelper {
  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    ResourceBundle rb = ResourceBundle.getBundle("db");
    Class.forName(rb.getString("driver"));
    return DriverManager.getConnection(
      rb.getString("url"),
      rb.getString("user"),
      rb.getString("password")
    );
  }
}
