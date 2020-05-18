package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Point point = new Point();
        System.out.println(point.toString());
        Line line = new Line(point, point);
        System.out.println(line.toString());
    }
}
