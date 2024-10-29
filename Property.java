/*
 * Class: CMSC203 
 * Instructor: Huseyin
 * Description: Represents a rectangular land plot with dimensions and position.
 * Due: 10/28/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Valentin Gabriel Paz
 */
package application;

public class Property {
    private String name, city, owner; // Name, city, and owner of the property
    private double rent;              // Monthly rent of the property
    private Plot plot;                // The plot of land associated with the property

    // Default constructor initializes property with empty values and a default plot
    public Property() {
        this("", "", 0.0, "", new Plot());
    }

    // Copy constructor creates a deep copy of another Property object
    public Property(Property p) {
        this(p.name, p.city, p.rent, p.owner, new Plot(p.plot));
    }

    // Constructor initializes property with name, city, rent, and owner, using a default plot
    public Property(String name, String city, double rent, String owner) {
        this(name, city, rent, owner, new Plot());
    }

    // Constructor initializes property with full details including plot position and dimensions
    public Property(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        this(name, city, rent, owner, new Plot(x, y, width, depth));
    }

    // Private constructor to handle all field initialization
    private Property(String name, String city, double rent, String owner, Plot plot) {
        this.name = name;
        this.city = city;
        this.rent = rent;
        this.owner = owner;
        this.plot = plot;
    }

    // Getters for property details
    public String getName() { return name; }
    public String getCity() { return city; }
    public double getRent() { return rent; }
    public String getOwner() { return owner; }
    
    // Returns a copy of the plot to prevent modification of the original plot
    public Plot getPlot() { return new Plot(plot); }

    // Setters for property details
    public void setName(String name) { this.name = name; }
    public void setCity(String city) { this.city = city; }
    public void setRent(double rent) { this.rent = rent; }
    public void setOwner(String owner) { this.owner = owner; }

    // Returns a formatted string representing property attributes
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%.2f", name, city, owner, rent);
    }
}
