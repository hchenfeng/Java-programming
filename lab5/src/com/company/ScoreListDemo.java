package com.company;

import java.util.Scanner;

public class ScoreListDemo {
    public static void main(String[] args) {
        ScoreList list = new ScoreList();
        String searchItem;


        try (Scanner scanner = new Scanner(System.in)) {

            // load the list with input values
            list.loadList(scanner);

            // report the number of scores in the list
            System.out.printf("There are %s score(s) in the list.%n", list.getSize());

            // prompt the user for a score, search the list
            System.out.println("Provide a score to search: ");
            do {
                searchItem = scanner.nextLine().trim();
            } while (searchItem.isEmpty());
        }

        // for the input score, and report the result
        if (list.findScore(Integer.parseInt(searchItem)) == -1) {
            System.out.println("Score not found.");
        } else {
            System.out.println("Score found.");
        }

        // display all the scores in the list
        System.out.printf("List of scores: %n%s", list.toString());
    }
}