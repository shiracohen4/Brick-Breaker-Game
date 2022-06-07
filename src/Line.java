/**
 * @author Shira Cohen
 * ID: 209088368
 * This class defines a line.
 */

public class Line {
    private Point start;
    private Point end;

    /**
     * Constructor.
     * @param start This is the start point of the line.
     * @param end This is the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 2nd constructor.
     * @param x1 This is the x value of the start point of the line.
     * @param y1 This is the y value of the start point of the line.
     * @param x2 This is the x value of the end point of the line.
     * @param y2 This is the y value of the end point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Length of the line.
     * @return Returns the length of the line.
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * Middle of the line.
     * @return Returns the middle point of the line.
     */
    public Point middle() {
        return new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
    }

    /**
     * Start of line.
     * @return Returns the start point of the line.
     */
    public Point start() {
        return start;
    }

    /**
     * End of line.
     * @return Returns the end point of the line.
     */
    public Point end() {
        return end;
    }

    /**
     * Checks whether this line is a point.
     * @return Returns true if the line is a point, false otherwise.
     */
    public boolean isLineAPoint() {
        return (this.start.getX() == this.end.getX() && this.start.getY() == this.end.getY());
    }

    /**
     * Checks whether this line is vertical to the x axis.
     * @return Returns true if the line is vertical, false otherwise.
     */
    private boolean isLineVertical() {
        return (this.start.getX() == this.end.getX() && this.start.getY() != this.end.getY());
    }

    /**
     * Checks whether a point is on a vertical line.
     * @param point The point that is checked.
     * @param line The line that is checked.
     * @return Returns true if the point is on the line, false otherwise.
     */
    public boolean isPointOnVerticalLine(Line point, Line line) {
        if (point.start.getX() == line.start.getX()) {
            double bigY = Math.max(line.start.getY(), line.end.getY());
            double smallY = Math.min(line.start.getY(), line.end.getY());
            return (point.start.getY() <= bigY && point.start.getY() >= smallY);
        } else {
            return false;
        }
    }

