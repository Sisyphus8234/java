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
    public static boolean t1Temp1 = false;

    public static int red=999;

    static {
        t1 = new MyThread(MyThread.State.off) {
            @Override
            public void run() {
                while (true) {
                    if (自动喝药 == true) {
                        pixelColor = robot.getPixelColor(625, 985);

//
//                        System.out.println(pixelColor);
//                        if(pixelColor.getRed()<red){
//                            red=pixelColor.getRed();
//                        }
//                        System.out.println(red);



                        if (
                                pixelColor.getRed() < 122
                        ) {
                            robot.keyRelease(VK_0);
                            robot.keyPress(VK_0);
                            robot.keyRelease(VK_0);
//                            t1Temp1=true;
//
//                            if(t1Temp1==true){
//                                pause(700L);
//                                t1Temp1=false;
//                            }

                        }
                    } else {
                        this.mySuspend();
                    }


                    pause(500);
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
        自动喝药 = true;
        t1.myResume();
    }

    @ListenMouseKeyboard(value = 117, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "t",value = 84, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "c",value = 67, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 自动喝药1() {
        自动喝药 = false;
    }

//    @ListenMouseKeyboard(note = "q",value = 81, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 自动喝药2() {
//        t1Temp1=true;
//    }


    @ListenMouseKeyboard(note = "`", value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 人物详情() {
        robot.keyPress(VK_C);
        robot.keyRelease(VK_C);
        Point point = MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(1355, 264);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(point.x, point.y);
    }


}