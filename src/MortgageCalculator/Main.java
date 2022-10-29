package MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal: ", 1_000, 10_000_000);
        float annualInterest = (float) readNumber("Annual interest rate: ", 1, 50);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Monthly Payments: " + mortgageFormatted);


    }

    public static double readNumber (String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between" + min + "and" + max);
        }
        return value;
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGES = 100;

        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENTAGES;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double mortgage =
                principal
                * ((monthlyInterest * Math.pow(( 1 + monthlyInterest), numberOfPayments))
                / (Math.pow(( 1 + monthlyInterest), numberOfPayments) - 1 ));
        return mortgage;
    }

}