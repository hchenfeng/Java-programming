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
            System.out.println("Enter score(s):");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    return;
                } else if (size < list.length) {
                    list[size] = Integer.parseInt(line);
                    size++;
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
