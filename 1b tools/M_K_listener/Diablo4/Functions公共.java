package custom;

import base.IFunctions;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

public class Functions公共 extends IFunctions {
    public static Color pixelColor;
    public static boolean 自动喝药 = false;
    public static MyThread t1;

    static {
        t1=new MyThread(MyThread.State.off) {
            @Override
            public void run() {
                while (true) {
                    if (自动喝药 == true) {
                        pixelColor = robot.getPixelColor(611, 993);
//                    System.out.println(pixelColor);
//                    85,14,18
                        System.out.println("------------pixelColor.getRed()");
                        System.out.println(pixelColor.getRed());
//
                        if (Math.abs(pixelColor.getRed() - 85) > 10
//                    Math.abs(pixelColor.getRed()-237)<=10
//                    &&Math.abs(pixelColor.getGreen()-28)<=10
//                    &&Math.abs(pixelColor.getBlue()-36)<=10
                        ) {

                            robot.keyPress(VK_Q);
                            robot.keyRelease(VK_Q);
                        }
                    }else {
                        this.mySuspend();
                    }


                    pause(1000);
                }
            }
        };
    }

    @ListenMouseKeyboard(value = 88, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 扔装备() {
        Point point = MouseInfo.getPointerInfo().getLocation();
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(1085, 699);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(point.x, point.y);
    }

    @ListenMouseKeyboard(value = 116, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 自动喝药() {
        自动喝药=true;
        t1.myResume();
    }

    @ListenMouseKeyboard(value = 117, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 自动喝药1() {
        自动喝药=false;
    }

    @ListenMouseKeyboard(note = "`",value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 人物详情() {
        robot.keyPress(VK_C);
        robot.keyRelease(VK_C);
        Point point=MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(1355,264);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(point.x,point.y);
    }


}