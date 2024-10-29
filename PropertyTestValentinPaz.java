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

public class PropertyTestValentinPaz {

    private Property propertyA, propertyB;

    @Before
    public void setUp() {
        propertyA = new Property("Lake House", "Lakeside", 2500, "John Doe");
        propertyB = new Property("Mountain Cabin", "Mountain View", 1800, "Jane Smith", 5, 5, 3, 3);
    }

    @Test
    public void testDefaultConstructor() {
        Property defaultProperty = new Property();
        assertEquals("", defaultProperty.getPropertyName());
        assertEquals("", defaultProperty.getCity());
        assertEquals(0, defaultProperty.getRentAmount(), 0.01);
        assertEquals("", defaultProperty.getOwner());
        assertEquals("0,0,1,1", defaultProperty.getPlot().toString());
    }

    @Test
    public void testCopyConstructor() {
        Property copyProperty = new Property(propertyA);
        assertEquals(propertyA.getPropertyName(), copyProperty.getPropertyName());
        assertEquals(propertyA.getCity(), copyProperty.getCity());
        assertEquals(propertyA.getRentAmount(), copyProperty.getRentAmount(), 0.01);
        assertEquals(propertyA.getOwner(), copyProperty.getOwner());
        assertEquals(propertyA.getPlot().toString(), copyProperty.getPlot().toString());
    }

    @Test
    public void testParameterizedConstructorWithoutPlot() {
        assertEquals("Lake House", propertyA.getPropertyName());
        assertEquals("Lakeside", propertyA.getCity());
        assertEquals(2500, propertyA.getRentAmount(), 0.01);
        assertEquals("John Doe", propertyA.getOwner());
        assertEquals("0,0,1,1", propertyA.getPlot().toString());
    }

    @Test
    public void testParameterizedConstructorWithPlot() {
        assertEquals("Mountain Cabin", propertyB.getPropertyName());
        assertEquals("Mountain View", propertyB.getCity());
        assertEquals(1800, propertyB.getRentAmount(), 0.01);
        assertEquals("Jane Smith", propertyB.getOwner());
        assertEquals("5,5,3,3", propertyB.getPlot().toString());
    }

    @Test
    public void testSetPropertyName() {
        propertyA.setPropertyName("Updated House");
        assertEquals("Updated House", propertyA.getPropertyName());
    }

    @Test
    public void testSetCity() {
        propertyA.setCity("New City");
        assertEquals("New City", propertyA.getCity());
    }

    @Test
    public void testSetRentAmount() {
        propertyA.setRentAmount(3000);
        assertEquals(3000, propertyA.getRentAmount(), 0.01);
    }

    @Test
    public void testSetOwner() {
        propertyA.setOwner("Updated Owner");
        assertEquals("Updated Owner", propertyA.getOwner());
    }

    @Test
    public void testSetPlot() {
        propertyA.setPlot(2, 2, 4, 4);
        assertEquals("2,2,4,4", propertyA.getPlot().toString());
    }

    @Test
    public void testToString() {
        assertEquals("Lake House,Lakeside,John Doe,2500.0", propertyA.toString());
    }
}
