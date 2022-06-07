/**
 * @author Shira Cohen
 * ID: 209088368
 * This class defines a point.
 */

public class Point {
    private double x;
    private double y;
    /**
     * Constructor.
     * @param x This is the x value of the point.
     * @param y This is the y value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Distance between this point and another point.
     * @param other The other point.
     * @return Returns the distance between the two points.
     */
    public double distance(Point other) {
        double dis = ((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y));
        return Math.sqrt(dis);
    }
    /**
     * Compares this point to another point.
     * @param other The other point.
     * @return Returns true if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return (this.x == other.x && this.y == other.y);
    }
    /**
     * Returns x value.
     * @return Returns the x value of this point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * Returns y value.
     * @return Returns the y value of this point.
     */
    public double getY() {
        return this.y;
    }
}
