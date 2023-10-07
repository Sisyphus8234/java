package custom;


import base.FunctionsAddition;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.*;
import java.time.LocalDateTime;

import static java.awt.event.InputEvent.BUTTON1_DOWN_MASK;
import static java.awt.event.KeyEvent.*;


public class Functions法师 extends Functions公共 {

    //    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static Long baseDelay = 150L;


    public static boolean t3Temp = false;

    public static boolean 右键或者1234在t1运行时按下 = false;

    public static final int rgby1 = 980;
    public static final int rgby2 = 995;
    public static final float value1 = 0.624F;
    public static final float value2 = 0.661F;
    public static int rgbx = 1313;
    public static int rgby = rgby1;
    public static float value = value1;
    public static FunctionsAddition.PixelColor pixelColor1 = new FunctionsAddition.PixelColor();
    public static FunctionsAddition.PixelColor pixelColor2 = new FunctionsAddition.PixelColor();
    public static float[] myHSB资源;


    public static boolean t1B = false;
    public static boolean t1B1 = false;
    public static boolean w或者左键 = false;
    public static boolean 是否基础技能 = false;
    public static boolean 是否核心技能 = true;
    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (t1B == true) {
                    if (是否核心技能) {

//                        System.out.println("222222222222222222");
                        robot.mouseRelease(BUTTON1_DOWN_MASK);
                        robot.mousePress(BUTTON1_DOWN_MASK);

                    }
                    if (是否基础技能) {
                        robot.keyPress(VK_5);
                        robot.keyRelease(VK_5);
                    }
                    t1B1 = true;
                } else {
                    if (t1B1 == true) {
                        robot.keyRelease(VK_5);
                        if (w或者左键 == false) {
                            robot.mouseRelease(BUTTON1_DOWN_MASK);
                        }
                        t1B1 = false;
                    }
                }
                pause(baseDelay);
            }
        }
    };

    public static boolean t2B = false;
    public static MyThread t2 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (t2B == true) {
                    robot.keyPress(VK_G);
                    robot.keyRelease(VK_G);
                }
                pause(baseDelay);
            }
        }
    };

    @ListenMouseKeyboard(note = "e", value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {
        是否核心技能 = true;
        t1B = true;
        t2B = false;
        Functions公共.自动喝药 = true;
        Functions公共.t1.myResume();
        进入战斗 = false;
    }

    //    @ListenMouseKeyboard(note = "e", value = 69,press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e1() {
    }

    @ListenMouseKeyboard(value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w() {
        w或者左键 = true;
        t1B = false;
        Functions公共.自动喝药 = false;
        t2B = false;
    }

    @ListenMouseKeyboard(value = 514, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 87, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w_1() {
        w或者左键 = false;
    }


    @ListenMouseKeyboard(value = 82, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void R() {
        t1B = false;
//        Functions公共.自动喝药=false;
        t2B = true;
    }


    @ListenMouseKeyboard(note = "侧键", value = 523, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 强制移动() {
        t1B = false;
        t2B = true;
    }

    @ListenMouseKeyboard(note = "侧键", value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 强制移动_1() {
        t1B = true;
        t2B = false;
    }

    //    @ListenMouseKeyboard(note = "右键",value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键() {

        是否基础技能 = false;
        是否核心技能 = true;

    }

    //    @ListenMouseKeyboard(note = "右键",value = 517, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键1() {
        是否基础技能 = true;
        是否核心技能 = false;
    }

    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1() {
//        if(右键或者1234在t1运行时按下==true){
//            之前已经有右键或者1234在t1运行时按下=true;
//        }else {
//            之前已经有右键或者1234在t1运行时按下=false;
//        }

//        暂停t1时是否松开左键 =false;
        if (t1B == true) {
            右键或者1234在t1运行时按下 = true;
        }
        t1B = false;
    }

    //    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 49, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1_1() {
        if (右键或者1234在t1运行时按下 == true) {
            t1B = true;
        }
        右键或者1234在t1运行时按下 = false;
    }


    @ListenMouseKeyboard(value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 处理要按一会的() {
        t按一会.myResume();
    }

//        @ListenMouseKeyboard(value = 52, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 处理要按一会的1() {
//    }

    public static MyThread t按一会 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (t1B == true) {
                    for (int i = 0; i < 15; i++) {
                        robot.keyPress(VK_4);
                        robot.keyRelease(VK_4);
                        pause(200L);
                    }
                    this.mySuspend();

                }
            }

        }

    };


    //    @ListenMouseKeyboard(note = "3",value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "4",value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四() {
        t1B = false;
        t2B = true;
    }

    //    @ListenMouseKeyboard(note = "3",value = 51, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "4",value = 52, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四1() {
        t1B = true;
        t2B = false;
    }


    public static LocalDateTime startTime = LocalDateTime.MIN;
    public static LocalDateTime currentDateTime = LocalDateTime.now();
    public static boolean t放1234B = true;
    public static boolean t放1234B1 = true;


    public static boolean 空格 = false;

    @ListenMouseKeyboard(note = "space", value = 32, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 空格() {
        空格 = true;
        进入战斗 = true;
    }

    @ListenMouseKeyboard(note = "space", value = 32, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 空格1() {
        空格 = false;

    }

    public static boolean 被动触发放技能 = true;

    //    @ListenMouseKeyboard(note = "`", value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void f1() {
        被动触发放技能 = false;
    }

    //    @ListenMouseKeyboard(note = "`", value = 192, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void f1_1() {
        被动触发放技能 = true;
        t1B = true;
        t2B = false;
    }

    public static void f1(int key) {
//        startTime=LocalDateTime.now();
//        while (LocalDateTime.now().getSecond()-startTime.getSecond()<1&&t1B) {
        robot.keyPress(key);
        robot.keyRelease(key);
        pause(150L);
//        }
    }

    public static void tempF() {
        if (pixelColor1.getPixelColorHSB(1120, 978)[1] > 0.1F) {
            f1(VK_5);
        } else if (pixelColor1.getPixelColorHSB(993, 981)[1] > 0.1F) {
            f1(VK_4);
        } else if (pixelColor1.getPixelColorHSB(931, 981)[1] > 0.38F) {
            f1(VK_3);
        } else if (pixelColor1.getPixelColorHSB(868, 981)[1] > 0.1F) {
            f1(VK_2);
        }
    }

    public static float[] temp;
    public static boolean 进入战斗 = false;
    public static MyThread t放1234 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                temp = pixelColor1.getPixelColorHSB(608, 928);
                if (被动触发放技能 == true) {
//                    if (t1B && pixelColor.getPixelColor(1307, 990)[1] < 0.2F) {
                    if (t1B && (
                            pixelColor1.getPixelColorHSB(1307, 1015)[1] < 0.2F ||
                                    (
//                                            pixelColor.getPixelColor(1307, 945)[1] < 0.2F

                                            进入战斗 == true &&
                                                    temp[2] < 0.44F
                                    )
                    )) {
                        tempF();
                    }
                } else {
                    if (t1B && pixelColor1.getPixelColorHSB(1307, 990)[1] < 0.2F) {


                        t1B = false;
                        if (空格 == false) {
                            t2B = true;
                        }
//                    } else if (pixelColor.getPixelColor(1307, 945)[1] > 0.24F) {
                    } else if (pixelColor1.getPixelColorHSB(1307, 990)[1] > 0.2F) {

                        t1B = true;
                        t2B = false;
                    } else if (空格 == false) {
                        t2B = true;
                    }
                }
                pause(200L);
            }
        }

    };


    public static Point temp1;
    public static int temp2 = 1;
    public static int temp3 = 20;

    public static boolean t范围移动鼠标B = true;

