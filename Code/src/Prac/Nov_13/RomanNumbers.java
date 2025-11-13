package Prac.Nov_13;

import java.util.Scanner;

public class RomanNumbers {
    private void convert(int num) {
        if (num < 1 || num > 9999) {
            System.out.println("Out of Range");
            return;
        }
        String roman = "";

        // Thousands
        if (num >= 1000) {
            int thousands = num / 1000;

            if (thousands == 1) {
                roman += "M";
            }
            if (thousands == 2) {
                roman += "MM";
            }
            if (thousands == 3) {
                roman += "MMM";
            }
            if (thousands == 4) {
                roman += "MMMM";
            }
            if (thousands == 5) {
                roman += "MMMMM";
            }
            if (thousands == 6) {
                roman += "MMMMMM";
            }
            if (thousands == 7) {
                roman += "MMMMMMM";
            }
            if (thousands == 8) {
                roman += "MMMMMMMM";
            }
            if (thousands == 9) {
                roman += "MMMMMMMMM";
            }

            num = num % 1000;
        }

        // Hundreds
        if (num >= 100) {
            int hundreds = num / 100;

            if (hundreds == 1) {
                roman += "C";
            }
            if (hundreds == 2) {
                roman += "CC";
            }
            if (hundreds == 3) {
                roman += "CCC";
            }
            if (hundreds == 4) {
                roman += "CD";
            }
            if (hundreds == 5) {
                roman += "D";
            }
            if (hundreds == 6) {
                roman += "DC";
            }
            if (hundreds == 7) {
                roman += "DCC";
            }
            if (hundreds == 8) {
                roman += "DCCC";
            }
            if (hundreds == 9) {
                roman += "CM";
            }

            num = num % 100;
        }

        // Tens

        if (num >= 10) {
            int tens = num / 10;

            if (tens == 1) {
                roman += "X";
            }
            if (tens == 2) {
                roman += "XX";
            }
            if (tens == 3) {
                roman += "XXX";
            }
            if (tens == 4) {
                roman += "XL";
            }
            if (tens == 5) {
                roman += "L";
            }
            if (tens == 6) {
                roman += "LX";
            }
            if (tens == 7) {
                roman += "LXX";
            }
            if (tens == 8) {
                roman += "LXXX";
            }
            if (tens == 9) {
                roman += "XC";
            }

            num = num % 10;
        }

        // Ones
        if (num >= 1) {
            if (num == 1) {
                roman += "I";
            }
            if (num == 2) {
                roman += "II";
            }
            if (num == 3) {
                roman += "III";
            }
            if (num == 4) {
                roman += "IV";
            }
            if (num == 5) {
                roman += "V";
            }
            if (num == 6) {
                roman += "VI";
            }
            if (num == 7) {
                roman += "VII";
            }
            if (num == 8) {
                roman += "VIII";
            }
            if (num == 9) {
                roman += "IX";
            }
        }
        System.out.println("Roman: "+roman);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int num = sc.nextInt();

        RomanNumbers rn = new RomanNumbers();
        rn.convert(num);

        sc.close();
    }
}
