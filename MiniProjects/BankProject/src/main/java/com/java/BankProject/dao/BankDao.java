package com.java.BankProject.dao;

import com.java.BankProject.model.Account;

import java.sql.SQLException;

public interface BankDao {
  String createAccount(Account account) throws SQLException, ClassNotFoundException;
  Account searchAccount(int accountNo) throws SQLException, ClassNotFoundException;
  String updateAccount(int accountNo, String city, String state) throws SQLException, ClassNotFoundException;
  String closeAccount(int accountNo) throws SQLException, ClassNotFoundException;
  String depositAccount(int accountNo, double amount) throws SQLException, ClassNotFoundException;
  String withdrawAccount(int accountNo, double amount) throws SQLException, ClassNotFoundException;
}
