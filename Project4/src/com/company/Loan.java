package com.company;

public abstract class Loan {
    // the applicant’s name
    protected String name;
    // the annual interest rate
    protected double interestRate;
    // the length of the loan in years
    protected int length;
    // the principal
    protected double principal;
    // the monthly payment
    protected double monthlyPayment;

    public Loan(String name, double rate, int years, double amount) {
        // constructor
        this.name = name;
        this.interestRate = rate;
        this.length = years;
        this.principal = amount;
    }

    public String process() {
        // a template method
        // call method calcMonthlyPayment()
        calcMonthlyPayment();
        // call method makeSummary()
        // return the summary
        return makeSummary();
    }

    abstract public void calcMonthlyPayment(); //an abstract method

    public String makeSummary() {
        //make and return a summary on the loan
        return String.format(
                "Name                    :      %s%n" +
                        "Principal               :      $ %,.2f%n" +
                        "Annual Interest Rate    :      %.2f %%%n" +
                        "Length of Loan in Years :      %s%n",
                name, principal, interestRate * 100, length);
    }

    public String toString() {
        return process();
    }
}


