package com.company;

public class AmortizedLoan extends Loan {

    public AmortizedLoan(String name, double rate, int years, double amount) {
        super(name, rate, years, amount);
    }

    public void setLoanType() {
        loanType = 2;
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
                "%s%n" +
                        "%s" +
                        "%-20s%-5s%s%,.2f",
                "Full Amortized Loan",
                super.toString(),
                "Monthly Payment", ":", "$", monthlyPayment);
    }
}
