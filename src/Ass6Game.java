//209088368

import biuoop.Sleeper;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class holds the main method that runs the game.
 */

public class Ass6Game {
    /**
     * The main method creates a Game object, initializes it and runs it.
     * @param args If provided, the levels are added to the game according to the arguments.
     */
    public static void main(String[] args) {

        List<LevelInformation> levels = new ArrayList<>();

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "1" -> levels.add(new DirectHit());
                    case "2" -> levels.add(new WideEasy());
                    case "3" -> levels.add(new Green3());
                    case "4" -> levels.add(new FinalFour());
                }
            }
        }

        if (levels.size() == 0) {
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Green3());
            levels.add(new FinalFour());
        }

        biuoop.GUI gui = new biuoop.GUI("GAME", 800, 600);

        GameFlow game = new GameFlow(new AnimationRunner(gui, 60, new Sleeper()),
                gui.getKeyboardSensor(),
                new Counter(0));

        game.runLevels(levels);
    }
}
