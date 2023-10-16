package custom;

import addition.FunctionsAddition;
import base.ListenMouseKeyboard;
import base.MyThread;

import static java.awt.event.KeyEvent.*;

public class Functions死灵 extends Functions公共 {
    static {
        Functions.筛选装备_子类=new 筛选装备_死灵();
    }
    public static boolean 按12时t1是否运行 = false;
    public static boolean 按space时t1是否运行 = false;
    private static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();
    public static MyThread t死灵攻击移动 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (b攻击移动 == true) {
                    robot.keyRelease(VK_G);
                    robot.keyPress(VK_G);
                    b攻击移动1 = true;
                } else {
                    if (b攻击移动1 == true) {
                        robot.keyRelease(VK_G);
                        b攻击移动1 = false;
                    }
                }
                pause(BaseDelay);
            }
        }
    };

    public static boolean 判断骷髅() {
        return pixelColor.getPixelColorHSB(776, 969)[1] < 0.59F
                || pixelColor.getPixelColorHSB(1374, 1028)[1] < 0.06F
                || pixelColor.getPixelColorHSB(1372, 983)[1] < 0.06F;
    }

    public static boolean b尸体技能优先 = false;
    public static MyThread t尸体技能优先 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (b尸体技能优先 == true) {
                    if (判断骷髅()) {
                        robot.keyPress(VK_1);
                        robot.keyRelease(VK_1);
                    }
                    else {

//                        robot.keyPress(VK_2);
//                        robot.keyRelease(VK_2);
//
//                        robot.keyPress(VK_3);
//                        robot.keyRelease(VK_3);
//
//                        robot.keyPress(VK_4);
//                        robot.keyRelease(VK_4);
//
//                        robot.keyPress(VK_W);
//                        robot.keyRelease(VK_W);

                        robot.keyRelease(VK_G);
                        robot.keyPress(VK_G);


                    }
                }
                pause(BaseDelay);
            }
        }
    };
    public static boolean b非尸体技能优先 = false;
    public static boolean b非尸体技能优先1 = false;
    public static MyThread t非尸体技能优先 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (b非尸体技能优先 == true) {
                    robot.keyPress(VK_SPACE);
                    if (b非尸体技能优先1 == false) {

                        robot.keyPress(VK_W);
                        robot.keyRelease(VK_W);
                    }
//
                    b非尸体技能优先1 = true;


                    robot.keyPress(VK_2);
                    robot.keyRelease(VK_2);
//                    }  else {
                    robot.keyPress(VK_3);
                    robot.keyRelease(VK_3);

                    robot.keyPress(VK_4);
                    robot.keyRelease(VK_4);
//                        pause(100L);


                    if (判断骷髅()) {
                        robot.keyPress(VK_1);
                        robot.keyRelease(VK_1);
                    } else {
                        robot.keyPress(VK_W);
                        robot.keyRelease(VK_W);
                    }


                } else {
                    if (b非尸体技能优先1 == true) {
                        if (space == false) {
                            robot.keyRelease(VK_SPACE);
                        }
                        b非尸体技能优先1 = false;
                    }
                }
                pause(BaseDelay);
            }
        }
    };


    @ListenMouseKeyboard(note = "e", value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {

        b移动 = false;

        自动喝药(null, null, false);

        b攻击移动 = false;

        b非尸体技能优先 = false;
        b尸体技能优先 = true;
        t尸体技能优先.myResume();


    }

    @ListenMouseKeyboard(note = "e", value = 69, press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e1() {
        b攻击移动 = true;
        b移动 = false;

        b非尸体技能优先 = false;
        b尸体技能优先 = false;

    }

    @ListenMouseKeyboard(note = "1", value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 尸体() {
//        if (b攻击移动 == true) {
//            按12时t1是否运行 = true;
//        }
        b攻击移动 = false;

        b尸体技能优先 = true;
        t尸体技能优先.myResume();

        b非尸体技能优先=false;
    }

    @ListenMouseKeyboard(note = "1", value = 49, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 尸体1() {
//        if (按12时t1是否运行 == true) {
            b攻击移动 = true;
//        }
//        按12时t1是否运行 = false;

        b尸体技能优先 = false;
    }

    @ListenMouseKeyboard(note = "2", value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 技能() {
        if (b攻击移动 == true) {
            按12时t1是否运行 = true;
        }
        b攻击移动 = false;


        b非尸体技能优先 = true;
        t非尸体技能优先.myResume();
    }

    @ListenMouseKeyboard(note = "2", value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 技能1() {
        if (按12时t1是否运行 == true) {
            b攻击移动 = true;
        }
        按12时t1是否运行 = false;

        b非尸体技能优先 = false;
    }

//    @ListenMouseKeyboard(note = "3",value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
//    public static void 技能_按一下() {
//        b攻击移动 = true;
//        b移动 = false;
//
//        tB是否尸体=false;
//        tB是否技能=false;
//    }

    //    @ListenMouseKeyboard(note = "3",value = 51, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    @ListenMouseKeyboard(note = "3", value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 技能_按一下1() {
        b攻击移动 = false;

        b非尸体技能优先 = true;
        t非尸体技能优先.myResume();
    }


    public static boolean space = false;

    @ListenMouseKeyboard(note = "space", value = 32, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 空格() {
        space = true;
        if (b攻击移动 == true) {
            按space时t1是否运行 = true;
        }
        b攻击移动 = false;
    }

    @ListenMouseKeyboard(note = "space", value = 32, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 空格1() {
        space = false;
        if (按space时t1是否运行 == true) {
            b攻击移动 = true;
        }
        按12时t1是否运行 = false;

    }

    @ListenMouseKeyboard(note = "r", value = 82, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void R() {
        b攻击移动 = false;
        Functions公共.b自动喝药 = false;
        b移动 = true;

        b非尸体技能优先 = false;
        b尸体技能优先 = false;
    }

    @ListenMouseKeyboard(note = "左键", value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(note = "w", value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w() {
        w或者左键 = true;
        b攻击移动 = false;
        b移动 = false;
        自动喝药1();

        b非尸体技能优先 = false;
        b尸体技能优先 = false;


    }

    @ListenMouseKeyboard(note = "左键", value = 514, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(note = "w", value = 87, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w_1() {
        w或者左键 = false;
    }


    @ListenMouseKeyboard(value = 523, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 侧键_f() {
        b攻击移动 = false;
        b移动 = true;

        b非尸体技能优先 = false;
        b尸体技能优先 = false;
    }

    @ListenMouseKeyboard(value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false)
    public static void 侧键_f_1() {
        b攻击移动 = true;
        b移动 = false;
    }

    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1() {
        if (b攻击移动 == true) {
            按12时t1是否运行 = true;
        }
        b攻击移动 = false;
    }

    //    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 52, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1_1() {
        if (按12时t1是否运行 == true) {
            b攻击移动 = true;
        }
        按12时t1是否运行 = false;
    }

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


}
