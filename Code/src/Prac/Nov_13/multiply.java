package Prac.Nov_13;

import java.util.Arrays;
import java.util.Scanner;

public class multiply {
    private static String mult(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();

        int[] result = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';

                int product = d1 * d2;

                int lastDigit = i + j + 1;
                int carry = i + j;

                int sum = product + result[lastDigit];

                result[lastDigit] = sum % 10;
                result[carry] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }

        for (int j = i; j < result.length; j++) {
            sb.append(result[j]);
        }

        //return Arrays.toString(result);
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st Number: ");
        String n1 = sc.nextLine();

        System.out.print("Enter 2nd Number: ");
        String n2 = sc.nextLine();

        System.out.println("\nResult: " + mult(n1, n2));

        sc.close();
    }
}
