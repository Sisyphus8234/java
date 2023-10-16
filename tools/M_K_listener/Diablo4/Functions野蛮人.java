package custom;

import addition.FunctionsAddition;
import base.Config;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.event.InputEvent.BUTTON1_DOWN_MASK;
import static java.awt.event.KeyEvent.VK_5;

public class Functions野蛮人 extends Functions公共 {
    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static boolean t1B1 = false;
    public static boolean t2B = false;
    public static boolean 右键或者1234在t1运行时按下 = false;
    public static boolean 是否基础技能 = true;
    public static boolean 是否核心技能 = true;

    public static boolean w或者左键 = false;
    public static FunctionsAddition.PixelColor pixelColor=new FunctionsAddition.PixelColor();
    public static void 判断核心技能怒气是否满足(){
        if (pixelColor.getPixelColorHSB(1318,960)[0]<0.33F){
            robot.keyPress(KeyEvent.VK_4);
            robot.keyRelease(KeyEvent.VK_4);
        }
    }
    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (b攻击移动 == true) {
                    if (是否基础技能 == true) {
                        robot.keyPress(KeyEvent.VK_5);
                        robot.keyRelease(KeyEvent.VK_5);
                    }
                    if (是否核心技能) {
                        判断核心技能怒气是否满足();
                    }
                    if (是否基础技能 == true) {
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    }
                    if (是否核心技能) {
                        判断核心技能怒气是否满足();
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

    @ListenMouseKeyboard(value = 82, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void R() {
        b攻击移动 = false;
//        Functions公共.自动喝药=false;
        t2B = true;
    }
    @ListenMouseKeyboard(value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w() {
        w或者左键 = true;
        b攻击移动 = false;
        Functions公共.b自动喝药 =false;
        t2B = false;
    }
    @ListenMouseKeyboard(value = 514,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 87, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w_1() {
        w或者左键 = false;
    }
    @ListenMouseKeyboard(note = "e",value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {
        b攻击移动 = true;
        t2B = false;
        Functions公共.b自动喝药 =true;
        Functions公共.t1.myResume();
    }
    @ListenMouseKeyboard(note = "e",value = 69,press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e1() {
        b攻击移动 = true;
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
        b攻击移动 = false;
        t2B = true;
    }

    @ListenMouseKeyboard(value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false)
    public static void 侧键_f_1() {
        b攻击移动 = true;
        t2B = false;
    }

    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1() {
        if (b攻击移动 == true) {
            右键或者1234在t1运行时按下 = true;
        }
        b攻击移动 = false;
    }
    //    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1_1() {
        if (右键或者1234在t1运行时按下 == true) {
            b攻击移动 = true;
        }
        右键或者1234在t1运行时按下 = false;
    }

//    @ListenMouseKeyboard(note = "3",value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "4",value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四() {
        b攻击移动 = false;
        t2B = true;
    }

//    @ListenMouseKeyboard(note = "3",value = 51, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "4",value = 52, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四1() {
        b攻击移动 = true;
        t2B = false;
    }



    static {
        Functions公共.筛选装备_子类 = new 筛选装备_野蛮人();
    }





}