    /**
     * Calculates the intersection point of a vertical line and a non-vertical line.
     * @param vertical The vertical line.
     * @param regular The non-vertical line.
     * @return Returns the intersection point if they intersect, and null otherwise.
     */
    private Point verticalLineWithRegularLineIntersection(Line vertical, Line regular) {
        double bigX = Math.max(regular.start.getX(), regular.end.getX());
        double smallX = Math.min(regular.start.getX(), regular.end.getX());
        if (vertical.start.getX() <= bigX && vertical.start.getX() >= smallX) {
            double m = (regular.end.getY() - regular.start.getY()) / (regular.end.getX() - regular.start.getX());
            double n = regular.start.getY() - (m * regular.start.getX());
            double yIntersection = (m * regular.start.getX()) + n;
            double bigY = Math.max(vertical.start.getY(), vertical.end.getY());
            double smallY = Math.min(vertical.start.getY(), vertical.end.getY());
            if (yIntersection <= bigY && yIntersection >= smallY) {
                return new Point(vertical.start.getX(), yIntersection);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Calculates the intersection point of a point and a line.
     * @param point The point.
     * @param regular The line (a non-vertical line).
     * @return Returns the intersection point if they intersect, and null otherwise.
     */
    public Point pointWithRegularLineIntersection(Line point, Line regular) {
        double m = (regular.end.getY() - regular.start.getY()) / (regular.end.getX() - regular.start.getX());
        double n = regular.start.getY() - (m * regular.start.getX());
        if (((m * point.start.getX()) + n) == point.start.getY()) {
            double bigX = Math.max(regular.start.getX(), regular.end.getX());
            double smallX = Math.min(regular.start.getX(), regular.end.getX());
            double bigY = Math.max(regular.start.getY(), regular.end.getY());
            double smallY = Math.min(regular.start.getY(), regular.end.getY());
            if (point.start.getX() <= bigX && point.start.getX() >= smallX) {
                if (point.start.getY() <= bigY && point.start.getY() >= smallY) {
                    return point.start;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Checks whether this line intersects with another line.
     * @param other The other line.
     * @return Returns true if the lines intersect, and false otherwise.
     */
    public boolean isIntersecting(Line other) {
        return this.intersectionWith(other) != null;
    }

    /**
     * Calculates the intersection point of this line and another line.
     * @param other The other line.
     * @return Returns the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        //two vertical lines
        if (this.isLineVertical() && other.isLineVertical()) {
            return null;
            //two points
        } else if (this.isLineAPoint() && other.isLineAPoint()) {
            if (this.start.equals(other.start)) {
                return this.start;
            } else {
                return null;
            }
            //one point and one vertical line
        } else if ((this.isLineAPoint() && other.isLineVertical()) || (other.isLineAPoint() && this.isLineVertical())) {
            if ((this.isLineAPoint() && other.isLineVertical())) {
                if (isPointOnVerticalLine(this, other)) {
                    return this.start;
                } else {
                    return null;
                }
            }
            if ((other.isLineAPoint() && this.isLineVertical())) {
                if (isPointOnVerticalLine(other, this)) {
                    return other.start;
                } else {
                    return null;
                }
            } //one vertical line and one regular line
        } else if (this.isLineVertical() && !other.isLineVertical() && !other.isLineAPoint()) {
            return verticalLineWithRegularLineIntersection(this, other);
        } else if (other.isLineVertical() && !this.isLineVertical() && !this.isLineAPoint()) {
            return verticalLineWithRegularLineIntersection(other, this);
            //one point and one regular line
        } else if (this.isLineAPoint() && !other.isLineVertical() && !other.isLineAPoint()) {
            return pointWithRegularLineIntersection(this, other);
        } else if (other.isLineAPoint() && !this.isLineVertical() && !this.isLineAPoint()) {
            return pointWithRegularLineIntersection(other, this);
            //common case
        } else {
            double m1 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
            double m2 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
            if (m1 == m2) {
                return null;
            } else {
                double n1 = this.start.getY() - (m1 * this.start.getX());
                double n2 = other.start.getY() - (m2 * other.start.getX());
                double xIntersect = (n2 - n1) / (m1 - m2);
                double yIntersect = (m1 * xIntersect) + n1;
                double bigX1 = Math.max(this.start.getX(), this.end.getX());
                double bigY1 = Math.max(this.start.getY(), this.end.getY());
                double smallX1 = Math.min(this.start.getX(), this.end.getX());
                double smallY1 = Math.min(this.start.getY(), this.end.getY());
                double bigX2 = Math.max(other.start.getX(), other.end.getX());
                double bigY2 = Math.max(other.start.getY(), other.end.getY());
                double smallX2 = Math.min(other.start.getX(), other.end.getX());
                double smallY2 = Math.min(other.start.getY(), other.end.getY());
                if (xIntersect <= bigX1 && xIntersect >= smallX1 && xIntersect <= bigX2 && xIntersect >= smallX2) {
                    if (yIntersect <= bigY1 && yIntersect >= smallY1 && yIntersect <= bigY2 && yIntersect >= smallY2) {
                        return new Point(xIntersect, yIntersect);
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * Compares this line to another line.
     * @param other The other line.
     * @return Returns true if the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        } else {
            return (this.start.equals(other.end) && this.end.equals(other.start));
        }
    }

    /**
     * Calculates an intersection point of a line and a rectangle.
     * (The closest one to the start of the line).
     * @param rect The rectangle.
     * @return If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        if (rect.intersectionPoints(this).size() == 0) {
            return null;
        } else if (rect.intersectionPoints(this).size() == 1) {
            return rect.intersectionPoints(this).get(0);
        } else if (rect.intersectionPoints(this).size() == 2) {
            Point first = rect.intersectionPoints(this).get(0);
            Point second = rect.intersectionPoints(this).get(1);
            if (first.distance(this.start) < second.distance(this.start)) {
                return first;
            }
            if (second.distance(this.start) < first.distance(this.start)) {
                return second;
            }
        }
        return null;
    }
}
