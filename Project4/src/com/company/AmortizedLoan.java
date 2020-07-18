package com.company;

public class AmortizedLoan extends Loan {

    public AmortizedLoan(String name, double rate, int years, double amount) {
        super(name, rate, years, amount);
    }

    public void calcMonthlyPayment() {
        // calculate the monthly payment using the appropriate formula
        // assign the result to the data field monthlyPayment
        monthlyPayment = (principal * (interestRate / 12) *
                Math.pow(1 + interestRate / 12, length * 12)) /
                (Math.pow(1 + interestRate / 12, length * 12) - 1);
    }

    public String toString() {
        return String.format(
                "Full Amortized Loan\n" +
                        "%s" +
                        "Monthly Payment         :      $ %,.2f",
                super.toString(), monthlyPayment);
    }
}
