package custom;

import addition.FunctionsAddition;
import base.InputInfo;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalDateTime;

import static java.awt.event.InputEvent.*;
import static java.awt.event.KeyEvent.*;

public class Functions野蛮人 extends Functions公共 {
    public static boolean 是否基础技能 = true;
    public static boolean 是否核心技能 = true;
    public static boolean 核心技能跳过条件 = false;

    public static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();

    public static boolean 最终是否满足 = true;
    public static LocalDateTime start = LocalDateTime.now();

    public static boolean 判断核心技能怒气是否满足() {
        return pixelColor.getPixelColorHSB(1318, 960)[0] < 0.33F || 核心技能跳过条件;
//        return pixelColor.getPixelColorHSB(1318, 975)[0] < 0.33F || 核心技能跳过条件;

    }

    public static boolean 判断核心技能怒气是否满足_1() {
        if (判断核心技能怒气是否满足() == true) {
            start = LocalDateTime.now();
        }else {

        }

        if(Duration.between(start,LocalDateTime.now()).toMillis()>900L){
            最终是否满足=false;
        }else {
            最终是否满足=true;
        }

        return 最终是否满足;
    };

    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (b攻击移动 == true) {
//                    if(b攻击移动1==false){
                    b攻击移动1 = true;
//                        robot.keyPress(VK_G);
//                    }
//                    if(space==true){
//                        robot.keyRelease(VK_G);
//                    }else {
//                        robot.keyPress(VK_G);
//                    }


//                    if (是否核心技能) {
//                        判断核心技能怒气是否满足();
//                    }
//                    if (是否基础技能 == true) {
//                        robot.keyPress(KeyEvent.VK_4);
//                        robot.keyRelease(KeyEvent.VK_4);
//                    }
//                    pause(BaseDelay);



                    if (v按下==true){

                        robot.mouseRelease(BUTTON1_DOWN_MASK);

                        robot.keyRelease(VK_V);
                        robot.keyRelease(VK_V);
                        pause(BaseDelay);
                        continue;
                    }

                    if (是否基础技能 == true) {
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);


                    }

                    if (判断核心技能怒气是否满足_1()) {
//                        robot.keyRelease(KeyEvent.VK_5);
                        robot.keyPress(KeyEvent.VK_5);
                        robot.keyRelease(KeyEvent.VK_5);


                    }

                    if (是否基础技能 == true) {
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);


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


    @ListenMouseKeyboard(note = "e", value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {
        b攻击移动 = true;
        b移动 = false;
        自动喝药(null, null, false);
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

    public static boolean space=false;


    public static boolean v按下=false;

    @ListenMouseKeyboard(note = "v", value = 86,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void v() {
        v按下=true;
    }
    @ListenMouseKeyboard(note = "v",press = false, value = 86,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void v_1() {
        v按下=false;

    }

    @ListenMouseKeyboard(note = "space", value = 32, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void space() {
space=true;
    }

    @ListenMouseKeyboard(note = "space", press = false,value = 32, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void space_1() {
space=false;
    }

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


    @ListenMouseKeyboard(note = "1", intercept = true, value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "2", intercept = true, value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "3", intercept = true, value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "4", intercept = true, value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 无干扰按键(InputInfo inputInfo) {
        无干扰按键(inputInfo.value, t1);
    }


//    public static FunctionsAddition.PixelColor pixelColor1 = new FunctionsAddition.PixelColor();

    public static void 按键(int key) {
        robot.keyPress(key);
        robot.keyRelease(key);
    }

//    public static int 按的是几 = -1;

//    public static void tempF() {
//        if (pixelColor1.getPixelColorHSB(993, 981)[1] > 0.1F) {
//            按的是几 = 4;
//            按键(VK_4);
//        } else if (pixelColor1.getPixelColorHSB(931, 981)[1] > 0.1F) {
//            按键(VK_3);
//        } else if (pixelColor1.getPixelColorHSB(868, 981)[1] > 0.1F) {
//            按键(VK_2);
//        } else if (pixelColor1.getPixelColorHSB(805, 978)[1] > 0.1F) {
//            按键(VK_1);
//        }
//    }

//    public static int 判断几是亮的() {
////        if (pixelColor1.getPixelColorHSB(993, 981)[1] > 0.1F) {
////            return VK_4;
////        } else
//        if (pixelColor1.getPixelColorHSB(931, 979)[1] > 0.1F) {
//            return VK_3;
//        } else if (pixelColor1.getPixelColorHSB(868, 979)[1] > 0.1F) {
//            return VK_2;
//        } else if (pixelColor1.getPixelColorHSB(805, 979)[1] > 0.1F) {
//            return VK_1;
//        }
//
//        return -1;
//    }



//    public static boolean b延续狂暴 = false;
//    public static MyThread t延续狂暴 = new MyThread() {
//        @Override
//        public void run() {
//            while (true) {
//                if (b延续狂暴 == true) {
//                    int 判断几是亮的 = 判断几是亮的();
//                    System.out.println(判断几是亮的);
//                    if (Duration.between(start, LocalDateTime.now()).toMillis() > 5000 &&
//                            (按的是几 == -1 || 判断几是亮的 == 按的是几)) {
//                        System.out.println(Duration.between(start, LocalDateTime.now()).toMillis());
//                        按键(判断几是亮的);
//                        按的是几 = 判断几是亮的;
//                    } else {
//                        Functions公共.start = LocalDateTime.now();
//                        按的是几 = -1;
//                    }
//                } else {
//                    this.mySuspend();
//                }
//                pause(BaseDelay);
//            }
//        }
//    };
//
//
//    //    @ListenMouseKeyboard(note = "`", value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void f延续狂暴() {
//        b延续狂暴 = true;
//        t延续狂暴.myResume();
//    }
//
//    //    @ListenMouseKeyboard(note = "`",press = false, value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void f延续狂暴_1() {
//        b延续狂暴 = false;
//    }


    static {
        Functions公共.筛选装备_子类 = new 筛选装备_野蛮人();
    }


}
