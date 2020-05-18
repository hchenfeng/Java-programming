package com.company;

public class Line {

    private Point p1, p2;

    /**
     * Initializes a newly created Line object with the given
     * values.
     *
     * @param x1 and x2 the x coordinates of p1 and p2
     * @param y1 and y2 the y coordinates of p1 and p2
     */
    public Line(int x1, int y1, int x2, int y2) {
        p1.setX(x1);
        p1.setY(y1);
        p2.setX(x2);
        p2.setY(y2);
    }

    /**
     * Initializes a newly created Line object with the values
     * from the two input Point objects.
     *
     * @param p1 and p2 two Point objects used to initialize
     *           this Line object
     */
    public Line(Point p1, Point p2) {
        if (p1 == p2) {
            throw new IllegalArgumentException("The two points used to define a line cannot be the same.");
        } else {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    /**
     * Calculate the slope of this Line object using the
     * formula (y1 - y2)/(x1 - x2)
     * <p>
     * slope of a vertical line is undefined, that is, x1 and x2
     * are equal, throw an ArithmeticException
     *
     * @return the slope of this Line object
     */
    public double getSlope() {
        if (p1.getX() == p2.getX()) {
            throw new ArithmeticException("Slope is undefined");
        } else {
            return ((double) p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
        }
    }

    /**
     * Calculate the distance between the two points of
     * this Line object
     *
     * @return the distance
     */
    public double getDistance() {
        return Math.sqrt(Math.pow(Math.abs(p1.getX() - p2.getX()), 2) + Math.pow(Math.abs(p1.getY() - p2.getY()), 2));
    }

    /**
     * Calculate the middle point of this Line object
     *
     * @return a Point object
     */
    public Point getMidpoint() {
        Point midPoint = new Point();
        midPoint.setX((p1.getX() - p2.getX()) / 2);
        midPoint.setY((p1.getY() - p2.getY()) / 2);
        return midPoint;
    }

    /**
     * two lines are parallel if they have the same slope, or
     * if they are both vertical. Note that two slopes are the
     * same if their difference is very small.
     *
     * @param line the other Line object
     * @return true if the objects are parallel; false
     * otherwise.
     */
    public boolean parallelTo(Line line) {
        if (p1.getX() == p2.getX() && line.p1.getX() == line.p2.getX()) {
            return true;
        } else return Math.abs(getSlope() - line.getSlope()) <= Math.ulp(Math.abs(getSlope() - line.getSlope()));
    }

    /**
     * Compares this object to the other object. The result is
     * true if and only if the argument is not null and is a
     * Line object with the same values as this Line object
     *
     * @param obj the object to compare with.
     * @return true if the objects are the same; false
     * otherwise.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Line) {
            return this.parallelTo((Line) obj) && (this.p1 == ((Line) obj).p1 || this.p2 == ((Line) obj).p2);
        }
        return false;
    }

    /**
     * Returns a String object that represents this Line
     *
     * @return a string representation of this Line's value.
     */
    public String toString() {
        return "[" + p1 + "," + p2 + "]";
    }
}
