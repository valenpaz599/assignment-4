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

class Plot {
    private int x, y, width, depth; // Position and size of the plot

    // Default constructor initializes plot at (0,0) with width and depth of 1
    public Plot() {
        this(0, 0, 1, 1);
    }

    // Parameterized constructor allows custom position and dimensions
    public Plot(int x, int y, int width, int depth) {
        setCoordinates(x, y);
        setDimensions(width, depth);
    }

    // Copy constructor creates a new plot with the same attributes as another plot
    public Plot(Plot p) {
        this(p.x, p.y, p.width, p.depth);
    }

    // Checks if this plot overlaps with another plot
    public boolean overlaps(Plot p) {
        return (x < p.x + p.width && x + width > p.x &&
                y < p.y + p.depth && y + depth > p.y);
    }

    // Checks if this plot fully encompasses another plot
    public boolean encompasses(Plot p) {
        return (x <= p.x && y <= p.y &&
                x + width >= p.x + p.width &&
                y + depth >= p.y + p.depth);
    }

    // Sets the x and y coordinates of the plot
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Sets the width and depth of the plot
    public void setDimensions(int width, int depth) {
        this.width = width;
        this.depth = depth;
    }

    // Getters for position and dimensions
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getDepth() { return depth; }

    // Returns a formatted string representing the plot's attributes
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
