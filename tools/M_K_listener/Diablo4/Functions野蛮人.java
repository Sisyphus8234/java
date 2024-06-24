package custom;

import addition.FunctionsAddition;
import base.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalDateTime;

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

    public static boolean 最终是否满足 = true;
    public static LocalDateTime start = LocalDateTime.now();

    public static boolean 判断旋风斩怒气是否满足() {
        return pixelColor.getPixelColorHSB(1318, 950)[0] < 0.33F || 核心技能跳过条件;
//        return pixelColor.getPixelColorHSB(1318, 975)[0] < 0.33F || 核心技能跳过条件;

    }

    public static boolean 判断核心技能怒气是否满足() {
//        return pixelColor.getPixelColorHSB(1318, 960)[0] < 0.33F || 核心技能跳过条件;
        return pixelColor.getPixelColorHSB(1318, 950)[0] < 0.33F || 核心技能跳过条件;
//        return pixelColor.getPixelColorHSB(1318, 940)[0] < 0.49F || 核心技能跳过条件;
//        return pixelColor.getPixelColorHSB(1318, 975)[0] < 0.33F || 核心技能跳过条件;

    }

    public static boolean 判断核心技能怒气是否满足_1() {
        if (判断核心技能怒气是否满足() == true) {
            start = LocalDateTime.now();
        } else {

        }

        if (Duration.between(start, LocalDateTime.now()).toMillis() > 800L) {
            最终是否满足 = false;
        } else {
            最终是否满足 = true;
        }

        return 最终是否满足;
    }

    ;

    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (攻击性移动 == true) {

                    robot.keyRelease(KeyEvent.VK_5);
                    robot.keyPress(KeyEvent.VK_5);

                    if (是否基础技能 == true) {

//                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    }


                }
                pause(BaseDelay);
            }
        }
    };


    public static FunctionsAddition.PixelColor pixelColor1 = new FunctionsAddition.PixelColor();

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


    public static boolean 攻击性移动 = false;

//    @ListenMouseKeyboard(key = "e",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,timeInterval = 200L)
//    public static void e() {
//    }

    @ListenMouseKeyboard(key = "e", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void e1() {
        攻击性移动 = true;
    }

    @ListenMouseKeyboard(key = "r", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void r() {
        攻击性移动 = false;
    }


}
