package com.company;

public class SimpleLoan extends Loan {

    public SimpleLoan(String name, double rate, int years, double amount) {
        super(name, rate, years, amount);
    }

    public void calcMonthlyPayment() {
        // calculate the monthly payment using the appropriate formula
        // assign the result to the data field monthlyPayment
        monthlyPayment = (principal * (interestRate * length + 1)) / (length * 12);
    }

    public String toString() {
        return String.format(
                "Simple Interest Loan%n" +
                        "%s" +
                        "Monthly Payment         :      $ %,.2f",
                super.toString(), monthlyPayment);
    }
}
