package com.company;

import java.util.Scanner;

public class LoanApplication {
    private Loan loan;

    public void run() {
        while (true) {

            // prompt the user for information about the new loan
            System.out.println("Select a loan type:");
            System.out.println("1. Simple Interest Loan");
            System.out.println("2. Amortized Loan");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            while (!(input.equals("1") || input.equals("2") || input.equals("0"))) {
                System.out.println("Enter 1 or 2 as a selection.");
                input = scanner.nextLine().trim();
            }

            String loanOption = input;

            // Break out of the loop if input is 0
            if (input.equals("0")) {
                break;
            }

            // Get name
            System.out.println("Enter Applicant's Name:");
            String name = scanner.nextLine();

            // Get annual interest rate
            System.out.println("Enter Annual Interest Rate: ");
            input = scanner.nextLine().trim();
            while (!input.matches("^(?:0*(?:\\.\\d+)?|1(\\.0*)?)$")) {
                System.out.println("Enter a number between 0 and 1 (a reasonable assumption about interest rate):");
                input = scanner.nextLine().trim();
            }
            String annualInterestRate = input;

            // Get length of loan
            System.out.println("Enter Length of the Loan in Years");
            input = scanner.nextLine().trim();
            while (!(input.matches("^[+]?([0-9]+(?:[.][0-9]*)?)$"))) {
                System.out.println("Enter a positive number for the length of the loan:");
                input = scanner.nextLine().trim();
            }
            String lengthOfLoanInYears = input;

            // Get principal amount
            System.out.println("Enter Principal Amount: ");
            input = scanner.nextLine().trim();
            while (!(input.matches("^[+]?([0-9]+(?:[.][0-9]*)?)$"))) {
                System.out.println("Enter a positive number for the principal amount:");
                input = scanner.nextLine().trim();
            }
            String principalAmount = input;

            // if it is a simple interest loan
            // create an instance of SimpleLoan and assign it to data field loan
            // else
            // create an instance of AmortizedLoan and assign it to data field loan
            // call method process() for the Loan object
            if (loanOption.equals("1")) {
                loan = new SimpleLoan(name, Double.parseDouble(annualInterestRate),
                        Integer.parseInt(lengthOfLoanInYears), Double.parseDouble(principalAmount));
            } else {
                loan = new AmortizedLoan(name, Double.parseDouble(annualInterestRate),
                        Integer.parseInt(lengthOfLoanInYears), Double.parseDouble(principalAmount));
            }

            // call the static method getSpooler() for class PrintSpooler to get
            // a reference to the only instance of it
            // call method printDocument for the instance with data field summary as
            // a parameter
            PrintSpooler.getSpooler().printDocument(loan.toString());
        }
    }
}
