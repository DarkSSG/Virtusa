package com.java.LibraryManagementProject.main;

import com.java.LibraryManagementProject.bal.BookBal;
import com.java.LibraryManagementProject.model.Book;

import java.util.List;
import java.util.Scanner;

public class BookMain {
  static Scanner sc = new Scanner(System.in);
  static BookBal bookBal = new BookBal();

  public static int readInt(String message) {
    while (true) {
      System.out.println(message);
      try {
        return Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input! Please enter a valid number.");
      }
    }
  }

  public static void showBookMain() {
    List<Book> bookList = bookBal.showBookBal();
    bookList.forEach(System.out::println);
  }

  public static void searchBookMain() {
    int bookID = readInt("Enter Book ID: ");
    Book book = bookBal.searchBookBal(bookID);
    if (book == null) {
      System.out.println("Book Not Found for BookID: " +bookID +".");
    }
    else {
      System.out.println(book);
    }
  }

  public static void addBookMain() {
    Book book = new Book();

    book.setBookId(readInt("Enter Book ID: "));

    System.out.println("Enter Book Title: ");
    book.setTitle(sc.nextLine());

    System.out.println("Enter Book Author: ");
    book.setAuthor(sc.nextLine());

    System.out.println("Enter Book Category: ");
    book.setCategory(sc.nextLine());

    book.setTotalCopies(readInt("Enter Total Copies: "));

    book.setIssuedCopies(readInt("Enter Issued Copies: "));

    System.out.println(bookBal.addBookBal(book));
  }

  public static void updateBookMain() {
    Book book = new Book();

    book.setBookId(readInt("Enter Book ID: "));

    System.out.println("Enter Book Title: ");
    book.setTitle(sc.nextLine());

    System.out.println("Enter Book Author: ");
    book.setAuthor(sc.nextLine());

    System.out.println("Enter Book Category: ");
    book.setCategory(sc.nextLine());

    book.setTotalCopies(readInt("Enter Total Copies: "));

    book.setIssuedCopies(readInt("Enter Issued Copies: "));

    System.out.println(bookBal.updateBookBal(book));
  }

  public static void issueBookMain() {
    int bookID = readInt("Enter Book ID: ");
    System.out.println(bookBal.issueBookBal(bookID));
  }

  public static void deleteBookMain() {
    int bookID = readInt("Enter Book ID: ");;
    System.out.println(bookBal.deleteBookBal(bookID));
  }

  public static void returnBookMain() {
    int bookID = readInt("Enter Book ID: ");
    System.out.println(bookBal.returnBookBal(bookID));
  }

  public static void main(String[] args) {
    int choice;

    do {
      System.out.println("OPTIONS FOR LIBRARY MANAGEMENT:- ");
      System.out.println("1. Add Book.");
      System.out.println("2. Show All Books.");
      System.out.println("3. Search Book.");
      System.out.println("4. Update Book.");
      System.out.println("5. Issue Book.");
      System.out.println("6. Return Book");
      System.out.println("7. Delete Book.");
      System.out.println("8. Exit. ");

      choice = readInt("Enter Your Choice: ");

      switch(choice) {
        case 1:
          addBookMain();
          break;
        case 2:
          showBookMain();
          break;
        case 3:
          searchBookMain();
          break;
        case 4:
          updateBookMain();
          break;
        case 5:
          issueBookMain();
          break;
        case 6:
          returnBookMain();
          break;
        case 7:
          deleteBookMain();
          break;
        case 8:
          System.exit(0);
        default:
          System.out.println("Invalid Choice!");
      }
    }while(true);
  }
}
