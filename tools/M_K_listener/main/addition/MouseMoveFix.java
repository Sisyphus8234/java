package addition;

import static base.IFunctions.robot;

public class MouseMoveFix {
    public static void run(int x,int y){
        robot.mouseMove(-1,-1);
        robot.mouseMove(x, y);

    }}
