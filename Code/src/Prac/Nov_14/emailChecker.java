package Prac.Nov_14;

import java.util.Scanner;

public class emailChecker {
    private void checkFormat (String email) throws InvalidEmailException, InvalidUserNameException {
        if (email.indexOf('@') == -1) {
            throw new InvalidEmailException ("Email should contain '@' symbol");
        }
        else if ((email.substring(0, email.indexOf('@')).length() < 8) || (email.substring(0, email.indexOf('@')).length() > 14)) {
            throw new InvalidUserNameException("Username should be between 8 to 14");
        }
        System.out.println("Email valid");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Email: ");
        String email = sc.nextLine();

        emailChecker checker = new emailChecker();

        try {
            checker.checkFormat(email);
        } catch (InvalidEmailException | InvalidUserNameException e) {
            System.err.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
