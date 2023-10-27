package custom;

import addition.FunctionsAddition;
import base.InputInfo;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.event.InputEvent.*;
import static java.awt.event.KeyEvent.*;

public class Functions野蛮人 extends Functions公共 {
    public static boolean 右键或者1234在t1运行时按下 = false;
    public static boolean 是否基础技能 = true;
    public static boolean 是否核心技能 = true;


    public static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();

    public static void 判断核心技能怒气是否满足() {
        if (pixelColor.getPixelColorHSB(1318, 960)[0] < 0.33F) {
            robot.keyPress(KeyEvent.VK_4);
            robot.keyRelease(KeyEvent.VK_4);
        }
    }

    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (b攻击移动 == true) {
                    if (是否核心技能) {
                        判断核心技能怒气是否满足();
                    }
                    if (是否基础技能 == true) {
                        robot.keyPress(KeyEvent.VK_5);
                        robot.keyRelease(KeyEvent.VK_5);
                    }
                    pause(BaseDelay);

                    if (是否核心技能) {
                        判断核心技能怒气是否满足();
                    }

                    if (是否基础技能 == true) {
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    }

                    b攻击移动1 = true;

                } else {
                    if (b攻击移动1 == true) {
                        robot.keyRelease(VK_5);
                        if (w或者左键 == false) {
                            robot.mouseRelease(BUTTON1_DOWN_MASK);
                        }
                        b攻击移动1 = false;
                    }

                }
                pause(BaseDelay);
            }
        }
    };


    @ListenMouseKeyboard(note = "e", value = 69, press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e1() {
    }


    @ListenMouseKeyboard(note = "右键", value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键() {
        是否基础技能 = false;
    }

    @ListenMouseKeyboard(note = "右键", value = 517, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键1() {
        是否基础技能 = true;
    }

    @ListenMouseKeyboard(note = "1",intercept = true,value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "2",intercept = true,value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "3",intercept = true,value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "4",intercept = true,value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1(InputInfo inputInfo){
        无干扰按键(inputInfo.value,t1);
    }
//    @ListenMouseKeyboard(note = "2",intercept = true,value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 键盘2(){
//        无干扰按键(VK_2,t1);
//    }
//    @ListenMouseKeyboard(note = "3",intercept = true,value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 键盘3(){
//        无干扰按键(VK_3,t1);
//    }
//    @ListenMouseKeyboard(note = "4",intercept = true,value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 键盘4(){
//        无干扰按键(VK_4,t1);
//    }






    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 键盘1() {
//        if (b攻击移动 == true) {
//            右键或者1234在t1运行时按下 = true;
//        }
//        b攻击移动 = false;
//    }

    //    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 键盘1_1() {
//        if (右键或者1234在t1运行时按下 == true) {
//            b攻击移动 = true;
//        }
//        右键或者1234在t1运行时按下 = false;
//    }

    //    @ListenMouseKeyboard(note = "3",value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "4",value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四() {
        b攻击移动 = false;
        b移动 = true;
    }

    //    @ListenMouseKeyboard(note = "3",value = 51, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "4",value = 52, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四1() {
        b攻击移动 = true;
        b移动 = false;
    }


    static {
        Functions公共.筛选装备_子类 = new 筛选装备_野蛮人();
    }


}
