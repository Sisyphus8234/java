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
                if (b攻击移动 == true) {
//                    if(b攻击移动1==false){

//                        robot.keyPress(VK_G);
//                        robot.mousePress(BUTTON1_DOWN_MASK);
//                    }
//                    if(space==true){
//                        robot.keyRelease(VK_G);
//                    }else {
//                        robot.keyPress(VK_G);
//                    }


                    b攻击移动1 = true;
                    if (v按下 == true) {

                        robot.mouseRelease(BUTTON1_DOWN_MASK);
                        robot.keyRelease(VK_5);

                        pause(BaseDelay);
                        continue;
                    }

                    if (b无干扰按键进行中 == true) {

                        pause(BaseDelay);
                        continue;
                    }


//                    if(e按下==false&&判断旋风斩怒气是否满足()==true){
//                        是否使用旋风斩=true;
//
//                    }
//
//                    if(pixelColor.getPixelColorHSB(1318, 1040)[1] <0.75F){
//                        是否使用旋风斩=false;
//                    }
//
//                    if(是否使用旋风斩==true){
//                        是否核心技能=true;
//                        是否基础技能=false;
//                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//                    }else {
//                        是否核心技能=false;
//                        是否基础技能=true;
//                        robot.keyRelease(KeyEvent.VK_5);
//                    }

//
//                    if (
//                            判断核心技能怒气是否满足() &&
//                                    是否核心技能) {
////                        robot.keyRelease(KeyEvent.VK_5);
//                        robot.keyPress(KeyEvent.VK_5);
//                        robot.keyRelease(KeyEvent.VK_5);
//                    }
//
//
//                    if (是否基础技能 == true) {
//                        robot.keyPress(VK_4);
//                        robot.keyRelease(VK_4);
//                    }


//                    robot.keyRelease(VK_G);

//                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    if (判断核心技能怒气是否满足()) {
//                        robot.keyPress(VK_G);
                        robot.keyRelease(KeyEvent.VK_5);
                        robot.keyPress(KeyEvent.VK_5);
//                        robot.keyRelease(KeyEvent.VK_5);
//                        robot.keyRelease(VK_G);

                    } else {
                        robot.keyRelease(KeyEvent.VK_5);
                    }

                    if (是否基础技能 == true) {

                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    }


                } else {
                    if (b攻击移动1 == true) {
//                        robot.keyRelease(VK_G);
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

//    static {
//        要暂停的t=t1;
//    }


    public static boolean e按下 = false;
    public static LocalDateTime e按下时间 = LocalDateTime.now();
    public static boolean z按过了 = false;

    @ListenMouseKeyboard(note = "e", value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "z", value = 90, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {
        b攻击移动 = true;
        b移动 = false;
        自动喝药(null, null, false);
        筛选装备.关闭传奇标记();


//        if(e按下==false){
//            e按下时间=LocalDateTime.now();
//            z按过了=false;
//        }
//        e按下=true;
//
//
//        if(Duration.between(e按下时间,LocalDateTime.now()).toMillis()>250L&&z按过了==false){
//            robot.keyPress(VK_Z);
//            robot.keyRelease(VK_Z);
//            z按过了=true;
//        }


//        是否使用旋风斩=false;


    }

//    @ListenMouseKeyboard(note = "e", press = false,value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void e_1() {
//        e按下=false;
//
//    }


    public static FunctionsAddition.PixelColor pixelColor1 = new FunctionsAddition.PixelColor();

    @ListenMouseKeyboard(note = "1", intercept = true, value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 1000L)
    @ListenMouseKeyboard(note = "2", intercept = true, value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 1000L)
    @ListenMouseKeyboard(note = "3", intercept = true, value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 1000L)
    @ListenMouseKeyboard(note = "4", intercept = true, value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 1000L)
    public static void 无干扰按键(InputInfo inputInfo) {

        int value = inputInfo.value;

        if (inputInfo.value == VK_1) {
            if (pixelColor1.getPixelColorHSB(805, 982)[2] < 0.15F) {
//                if (pixelColor1.getPixelColorHSB(931, 981)[1] < 0.37F) {
//                value=VK_2;
                要按的key.add(VK_2);
//            }
            }
        }

        if (inputInfo.value == VK_2) {
            if (pixelColor1.getPixelColorHSB(805, 982)[2] > 0.15F) {
                value = VK_1;
            }
        }
        要按的key.add(value);


        b无干扰按键 = true;
        t无干扰按键.myResume();
    }

    @ListenMouseKeyboard(note = "右键", value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键() {

        核心技能跳过条件 = true;
        是否基础技能 = false;
    }

    @ListenMouseKeyboard(note = "右键", value = 517, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键1() {
        核心技能跳过条件 = false;
        是否基础技能 = true;
    }

    public static boolean space = false;


    public static boolean v按下 = false;

    @ListenMouseKeyboard(note = "v", value = 86, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "`", value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void v() {
        v按下 = true;
    }

    @ListenMouseKeyboard(note = "v", press = false, value = 86, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "`", press = false, value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void v_1() {
        v按下 = false;
    }

    @ListenMouseKeyboard(note = "space", value = 32, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void space() {
        space = true;
    }

    @ListenMouseKeyboard(note = "space", press = false, value = 32, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void space_1() {
        space = false;
    }


//        public static MyThread t自动技能 = new MyThread(MyThread.State.on) {
//        @Override
//        public void run() {
//            while (true) {
//                if (b攻击移动 == true&&v按下==false) {
//
//
//                    robot.keyPress(VK_8);
//                    robot.keyRelease(VK_8);
//                }
//                pause(300L);
//            }
//        }
//    };


//    public static MyThread t钢铁之肤 = new MyThread(MyThread.State.on) {
//        @Override
//        public void run() {
//            while (true) {
//                if (b攻击移动 == true) {
//                    if (Functions公共.pixelColor.getPixelColorHSB(617, 970)[1] < 0.5F) {
//                        robot.keyPress(VK_8);
//                        robot.keyRelease(VK_8);
//                    }
//                } else {
//
//                }
//                pause(300L);
//            }
//        }
//    };


    static {
        Functions公共.筛选装备_子类 = new 筛选装备_野蛮人();
    }


}
