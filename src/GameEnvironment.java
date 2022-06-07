import java.util.ArrayList;
import java.util.List;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class holds a collection of objects (collidables) the ball can collide with during the game.
 * The ball will know the game environment, and will use it to check for collisions and direct its movement.
 */
public class GameEnvironment {
    private List<Collidable> collidables = new ArrayList<>();

    /**
     * Adds a given collidable to the environment.
     * @param c The collidable.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Gets the closest collision of the ball with another object.
     * @param trajectory The path the ball will move in.
     * @return If the ball will not collide with any of the collidables in this collection, return null.
     * Else, return the information about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        double thisDis;
        double shortestDis = 0;
        Point possiblePoint;
        int index = -1;
        for (int i = 0; i < collidables.size(); i++) {
            possiblePoint = trajectory.closestIntersectionToStartOfLine(collidables.get(i).getCollisionRectangle());
            if (possiblePoint != null) {
                thisDis = trajectory.start().distance(possiblePoint);
                if (thisDis < shortestDis || shortestDis == 0) {
                    shortestDis = thisDis;
                    index = i;
                }
            }
        }
        if (index == -1) {
            return null;
        } else {
            possiblePoint = trajectory.closestIntersectionToStartOfLine(collidables.get(index).getCollisionRectangle());
            return new CollisionInfo(possiblePoint, collidables.get(index));
        }
    }

    /**
     * Gets the collidables collection.
     * @return Returns the collidables collection.
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }

    /**
     * Removes a collidable object from a GameEnvironment object.
     * @param c The collidable object.
     */
    public void removeCollidableGameEnv(Collidable c) {
        this.collidables.remove(c);
    }
}