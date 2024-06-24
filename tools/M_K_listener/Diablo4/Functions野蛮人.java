package custom;

import addition.FunctionsAddition;
import base.*;

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
        return pixelColor.getPixelColorHSB(1318, 975)[0] < 0.33F || 核心技能跳过条件;

    }


    ;

    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            boolean tempB = false;
            while (true) {
                if (攻击性移动 == true) {
                    tempB = true;

                    robot.keyRelease(KeyEvent.VK_5);
                    robot.keyPress(KeyEvent.VK_5);

                    if (判断核心技能怒气是否满足() == false) {
//                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    }


                } else {
                    if (tempB == true) {
                        tempB = false;
                        robot.keyRelease(VK_5);
                        robot.mouseRelease(BUTTON1_DOWN_MASK);
                    }
                }
                pause(BaseDelay);
            }
        }
    };


    public static boolean 攻击性移动 = false;

    @ListenMouseKeyboard(key = "e",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,timeInterval = 200L)
    @ListenMouseKeyboard(userInput = false, key = "e", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void e() {
        攻击性移动 = false;
        自动拾取start();
    }

    @ListenMouseKeyboard(key = "e", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "e", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void e1() {
        攻击性移动 = true;
        自动喝药开始(null, null, true);

    }

    @ListenMouseKeyboard(key = "r", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "r", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void r() {
        攻击性移动 = false;
        自动喝药结束();
        自动拾取stop();
    }

    @ListenMouseKeyboard(key = "r", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "r", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void r1() {
        攻击性移动 = false;
        自动喝药结束();
        自动拾取stop();
    }


    //-----

    public static FunctionsAddition.PixelColor pixelColor1 = new FunctionsAddition.PixelColor();
    public static List<Integer> l1 = new ArrayList<>(Arrays.asList(VK_6, VK_7, VK_8));

    public static MyThread t2 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            int i = 0;
            LocalDateTime tempTIme = LocalDateTime.now();
            while (true) {
                if (攻击性移动 == true && pixelColor1.getPixelColorHSB(p自动喝药_在上方位置_长时间损失少量0血量就恢复.x, p自动喝药_在上方位置_长时间损失少量0血量就恢复.y)[1] < 0.5F && LocalDateTime.now().isAfter(tempTIme)) {

                    robot.keyPress(l1.get(i));
                    robot.keyRelease(l1.get(i));
                    i++;
                    if (i >= l1.size()) {
                        i = 0;
                    }

                    tempTIme = LocalDateTime.now().plusSeconds(5);

                }
                pause(200L);
            }
        }
    };


    public static MyThread t3 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {

            while (true) {
                if (攻击性移动 == true) {

                    robot.keyPress(VK_9);
                    robot.keyRelease(VK_9);

                }
                pause(200L);
            }
        }
    };


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
