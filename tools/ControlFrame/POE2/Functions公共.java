package custom;

import base.*;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static addition.PixelColor.*;
import static base.CommonUtil.customConditionSet;
import static base.CommonUtil.keyCodeMap;
import static java.awt.event.KeyEvent.*;

public class Functions公共 extends IFunctions {
    public static Set<String> 初始化set = new HashSet();

    public static void start(){
        t移动.nonBlock();
    }

    public static void stop(){
        t移动.block();
    }




    @ListenMouseKeyboard(intercept = true, key = "v", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, immediately = false, timeInterval = 50L, customCondition = "!" + start)
    @ListenMouseKeyboard(intercept = true,key = "v", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, immediately = false, timeInterval = 50L, customCondition = "!" + start)
    public static void ctrl(InputInfo inputInfo) {


        threadPressOrRelease(VK_CONTROL, false, true);
        threadPressOrRelease(BUTTON1_DOWN_MASK, true, true);
//        pause(50L);
        threadPressOrRelease(BUTTON1_DOWN_MASK, true, false);
        threadPressOrRelease(VK_CONTROL, false, false);
    }

    //    @ListenMouseKeyboard(intercept = true, key = "u", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,immediately = false)
//    @ListenMouseKeyboard(intercept = true, key = "u", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,immediately = false)
    @ListenMouseKeyboard(intercept = true, key = "z", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, immediately = false)
    @ListenMouseKeyboard(intercept = true, key = "z", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, immediately = false)

    public static void 丢东西(InputInfo inputInfo) {
        Point temp = getPointFix();

        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        pause(100L);

        myMouseMove(822, 941);

        pause(100L);

        robot.mousePress(BUTTON1_DOWN_MASK);
        pause(50L);
        robot.mouseRelease(BUTTON1_DOWN_MASK);

//        pause(300L);
//        robot.keyPress(VK_ENTER);
//        robot.keyRelease(VK_ENTER);
//
//        pause(50L);
//        robot.keyPress(VK_ENTER);
//        robot.keyRelease(VK_ENTER);
//        pause(300L);
        myMouseMove(temp.x, temp.y);


    }


    public static Point 回蓝point = new Point(1783, 968);
    public static Point 回蓝point1 = new Point(1785, 942);
    public static Point 回蓝point2 = new Point(1790, 980);

    public static boolean 低蓝() {
        float[] temp = getPixelColorHSB(1790, 980);
        return temp[0] <= 0.18F && temp[1] <= 0.19F && temp[2] <= 0.27F;
    }

