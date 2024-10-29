/*
 * Class: CMSC203 
 * Instructor: Huseyin
 * Description: Represents a rectangular land plot with dimensions and position.
 * Due: 10/28/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Valentin Gabriel Paz
*/

package application;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PlotTestValentinPaz {

    private Plot plotA, plotB, plotC;

    @Before
    public void setUp() {
        plotA = new Plot(0, 0, 5, 5);       // Plot at (0,0) with width and depth of 5
        plotB = new Plot(1, 1, 2, 2);       // Smaller plot inside plotA
        plotC = new Plot(6, 6, 3, 3);       // Plot outside of plotA
    }

    @Test
    public void testDefaultConstructor() {
        Plot defaultPlot = new Plot();
        assertEquals(0, defaultPlot.getX());
        assertEquals(0, defaultPlot.getY());
        assertEquals(1, defaultPlot.getWidth());
        assertEquals(1, defaultPlot.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Plot copyPlot = new Plot(plotA);
        assertEquals(plotA.getX(), copyPlot.getX());
        assertEquals(plotA.getY(), copyPlot.getY());
        assertEquals(plotA.getWidth(), copyPlot.getWidth());
        assertEquals(plotA.getDepth(), copyPlot.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        Plot paramPlot = new Plot(2, 3, 6, 7);
        assertEquals(2, paramPlot.getX());
        assertEquals(3, paramPlot.getY());
        assertEquals(6, paramPlot.getWidth());
        assertEquals(7, paramPlot.getDepth());
    }

    @Test
    public void testOverlaps() {
        assertTrue(plotA.overlaps(plotB));  // plotB is inside plotA, so they overlap
        assertFalse(plotA.overlaps(plotC)); // plotA and plotC do not overlap
    }

    @Test
    public void testEncompasses() {
        assertTrue(plotA.encompasses(plotB));  // plotA fully encompasses plotB
        assertFalse(plotA.encompasses(plotC)); // plotA does not encompass plotC
    }

    @Test
    public void testSetAndGetX() {
        plotA.setX(10);
        assertEquals(10, plotA.getX());
    }

    @Test
    public void testSetAndGetY() {
        plotA.setY(15);
        assertEquals(15, plotA.getY());
    }

    @Test
    public void testSetAndGetWidth() {
        plotA.setWidth(8);
        assertEquals(8, plotA.getWidth());
    }

    @Test
    public void testSetAndGetDepth() {
        plotA.setDepth(9);
        assertEquals(9, plotA.getDepth());
    }

    @Test
    public void testToString() {
        assertEquals("0,0,5,5", plotA.toString());
    }
}
