package com.company;

public class Point {

    private int x;
    private int y;

    /**
     * Initializes a newly created Point object with x and y
     * coordinates set to 0.
     */
    public Point() {
    }

    /**
     * Initializes a newly created Point object with the given
     * values.
     *
     * @param x the x coordinate of this point
     * @param y the y coordinate of this point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Initializes a newly created Point object with the values
     * from the input string. Throws an IllegalArgumentException
     * if parameter str is a null reference or contains more
     * than two values; sets both instance variables to zero if
     * str contains nothing but space characters.
     *
     * @param str string containing values of coordinates, such
     *            as "10,20".
     */
    public Point(String str) {
        String[] inputFields;
        if (str == null) {
            throw new IllegalArgumentException("Input is null.");
        } else if (str.split(",", 2).length > 2) {
            throw new IllegalArgumentException("Input contains more that 2 values.");
        } else if (str.matches(" +")) {
            this.x = 0;
            this.y = 0;
        } else if (str.matches("^([1-9])*([0-9]),([1-9])*([0-9])$")) {
            inputFields = str.split(",", 2);
            this.x = Integer.parseInt(inputFields[0]);
            this.y = Integer.parseInt(inputFields[1]);
        } else {
            throw new IllegalArgumentException("Expected input format should be like \"3,4\".");
        }
    }

    /**
     * Initializes a newly created Point object with the values
     * from the input Point object.
     *
     * @param other a Point object used to initialize this Point
     *              object
     */
    public Point(Point other) {
        if (other == null) {
            throw new NullPointerException("Other point is null.");
        } else {
            this.x = other.x;
            this.y = other.y;
        }
    }

    /**
     * Returns the x coordinate of this Point object.
     *
     * @return the x coordinate of this object.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of this Point object.
     *
     * @return the y coordinate of this object.
     */
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns a String object that represents this Point as,
     * for example, (5, 3) if x is 5 and y is 3.
     *
     * @return a string representation of this Point's value.
     */
    public String toString() {
        return String.format("(%s,%s)", x, y);
    }

    /**
     * Compares this object to the other object. The result is
     * true if and only if the argument is not null and is a
     * Point object that contains the same values as this Point
     * object.
     *
     * @param other the object to compare with.
     * @return true if the objects are the same; false
     * otherwise.
     */
    public boolean equals(Object other) {
        if (other instanceof Point) {
            return this.x == ((Point) other).x && this.y == ((Point) other).y;
        }
        return false;
    }

    /**
     * Returns the Manhattan distance between this Point object
     * and the other Point object.
     * <p>
     * Manhattan distance is the distance between two points if
     * you walk only in a horizontal or vertical direction.
     *
     * @param other the other Point object
     * @return the Manhattan distance between this and other
     * Point objects.
     */
    public int manhattanDistance(Point other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }
}