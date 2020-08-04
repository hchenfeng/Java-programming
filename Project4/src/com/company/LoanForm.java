package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LoanForm extends JFrame {

    // control fields
    private JPanel window;
    private JRadioButton simpleRadioButton;
    private JRadioButton amortizedRadioButton;
    private final ButtonGroup loanTypeRadioButtonGroup = new ButtonGroup();
    private JTextField nameTextField;
    private JTextField principalTextField;
    private JTextField lengthTextField;
    private JComboBox<String> rateComboBox;
    private JButton addButton;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton summaryButton;
    private JButton saveButton;
    private JTextArea displayTextArea;
    private JLabel loanTypeLabel;
    private JLabel nameLabel;
    private JLabel principalLabel;
    private JPanel loanTypePanel;
    private JPanel textFieldsPanel;
    private JLabel lengthLabel;
    private JLabel rateLabel;
    private JLabel paymentLabel;
    private JLabel paymentDisplayLabel;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JLabel nameInputErrorLabel;
    private JLabel principalInputErrorLabel;
    private JLabel lengthInputErrorLabel;


    private int loanType;
    private String name;
    private String principal;
    private String length;
    private String rate;
    private double monthlyPayment;
    private Loan loanFound;


    public LoanForm() {

        JFrame frame = new JFrame("Loan Application");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(window);
//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        loanTypeRadioButtonGroup.add(simpleRadioButton);
        loanTypeRadioButtonGroup.add(amortizedRadioButton);

//        System.out.println(frame.getSize());

        LoanManager loanManager = new LoanManager(new ArrayList<>());

        String inputFilePath = "./src/loan.txt";
        String outputFilePath = "./src/loan.txt";
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        if (inputFile.exists()) {
            loadDataFromFile(inputFile, loanManager);
        }


        addButton.addActionListener(e -> {
//            loanType = getLoanType();
//            name = getNameText();
//            principal = getPrincipalText();
//            length = getLengthText();
//            rate = getRateComboBoxOption().trim().replace("%", "");

            getInput();
            Loan loan = null;

            if (loanType == 1) {
                loan = new SimpleLoan(name, Double.parseDouble(rate) / 100,
                        Integer.parseInt(length), Double.parseDouble(principal));
            } else if (loanType == 2) {
                loan = new AmortizedLoan(name, Double.parseDouble(rate) / 100,
                        Integer.parseInt(length), Double.parseDouble(principal));
            }

            loanManager.addLoan(loan);

//            System.out.println(loan.toString());

            monthlyPayment = loan.getMonthlyPayment();

            paymentDisplayLabel.setText(String.format("%.2f", monthlyPayment));

            displayTextArea.setText(loan.toString());

        });

        searchButton.addActionListener(e -> {
//            searchLoan();
            name = getNameText();

            loanFound = loanManager.searchLoan(name);
            if (loanFound == null) {
//                simpleRadioButton.setSelected(false);
//                amortizedRadioButton.setSelected(false);

                clearDisplay();
                JOptionPane.showMessageDialog(frame, String.format("Loan not found under name: %s.", name), "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                displayTextArea.setText(loanFound.toString());
                nameTextField.setText(loanFound.getName());
                principalTextField.setText(String.valueOf(loanFound.getPrincipal()));
                lengthTextField.setText(String.valueOf(loanFound.getLength()));

                paymentDisplayLabel.setText(String.valueOf(loanFound.getMonthlyPayment()));
            }

        });

        deleteButton.addActionListener(e -> {
//            deleteLoan();
            name = getNameText();
            Loan loan = loanManager.searchLoan(name);

            int response = JOptionPane.showConfirmDialog(frame, "Are you sure that you want to delete this loan?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                loanManager.removeLoan(loan);
                clearDisplay();
            } else if (response == JOptionPane.NO_OPTION) {

            } else if (response == JOptionPane.CLOSED_OPTION) {

            }


            System.out.println(loanManager.toString());

        });

        summaryButton.addActionListener(e -> {
            makeSummary(loanManager);
        });

        saveButton.addActionListener(e -> {
//            saveLoan();
            writeToFile(loanManager.generatedSaveText(), outputFile);
        });

        //
//        nameTextField.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                if (!getNameText().equals("t")) {
//                    paymentDisplayLabel.setText("test");
//                } else {
//                    paymentDisplayLabel.setText("");
//                }
//            }
//        });

    }

    private void getInput() {
        loanType = getLoanType();
        name = getNameText();
        principal = getPrincipalText();
        length = getLengthText();
        rate = getRateComboBoxOption().trim().replace("%", "");
    }

    private int getLoanType() {
        if (selectSimpleLoan()) {
            return 1;
        } else if (selectAmortizedLoan()) {
            return 2;
        }
        return 0;
    }

    private void clearDisplay() {
        loanTypeRadioButtonGroup.clearSelection();
        displayTextArea.setText("");
        nameTextField.setText("");
        principalTextField.setText("");
        lengthTextField.setText("");
        rateComboBox.setSelectedItem(null);
        paymentDisplayLabel.setText("");
        displayTextArea.setText("");
    }

    private String getNameText() {
        return nameTextField.getText();
    }

    private String getPrincipalText() {
        return principalTextField.getText();
    }

    private String getLengthText() {
        return lengthTextField.getText();
    }

    private boolean selectSimpleLoan() {
        return simpleRadioButton.isSelected();
    }

    private boolean selectAmortizedLoan() {
        return amortizedRadioButton.isSelected();
    }

    private String getRateComboBoxOption() {
        return Objects.requireNonNull(rateComboBox.getSelectedItem()).toString();
    }

    private void makeSummary(LoanManager loanManager) {
        String totalNumberOfLoans;
        String numberOfSimpleLoans;
        String numberOfAmortizedLoans;
        String totalAmountOfMoney;

        totalNumberOfLoans = String.valueOf(loanManager.getSize());
        numberOfSimpleLoans = String.valueOf(loanManager.getNumberOfSimpleLoan());
        numberOfAmortizedLoans = String.valueOf(loanManager.getNumberOfAmortizedLoan());
        totalAmountOfMoney = String.valueOf(loanManager.getTotalAmountOfPrincipal());

        String summary = String.format(
                "%s%n%n" +
                        "%-30s%s%s%n" +
                        "%-30s%s%s%n" +
                        "%-30s%s%s%n" +
                        "%-30s%s%s%n",
                "Loan Summary",
                "Total Number of Loans", ":", totalNumberOfLoans,
                "Number of Simple Loans", ":", numberOfSimpleLoans,
                "Number of Amortized Loans", ":", numberOfAmortizedLoans,
                "Amount of Money Borrowed", ":", totalAmountOfMoney);

        displayTextArea.setText(summary);
    }

    private void loadDataFromFile(File inputFile, LoanManager loanManager) {
        try (Scanner in = new Scanner(inputFile)) {

            String name;
            double principal;
            int length;
            double rate;
            int loanType;

            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] tokens = line.split(" ");
                Loan loan = null;

                name = tokens[0];
                principal = Double.parseDouble(tokens[1]);
                length = Integer.parseInt(tokens[2]);
                rate = Double.parseDouble(tokens[3]);
                loanType = Integer.parseInt(tokens[4]);

                if (loanType == 1) {
                    loan = new SimpleLoan(name, rate, length, principal);
                } else if (loanType == 2) {
                    loan = new AmortizedLoan(name, rate, length, principal);
                }

                loanManager.addLoan(loan);

            }
        } catch (Exception exception) {
            System.out.println("Error processing file: " + exception);
        }
    }

    private void writeToFile(String input, File outputPath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {
            fileOutputStream.write(input.getBytes());
            fileOutputStream.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
