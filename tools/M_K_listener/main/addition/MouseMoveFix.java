package addition;

import static base.IFunctions.robot;

public class MouseMoveFix {
    public static void run(int x, int y, double screenScale) {
//        //1.8fix
//        robot.mouseMove(-1,-1);
//        robot.mouseMove((int) (x/screenScale), (int) (y/screenScale));
        //17
        robot.mouseMove(x, y);
    }

    public static void run(int x, int y) {
        //17
        robot.mouseMove(x, y);
    }
}
