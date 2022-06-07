/**
 * @author Shira Cohen
 * ID: 209088368
 * This class holds information about a certain collision that will take place.
 */
public class CollisionInfo {
    private Point point;
    private Collidable object;

    /**
     * Constructor.
     * @param collisionPoint The point at which the collision occurs.
     * @param collisionObject The collidable object involved in the collision.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.point = collisionPoint;
        this.object = collisionObject;
    }

    /**
     * The point at which the collision occurs.
     * @return Returns the point.
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * The collidable object involved in the collision.
     * @return Returns the object.
     */
    public Collidable collisionObject() {
        return this.object;
    }

    /**
     * Checks whether the collision point is on the upper side of the collidable rectangle.
     * @return Returns true if it is, false otherwise.
     */
    public boolean isOnUpperSide() {
        double uLeftX = this.object.getCollisionRectangle().getUpperLeft().getX();
        double uRightX = this.object.getCollisionRectangle().getUpperRight().getX();
        double uSideY = this.object.getCollisionRectangle().getUpperLeft().getY();
        return (point.getX() <= uRightX && point.getX() >= uLeftX && point.getY() == uSideY);
    }

    /**
     * Checks whether the collision point is on the lower side of the collidable rectangle.
     * @return Returns true if it is, false otherwise.
     */
    public boolean isOnLowerSide() {
        double lLeftX = this.object.getCollisionRectangle().getLowerLeft().getX();
        double lRightX = this.object.getCollisionRectangle().getLowerRight().getX();
        double lSideY = this.object.getCollisionRectangle().getLowerLeft().getY();
        return (point.getX() <= lRightX && point.getX() >= lLeftX && point.getY() == lSideY);
    }

    /**
     * Checks whether the collision point is on the left side of the collidable rectangle.
     * @return Returns true if it is, false otherwise.
     */
    public boolean isOnLeftSide()  {
        double uLeftY = this.object.getCollisionRectangle().getUpperLeft().getY();
        double lLeftY = this.object.getCollisionRectangle().getLowerLeft().getY();
        double lSideX = this.object.getCollisionRectangle().getUpperLeft().getX();
        return (point.getY() <= lLeftY && point.getY() >= uLeftY && point.getX() == lSideX);
    }

    /**
     * Checks whether the collision point is on the right side of the collidable rectangle.
     * @return Returns true if it is, false otherwise.
     */
    public boolean isOnRightSide() {
        double uRightY = this.object.getCollisionRectangle().getUpperRight().getY();
        double lRightY = this.object.getCollisionRectangle().getLowerRight().getY();
        double rSideX = this.object.getCollisionRectangle().getUpperRight().getX();
        return (point.getY() <= lRightY && point.getY() >= uRightY && point.getX() == rSideX);
    }
}