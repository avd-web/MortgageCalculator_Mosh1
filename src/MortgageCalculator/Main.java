package MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // declaring months/percentages
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGES = 100;

        // start program
        System.out.print("Input Principal amount: ");
        Scanner scanner = new Scanner(System.in);
        int principal = scanner.nextInt();
        // print output 1
        System.out.println("Principal amount: " + principal);


        System.out.print("Input interest rate (%): ");
        float monthlyInterest = scanner.nextFloat() / MONTHS_IN_YEAR / PERCENTAGES;
        // print output 2
        System.out.println("Monthly interest rate: " + monthlyInterest + "%");

        System.out.print("Input number of years: ");
        byte years = scanner.nextByte();
        // print output 3
        System.out.println("Number of payments: " +(years * MONTHS_IN_YEAR));

        // mortgage calculation
        double mortgage =
                        principal
                        *
                        ((monthlyInterest * Math.pow(( 1 + monthlyInterest), years))
                        /
                        (Math.pow(( 1 + monthlyInterest), years) - 1 ));

        // Format amount + print output 3
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Amount per payment " + mortgageFormatted);


    }

}