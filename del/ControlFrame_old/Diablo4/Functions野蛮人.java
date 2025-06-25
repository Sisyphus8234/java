package custom;

import addition.FunctionsAddition;
import base.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.awt.event.InputEvent.*;
import static java.awt.event.KeyEvent.*;

public class Functions野蛮人 extends Functions公共 {
    static {
        Config.prefix = "ye_man_ren";
    }

    public static boolean 是否基础技能 = true;
    public static boolean 是否核心技能 = true;
    public static boolean 核心技能跳过条件 = false;
    public static boolean 是否使用旋风斩 = false;

    public static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();


    public static boolean 判断旋风斩怒气是否满足() {
        return pixelColor.getPixelColorHSB(1318, 950)[0] < 0.33F || 核心技能跳过条件;
//        return pixelColor.getPixelColorHSB(1318, 975)[0] < 0.33F || 核心技能跳过条件;

    }

    public static boolean 判断核心技能怒气是否满足() {
//        return pixelColor.getPixelColorHSB(1318, 960)[0] < 0.33F || 核心技能跳过条件;
//        return pixelColor.getPixelColorHSB(1318, 950)[0] < 0.33F || 核心技能跳过条件;
//        return pixelColor.getPixelColorHSB(1318, 940)[0] < 0.49F || 核心技能跳过条件;
//        return pixelColor.getPixelColorHSB(1318, 975)[0] < 0.33F || 核心技能跳过条件;
        return pixelColor.getPixelColorHSB(1318, 1020)[0] < 0.31F || 核心技能跳过条件;

    }


    ;

    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            boolean tempB = true;

            while (true) {
                if (攻击性移动 == true) {
                    tempB = true;

                    robot.keyRelease(VK_9);
                    robot.keyPress(VK_9);



                } else {
                    if (tempB == true) {
                        tempB = false;
                        robot.keyRelease(VK_9);

                    }
                }
                pause(BaseDelay);
            }
        }
    };


    public static boolean 攻击性移动 = false;

    @ListenMouseKeyboard(key = "w", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 200L)
    @ListenMouseKeyboard(userInput = false, key = "w", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,timeInterval = 200L)
    public static void w() {
        攻击性移动 = false;
        自动拾取start();
    }

    @ListenMouseKeyboard(key = "w", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "w", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void e1() {
        攻击性移动 = true;
        自动喝药开始(null, null, true);

    }

    @ListenMouseKeyboard(key = "r", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "r", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "c", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "c", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "d", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "d", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void r1() {
        攻击性移动 = false;
        自动喝药结束();
        自动拾取stop();
    }


    //-----


    public static Point 技能1 = new Point(804, 979);
    public static Point 技能2 = new Point(867, 979);
    public static Point 技能3 = new Point(930, 979);


//    public static MyThread t2 = new MyThread(MyThread.State.on) {
//        @Override
//        public void run() {
//            FunctionsAddition.PixelColor pixelColor1 = new FunctionsAddition.PixelColor();
//            int 技能;
//            LocalDateTime tempTIme = LocalDateTime.now();
//            while (true) {
//                if (攻击性移动 == true && pixelColor1.getPixelColorHSB(p自动喝药_在上方位置_长时间损失少量0血量就恢复.x, p自动喝药_在上方位置_长时间损失少量0血量就恢复.y)[1] < 0.5F && LocalDateTime.now().isAfter(tempTIme)) {
//
////                    if (pixelColor1.getPixelColorHSB(技能1.x, 技能1.y)[2] > 0.45F) {
////                        技能 = VK_6;
//
////                    } else {
//                        技能 = VK_6;
////                    }
//                    robot.keyPress(技能);
//                    robot.keyRelease(技能);
//
////                    tempTIme = LocalDateTime.now().plusSeconds(5);
//
//                }
//                pause(200L);
//            }
//        }
//    };


    public static MyThread t3 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {

            while (true) {
                if (攻击性移动 == true) {


                    robot.keyPress(VK_8);
                    robot.keyRelease(VK_8);

                    if(LocalDateTime.now().isAfter(技能禁用)) {
                        robot.keyPress(VK_E);
                        robot.keyRelease(VK_E);
                    }

                    if(getKeyStatus(BUTTON1_DOWN_MASK)==true) {


                        robot.keyPress(VK_7);
                        robot.keyRelease(VK_7);

                        robot.keyPress(VK_6);
                        robot.keyRelease(VK_6);

                    }




                }
                pause(200L);
            }
        }
    };

    public static LocalDateTime 技能禁用=LocalDateTime.now();

    @ListenMouseKeyboard(key = "滚轮", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(userInput = false, key = "滚轮", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    public static void 滚轮() {
        技能禁用=LocalDateTime.now().plusSeconds(4);
    }


    @ListenMouseKeyboard(key = "左键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(userInput = false, key = "左键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    public static void 左键按下() {
        setKeyStatus(BUTTON1_DOWN_MASK,true);
    }

    @ListenMouseKeyboard(key = "左键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(userInput = false, key = "左键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    public static void 左键按下1() {
        setKeyStatus(BUTTON1_DOWN_MASK,false);
    }


//    @ListenMouseKeyboard(key = "1", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 1000L)
//    @ListenMouseKeyboard(key = "2", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 1000L)
//    @ListenMouseKeyboard(key = "3", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 1000L)
//    @ListenMouseKeyboard(key = "4", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 1000L)
//    public static void 无干扰按键(InputInfo inputInfo) {
//
//        int value = inputInfo.value;
//
//        if (inputInfo.value == VK_1) {
//            if (pixelColor1.getPixelColorHSB(805, 982)[2] < 0.15F) {
////                if (pixelColor1.getPixelColorHSB(931, 981)[1] < 0.37F) {
////                value=VK_2;
//                要按的key.add(VK_2);
////            }
//            }
//        }
//
//        if (inputInfo.value == VK_2) {
//            if (pixelColor1.getPixelColorHSB(805, 982)[2] > 0.15F) {
//                value = VK_1;
//            }
//        }
//        要按的key.add(value);
//
//
//        b无干扰按键 = true;
//        t无干扰按键.myResume();
//    }


}
