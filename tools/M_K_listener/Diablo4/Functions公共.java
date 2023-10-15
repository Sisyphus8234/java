package custom;

import addition.FunctionsAddition;
import base.IFunctions;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.*;
import java.time.LocalDateTime;

import static java.awt.event.KeyEvent.*;

public class Functions公共 extends IFunctions {

    public static boolean 自动喝药B = false;
    public static boolean TempT1B = false;
    public static LocalDateTime localDateTime = LocalDateTime.now();

    public static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();
    public static MyThread t1 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (自动喝药B == true) {
                    if (pixelColor.getPixelColorHSB(625, 990)[1] < 0.5F) {
                        robot.keyRelease(VK_0);
                        robot.keyPress(VK_0);
                        robot.keyRelease(VK_0);
                        TempT1B = true;
                        if (TempT1B == true) {
                            pause(600L);
                            TempT1B = false;
                        }
                    } else {
                        if (pixelColor.getPixelColorHSB(625, 950)[1] < 0.5F) {
                            if(LocalDateTime.now().getSecond() - localDateTime.getSecond()<0) {
                                System.out.println(LocalDateTime.now().getSecond() - localDateTime.getSecond());
                                System.out.println(LocalDateTime.now());
                                System.out.println(localDateTime);
                            }
                            if (LocalDateTime.now().getSecond() - localDateTime.getSecond() > 5) {
                                robot.keyRelease(VK_0);
                                robot.keyPress(VK_0);
                                robot.keyRelease(VK_0);
                                TempT1B = true;
                                if (TempT1B == true) {
                                    pause(1000L);
                                    TempT1B = false;
                                }
                            }

                        } else {
                            localDateTime = LocalDateTime.now();
                            System.out.println("2222");
                        }
                    }
                } else {
                    this.mySuspend();
                }
                pause(300L);
            }
        }
    };

    //    @ListenMouseKeyboard(note = "f5", value = 116, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 自动喝药() {
        自动喝药B = true;
        t1.myResume();
    }

    //    @ListenMouseKeyboard(note = "f6", value = 117, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "t", value = 84, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 自动喝药1() {
        自动喝药B = false;
    }


    @ListenMouseKeyboard(note = "x", value = 88, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 扔装备() {
        Point point = MouseInfo.getPointerInfo().getLocation();
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(1085, 699);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(point.x, point.y);
    }

    @ListenMouseKeyboard(note = "b", value = 66, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 人物详情() {
        robot.keyPress(VK_C);
        robot.keyRelease(VK_C);
        Point point = MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(1355, 264);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(point.x, point.y);
    }

    @ListenMouseKeyboard(note = "f7", value = 118, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void f() {
        String text=readClipboard().replaceAll(" ","");
        String[] parts = text.split(",");
        int x=Integer.parseInt(parts[0]);
        int y=Integer.parseInt(parts[1]);
        pixelColor.threadOn(x,y);
        writeClipboard(x+","+y);
    }

    @ListenMouseKeyboard(note = "f8", value = 119, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void f1() {
        pixelColor.threadOff();
    }


    public static boolean t右键连点是否左键 = false;
    public static LocalDateTime 计时器 = LocalDateTime.MIN;
    public static MyThread t鼠标连点 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (t右键连点是否左键 == false) {
                    robot.mousePress(BUTTON3_DOWN_MASK);
                    robot.mouseRelease(BUTTON3_DOWN_MASK);
                } else {
                    robot.mousePress(BUTTON1_DOWN_MASK);
                    robot.mouseRelease(BUTTON1_DOWN_MASK);
                }
                pause(200L);
            }
        }
    };

    @ListenMouseKeyboard(note = "=", value = 187, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 右键连点() {
        if (LocalDateTime.now().getSecond() - 计时器.getSecond() < 2) {
            t右键连点是否左键 = true;
        } else {
            t右键连点是否左键 = false;
        }
        计时器 = LocalDateTime.now();
        t鼠标连点.myResume();
    }

    @ListenMouseKeyboard(note = "-", value = 189, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 右键连点_1() {
        t鼠标连点.mySuspend();
    }


    //-------------


    public static MyThread t筛选装备 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (筛选装备.是否标记 == true) {
                    筛选装备.run1();
                } else if (筛选装备.是否扫描和筛选 == true) {
                    筛选装备.run(筛选装备_子类);
                }

                this.mySuspend();
            }
        }
    };

    public static 筛选装备_子类 筛选装备_子类;

    @ListenMouseKeyboard(note = "f1", value = 112, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备() {
        筛选装备.标记起点();
    }

    @ListenMouseKeyboard(note = "f2", value = 113, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 图像识别_装备1() {
        筛选装备.是否扫描和筛选 = true;
        筛选装备.是否标记 = false;
        t筛选装备.myResume();
    }

    @ListenMouseKeyboard(note = "f3", value = 114, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备2() {
        筛选装备.是否扫描和筛选 = false;
        筛选装备.是否标记 = true;
        t筛选装备.myResume();
    }

    @ListenMouseKeyboard(note = "f4", value = 115, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备_终止() {
        筛选装备.是否扫描和筛选 = false;
        筛选装备.是否标记 = false;
    }

    @ListenMouseKeyboard(note = "f5", value = 116, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_标记传奇() {
//        robot.keyPress(VK_C);
//        robot.keyRelease(VK_C);
        筛选装备.显示传奇标记();
    }

    @ListenMouseKeyboard(note = "f6", value = 117, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_重置传奇列表() {
        robot.keyPress(VK_ESCAPE);
        robot.keyRelease(VK_ESCAPE);
        筛选装备.关闭传奇标记();
    }


}