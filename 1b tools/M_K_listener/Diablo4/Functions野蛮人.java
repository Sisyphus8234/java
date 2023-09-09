package custom;

import base.Config;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.event.InputEvent.BUTTON1_DOWN_MASK;
import static java.awt.event.KeyEvent.VK_5;
import static java.awt.event.KeyEvent.VK_V;

public class Functions野蛮人 extends Functions公共 {
    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static Long baseDelayT3 = Long.parseLong(Config.read("BaseDelay"))*2;
    public static boolean t1B = false;
    public static boolean t1B1 = false;
    public static boolean t2B = false;
    public static boolean 右键或者1234在t1运行时按下 = false;
    public static boolean 是否基础技能 = true;
    public static boolean 是否核心技能 = true;
    private static Color pixelColor资源;
    public static boolean w或者左键 = false;
    public static void fTemp(){
        pixelColor资源 = robot.getPixelColor(1318, 965);
        if (pixelColor资源.getRed() +
                pixelColor资源.getGreen() +
                pixelColor资源.getBlue() < 130
        ) {
        }else {
            robot.keyPress(KeyEvent.VK_4);
            robot.keyRelease(KeyEvent.VK_4);
        }
    }
    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (t1B == true) {
                    if (是否基础技能 == true) {
                        robot.keyPress(KeyEvent.VK_5);
                        robot.keyRelease(KeyEvent.VK_5);
                    }
                    if (是否核心技能) {
                        fTemp();
                    }
                    if (是否基础技能 == true) {
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    }
                    if (是否核心技能) {
                        fTemp();
                    }

                } else {

                }
                pause(baseDelay);
            }
        }
    };
//    public static MyThread t1 = new MyThread(MyThread.State.on) {
//        @Override
//        public void run() {
//            while (true) {
//                if (t1B == true) {
//                    if (是否基础技能 == true) {
//                        robot.mouseRelease(BUTTON1_DOWN_MASK);
//                        robot.mousePress(BUTTON1_DOWN_MASK);
//                    }
//                    if (是否核心技能) {
//                        robot.keyRelease(VK_5);
//                        robot.keyPress(VK_5);
//                    }
//
//                    t1B1=true;
//                } else {
//                    if(t1B1==true){
//                        robot.keyRelease(VK_5);
//                        if(w或者左键==false) {
//                            robot.mouseRelease(BUTTON1_DOWN_MASK);
//                        }
//                        t1B1=false;
//                    }
//                }
//                pause(baseDelay);
//            }
//        }
//    };
    public static MyThread t2 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (t2B == true) {
                    robot.keyPress(KeyEvent.VK_G);
                    robot.keyRelease(KeyEvent.VK_G);
                }
                pause(baseDelay);

            }
        }
    };
    public static boolean t捡东西B = false;
    public static MyThread t捡东西=new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (t1B == true) {
                    robot.keyRelease(VK_V);
                    robot.keyPress(VK_V);
                    t捡东西B =true;
                } else {
                    if(t捡东西B ==true){
                        robot.keyRelease(VK_V);
                        t捡东西B =false;
                    }

                }
                pause(baseDelay);
            }
        }
    };
    @ListenMouseKeyboard(value = 82, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void R() {
        t1B = false;
//        Functions公共.自动喝药=false;
        t2B = true;
    }
    @ListenMouseKeyboard(value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w() {
        w或者左键 = true;
        t1B = false;
        Functions公共.自动喝药=false;
        t2B = false;
    }
    @ListenMouseKeyboard(value = 514,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 87, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w_1() {
        w或者左键 = false;
    }
    @ListenMouseKeyboard(note = "e",value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {
        t1B = true;
        t2B = false;
        Functions公共.自动喝药=true;
        Functions公共.t1.myResume();
    }
    @ListenMouseKeyboard(note = "e",value = 69,press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e1() {
        t1B = true;
        t2B = false;
    }



    @ListenMouseKeyboard(note = "右键",value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键() {
        是否基础技能=false;
    }
    @ListenMouseKeyboard(note = "右键",value = 517, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键1() {
        是否基础技能=true;
    }
    @ListenMouseKeyboard(value = 523, keyboardOrMouse =     ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard )
    public static void 侧键_f() {
        t1B = false;
        t2B = true;
    }

    @ListenMouseKeyboard(value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false)
    public static void 侧键_f_1() {
        t1B = true;
        t2B = false;
    }

    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1() {
        if (t1B == true) {
            右键或者1234在t1运行时按下 = true;
        }
        t1B = false;
    }
    //    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1_1() {
        if (右键或者1234在t1运行时按下 == true) {
            t1B = true;
        }
        右键或者1234在t1运行时按下 = false;
    }

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

    public static 筛选装备_野蛮人 筛选装备_野蛮人 = new 筛选装备_野蛮人();
    public static MyThread t4= new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if(筛选装备.是否标记 ==true){
                    筛选装备.run1();
                }else if(筛选装备.是否扫描和筛选 ==true){
                    筛选装备.run(robot,筛选装备_野蛮人);
                }

                this.mySuspend();
            }
        }
    };
    @ListenMouseKeyboard(note = "f1",value = 112, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备() {
        筛选装备.标记起点();
    }
    @ListenMouseKeyboard(note = "f2",value = 113, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 图像识别_装备1() {
        筛选装备.是否扫描和筛选 = true;
        筛选装备.是否标记 = false;
        t4.myResume();
    }
    @ListenMouseKeyboard(note = "f3",value = 114, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备2() {
        筛选装备.是否扫描和筛选 = false;
        筛选装备.是否标记 = true;
        t4.myResume();
    }
    @ListenMouseKeyboard(note = "f4",value = 115, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备_终止() {
        筛选装备.是否扫描和筛选 = false;
        筛选装备.是否标记 = false;
    }






}
