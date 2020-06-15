package com.company;

import java.util.*;

public class BookList {
    // holds a list of Book objects
    private final ArrayList<Book> books;

    // constructor
    public BookList() {
        this.books = new ArrayList<>();
    }

    // returns the size of the list
    public int getSize() {
        return books.size();
    }

    // inserts object book at its proper position
    public void addBook(Book book) {
        if ((getSize() == 0 || books.get(getSize() - 1).compareTo(book) <= 0)) {
            // If first book or new book code >= last book code in the arrayList (in ascending order),
            // just append new book to the end of the arrayList.
            books.add(book);
        } else if (books.get(getSize() - 1).compareTo(book) > 0) {
            // If new book code < last book code in the arrayList (in ascending order),
            // search book list until find book with equal or smaller code,
            // then insert book to position after the found position.
            for (int i = getSize() - 2; i >= 0; i--) {
                if (books.get(i).compareTo(book) <= 0) {
                    books.add(i + 1, book);
                    break;
                }
            }
        }
    }

    // removes the object with the given title
    // from the list if it is found
    public void removeBook(String title) {
        books.remove(findBook(title));
    }

    // returns the object with the given title
    // if it is found; otherwise returns null
    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // returns the total cost of all the books
    public double calcTotal() {
        double total = 0;
        for (Book book : books) {
            total += book.getPrice();
        }
        return total;
    }

    // returns a textual representation of all
    // the books in the list
    public String toString() {
        StringBuilder books = new StringBuilder();
        for (Book book : this.books) {
            books.append(String.format("%s %.2f %s%n", book.getCode(), book.getPrice(), book.getTitle()));
        }
        return books.toString();
    }
}
