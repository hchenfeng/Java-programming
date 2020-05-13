package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    private Point p1;
    private Point p2;
    private Point p3;
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() {
        p1 = new Point(3, 4);
        p2 = new Point(3, 4);
        p3 = new Point(5, 6);
    }

    @Test
    public void testNoParamConstructor() {
        Point p = new Point();
        assertNotEquals(null, p);
        assertEquals(p, new Point(0, 0));
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    @Test
    public void testWithParamConstructor() {
        Point p = new Point(1, 2);
        assertNotEquals(null, p);
        assertEquals(p, new Point(1, 2));
        assertEquals(1, p.getX());
        assertEquals(2, p.getY());
    }

    @Test
    public void testWithPointParamConstructor() {
        Point p = new Point(p1);
        assertNotEquals(null, p);
        assertEquals(p1, p);
        assertEquals(p1.getX(), p.getX());
        assertEquals(p1.getY(), p.getY());
    }

    @Test
    public void testGetX() {
        assertEquals(3, p1.getX());
        assertEquals(3.0, p1.getX(), DELTA);
        assertEquals(5, p3.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(4, p1.getY());
        assertEquals(6, p3.getY());
        assertEquals(6.0, p3.getY(), DELTA);
    }

    @Test
    public void testToString() {
        Point p = new Point();
        Point q = new Point(p2);
        assertEquals("(0, 0)", p.toString());
        assertEquals("(3, 4)", q.toString());
        assertEquals("(3, 4)", p1.toString());
    }

    @Test
    public void testEquals() {
        assertFalse(p1.equals(null));
        assertTrue(p1.equals(p1));
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
    }
}