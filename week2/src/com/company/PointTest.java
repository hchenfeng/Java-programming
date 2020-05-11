package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    Point p1;
    Point p2;
    Point p3;

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
    }

    @Test
    public void testWithParamConstructor() {
        Point p = new Point(1, 2);
        assertNotEquals(null, p);
        assertEquals(p, new Point(1, 2));
    }

    @Test
    public void testWithPointParamConstructor() {
        Point p = new Point(p1);
        assertNotEquals(null, p);
        assertEquals(p1, p);
    }

    @Test
    public void testGetX() {
        assertEquals(3, p1.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(4, p1.getY());
    }

    @Test
    public void testToString() {
        assertEquals("(3, 4)", p1.toString());
    }

    @Test
    public void testEquals() {
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
    }
}