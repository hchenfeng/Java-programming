package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static java.lang.Integer.parseInt;

public class GameFrame extends JFrame {

    private JButton start, guess;
    private JLabel inputLabel, outputLabel;
    private JTextField input;
    private JPanel parentPanel, inputPanel, buttonPanel;
    private GameModel model;

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 150;

    public GameFrame(GameModel model) {
        // create screen elements and add them to the frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Guess A Number Between 1 and 1,000");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        start = new JButton("Start");
        guess = new JButton("Guess");
        inputLabel = new JLabel("Enter your guess:");
        outputLabel = new JLabel("Click the start button to start a new game", JLabel.CENTER);
        final int fieldWidth = 7;
        input = new JTextField(fieldWidth);

        parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());

        inputPanel = new JPanel();
        buttonPanel = new JPanel();

        inputPanel.add(inputLabel);
        inputPanel.add(input);

        parentPanel.add(inputPanel, "North");

        buttonPanel.add(start);
        buttonPanel.add(guess);

        parentPanel.add(buttonPanel, "South");

        parentPanel.add(outputLabel, "Center");
        add(parentPanel);

        this.model = model;

        ActionListener listener = new ButtonListener();
        start.addActionListener(listener);
        guess.addActionListener(listener);

    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == start) {
                // actions when the start button is clicked
                model.start();

            } else {
                // actions when the other button is clicked
                int numGuess = parseInt(input.getText());
                outputLabel.setText(model.verify(numGuess));
            }
        }
    }
}

