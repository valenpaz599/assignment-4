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

public class ManagementCompany {
    private String name, taxID;               // Company name and tax ID
    private double feePercent;                // Percentage fee charged by the company
    private static final int MAX_PROPERTIES = 5;      // Maximum properties the company can manage
    private static final int DEFAULT_WIDTH = 10, DEFAULT_DEPTH = 10; // Default plot dimensions
    private Plot plot;                        // Plot representing the company’s management area
    private Property[] properties = new Property[MAX_PROPERTIES]; // Array to store managed properties
    private int propertyCount = 0;            // Current count of properties

    // Default constructor initializes company with empty name, tax ID, and feePercent 0
    public ManagementCompany() {
        this("", "", 0);
    }

    // Constructor initializes company with name, taxID, fee percentage, and default plot dimensions
    public ManagementCompany(String name, String taxID, double feePercent) {
        this(name, taxID, feePercent, 0, 0, DEFAULT_WIDTH, DEFAULT_DEPTH);
    }

    // Constructor initializes company with name, taxID, fee percentage, and specific plot dimensions
    public ManagementCompany(String name, String taxID, double feePercent, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.feePercent = feePercent;
        this.plot = new Plot(x, y, width, depth);
    }

    // Copy constructor creates a deep copy of another ManagementCompany
    public ManagementCompany(ManagementCompany other) {
        this(other.name, other.taxID, other.feePercent, other.plot.getX(), other.plot.getY(), 
             other.plot.getWidth(), other.plot.getDepth());
        for (int i = 0; i < other.propertyCount; i++) {
            this.properties[i] = new Property(other.properties[i]);
        }
        this.propertyCount = other.propertyCount;
    }

    // Returns a formatted summary of all properties managed by the company and total management fee
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Properties for " + name + " (Tax ID: " + taxID + ")\n");
        sb.append("_____________________________________________\n");
        for (int i = 0; i < propertyCount; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("_____________________________________________\n")
          .append("Total Management Fee: ").append(String.format("%.2f", calculateTotalFee()));
        return sb.toString();
    }

    // Adds a property to the company if within limits and not overlapping others
    public int addProperty(Property property) {
        if (propertyCount >= MAX_PROPERTIES) return -1; // Max capacity reached
        if (property == null) return -2;                // Null property
        if (!plot.encompasses(property.getPlot())) return -3; // Property out of bounds
        for (int i = 0; i < propertyCount; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) return -4; // Overlap detected
        }
        properties[propertyCount++] = new Property(property); // Add property
        return propertyCount - 1;
    }

    // Adds a property using name, city, rent, and owner details
    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    // Adds a property using full details including plot dimensions
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    // Returns a formatted string of a property at the specified index
    public String displayPropertyAtIndex(int index) {
        return (index >= 0 && index < propertyCount) ? properties[index].toString() : "Invalid index.";
    }

    // Finds the index of the property with the highest rent
    public int maxRentPropertyIndex() {
        if (propertyCount == 0) return -1;
        int maxIndex = 0;
        for (int i = 1; i < propertyCount; i++) {
            if (properties[i].getRentAmount() > properties[maxIndex].getRentAmount()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Returns the rent amount of the property with the highest rent
    public double maxRentProp() {
        int index = maxRentPropertyIndex();
        return index != -1 ? properties[index].getRentAmount() : 0;
    }

    // Calculates and returns the total rent of all properties
    public double totalRent() {
        double sum = 0;
        for (int i = 0; i < propertyCount; i++) {
            sum += properties[i].getRentAmount();
        }
        return sum;
    }

    // Returns the maximum rent property amount
    public double getHighestRentProperty() {
        return maxRentProp();
    }

    // Calculates the total management fee based on total rent and fee percentage
    private double calculateTotalFee() {
        return (totalRent() * feePercent) / 100;
    }
}
