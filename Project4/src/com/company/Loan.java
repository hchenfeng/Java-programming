package com.company;

public abstract class Loan implements Comparable<Loan> {
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
    // loan type
    protected int loanType;

    public Loan(String name, double rate, int years, double amount) {
        // constructor
        this.name = name;
        this.interestRate = rate;
        this.length = years;
        this.principal = amount;
        setLoanType();
    }

    public abstract void setLoanType();

    public String getName() {
        return name;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getLength() {
        return length;
    }

    public double getPrincipal() {
        return principal;
    }

    public int getLoanType() {
        return loanType;
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

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public String makeSummary() {
        //make and return a summary on the loan
        return String.format(
                "%n%-20s%-5s%s%n" +
                        "%-20s%-5s%s%,.2f%n" +
                        "%-20s%-5s%,.2f%s%n" +
                        "%-20s%-5s%s%n",
                "Name", ":", name,
                "Principal", ":", "$", principal,
                "Annual Rate", ":", interestRate * 100,"%",
                "Loan Length (Years)", ":", length);
    }

    public String toString() {
        return process();
    }

    @Override
    public int compareTo(Loan o) {
        return this.name.compareToIgnoreCase(o.name);
    }
}


