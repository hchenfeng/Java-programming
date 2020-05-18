package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void testEmptyConstructor() {
        Point p = new Point();
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    @Test
    public void testIntConstructor() {
        Point p = new Point(5, 10);
        assertEquals(5, p.getX());
        assertEquals(10, p.getY());
    }

    @Test
    public void testStrConstructor() {
        Point p = new Point("5,10");
        assertEquals(5, p.getX());
        assertEquals(10, p.getY());
    }

    @Test
    public void testEmptyStringConstructor() {
        Point p = new Point("  ");
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    @Test
    public void testOtherPointConstructor() {
        Point p = new Point("5,10");
        Point q = new Point(p);
        assertEquals(5, p.getX());
        assertEquals(10, p.getY());
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointConstructor() {
        Point p = null;
        Point q = new Point(p);
    }

    @Test
    public void testToStringWithIntParams() {
        Point p = new Point(5, 10);
        assertEquals("(5,10)", p.toString());
    }

    @Test
    public void testToStringWithStringParams() {
        String str = "3,7";
        Point p = new Point(str);
        assertEquals("(3,7)", p.toString());
    }

    @Test
    public void testToStringWithPointParam() {
        Point p = new Point(5, 10);
        Point q = new Point(p);
        assertEquals("(5,10)", q.toString());
    }

    @Test
    public void testEqualsNull() {
        Point p = new Point(5, 10);
        assertEquals(false, p.equals(null));
    }

    @Test
    public void testEqualsSelf() {
        Point p = new Point(5, 10);
        Point q = new Point(5, 10);
        assertEquals(true, p.equals(q));
    }

    @Test
    public void testEqualsOther() {
        Point p = new Point(5, 10);
        Point q = new Point(10, 5);
        assertEquals(false, p.equals(q));
    }

    @Test
    public void testManhattanDistanceWithSelf() {
        Point p = new Point(10, 15);
        assertEquals(0, p.manhattanDistance(p));
    }

    @Test
    public void testManhattanDistanceBetweenTwoPoints() {
        Point p = new Point(5, 7);
        Point q = new Point(10, 15);
        assertEquals(13, p.manhattanDistance(q));
    }

    @Test
    public void testManhattanDistanceBetweenPointAndOrigin() {
        Point p = new Point(5, 7);
        Point q = new Point(0, 0);
        assertEquals(12, p.manhattanDistance(q));
    }

    @Test
    public void testManhattanDistanceBetweenPointsInDifferentQuadrant() {
        Point p = new Point(5, 7);
        Point q = new Point(0, -5);
        assertEquals(17, p.manhattanDistance(q));
    }
}