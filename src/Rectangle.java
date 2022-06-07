import java.util.ArrayList;
import java.util.List;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class defines a rectangle.
 */
public class Rectangle {
    private double width;
    private double height;
    private Point upperLeft;
    private Point upperRight;
    private Point lowerLeft;
    private Point lowerRight;
    private Line upperSide;
    private Line lowerSide;
    private Line leftSide;
    private Line rightSide;

    /**
     * Constructor.
     * @param upperLeft The upper left point of the rectangle.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.width = width;
        this.height = height;
        this.upperLeft = upperLeft;
        this.upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        this.lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        this.lowerRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        this.upperSide = new Line(upperLeft, upperRight);
        this.lowerSide = new Line(lowerLeft, lowerRight);
        this.leftSide = new Line(upperLeft, lowerLeft);
        this.rightSide = new Line(upperRight, lowerRight);
    }

    /**
     * Finds intersection points of the rectangle with a given line.
     * @param line The line the rectangle might intersect with.
     * @return Returns a (possibly empty) List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<>();
        if (this.upperSide.isIntersecting(line)) {
            intersectionPoints.add(this.upperSide.intersectionWith(line));
        }
        if (this.lowerSide.isIntersecting(line)) {
            intersectionPoints.add(this.lowerSide.intersectionWith(line));
        }
        if (this.leftSide.isIntersecting(line)) {
            intersectionPoints.add(this.leftSide.intersectionWith(line));
        }
        if (this.rightSide.isIntersecting(line)) {
            intersectionPoints.add(this.rightSide.intersectionWith(line));
        }
        return intersectionPoints;
    }

    /**
     * Returns the width of the rectangle.
     * @return Returns the width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the rectangle.
     * @return Returns the height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-left point of the rectangle.
     * @return Returns the upper-left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Returns the upper-right point of the rectangle.
     * @return Returns the upper-right point.
     */
    public Point getUpperRight() {
        return this.upperRight;
    }

    /**
     * Returns the lower-left point of the rectangle.
     * @return Returns the lower-left point.
     */
    public Point getLowerLeft() {
        return this.lowerLeft;
    }

    /**
     * Returns the lower-right point of the rectangle.
     * @return Returns the lower-right point.
     */
    public Point getLowerRight() {
        return this.lowerRight;
    }
}
