package custom;

import base.*;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;

import static addition.PixelColor.getPixelColorHSB;
import static base.CommonUtil.customConditionSet;
import static java.awt.event.KeyEvent.*;

public class Functions召唤 extends Functions公共 {

    static {
        初始化set.add(回蓝开启);
//		初始化set.add(回血开启);
        初始化set.add(start);
        初始化set.add(移动);
        初始化set.add(左键连点);
    }

    public static boolean 低盾() {
        float[] temp = getPixelColorHSB(171, 1064);
        return (temp[2] <= 0.18F);
    }

    public static boolean 低盾1() {
        float[] temp = getPixelColorHSB(214, 1018);
        return (temp[2] <= 0.42F);
    }

    public static boolean 低盾2() {
        float[] temp = getPixelColorHSB(224, 968);
        return (temp[2] <= 0.9F);
    }

    public static MyThread 回盾 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (CommonUtil.customConditionSet.contains(start)) {

                    if (低盾2()) {
                        robot.keyPress(VK_1);
                        robot.keyRelease(VK_1);
                        robot.keyPress(VK_SPACE);
                        robot.keyRelease(VK_SPACE);
                        pause(600);
                    }
                }
                pause(300L);

            }
        }
    };


    public static Point 怒炎 = new Point(1773, 1000);
    public static Point 怒炎1 = new Point(1800, 940);


//    public static MyThread 自动左键 = new MyThread(MyThread.State.on) {
//        @Override
//        public void run() {
//            while (true) {
//
//                if (customConditionSet.contains(start)) {
//                    if (customConditionSet.contains(右键按下)) {
//                        robot.keyPress(VK_Q);
//                        robot.keyRelease(VK_Q);
//                        pause(1000L);
//
//                        robot.keyPress(VK_6);
//                        robot.keyRelease(VK_6);
//                        pause(1000L);
//                    }
//                    pause(150L);
//                }
//
//            }
//        }
//    };


    public static boolean b放奉献 = false;
    public static boolean b火墙 = false;
    public static MyThread t滚轮 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {

            LocalDateTime 火墙时间 = LocalDateTime.now();

            while (true) {

                if (this.checkBlock() == false) {
                    myKeyRelease(VK_F);
                    myKeyRelease(VK_6);
                }

                this.getBlock();


//                if (b放奉献 == true) {
//                    myKeyPress(VK_6);
//                    myKeyRelease(VK_6);
//                    pause(300L);
//                    b放奉献 = false;
//                    tempTime=LocalDateTime.now().plus(Duration.ofMillis(9400));
//                }else{
                if (LocalDateTime.now().isAfter(火墙时间)) {
                    火墙时间 = LocalDateTime.now().plus(Duration.ofMillis(3000L));
                    robot.keyPress(VK_T);
                    pause(500L);
                    robot.keyRelease(VK_T);
//                        b火墙=false;

//                        robot.keyPress(VK_R);
//                        pause(600L);
//                        robot.keyRelease(VK_R);
                }


//                }


                myKeyPress(VK_F);


                pause(300L);

//                pause(400L);
//                滚轮上(new InputInfo());
            }
        }
    };


    public static LocalDateTime tempTime = LocalDateTime.now();

    @ListenMouseKeyboard(key = "滚轮", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "-7864320,-15728640", customCondition = start, timeInterval = 800L)
    @ListenMouseKeyboard(key = "滚轮", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "-7864320,-15728640", customCondition = start, timeInterval = 800L)
    public static void 滚轮下() {
        customConditionSet.remove(左键连点);

        wasd = 2;

        customConditionSet.add(滚轮);

//        if (LocalDateTime.now().isAfter(tempTime)) {
//            b放奉献 = true;
//        }

        b火墙 = true;

        t滚轮.nonBlock();


    }


    @ListenMouseKeyboard(key = "滚轮", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "7864320,15728640", customCondition = start, timeInterval = 800L)
    @ListenMouseKeyboard(key = "滚轮", userInput = false, intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "7864320,15728640", customCondition = start, timeInterval = 800L)
    public static void 滚轮上(InputInfo inputInfo) {
        customConditionSet.add(左键连点);


        if (!customConditionSet.contains(滚轮)) {
            threadPressOrReleaseWithDelay(VK_X, false, true, 0);
            threadPressOrReleaseWithDelay(VK_X, false, false, 400);

            threadPressOrReleaseWithDelay(VK_SPACE, false, true, 0);


//            threadPressOrReleaseWithDelay(VK_SPACE, false, false, 800);
//
//            threadPressOrReleaseWithDelay(VK_X, false, true, 0);
//            threadPressOrReleaseWithDelay(VK_X, false, false, 0);

                threadPressOrReleaseWithDelay(VK_SPACE, false, false, 0);//
//                threadPressOrReleaseWithDelay(VK_0, false, true, 200);
                threadPressOrReleaseWithDelay(VK_0, false, true, 0);
                threadPressOrReleaseWithDelay(VK_0, false, false, 0);

        } else {
            customConditionSet.remove(滚轮);
            t滚轮.block();

            if (customConditionSet.contains(右键按下)) {
                wasd = 1;
            } else {
//				threadPressOrRelease(VK_F, false, false);
//				threadPressOrRelease(VK_R, false, false);
                wasd = 0;
            }
            threadPressOrRelease(VK_F, false, false);
            threadPressOrRelease(VK_T, false, false);
        }
    }


    @ListenMouseKeyboard(key = "右键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = "!" + 右键按下 + "," + start)
    @ListenMouseKeyboard(userInput = false, key = "右键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = "!" + 右键按下 + "," + start)
    public static void 右键() {
        customConditionSet.add(右键按下);
//        customConditionSet.remove(左键连点);
//        customConditionSet.remove(移动);
    }


    //
    @ListenMouseKeyboard(key = "右键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = 右键按下 + "," + start)
    @ListenMouseKeyboard(userInput = false, key = "右键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = 右键按下 + "," + start)
    public static void 右键1() {
        customConditionSet.remove(右键按下);
//        customConditionSet.add(左键连点);
//        customConditionSet.add(移动);
    }


//    public static boolean 快闪现=true;
//    @ListenMouseKeyboard(key = "3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = start)
//    @ListenMouseKeyboard(userInput = false, key = "3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = start)
//    public static void 三() {
//
//        customConditionSet.remove(移动);
//        robot.keyRelease(VK_A);
//        robot.keyRelease(VK_W);
//        robot.keyRelease(VK_D);
//        robot.keyRelease(VK_S);
//
//    }

//    @ListenMouseKeyboard(key = "4", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = start)
//    @ListenMouseKeyboard(userInput = false, key = "4", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = start)
//    public static void 四() {
//        if(customConditionSet.contains(start)){
//            customConditionSet.add(移动);
//
//        }
//    }
}