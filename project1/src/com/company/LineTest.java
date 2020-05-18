package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void testConstructorWithIntParams() {
        Line line = new Line(1, 2, 3, 4);
        assertEquals("[(1,2),(3,4)]", line.toString());
    }

    @Test
    public void testConstructorWithPointParams() {
        Point p = new Point(1, 2);
        Point q = new Point(3, 4);
        Line line = new Line(p, q);
        assertEquals("[(1,2),(3,4)]", line.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithSamePointParam() {
        Point p = new Point(3, 4);
        Line line = new Line(p, p);
    }

    @Test
    public void testGetSlopeZero() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(5, 4);
        Line line = new Line(p1, p2);
        assertEquals(0, line.getSlope(), Math.ulp(line.getSlope()));
    }

    @Test
    public void testGetSlope() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 3);
        Line line = new Line(p1, p2);
        assertEquals(1, line.getSlope(), Math.ulp(line.getSlope()));
    }

    @Test
    public void testGetDistance() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(0, 0);
        Line line = new Line(p1, p2);
        assertEquals(5, line.getDistance(), Math.ulp(line.getDistance()));
    }

    @Test
    public void testGetMidpoint() {
        Point p1 = new Point(6, 8);
        Point p2 = new Point(0, 0);
        Line line = new Line(p1, p2);
        assertEquals(new Point(3, 4), line.getMidpoint());

        Point p3 = new Point(-6, -8);
        Line line1 = new Line(p1, p3);
        assertEquals(p2, line1.getMidpoint());
    }

    @Test
    public void testParallelToWithTwoVerticalLines() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(3, 4);
        Point p4 = new Point(3, 5);
        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p3, p4);
        assertTrue(line1.parallelTo(line2));
    }

    @Test
    public void testParallelToTrue() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(6, 8);
        Point p3 = new Point(0, 4);
        Point p4 = new Point(-3, 0);
        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p3, p4);
        assertTrue(line1.parallelTo(line2));
    }

    @Test
    public void testParallelToFalse() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(5, 8);
        Point p3 = new Point(0, 4);
        Point p4 = new Point(-3, 0);
        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p3, p4);
        assertFalse(line1.parallelTo(line2));
    }

    @Test
    public void testEqualsTrue() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(6, 8);
        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p1, p2);
        assertTrue(line1.equals(line2));
    }

    @Test
    public void testEqualsFalse() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(6, 8);
        Point p3 = new Point(1, 2);
        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p1, p3);
        assertFalse(line1.equals(line2));
    }

    @Test
    public void testToString() {
        Point p1 = new Point(6, 8);
        Point p2 = new Point(0, 0);
        Line line = new Line(p1, p2);
        assertEquals("[(6,8),(0,0)]", line.toString());
    }

}