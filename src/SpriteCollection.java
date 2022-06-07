import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class holds a collection of sprites.
 */
public class SpriteCollection {
    private List<Sprite> sprites = new ArrayList<>();

    /**
     * Adds a given sprite to the sprites collection.
     * @param s The given sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * Calls timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < sprites.size(); i++) {
            this.sprites.get(i).timePassed();
        }
    }

    /**
     * Calls drawOn(d) on all sprites.
     * @param d The given surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < sprites.size(); i++) {
            this.sprites.get(i).drawOn(d);
        }
    }

    /**
     * Removes a Sprite object from a SpriteCollection object.
     * @param s The Sprite object.
     */
    public void removeSpriteSpriteCol(Sprite s) {
        this.sprites.remove(s);
    }
}