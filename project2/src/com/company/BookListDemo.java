package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BookListDemo {

    public static void main(String[] args) {

        String inputFilePath = "./src/proj2.txt";
        String outputFilePath = "./src/proj2Out.txt";
        File outputFile = new File(outputFilePath);

        // create an object of BookList
        BookList bookList = new BookList();

        File file = new File(inputFilePath);
        try (Scanner in = new Scanner(file)) {
            int code;
            double price;
            String title;
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] tokens = line.split(" ");
                String[] titleArray;
                int tokenLength = tokens.length;
                // read code
                code = Integer.parseInt(tokens[0]);
                // read price
                price = Double.parseDouble(tokens[1]);
                // read title
                titleArray = Arrays.copyOfRange(tokens, 2, tokenLength);
                title = String.join(" ", titleArray);

                // create a Book object with the input data in variables title, price, and code
                Book book = new Book(title, price, code);

                // add it to the BookList object that you created earlier
                bookList.addBook(book);
            }
        } catch (Exception exception) {
            System.out.println("Error processing file: " + exception);
        }
        // use methods of class BookList to manipulate the BookList object
        // write the resulting book list into a text file
        System.out.println(bookList.toString());
        writeToFile(bookList.toString(), outputFile);
    }


    private static void writeToFile(String input, File outputPath) {
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
