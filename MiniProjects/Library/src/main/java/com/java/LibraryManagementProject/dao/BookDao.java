package com.java.LibraryManagementProject.dao;

import com.java.LibraryManagementProject.model.Book;
import java.util.List;

public interface BookDao {
  String addBookDao(Book book);
  Book searchBookDao(int id);
  List<Book> showBooksDao();
  String updateBookDao(Book book);
  String issueBookDao(int id);
  String deleteBookDao(int id);
  String returnBookDao(int id);
}
