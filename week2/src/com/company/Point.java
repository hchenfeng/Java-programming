package com.company;

public class Point {
    private int x;
    private int y;

    /**
     * Initializes a newly created Point object with x and y coordinates set to 0.
     */
    public Point() {
    }

    /**
     * Initializes a newly created Point object with the given values.
     *
     * @param x the x coordinate of this point
     * @param y the y coordinate of this point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Initializes a newly created Point object with the values from the input Point object.
     *
     * @param other a Point object used to initialize this Point object
     */
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
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

    /**
     * Returns a String object that represents this Point as,
     * for example, (5, 3) if x is 5 and y is 3.
     *
     * @return a string representation of this Point's value.
     */
    public String toString() {
        // TO DO
        return String.format("(%s, %s)", x, y);
    }

    /**
     * Compares this object to the other object. The result is true if and
     * only if the argument is not null and is a Point object that contains the
     * same values as this Point object.
     *
     * @param other the object to compare with.
     * @return true if the objects are the same; false otherwise.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Point))
            return false;
        Point p = (Point) other;

        // Write code for the rest of this method below
        return this.x == p.x && this.y == p.y;
    }
}