    public static final String 回蓝开启 = "回蓝开启";
    public static MyThread 回蓝 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (CommonUtil.customConditionSet.contains(start) && customConditionSet.contains(回蓝开启)) {

                    if (低蓝()) {
//                    if(HSB.getPixelColorHSB(喝药point1.x,喝药point1.y)[2]<=0.35){
                        robot.keyPress(VK_2);
                        robot.keyRelease(VK_2);
                        pause(1500L);
                    }
                }
                pause(500L);
            }
        }
    };



    public static final String 回血开启 = "回血开启";
    public static Point 喝药point = new Point(123, 968);
    public static Point 喝药point2 = new Point(123, 955);
    public static Point 喝药point1 = new Point(965, 361);

    public static boolean 低血() {
        float[] temp = getPixelColorHSB(123, 955);
        return temp[1] <= 0.33 && temp[2] <= 0.24;
    }

    public static MyThread 喝药 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (CommonUtil.customConditionSet.contains(start) && CommonUtil.customConditionSet.contains(回血开启)) {

                    if (低血()) {
//                    if(HSB.getPixelColorHSB(喝药point1.x,喝药point1.y)[2]<=0.35){
                        robot.keyPress(VK_1);
                        robot.keyRelease(VK_1);

//                        robot.keyPress(VK_SPACE);
//                        robot.keyRelease(VK_SPACE);
                        pause(300L);
                    }
                }
                pause(300L);

            }
        }
    };


    @ListenBar(onOrOff = ListenBar.OnOrOff.on)
    public static String on = "home";

    @ListenBar(onOrOff = ListenBar.OnOrOff.off)
    public static String off = "end";


    public static final String start = "start";
    public static final String 移动 = "yd";
    public static final String 左键连点 = "zjld";



    @ListenMouseKeyboard(intercept = true, key = "win", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(intercept = true, key = "win", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(intercept = true, key = "侧键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = "!" + start)
    @ListenMouseKeyboard(intercept = true, key = "侧键按下", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = "!" + start)
    public static void 开(InputInfo inputInfo) {

        customConditionSet.addAll(初始化set);
    }




    public static final String 滚轮 = "滚轮";
    public static final String 右键按下 = "右键";

    @ListenMouseKeyboard(intercept = true, key = "shift左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = start)
    @ListenMouseKeyboard(intercept = true, key = "shift左", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = start)
    @ListenMouseKeyboard(intercept = true, key = "侧键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = start)
    @ListenMouseKeyboard(intercept = true, key = "侧键按下", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = start)
//    @ListenMouseKeyboard(intercept = true, key = "x", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(intercept = true, key = "x", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "c", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "c", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "b", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "b", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "u", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "u", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "i", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "i", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "esc", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "esc", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void 关(InputInfo inputInfo) {

        CommonUtil.customConditionSet.removeAll(初始化set);
        robot.keyRelease(VK_A);
        robot.keyRelease(VK_W);
        robot.keyRelease(VK_D);
        robot.keyRelease(VK_S);
    }

    public static final String win按下="winAX";
    @ListenMouseKeyboard(extend = true,  key = "win", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "!"+win按下)
    @ListenMouseKeyboard(extend = true, key = "win", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "!"+win按下)
    public static void 长按(InputInfo inputInfo) {
            customConditionSet.add(win按下);
            winTime =LocalDateTime.now().plus(Duration.ofMillis(200));
    }

    @ListenMouseKeyboard(extend = true,  press = false, key = "win", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(extend = true,  press = false, key = "win", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void 长按1(InputInfo inputInfo) {
        customConditionSet.remove(win按下);

        if(LocalDateTime.now().compareTo(winTime)>=0){


            customConditionSet.remove(移动);
            robot.keyRelease(VK_A);
            robot.keyRelease(VK_W);
            robot.keyRelease(VK_D);
            robot.keyRelease(VK_S);
        }
    }
    public static LocalDateTime winTime = LocalDateTime.now();


    public static MyThread 自动左键 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {

                if (customConditionSet.contains(start)&&customConditionSet.contains(左键连点)) {

                    robot.mousePress(BUTTON1_DOWN_MASK);
                    robot.mouseRelease(BUTTON1_DOWN_MASK);

                    pause(150L);
                }

            }
        }
    };

    public static Point basePoint = new Point(960, 503);

    public static MyThread t移动 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if(customConditionSet.contains(start)&&customConditionSet.contains(移动)) {
                    Point temp = getPointFix();
                    calculateAngle(basePoint, temp);
                }
                pause(100L);
            }
        }
    };


    public static int wasd = KeyWASD.前进;
    static class KeyWASD {
        static final int 前进=0;
        static final int 不动=1;
        static final int 后退=2;
    }

    public static void calculateAngle(Point a, Point b) {
        // 计算向量 (a.x - b.x, a.y - b.y)
        double deltaX = a.x - b.x;
        double deltaY = a.y - b.y;

        // 使用 atan2 计算角度，atan2 返回的是弧度值
        double angleInRadians = Math.atan2(deltaY, deltaX);

        // 将弧度转换为度数
        double angleInDegrees = Math.toDegrees(angleInRadians);

        // 如果需要让角度范围是 [0, 360)，可以进行如下调整：
        if (angleInDegrees < 0) {
            angleInDegrees += 360;
        }


        if (wasd == KeyWASD.不动) {
            robot.keyRelease(VK_A);
            robot.keyRelease(VK_W);
            robot.keyRelease(VK_D);
            robot.keyRelease(VK_S);
            return;
        }

        if (wasd == KeyWASD.后退) {
            angleInDegrees = angleInDegrees + 180;
            if (angleInDegrees > 360) {
                angleInDegrees = angleInDegrees - 360;
            }
        }

        // 计算区间编号
        int direction = (int) ((angleInDegrees + 22.5) / 45) % 8;

        switch (direction) {
            case 0: // -22.5 到 22.5 (左)
                robot.keyPress(VK_A);
                robot.keyRelease(VK_W);
                robot.keyRelease(VK_D);
                robot.keyRelease(VK_S);
                break;
            case 1: // 22.5 到 67.5 (左前)
                robot.keyPress(VK_A);
                robot.keyPress(VK_W);
                robot.keyRelease(VK_D);
                robot.keyRelease(VK_S);
                break;
            case 2: // 67.5 到 112.5 (前)
                robot.keyRelease(VK_A);
                robot.keyPress(VK_W);
                robot.keyRelease(VK_D);
                robot.keyRelease(VK_S);
                break;
            case 3: // 112.5 到 157.5 (右前)
                robot.keyRelease(VK_A);
                robot.keyPress(VK_W);
                robot.keyPress(VK_D);
                robot.keyRelease(VK_S);
                break;
            case 4: // 157.5 到 202.5 (右)
                robot.keyRelease(VK_A);
                robot.keyRelease(VK_W);
                robot.keyPress(VK_D);
                robot.keyRelease(VK_S);
                break;
            case 5: // 202.5 到 247.5 (右后)
                robot.keyRelease(VK_A);
                robot.keyRelease(VK_W);
                robot.keyPress(VK_D);
                robot.keyPress(VK_S);
                break;
            case 6: // 247.5 到 292.5 (后)
                robot.keyRelease(VK_A);
                robot.keyRelease(VK_W);
                robot.keyRelease(VK_D);
                robot.keyPress(VK_S);
                break;
            case 7: // 292.5 到 337.5 (左后)
                robot.keyPress(VK_A);
                robot.keyRelease(VK_W);
                robot.keyRelease(VK_D);
                robot.keyPress(VK_S);
                break;
        }
    }

    @ListenMouseKeyboard(intercept = true, key = "f8", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(intercept = true, userInput = false, key = "f8", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void f8(InputInfo inputInfo) {

        读取颜色();
    }


    @ListenMouseKeyboard(intercept = true, key = "f9", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(intercept = true, userInput = false, key = "f9", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void f9(InputInfo inputInfo) {

        读取颜色1();
    }


}