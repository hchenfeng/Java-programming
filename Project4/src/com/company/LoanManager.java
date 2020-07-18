package com.company;

import java.util.ArrayList;

public class LoanManager {
    private ArrayList<Loan> loans;

    public LoanManager(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "LoanManager{" +
                "loans=" + loans +
                '}';
    }
}