//    public static MyThread t范围移动鼠标 = new MyThread(MyThread.State.on) {
//        @Override
//        public void run() {
//            while (true) {
//                if (t1B == true && t范围移动鼠标B == true) {
//                    temp1 = MouseInfo.getPointerInfo().getLocation();
//                    int x = temp1.x;
//                    int y = temp1.y;
//                    if (temp2 == 1) {
//                        x = temp1.x + temp3;
//                        y = temp1.y;
//                    } else if (temp2 == 2) {
//                        x = temp1.x;
//                        y = temp1.y + temp3;
//                    } else if (temp2 == 3) {
//                        x = temp1.x - temp3;
//                        y = temp1.y;
//                    } else if (temp2 == 4) {
//                        x = temp1.x;
//                        y = temp1.y - temp3;
//                    }
//
//                    robot.mouseMove(x, y);
//                    temp2++;
//                    if (temp2 >= 5) {
//                        temp2 = 1;
//                    }
//
//                }
//                pause(100L);
//
//            }
//        }
//    };

    public static Point 中心点 = new Point(955, 514);

    public static Robot robot1;

    static {
        try {
            robot1 = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @ListenMouseKeyboard(note = "`", value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "g", value = 71, intercept = true,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "alt", value = 164, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 后撤步() {
        if (t1B == true&& pixelColor2.getPixelColorHSB(1239,897)[2]>0.25F) {
//            t范围移动鼠标.mySuspend();
            Point temp = MouseInfo.getPointerInfo().getLocation();
            robot1.mouseMove(中心点.x * 2 - temp.x, 中心点.y * 2 - temp.y);
            pause(50L);
            robot1.keyPress(VK_F);
//            pause(100L);
            robot1.keyRelease(VK_F);
//            pause(20L);
//            robot1.mouseMove(temp.x, temp.y);
            pause(100L);
            robot1.mouseMove(temp.x, temp.y);
//            t范围移动鼠标.myResume();




        }
    }


    public static boolean t捡东西B = false;
    public static MyThread t捡东西 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (t1B == true) {
                    robot.keyPress(VK_ALT);
                    robot.keyRelease(VK_ALT);
                    robot.keyRelease(VK_V);
                    robot.keyPress(VK_V);
                    t捡东西B = true;
                } else {

                    if (t捡东西B == true) {
                        robot.keyRelease(VK_V);
                        t捡东西B = false;
                    }

                }
                pause(baseDelay);

            }
        }
    };


    public static MyThread t4 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (筛选装备.是否标记 == true) {
                    筛选装备.run1();
                } else if (筛选装备.是否扫描和筛选 == true) {
                    筛选装备.run(筛选装备_法师);
                }

                this.mySuspend();
            }
        }
    };

    public static 筛选装备_法师 筛选装备_法师 = new 筛选装备_法师();

    @ListenMouseKeyboard(note = "f1", value = 112, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备() {
        筛选装备.标记起点();
    }

    @ListenMouseKeyboard(note = "f2", value = 113, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 图像识别_装备1() {
        筛选装备.是否扫描和筛选 = true;
        筛选装备.是否标记 = false;
        t4.myResume();
    }

    @ListenMouseKeyboard(note = "f3", value = 114, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备2() {
        筛选装备.是否扫描和筛选 = false;
        筛选装备.是否标记 = true;
        t4.myResume();
    }

    @ListenMouseKeyboard(note = "f4", value = 115, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备_终止() {
        筛选装备.是否扫描和筛选 = false;
        筛选装备.是否标记 = false;
    }


}
