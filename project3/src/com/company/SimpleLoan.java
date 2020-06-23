package com.company;

public class SimpleLoan extends Loan {

    public SimpleLoan(String name, double rate, int years, double amount) {
        super(name, rate, years, amount);
    }

    public void calcMonthPayment() {
        // calculate the monthly payment using the appropriate formula
        // assign the result to the data field monthlyPayment
    }

    public String toString() {
        return "Simple Interest Loan";
    }
}
