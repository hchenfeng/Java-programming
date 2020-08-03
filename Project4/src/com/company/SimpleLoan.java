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
                "%s%n" +
                        "%s" +
                        "%-20s%-5s%s%,.2f",
                "Simple Interest Loan",
                super.toString(),
                "Monthly Payment", ":", "$", monthlyPayment);
    }
}
