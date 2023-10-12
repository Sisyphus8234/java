package custom;

import addition.FunctionsAddition;
import base.ListenMouseKeyboard;
import base.MyThread;

import static java.awt.event.KeyEvent.*;

public class Functions死灵1 extends Functions公共 {
    public static Long baseDelay = 200L;
    public static boolean t1B = false;
    public static boolean tB是否尸体 = false;
    public static boolean tB是否技能 = false;
    public static boolean t1B1 = false;
    public static boolean t2B = false;
    public static boolean 按12时t1是否运行 = false;
    public static boolean 按space时t1是否运行 = false;
    public static boolean 是否基础技能 = true;
    public static boolean 是否核心技能 = true;
    private static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();
    private static FunctionsAddition.PixelColor pixelColor1 = new FunctionsAddition.PixelColor();
    public static boolean w或者左键 = false;



    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (t1B == true) {
                    t1B1 = true;
                    robot.mouseRelease(BUTTON1_DOWN_MASK);
                    robot.mousePress(BUTTON1_DOWN_MASK);
                } else {
                    if(t1B1==true){
                        robot.keyRelease(VK_5);
                        if(w或者左键==false) {
                            robot.mouseRelease(BUTTON1_DOWN_MASK);
                        }
                        t1B1=false;
                    }
                }
                pause(baseDelay);
            }
        }
    };


    public static boolean t技能B1 = false;
    public static MyThread t技能 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (tB是否技能 == true) {
                    robot.keyPress(VK_SPACE);
//                    if(t技能B1==false){
//
//                        robot.keyPress(VK_2);
//                        robot.keyRelease(VK_2);
//                    }





//
                    t技能B1 = true;




                    if(pixelColor.getPixelColorHSB(1308,1020)[1]>0.14F){
                        robot.keyPress(VK_5);
                        robot.keyRelease(VK_5);
                    }else {
                        robot.keyPress(VK_2);
                        robot.keyRelease(VK_2);
                    }









                } else {
                    if (t技能B1 == true) {
                        if (space == false) {
                            robot.keyRelease(VK_SPACE);
                        }
                        t技能B1=false;
                    }
                }
                pause(baseDelay);
            }
        }
    };


    public static MyThread t2 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (t2B == true) {
                    robot.keyPress(VK_G);
                    robot.keyRelease(VK_G);
                }
                pause(baseDelay);

            }
        }
    };
    public static boolean t捡东西B = false;
    public static MyThread t捡东西 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                if (t1B == true) {
                    robot.keyRelease(VK_V);
                    robot.keyPress(VK_V);
                    t捡东西B = true;
                } else {
                    if (t捡东西B == true) {
                        robot.keyRelease(VK_V);
                        t捡东西B = false;
                    }

                }
                pause(baseDelay);
            }
        }
    };


    @ListenMouseKeyboard(note = "e", value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {
        t1B = true;
        t2B = false;
        Functions公共.自动喝药B = true;
        Functions公共.t1.myResume();

        tB是否尸体=false;
        tB是否技能=false;
    }




    @ListenMouseKeyboard(note = "2",value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 技能() {
        if (t1B == true) {
            按12时t1是否运行 = true;
        }
        t1B = false;


        tB是否技能 = true;
        t技能.myResume();
    }

    @ListenMouseKeyboard(note = "2",value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 技能1() {
        if (按12时t1是否运行 == true) {
            t1B = true;
        }
        按12时t1是否运行 = false;

        tB是否技能 = false;
    }





    public static boolean space = false;
    @ListenMouseKeyboard(note = "space", value = 32, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 空格() {
        space = true;
//        if (t1B == true) {
//            按space时t1是否运行 = true;
//        }
//        t1B = false;
    }

    @ListenMouseKeyboard(note = "space", value = 32, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 空格1() {
        space = false;
//        if (按space时t1是否运行 == true) {
//            t1B = true;
//        }
//        按12时t1是否运行 = false;

    }

    @ListenMouseKeyboard(note="r",value = 82, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void R() {
        t1B = false;
        Functions公共.自动喝药B =false;
        t2B = true;

        tB是否技能=false;
        tB是否尸体=false;
    }

    @ListenMouseKeyboard(note="左键",value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(note="w",value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w() {
        w或者左键 = true;
        t1B = false;
//        Functions公共.自动喝药 = false;
        t2B = false;

        tB是否技能=false;
        tB是否尸体=false;
    }

    @ListenMouseKeyboard(note="左键",value = 514, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(note="w",value = 87, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w_1() {
        w或者左键 = false;
    }




    @ListenMouseKeyboard(value = 523, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 侧键_f() {
        t1B = false;
        t2B = true;

        tB是否技能=false;
        tB是否尸体=false;
    }

    @ListenMouseKeyboard(value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false)
    public static void 侧键_f_1() {
        t1B = true;
        t2B = false;
    }

    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1() {
        if (t1B == true) {
            按12时t1是否运行 = true;
        }
        t1B = false;
    }

    //    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(value = 49, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 52, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1_1() {
        if (按12时t1是否运行 == true) {
            t1B = true;
        }
        按12时t1是否运行 = false;
    }

    //    @ListenMouseKeyboard(note = "3",value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "4",value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四() {
        t1B = false;
        t2B = true;
    }

    //    @ListenMouseKeyboard(note = "3",value = 51, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "4",value = 52, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四1() {
        t1B = true;
        t2B = false;
    }


}
