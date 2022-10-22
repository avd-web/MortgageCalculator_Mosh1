package MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // declaring months/percentages
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGES = 100;
        int principal = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input Principal amount ($1K - $10M): ");
            principal = scanner.nextInt();
            if (principal >= 1_000 && principal <= 10_000_000)
                break;
            System.out.println("Enter a value between 1000 and 10000000");
        }

        // print output 1
        System.out.println("Principal amount: " + principal);


        System.out.print("Input annual interest rate (%): ");
        float monthlyInterest = scanner.nextFloat() / MONTHS_IN_YEAR / PERCENTAGES;

        System.out.print("Input number of years: ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;
        // print output 2
        System.out.println("Number of payments: " + numberOfPayments);

        // mortgage calculation
        double mortgage =
                        principal
                *
                ((monthlyInterest * Math.pow(( 1 + monthlyInterest), numberOfPayments))
                        /
                        (Math.pow(( 1 + monthlyInterest), numberOfPayments) - 1 ));

        // Format amount + print output 3
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Amount per payment " + mortgageFormatted);

        //test
    }

}