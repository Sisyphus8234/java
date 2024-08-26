package custom;

import addition.FunctionsAddition;
import base.CommonUtil;
import base.ListenMouseKeyboard;
import base.MyThread;
import base.enty.TaskResult;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.awt.event.KeyEvent.*;


public class Functions死灵 extends Functions公共 {
    private static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();
    public static boolean 需要骷髅祭司 = false;
    public static boolean 需要骷髅法师 = false;
    public static boolean 需要骷髅战士 = false;

    public static boolean 判断骷髅() {
//        需要骷髅战士 = pixelColor.getPixelColorHSB(1376, 997)[1] < 0.06F;
        需要骷髅战士 = pixelColor.getPixelColorHSB(1376, 982)[1] < 0.11F;
        需要骷髅法师 = pixelColor.getPixelColorHSB(1377, 1027)[1] < 0.11F;
        需要骷髅祭司 = pixelColor.getPixelColorHSB(783, 969)[1] < 0.72F;
        return 需要骷髅祭司 || 需要骷髅法师 || 需要骷髅战士;
    }


//    static MyThread t自动召唤 = new MyThread(MyThread.State.on) {
//        @Override
//        public void run() {
//            while (true) {
//                if (CommonUtil.customConditionSet.contains(战斗) && !CommonUtil.customConditionSet.contains(移动) && LocalDateTime.now().isAfter(time)
//                        && 判断骷髅() == true
//                ) {
//                    robot.keyPress(VK_6);
//                    robot.keyRelease(VK_6);
//                }
//
//                pause(300L);
//
//            }
//        }
//    };


    public static final String 战斗 = "战斗";
    public static final String 移动 = "移动";

    @ListenMouseKeyboard(key = "w", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "w", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void w1() {
        CommonUtil.customConditionSet.remove(战斗);
        自动拾取start();
        自动喝药开始(null, null, true);
        tR2();
        t右键2();
    }

    @ListenMouseKeyboard(key = "w", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "w", press = false, userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void w2() {
        CommonUtil.customConditionSet.add(战斗);

        tR1();
    }


    public static boolean b右键 = false;
    static MyThread t右键 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (b右键 == true) {
                    robot.keyRelease(VK_R);

                    if (LocalDateTime.now().isBefore(time衰老)) {
                        robot.keyPress(VK_SPACE);
                        robot.keyPress(VK_E);
                        robot.keyRelease(VK_E);
                        robot.keyRelease(VK_SPACE);

                        robot.keyPress(VK_8);
                        robot.keyRelease(VK_8);

                    }else {

                        robot.keyPress(VK_6);
                        robot.keyRelease(VK_6);

                        if (判断骷髅() == false) {
                            robot.keyPress(VK_5);
                            robot.keyRelease(VK_5);

                            robot.keyPress(VK_7);
                            robot.keyRelease(VK_7);
                        }
                    }
                    pause(200L);
                } else {
                    this.mySuspend();
                }
            }
        }
    };

    public static void t右键1() {
        b右键 = true;
        t右键.myResume();
    }

    public static void t右键2() {
        b右键 = false;
    }

    public static LocalDateTime time = LocalDateTime.now();
    public static boolean bR = false;
    static MyThread tR = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (bR == true) {
                    CommonUtil.customConditionSet.add(移动);
                    robot.keyRelease(VK_R);
                    robot.keyPress(VK_R);
                    pause(300L);
                } else {
                    robot.keyRelease(VK_R);
                    CommonUtil.customConditionSet.remove(移动);
//                    time = LocalDateTime.now().plus(300L, ChronoUnit.MILLIS);
                    this.mySuspend();
                }
            }
        }
    };

    public static void tR1() {
        bR = true;
        tR.myResume();
    }

    public static void tR2() {
        bR = false;
    }

    //    @ListenMouseKeyboard(key = "2", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L, customCondition = 战斗)
//    @ListenMouseKeyboard(key = "2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L, customCondition = 战斗)
//    @ListenMouseKeyboard(key = "3", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L, customCondition = 战斗)
//    @ListenMouseKeyboard(key = "3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L, customCondition = 战斗)
    @ListenMouseKeyboard(key = "右键按下", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 500L, customCondition = 战斗)
    @ListenMouseKeyboard(key = "右键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 500L, customCondition = 战斗)
    @ListenMouseKeyboard(key = "滚轮", otherCondition = "mouseData=-7864320", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 500L, customCondition = 战斗)
    @ListenMouseKeyboard(userInput = false,key = "滚轮", otherCondition = "mouseData=-7864320", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 500L, customCondition = 战斗)
    public static TaskResult 右键() {
        tR2();
        t右键1();
        return new TaskResult(true);
    }


    //    @ListenMouseKeyboard(key = "2", press = false,userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L, customCondition = 战斗)
//    @ListenMouseKeyboard(key = "2",  press = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L, customCondition = 战斗)
//    @ListenMouseKeyboard(key = "3",  press = false,userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L, customCondition = 战斗)
//    @ListenMouseKeyboard(key = "3",  press = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L, customCondition = 战斗)
    @ListenMouseKeyboard(key = "右键松开", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L, customCondition = 战斗)
    @ListenMouseKeyboard(key = "右键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L, customCondition = 战斗)
    @ListenMouseKeyboard(key = "滚轮", otherCondition = "mouseData=7864320", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 500L, customCondition = 战斗)
    @ListenMouseKeyboard(userInput = false,key = "滚轮", otherCondition = "mouseData=7864320", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 500L, customCondition = 战斗)
    public static TaskResult 右键1() {
        t右键2();
        tR1();
        return new TaskResult(true);
    }


    public static LocalDateTime time衰老 = LocalDateTime.now();

    @ListenMouseKeyboard(key = "左键按下", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L, customCondition = 战斗)
    @ListenMouseKeyboard(key = "左键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L, customCondition = 战斗)
    public static TaskResult 左键1() {
        time衰老 = LocalDateTime.now().plus(600L, ChronoUnit.MILLIS);
        return new TaskResult(true);

    }


    @ListenMouseKeyboard(key = "c", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "c", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "d", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "d", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "t", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "t", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void t() {
        CommonUtil.customConditionSet.remove(战斗);
        自动喝药结束();

        自动拾取stop();
        tR2();
        t右键2();

    }

}
