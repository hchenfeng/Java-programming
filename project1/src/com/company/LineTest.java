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

    @Test
    public void testParallelTo() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testToString() {
    }
}