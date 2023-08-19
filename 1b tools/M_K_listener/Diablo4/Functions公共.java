import java.awt.*;
import static java.awt.event.KeyEvent.*;

public class Functions公共 extends IFunctions{
    public static Color pixelColor;

    static {
        new MyThread("off") {
            @Override
            public void run() {
                while (true) {

                    pixelColor = robot.getPixelColor(609, 983);
//                    System.out.println(pixelColor);
                    if(Math.abs(pixelColor.getRed())<=54
//                    Math.abs(pixelColor.getRed()-237)<=10
//                    &&Math.abs(pixelColor.getGreen()-28)<=10
//                    &&Math.abs(pixelColor.getBlue()-36)<=10
                    ){

                        robot.keyPress(VK_Q);
                        robot.keyRelease(VK_Q);
                    }


                    pause(300);
                }
            }
        };
    }

    }