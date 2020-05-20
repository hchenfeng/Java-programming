package com.company;

public class Main {

    public static void main(String[] args) {

        // Point tests

        Point point = new Point();
        System.out.println("Empty constructor:");
        System.out.printf(" x:\n  Expected: 0\n  Actual: %s\n", point.getX());
        System.out.printf(" y:\n  Expected: 0\n  Actual: %s\n", point.getY());
        System.out.println();

        Point point1 = new Point(1, 2);
        System.out.println("Int constructor:");
        System.out.printf(" x:\n  Expected: 1\n  Actual: %s\n", point1.getX());
        System.out.printf(" y:\n  Expected: 2\n  Actual: %s\n", point1.getY());
        System.out.println();

        Point point2 = new Point("3,4");
        System.out.println("String constructor:");
        System.out.printf(" x:\n  Expected: 3\n  Actual: %s\n", point2.getX());
        System.out.printf(" y:\n  Expected: 4\n  Actual: %s\n", point2.getY());
        System.out.println();

        Point point3 = new Point(" ");
        System.out.println("Empty string constructor:");
        System.out.printf(" x:\n  Expected: 0\n  Actual: %s\n", point3.getX());
        System.out.printf(" y:\n  Expected: 0\n  Actual: %s\n", point3.getY());
        System.out.println();

        Point point4 = new Point(point1);
        System.out.println("Point param constructor:");
        System.out.printf(" x:\n  Expected: 1\n  Actual: %s\n", point4.getX());
        System.out.printf(" y:\n  Expected: 2\n  Actual: %s\n", point4.getY());
        System.out.println();

        point3.setX(6);
        point3.setY(8);

        System.out.println("To String:");
        System.out.printf("  Expected: (1,2)\n  Actual: %s\n", point1);
        System.out.printf("  Expected: (3,4)\n  Actual: %s\n", point2);
        System.out.printf("  Expected: (6,8)\n  Actual: %s\n", point3);
        System.out.printf("  Expected: (1,2)\n  Actual: %s\n", point4);
        System.out.println();

        System.out.println("Equals:");
        System.out.printf("  Expected: true\n  Actual: %s\n", point1.equals(point4));
        System.out.printf("  Expected: false\n  Actual: %s\n", point1.equals(point2));
        System.out.println();

        System.out.println("ManhattanDistance:");
        System.out.printf("  Expected: 7\n  Actual: %s\n", point.manhattanDistance(point2));
        System.out.println();

        // Line tests

        Line line = new Line(5, 6, 7, 8);
        System.out.println("Line constructor with int params:");
        System.out.printf("  Expected: [(5,6),(7,8)]\n  Actual: %s\n", line);
        System.out.println();

        Line line1 = new Line(point, point2);
        System.out.println("Line constructor with point params:");
        System.out.printf("  Expected: [(0,0),(3,4)]\n  Actual: %s\n", line1);
        System.out.println();

        System.out.printf("Slope of line %s:\n", line);
        System.out.printf("  Expected: 1.0\n  Actual:  %s\n", line.getSlope());
        System.out.println();

        System.out.printf("Distance between points on line %s:\n", line1);
        System.out.printf("  Expected: 5.0\n  Actual: %s\n", line1.getDistance());
        System.out.println();

        System.out.printf("Midpoint between points on line %s:\n", line);
        System.out.printf("  Expected: (6,7)\n  Actual: %s\n", line.getMidpoint());
        System.out.println();

        System.out.printf("Is line %s parallel to line %s?\n", line, line1);
        System.out.printf("  Expected: false\n  Actual: %s\n", line.parallelTo(line1));
        System.out.println();

        System.out.printf("Is line %s parallel to line %s?\n", line, line);
        System.out.printf("  Expected: true\n  Actual: %s\n", line.parallelTo(line));
        System.out.println();

        System.out.printf("Is line %s equal to line %s?\n", line, line1);
        System.out.printf("  Expected: false\n  Actual: %s\n", line.parallelTo(line1));
        System.out.println();

        System.out.printf("Is line %s equal to line %s?\n", line, line);
        System.out.printf("  Expected: true\n  Actual: %s\n", line.parallelTo(line));
        System.out.println();

        System.out.println("To String:");
        System.out.printf("  Expected: [(5,6),(7,8)]\n  Actual: %s\n", line.toString());
        System.out.printf("  Expected: [(0,0),(3,4)]\n  Actual: %s\n", line1.toString());
    }
}
