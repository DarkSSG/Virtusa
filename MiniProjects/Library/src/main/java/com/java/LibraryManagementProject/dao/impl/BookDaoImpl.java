package com.java.LibraryManagementProject.dao.impl;

import com.java.LibraryManagementProject.dao.BookDao;
import com.java.LibraryManagementProject.model.Book;
import com.java.LibraryManagementProject.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
  @Override
  public String addBookDao(Book book) {
    String cmd = "insert into book values (?,?,?,?,?,?,?)";
    try (Connection connection = ConnectionHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {

      preparedStatement.setInt(1, book.getBookId());
      preparedStatement.setString(2, book.getTitle());
      preparedStatement.setString(3, book.getAuthor());
      preparedStatement.setString(4, book.getCategory());
      preparedStatement.setInt(5, book.getTotalCopies());
      preparedStatement.setInt(6, book.getIssuedCopies());
      preparedStatement.setInt(7, book.getAvailableCopies());

      preparedStatement.executeUpdate();
      return "Book Added Successfully.";
    } catch (ClassNotFoundException | SQLException e) {
      return e.getMessage();
    }
  }

  @Override
  public Book searchBookDao(int id) {
    String cmd = "Select * from book where book_id = ?";
    Book book = null;
    try(Connection connection = ConnectionHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {

      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();

      if(rs.next()) {
        book = new Book(
          rs.getInt("book_id"),
          rs.getString("title"),
          rs.getString("author"),
          rs.getString("category"),
          rs.getInt("total_copies"),
          rs.getInt("issued_copies"),
          rs.getInt("available_copies")
        );
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return book;
  }

  @Override
  public List<Book> showBooksDao() {
    String cmd = "Select * from book";
    List<Book> books = new ArrayList<>();

    try (Connection connection = ConnectionHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        Book book = new Book(
          resultSet.getInt("book_id"),
          resultSet.getString("title"),
          resultSet.getString("author"),
          resultSet.getString("category"),
          resultSet.getInt("total_copies"),
          resultSet.getInt("issued_copies"),
          resultSet.getInt("available_copies")
        );
        books.add(book);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return books;
  }

  @Override
  public String updateBookDao(Book book) {
    String cmd = "update book set title=?, author=?, category=?, total_copies=?, issued_copies=?, available_copies=? where book_id=?";
    try (Connection connection = ConnectionHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {

      preparedStatement.setString(1, book.getTitle());
      preparedStatement.setString(2, book.getAuthor());
      preparedStatement.setString(3, book.getCategory());
      preparedStatement.setInt(4, book.getTotalCopies());
      preparedStatement.setInt(5, book.getIssuedCopies());
      preparedStatement.setInt(6, book.getAvailableCopies());
      preparedStatement.setInt(7, book.getBookId());

      preparedStatement.executeUpdate();
      return "Book Updated Successfully.";
    }
    catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public String issueBookDao(int id) {
    String cmd = "update book set issued_copies = issued_copies + 1, available_copies = available_copies - 1 where book_id = ?";

    try (Connection connection = ConnectionHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();

      return "Book Issued Successfully.";
    }
    catch (Exception e) {
      return e.getMessage();
    }
  }


  @Override
  public String deleteBookDao(int id) {
    String cmd = "delete from book where book_id = ?";

    try (Connection connection = ConnectionHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {

      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();

      return "Book Deleted Successfully.";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public String returnBookDao(int id) {
        String cmd = "update book set issued_copies = issued_copies - 1, available_copies = available_copies + 1 where book_id = ?";

    try (Connection connection = ConnectionHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(cmd)) {

      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();

      return "Book Returned Successfully.";
    }
    catch (Exception e) {
      return e.getMessage();
    }
  }
}
