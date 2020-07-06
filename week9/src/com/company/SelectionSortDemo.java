package com.company;

import java.util.Arrays;
import java.util.Random;

/**
 * This program demonstrates the selection sort algorithm by
 * sorting an array that is filled with random numbers.
 */
public class SelectionSortDemo {
    public static void main(String[] args) {
        Random generator = new Random();
        int length = 10;
        Integer[] a = new Integer[length];
        Coin[] coins = new Coin[length];

        for (int i = 0; i < a.length; i++)
            a[i] = generator.nextInt(100);

        System.out.println("Unsorted List: " + Arrays.toString(a));

        SelectionSorter<Integer> sorter = new SelectionSorter<>(a);
        sorter.sort();

        System.out.println("Sorted List:   " + Arrays.toString(a));

        // Use random int to create a list of coins
        for (int i = 0; i < coins.length; i++) {
            switch (generator.nextInt(4)) {
                case 0:
                    coins[i] = new Coin(0.01, "penny");
                    break;
                case 1:
                    coins[i] = new Coin(0.05, "nickel");
                    break;
                case 2:
                    coins[i] = new Coin(0.10, "dime");
                    break;
                case 3:
                    coins[i] = new Coin(0.25, "quarter");
                    break;
            }
        }

        System.out.println();

        System.out.println("Unsorted Coins List: " + Arrays.toString(coins));

        SelectionSorter<Coin> coinSorter = new SelectionSorter<>(coins);
        coinSorter.sort();

        System.out.println("Sorted Coins List: " + Arrays.toString(coins));
    }
}


