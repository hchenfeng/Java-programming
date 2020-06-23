package com.company;

public abstract class Loan {
    protected String name; // the applicant’s name
    protected double interestRate; // the annual interest rate
    protected int length;  // the length of the load in years
    protected double principle;  // the principle
    protected double monthlyPayment;  // the monthly payment

    public Loan(String name, double rate, int years, double amount) {
        // constructor
    }

    public String process() {// a template method
        // call method calcMonthlyPayment()
        // call method makeSummary()
        // return the summary
        return "";
    }

    abstract public void calcMonthPayment(); //an abstract method

    public String makeSummary() {
        //make and return a summary on the loan
        return null;
    }

    public String toString() {
        return "Loan";
    }
}


