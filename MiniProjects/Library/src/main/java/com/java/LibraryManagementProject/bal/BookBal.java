package com.java.LibraryManagementProject.bal;

import com.java.LibraryManagementProject.dao.BookDao;
import com.java.LibraryManagementProject.dao.impl.BookDaoImpl;
import com.java.LibraryManagementProject.model.Book;

import java.util.List;

public class BookBal {
  private final BookDao bookDao;

  public BookBal() {
    bookDao = new BookDaoImpl();
  }

  public List<Book> showBookBal() {
    return bookDao.showBooksDao();
  }

  public Book searchBookBal(int id) {
    return bookDao.searchBookDao(id);
  }

  public String addBookBal(Book book) {
    if (bookDao.searchBookDao(book.getBookId()) != null) {
      return "Book Already Exists.";
    }
    String validation = validateBook(book);
    if (!validation.equals("OK")) {
      return validation;
    }
    return bookDao.addBookDao(book);
  }

  public String updateBookBal(Book book) {
    if (bookDao.searchBookDao(book.getBookId()) == null) {
      return "Book Not Found.";
    }
    String validation = validateBook(book);
    if (!validation.equals("OK")) {
      return validation;
    }
    return bookDao.updateBookDao(book);
  }

  public String deleteBookBal(int id) {
    if (bookDao.searchBookDao(id) == null) {
      return "Book Not Found.";
    }
    return bookDao.deleteBookDao(id);
  }

  public String issueBookBal(int id) {
    Book book = bookDao.searchBookDao(id);

    if (book == null) {
      return "Book Not Found.";
    }

    if (book.getAvailableCopies() <= 0) {
      return "No copies available to issue.";
    }

    return bookDao.issueBookDao(id);
  }

  public String returnBookBal(int id) {
    Book book = bookDao.searchBookDao(id);
    if (book == null) {
      return "Book Not Found.";
    }
    if (book.getIssuedCopies() <= 0) {
      return "No issued copies to return.";
    }
    return bookDao.returnBookDao(id);
  }

  public String validateBook(Book book) {
    StringBuilder sb = new StringBuilder();

    if (book.getBookId() <= 0) {
      sb.append("Book ID must be positive.\n");
    }

    if (book.getTitle().length() < 3) {
      sb.append("Title must have at least 3 characters.\n");
    }

    if (book.getAuthor().length() < 3) {
      sb.append("Author must have at least 3 characters.\n");
    }

    if (book.getCategory().length() < 3) {
      sb.append("Category must have at least 3 characters.\n");
    }

    if (book.getTotalCopies() <= 0) {
      sb.append("Total copies must be greater than 0.\n");
    }

    if (book.getIssuedCopies() > book.getTotalCopies()) {
      sb.append("Issued copies cannot exceed total copies.\n");
    }

    // Auto-correct available copies
    book.setAvailableCopies(book.getTotalCopies() - book.getIssuedCopies());

    if (sb.length() == 0) {
      return "OK";
    }

    return sb.toString();
  }
 }
