package com.java.BankProject.main;

import java.util.Scanner;

public class BankMenuMain {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("\n=== BANK MAIN MENU ===");
      System.out.println("1. Create Account");
      System.out.println("2. Deposit");
      System.out.println("3. Withdraw");
      System.out.println("4. Update Account");
      System.out.println("5. Close Account");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");

      int ch = sc.nextInt();

      switch (ch) {
        case 1:
          CreateAccountMain.main(null);
          break;
        case 2:
          DepositAccountMain.main(null);
          break;
        case 3:
          WithdrawAccountMain.main(null);
          break;
        case 4:
          UpdateAccountMain.main(null);
          break;
        case 5:
          CloseAccountMain.main(null);
          break;
        case 6:
          System.exit(0);
          return;
        default:
          System.out.println("Invalid choice.");
      }
    }
  }
}
