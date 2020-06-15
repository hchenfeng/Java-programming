package com.company;

import java.util.Scanner;

/**
 * A ScoreList holds a sequence of integer values. It provides
 * several of the methods for manipulating a list of scores.
 */
public class ScoreList {

    private final int MaxLength = 50;
    private final int[] list;        // a list of scores
    private int size;        // the number of scores in list

    /**
     * Allocates an array of length 50 for the list.
     * Initializes size to zero to indicate an empty list.
     */
    public ScoreList() {
        list = new int[MaxLength];
        size = 0;
    }

    /**
     * Returns the actual number of scores in array list.
     *
     * @return the actual size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Reads scores into the array and keeps track of the number
     * Stops reading when the array is full or no more input.
     */
    public void loadList(Scanner scanner) {
        System.out.println("Please enter a non-negative integer as a score.");
        System.out.println("Press ENTER after each entry.");
        System.out.println("An empty line after any valid input would " +
                "signal an end to entering scores.");
        System.out.println("Enter score(s):");
        // Variable for registering if an input line is the first empty input.
        boolean firstEmpty = true;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Check if input is empty.
            if (line.isEmpty()) {
                if (firstEmpty) {
                    // If this is the first empty line or the empty line before any
                    // valid input, ask for a non-empty integer input.
                    System.out.println("Input needs to be a non-negative integer. Try again: ");
                } else {
                    // If this is not the first empty line, break out of the scanner loop.
                    break;
                }
            } else if (!(line.matches("^\\d+$"))) {
                // If input is not a non-negative integer, ask for retry.
                System.out.println("Input needs to be a non-negative integer. Try again: ");
            } else if (size < list.length) {
                list[size] = Integer.parseInt(line);
                size++;
                // Next empty line would end current scanner session.
                firstEmpty = false;
            } else {
                // If getting more than 50 scores, end scanner session.
                System.out.println("Cannot accept more than 50 scores.");
                break;
            }

        }
    }

    /**
     * Searches the list for a score and returns its index
     * if found in the list or -1 otherwise.
     *
     * @param num the target of the search
     * @return an array index or -1
     */
    public int findScore(int num) {
        for (int i = 0; i < size; i++) {
            int score = list[i];
            if (score == num) {
                return score;
            }
        }
        return -1;
    }

    /**
     * Converts a list of scores to a String.
     *
     * @return a String representation of the list
     */
    public String toString() {
        StringBuilder scores = new StringBuilder();
        for (int i = 0; i < size; i++) {
            scores.append(list[i]).append(" ");
        }
        return String.valueOf(scores);
    }
}
