package custom;
import base.Config;
import base.IFunctions;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions死灵 extends IFunctions {

    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static boolean t1Temp = false;
    public static boolean t3Temp = false;
    //    public static boolean t2Temp = false;
    public static boolean 右键或者1234在t1运行时按下 = false;
    public static boolean 之前已经有右键或者1234在t1运行时按下 = false;
    public static boolean 暂停t1时是否松开左键 = true;
    public static boolean 攻击型加移动 = true;

    public static boolean 是否连点左键 = true;


    public static MyThread t1;
    public static MyThread t2;
    public static MyThread t3;

    static {
        t1 = new MyThread(MyThread.State.on) {
            @Override
            public void run() {
                while (true) {

                    if (t1Temp == true) {
                        if (攻击型加移动 == true) {
                            if (是否连点左键 == true) {
                                robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                                robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                            }
//                            robot.keyPress(KeyEvent.VK_5);
//                            robot.keyRelease(KeyEvent.VK_5);

                        } else {
//                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                            robot.keyPress(KeyEvent.VK_G);
                            robot.keyRelease(KeyEvent.VK_G);
                        }

                        pause(baseDelay);

                    } else {

//                         robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        pause(baseDelay);

                    }
                }
            }
        };
        t1.myResume();

//        t2 = new MyThread() {
//            @Override
//            public void run() {
//                while (true) {
////                    robot.keyPress(KeyEvent.VK_R);
//                    if(t2Temp==true){
//                    robot.keyPress(KeyEvent.VK_G);}
//                    if(t2Temp==false){
//
//
//                    }
//
//                    pause(200);
////                    this.mySuspend();
//
//
//                }
//            }
//        };
//        t2.myResume();

        t3 = new MyThread(MyThread.State.on) {
            @Override
            public void run() {
                while (true) {

                    if (t3Temp == true) {


                        robot.keyPress(KeyEvent.VK_5);
                        robot.keyPress(KeyEvent.VK_7);

                        robot.keyRelease(KeyEvent.VK_5);





                    } else {
                        robot.keyRelease(KeyEvent.VK_7);
                    }
                    pause(baseDelay);

                }
            }
        };

    }

//    @ListenMouseKeyboard(value = 82, intercept = true,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void r() {
//
//        t1Temp =true;
//        t1.myResume();
//
//    }
//    @ListenMouseKeyboard(value = 82,press = false, intercept = true,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void r1() {
//    }

    @ListenMouseKeyboard(value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {
        攻击型加移动 = true;
        t1Temp = true;
        t1.myResume();

//                robot.keyRelease(KeyEvent.VK_G);
//        robot.keyPress(KeyEvent.VK_G);
    }

    @ListenMouseKeyboard(value = 82, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void R() {
        攻击型加移动 = false;
        t1Temp = true;
        t1.myResume();
    }


    @ListenMouseKeyboard(value = 523, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard )
    public static void 侧键_f() {
        攻击型加移动 = false;
    }

    @ListenMouseKeyboard(value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false)
    public static void 侧键_f_1() {
        攻击型加移动 = true;
    }


    @ListenMouseKeyboard(value = 514, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w() {
        暂停t1时是否松开左键 = false;
        t1Temp = false;

//                robot.keyRelease(KeyEvent.VK_G);


    }

    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1() {
//        if(右键或者1234在t1运行时按下==true){
//            之前已经有右键或者1234在t1运行时按下=true;
//        }else {
//            之前已经有右键或者1234在t1运行时按下=false;
//        }

//        暂停t1时是否松开左键 =false;

        if (t1Temp == true) {
            右键或者1234在t1运行时按下 = true;
        }
        t1Temp = false;

    }

    //    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 49, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1_1() {
        if (右键或者1234在t1运行时按下 == true) {
            t1Temp = true;
//            t1.myResume();
        }
        右键或者1234在t1运行时按下 = false;

    }

//    @ListenMouseKeyboard(value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 四() {
//        攻击型加移动 = false;
//
//    }



    @ListenMouseKeyboard(value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键() {
        是否连点左键 = false;

    }


    @ListenMouseKeyboard(value = 517, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键1() {
        是否连点左键 = true;

    }

    @ListenMouseKeyboard(value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)


    public static void 波浪() {
        是否连点左键 = false;
        t3Temp=true;
    }

    @ListenMouseKeyboard(value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false, intercept = true)
    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false, intercept = true)

    public static void 波浪1() {
        是否连点左键 = true;
        t3Temp=false;
    }


}
