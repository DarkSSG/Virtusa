package com.java.LibraryManagementProject.model;

public class Book {
  int bookId;
  String title;
  String author;
  String category;
  int totalCopies;
  int issuedCopies;
  int availableCopies;

  public Book() {

  }

  public Book(int bookId, String title, String author, String category, int totalCopies, int issuedCopies, int availableCopies) {
    this.bookId = bookId;
    this.title = title;
    this.author = author;
    this.category = category;
    this.totalCopies = totalCopies;
    this.issuedCopies = issuedCopies;
    this.availableCopies = availableCopies;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getTotalCopies() {
    return totalCopies;
  }

  public void setTotalCopies(int totalCopies) {
    this.totalCopies = totalCopies;
  }

  public int getIssuedCopies() {
    return issuedCopies;
  }

  public void setIssuedCopies(int issuedCopies) {
    this.issuedCopies = issuedCopies;
  }

  public int getAvailableCopies() {
    return availableCopies;
  }

  public void setAvailableCopies(int availableCopies) {
    this.availableCopies = availableCopies;
  }

  @Override
  public String toString() {
    return "Library{" +
      "bookId=" + bookId +
      ", title='" + title + '\'' +
      ", author='" + author + '\'' +
      ", category='" + category + '\'' +
      ", totalCopies=" + totalCopies +
      ", issuedCopies=" + issuedCopies +
      ", availableCopies=" + availableCopies +
      '}';
  }
}
