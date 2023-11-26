package custom;

import addition.FunctionsAddition;
import base.*;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public class Functions公共 extends IFunctions {
    static {
        Controller.refreshtime = 200L;
    }

    public static long BaseDelay = 300L;
    public static boolean b攻击移动 = false;
    public static boolean b攻击移动1 = false;

    public static boolean b移动 = false;
    public static boolean b移动1 = false;
    public static MyThread t移动 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (b移动 == true) {
                    robot.keyRelease(VK_G);
                    robot.keyPress(VK_G);
                    b移动1 = true;
                } else {
                    if (b移动1 == true) {
                        robot.keyRelease(VK_G);
                        b移动1 = false;
                    }
                }

                pause(BaseDelay);
            }
        }
    };

    public static boolean b拾取物品 = false;
    public static boolean b需要骑马 = false;
    public static LocalDateTime 骑马start = LocalDateTime.now();
    public static FunctionsAddition.PixelColor pixelColor拾取物品 = new FunctionsAddition.PixelColor();
    public static MyThread t拾取物品 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {

                if (b攻击移动 == true) {

                    if (b需要骑马 == true && pixelColor拾取物品.getPixelColorHSB(801, 974)[0] > 0.35F) {
                        robot.keyPress(VK_Z);
                        robot.keyRelease(VK_Z);
                    }
                    robot.keyPress(VK_ALT);
                    robot.keyRelease(VK_ALT);
                    robot.keyRelease(VK_V);
                    robot.keyPress(VK_V);
                    b拾取物品 = true;
                } else {
                    if (b拾取物品 == true) {
                        robot.keyRelease(VK_V);
                        b拾取物品 = false;
                    }
                }

                if (Duration.between(骑马start, LocalDateTime.now()).toMillis() > 800L) {
                    b需要骑马 = false;
                }


                pause(BaseDelay);

            }
        }
    };


    @ListenMouseKeyboard(note = "e", value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {
        b攻击移动 = true;
        b移动 = false;
        自动喝药();
    }

    public static boolean w或者左键 = false;

    @ListenMouseKeyboard(note = "左键", value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(note = "w", value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "v", value = 86, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)

    public static void w() {
        w或者左键 = true;
        b攻击移动 = false;
        b移动 = false;
        自动喝药1();
    }

    @ListenMouseKeyboard(note = "左键", value = 514, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(note = "w", value = 87, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "v", press = false,value = 86, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)

    public static void w_1() {
        w或者左键 = false;
    }

//    @ListenMouseKeyboard(note = "v", value = 86, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void v() {
//        b攻击移动 = false;
//        b移动 = false;
//    }

    @ListenMouseKeyboard(note = "r", value = 82, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void R() {
        b攻击移动 = false;
//        Functions公共.自动喝药=false;
        b移动 = true;
    }


    public static boolean b攻击移动是否在运行 = false;
    public static boolean b移动是否在运行 = false;
    public static boolean b是否第一次按f = true;

    @ListenMouseKeyboard(note = "侧键", value = 523, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(note = "f", value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 强制移动() {

        if (b是否第一次按f == true) {
            if (b攻击移动 == true) {
                b攻击移动是否在运行 = true;
            } else {
                b攻击移动是否在运行 = false;
            }

            if (b移动 == true) {
                b移动是否在运行 = true;
            } else {
                b移动是否在运行 = false;
            }

            b攻击移动 = false;
            b移动 = true;

            骑马start = LocalDateTime.now();
            b需要骑马 = true;

        }


        if (b是否第一次按f == true) {
            b是否第一次按f = false;
        }
    }

    @ListenMouseKeyboard(note = "侧键", value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(note = "f", press = false, value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 强制移动_1() {


        if (b攻击移动是否在运行 == true) {
            b攻击移动 = true;
        } else {
            b攻击移动 = false;
        }

        if (b移动是否在运行 == true) {
            b移动 = true;
        } else {
            b移动 = false;
        }

        b是否第一次按f = true;
    }

    //-----------------------------


    public static List<Integer> 要按的key = new ArrayList();
    public static MyThread 要暂停的t;
    public static boolean b无干扰按键 = false;
    public static boolean b无干扰按键进行中 = false;
    public static LocalDateTime start = LocalDateTime.now();
    public static MyThread t无干扰按键 = new MyThread() {

        @Override
        public void run() {

            while (true) {
                if (b无干扰按键 == true) {
//                    if(LocalDateTime.now().getNano()-start.getNano()<2000) {
//                    if (Duration.between(start, LocalDateTime.now()).toMillis() < 1100) {
//                        System.out.println(Duration.between(start,LocalDateTime.now()).toMillis());
//                    要暂停的t.mySuspend();
//                    pause(50L);
                    b无干扰按键进行中 = true;
                    try {
                        start = LocalDateTime.now();
                        while (Duration.between(start, LocalDateTime.now()).toMillis() < 要按的key.size() * 600L) {
                            int i = 0;
                            int size = 要按的key.size();
                            while (i < size) {
                                robot.keyPress(要按的key.get(i));
                                robot.keyRelease(要按的key.get(i));
                                pause(100L);
                                i++;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    b无干扰按键进行中 = false;
                    要按的key.clear();


//                    pause(100L);
//                    要暂停的t.myResume();

//                    pause(500L);

//                    b无干扰按键=false;
//                    }


                }
                this.mySuspend();

                pause(BaseDelay);
            }
        }
    };

//    public static void 无干扰按键(int key) {
////        start = LocalDateTime.now();
////        要按的key = key;
////        b无干扰按键 = true;
////        t无干扰按键.myResume();
//
////        要暂停的t.mySuspend();
////        robot.keyPress(key);
////        robot.keyRelease(key);
////        要暂停的t.myResume();
//
//    }


    @ListenMouseKeyboard(note = "1", intercept = true, value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(note = "2", intercept = true, value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(note = "3", intercept = true, value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(note = "4", intercept = true, value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void 无干扰按键(InputInfo inputInfo) {

        要按的key.add(inputInfo.value);


        b无干扰按键 = true;
        t无干扰按键.myResume();
    }

    //-----------------------------

    public static Point p自动喝药 = new Point(625, 990);
    public static Point p自动喝药1 = new Point(625, 950);


    public static boolean b自动喝药 = false;
    public static boolean b自动喝药1 = false;
    public static boolean b自动喝药2 = true;
    public static LocalDateTime localDateTime = LocalDateTime.now();

    public static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();
    public static MyThread t自动喝药 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (b自动喝药 == true) {
                    if (pixelColor.getPixelColorHSB(625, 990)[1] < 0.5F) {
                        robot.keyRelease(VK_0);
                        robot.keyPress(VK_0);
                        robot.keyRelease(VK_0);
                        b自动喝药1 = true;
                        if (b自动喝药1 == true) {
                            pause(800L);
                            b自动喝药1 = false;
                        }
                    } else if (b自动喝药2 == true) {
                        if (pixelColor.getPixelColorHSB(625, 950)[1] < 0.5F) {
                            if (LocalDateTime.now().getSecond() - localDateTime.getSecond() < 0) {
                                System.out.println(LocalDateTime.now().getSecond() - localDateTime.getSecond());
                                System.out.println(LocalDateTime.now());
                                System.out.println(localDateTime);
                            }
                            if (Duration.between(localDateTime, LocalDateTime.now()).toMillis() > 5000) {
                                robot.keyRelease(VK_0);
                                robot.keyPress(VK_0);
                                robot.keyRelease(VK_0);
                                b自动喝药1 = true;
                                if (b自动喝药1 == true) {
                                    pause(1200L);
                                    b自动喝药1 = false;
                                }
                            }

                        } else {
                            localDateTime = LocalDateTime.now();
                        }
                    }
                } else {
                    this.mySuspend();
                }
                pause(300L);
            }
        }
    };


    public static void 自动喝药() {
        b自动喝药 = true;
        t自动喝药.myResume();
    }

    public static void 自动喝药(Point point, Point point1, boolean b) {
        if (point != null) {
            p自动喝药 = point;
        }
        if (point1 != null) {
            p自动喝药1 = point1;
        }
        b自动喝药2 = b;
        自动喝药();
    }

    public static void 自动喝药1() {
        b自动喝药 = false;
    }

    //------------------------------------------------


    //---------------------------------------------------


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
        long time = 150L;
        robot.keyPress(VK_C);
        robot.keyRelease(VK_C);
        pause(time);
        Point point = MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(1355, 264);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        pause(time);
        robot.mouseMove(1089, 115);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);


        robot.mouseMove(point.x, point.y);
    }


    //------------------


    @ListenMouseKeyboard(note = "f7", value = 118, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 读取颜色() {
        String text = readClipboard().replaceAll(" ", "");
        String[] parts = text.split(",");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        pixelColor.threadOn(x, y);
        writeClipboard(x + "," + y);
    }

    @ListenMouseKeyboard(note = "f8", value = 119, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 读取颜色_1() {
        pixelColor.threadOff();
    }


    //------------------------------------------------


    //-------------------------------------------------------

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

    @ListenMouseKeyboard(note = "=", value = 187, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 右键连点() {
        if (LocalDateTime.now().getSecond() - 计时器.getSecond() < 2) {
            t右键连点是否左键 = true;
        } else {
            t右键连点是否左键 = false;
        }
        计时器 = LocalDateTime.now();
        t鼠标连点.myResume();
    }

    @ListenMouseKeyboard(note = "-", value = 189, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
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
    public static void 图像识别_标记传奇_1() {
//        robot.keyPress(VK_ESCAPE);
//        robot.keyRelease(VK_ESCAPE);
        筛选装备.关闭传奇标记();
    }


}