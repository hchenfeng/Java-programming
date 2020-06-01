package com.company;

import java.io.File;
import java.util.Scanner;

public class BookListDemo {

    public static void main(String[] args) {
        // create an object of BookList
        try {
            Scanner in = new Scanner(new File("src/proj2.txt"));
            int code;
            double price;
            String title;
            while (in.hasNextLine()) {

// read code
// read price
                // read title
// create a Book object with the input data in variables title, price, and code
// add it to the BookList object that you created earlier
            }
            in.close();
        } catch (Exception exception) {
            System.out.println("Error processing file: " + exception);
        }
// use methods of class BookList to manipulate the BookList object
// write the resulting book list into a text file


    }
}
