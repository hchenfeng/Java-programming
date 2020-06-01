package com.company;

import java.util.ArrayList;

public class BookList {
    // holds a list of Book objects
    private final ArrayList<Book> books;

    // constructor
    public BookList(ArrayList<Book> books) {
        this.books = books;
    }

    // returns the size of the list
    public int getSize() {
        return books.size();
    }

    // inserts object book at its proper position
    public void addBook(Book book) {
        books.add(book);
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
//    public String toString() { }
}
