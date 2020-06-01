package com.company;

public class Book {
    private String title;
    private double price;
    private int code;

    public Book(String title, double price, int code) {
        this.title = title;
        this.price = price;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
