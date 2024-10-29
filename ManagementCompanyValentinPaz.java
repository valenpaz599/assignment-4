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

public class ManagementCompanyValentinPaz {

    private ManagementCompany company;
    private Property property1, property2, property3;

    @Before
    public void setUp() {
        company = new ManagementCompany("Test Company", "12345", 10.0, 0, 0, 10, 10);
        property1 = new Property("Property One", "City A", 1200, "Owner A", 1, 1, 3, 3);
        property2 = new Property("Property Two", "City B", 1500, "Owner B", 5, 5, 3, 3);
        property3 = new Property("Property Three", "City C", 1000, "Owner C", 0, 0, 5, 5);
    }

    @Test
    public void testAddPropertyObject() {
        assertEquals(0, company.addProperty(property1));
        assertEquals(1, company.addProperty(property2));
        assertEquals(2, company.addProperty(property3));
    }

    @Test
    public void testAddPropertyWithDetails() {
        assertEquals(0, company.addProperty("Property Four", "City D", 1300, "Owner D"));
    }

    @Test
    public void testAddPropertyWithFullDetails() {
        assertEquals(0, company.addProperty("Property Five", "City E", 1100, "Owner E", 7, 7, 2, 2));
    }

    @Test
    public void testDisplayPropertyAtIndex() {
        company.addProperty(property1);
        assertEquals("Property One,City A,Owner A,1200.0", company.displayPropertyAtIndex(0));
        assertEquals("Invalid index.", company.displayPropertyAtIndex(5));
    }

    @Test
    public void testMaxRentProp() {
        company.addProperty(property1);
        company.addProperty(property2);
        company.addProperty(property3);
        assertEquals(1500, company.maxRentProp(), 0.01);
    }

    @Test
    public void testMaxRentPropertyIndex() {
        company.addProperty(property1);
        company.addProperty(property2);
        company.addProperty(property3);
        assertEquals(1, company.maxRentPropertyIndex());
    }

    @Test
    public void testTotalRent() {
        company.addProperty(property1);
        company.addProperty(property2);
        assertEquals(2700, company.totalRent(), 0.01);
    }

    @Test
    public void testGetHighestRentProperty() {
        company.addProperty(property1);
        company.addProperty(property2);
        assertEquals(1500, company.getHighestRentProperty(), 0.01);
    }

    @Test
    public void testToString() {
        company.addProperty(property1);
        String expectedOutput = "Properties for Test Company (Tax ID: 12345)\n" +
                                "_____________________________________________\n" +
                                "Property One,City A,Owner A,1200.0\n" +
                                "_____________________________________________\n" +
                                "Total Management Fee: 120.0";
        assertTrue(company.toString().contains(expectedOutput));
    }

    @Test
    public void testGetMAX_PROPERTY() {
        assertEquals(5, company.getMAX_PROPERTY());
    }
}

