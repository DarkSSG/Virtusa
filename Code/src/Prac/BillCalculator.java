package Prac;

import java.util.Scanner;

public class BillCalculator {
    private static double calculateBill(double units) {
        double bill = 0;

        //Rates for different units
        double rate1, rate2, rate3, rate4, rate5;

        rate1 = 1.0; // 90 units 1.0/-
        rate2 = 1.5; // 91 to 150 units 1.5/-
        rate3 = 2.0; // 151 to 200 units 2.0/-
        rate4 = 2.5; // 201 to 240 units 2.5/-
        rate5 = 3.0; // 240+ units 3/-

        if (units <= 90) {
            bill = units * rate1;
        }
        else if (units <= 150) {
            bill = (90 * rate1) + ((units - 90) * rate2);
        }
        else if (units <= 200) {
            bill = (90 * rate1) + (60 * rate2) + ((units - 150) * rate3);
        }
        else if (units <= 240) {
            bill = (90 * rate1) + (60 * rate2) + (50 * rate3) + ((units - 200) * rate4);
        }
        else {
            bill = (90 * rate1) + (60 * rate2) + (50 * rate3) + (40 * rate4) + ((units - 240) * rate5);
        }

        return bill;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total units consumed: ");
        double units = sc.nextDouble();

        System.out.println("Total Electricity Bill: Rs. " + calculateBill(units));

        sc.close();
    }
}

