package com.company;

public class Main {

    public static void main(String[] args) {

        Point point = new Point();

        Point point1 = new Point(1, 2);
        Point point2 = new Point("3,4");
        Point point3 = new Point(" ");
        Point point4 = new Point(point1);

        System.out.println(point.getX());
        System.out.println(point.getY());

        point3.setX(6);
        point3.setY(8);

        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
        System.out.println(point4);

        System.out.println("Expected: true");
        System.out.println("Actual: " + point.equals(point));
        System.out.println("Expected: false");
        System.out.println("Actual: " + point.equals(point2));
        System.out.println("Expected: 7");
        System.out.println("Actual: " + point.manhattanDistance(point2));


        Line line = new Line(1, 2, 3, 4);
        Line line1 = new Line(point1, point2);
        System.out.println(line.getSlope());
        System.out.println(line1.getDistance());
        System.out.println(line.getMidpoint());
        System.out.println(line.parallelTo(line1));
        System.out.println(line.equals(line1));
        System.out.println(line.toString());
    }
}
