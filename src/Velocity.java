/**
 * @author Shira Cohen
 * ID: 209088368
 * This class defines an object's velocity.
 */

public class Velocity {
    private double dx = 0;
    private double dy = 0;
    /**
     * Constructor.
     * @param dx The movement on the x axis.
     * @param dy The movement on the y axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * Returns the x axis movement.
     * @return Returns the movement on the x axis.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * Returns the y axis movement.
     * @return Returns the movement on the y axis.
     */
    public double getDy() {
        return this.dy;
    }
    /**
     * Takes a point with position (x,y) and returns a new point with position (x+dx, y+dy).
     * @param p The point this velocity is applied to.
     * @return Returns the point in the new position.
     */
    public Point applyToPoint(Point p) {
        return new Point((p.getX() + this.dx), (p.getY() + this.dy));
    }

    /**
     * An alternative constructor.
     * @param angle Gets the desired angle the object should move in.
     * @param speed Gets the desired speed of the object.
     * @return Returns the velocity according to the angle and the speed (calculates the dx and the dy values).
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //input validation
        if (angle < 0 || angle >= 360 || speed < 0) {
            return null;
        }
        double dx;
        double dy;
        if (angle == 0) {
            dx = 0;
            dy = -speed;
        } else if (angle == 90) {
            dx = speed;
            dy = 0;
        } else if (angle == 180) {
            dx = 0;
            dy = speed;
        } else if (angle == 270) {
            dx = -speed;
            dy = 0;
        } else {
            double tanAngle = Math.abs(Math.tan(Math.toRadians(angle - 90)));
            dx = Math.sqrt((speed * speed) / (1 + (tanAngle * tanAngle)));
            dy = dx * tanAngle;
            if (angle > 0 && angle < 90) {
                dy = -dy;
            } else if (angle > 180 && angle < 270) {
                dx = -dx;
            } else if (angle > 270 && angle <= 359) {
                dx = -dx;
                dy = -dy;
            }
        }
        return new Velocity(dx, dy);
    }
}
