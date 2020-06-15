package com.company;

import java.util.Scanner;

public class ScoreListDemo {
    public static void main(String[] args) {
        // Create a new score list with 50 spots.
        ScoreList list = new ScoreList();

        // Placeholder for a score to search.
        int searchItem = 0;

        // Try-with-resources closes the resource at the end of the statement.
        try (Scanner scanner = new Scanner(System.in)) {

            // load the list with input values
            list.loadList(scanner);

            // report the number of scores in the list
            System.out.printf("There are %s score(s) in the list.%n%n", list.getSize());

            // prompt the user for a score, search the list
            System.out.println("Provide a score to search: ");
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (!(line.matches("^\\d+$"))) {
                    System.out.println("Input needs to be a non-negative integer. Try again: ");
                } else {
                    searchItem = Integer.parseInt(line);
                    break;
                }
            }
        }

        // for the input score, and report the result
        if (list.findScore(searchItem) == -1) {
            System.out.println("Score not found.\n");
        } else {
            System.out.println("Score found.\n");
        }

        // display all the scores in the list
        System.out.printf("List of scores: %n%s", list.toString());
    }
}