package com.company;

import java.util.ArrayList;

public class LoanManager {
    private final ArrayList<Loan> loans;
    private int numberOfSimpleLoan=0;
    private int numberOfAmortizedLoan=0;
    private double totalAmountOfPrincipal=0;

    public LoanManager(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
        if (loan instanceof SimpleLoan) {
            numberOfSimpleLoan++;
        } else if (loan instanceof AmortizedLoan) {
            numberOfAmortizedLoan++;
        }
        totalAmountOfPrincipal += loan.principal;
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    public int getSize() {
        return loans.size();
    }

    public int getNumberOfSimpleLoan() {
        return numberOfSimpleLoan;
    }

    public int getNumberOfAmortizedLoan() {
        return numberOfAmortizedLoan;
    }

    public double getTotalAmountOfPrincipal() {
        return totalAmountOfPrincipal;
    }

    public Loan searchLoan(String name) {

        for (Loan l : loans) {
            if (l.name.equalsIgnoreCase(name)) {
                return l;
            }
        }
        return null;
    }

    public String generatedSaveText() {
        StringBuilder str = new StringBuilder();
        for (Loan l : loans) {
            str.append(String.format("%s %s %s %s %s%n",
                    l.getName(), l.getPrincipal(), l.getLength(), l.getInterestRate(), l.getLoanType()));
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "LoanManager{" +
                "loans=" + loans +
                '}';
    }
}
