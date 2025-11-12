package Prac;

import java.util.Scanner;

public class BillCalculator2 {
    public void calculate(int units) {
        double billAmount = 0;
        double rate;

        // Slab 1: up to 90 units
        if (units <= 90) {
            rate = 1.0;
            billAmount = units * rate;
        }

        // Slab 2: 91 to 150 units
        if (units > 90) {
            rate = 1.0;
            billAmount = 90 * rate;

            if (units > 150) {
                rate = 1.5;
                billAmount += 60 * rate;
            } else {
                rate = 1.5;
                billAmount += (units - 90) * rate;
            }
        }

        // Slab 3: 151 to 200 units
        if (units > 150) {
            rate = 2.0;

            if (units > 200) {
                billAmount += 50 * rate;
            } else {
                billAmount += (units - 150) * rate;
            }
        }

        // Slab 4: 201 to 240 units
        if (units > 200) {
            rate = 2.5;

            if (units > 240) {
                billAmount += 40 * rate;
            } else {
                billAmount += (units - 200) * rate;
            }
        }

        // Slab 5: above 240 units
        if (units > 240) {
            rate = 3.0;
            billAmount += (units - 240) * rate;
        }

        System.out.println("Total Bill Amount: Rs. " + billAmount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total units consumed: ");
        int units = sc.nextInt();

        BillCalculator2 obj = new BillCalculator2();
        obj.calculate(units);

        sc.close();
    }
}
