package com.company;

import javax.swing.*;

public class Project4 {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void createAndShowGUI() {
        new LoanForm();
    }
}
