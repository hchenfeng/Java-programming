/**
 * ******************
 * Assignment 1, CIS 500
 * Chenfeng Hao
 * ******************/

package com.company;

import java.security.SecureRandom;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        // Pick 6 random numbers between 1 and 49 (inclusive)
        int[] number = secureRandom.ints(1, 50).distinct().limit(6).toArray();
        System.out.println("Play this combination--it'll make you rich!");
        System.out.println(Arrays.toString(number));
    }
}
