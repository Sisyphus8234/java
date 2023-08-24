package custom;


import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.event.KeyEvent;

import static java.awt.event.InputEvent.*;
import static java.awt.event.KeyEvent.*;



public class Functions游侠 extends Functions公共 {

//    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static Long baseDelay = 200L;
    public static boolean t1Temp = false;
    public static boolean t1Temp1 = false;
    public static boolean t2Temp = false;

    public static boolean 右键或者1234在t1运行时按下 = false;
    public static boolean 之前已经有右键或者1234在t1运行时按下 = false;
    public static boolean 暂停t1时是否松开左键 = true;
    public static boolean 是否基础技能 = true;
    public static boolean 是否核心技能 = true;
    public static 筛选装备_游侠 筛选装备_游侠 = new 筛选装备_游侠();


    public static MyThread t1;
    public static MyThread t2;
    public static MyThread t3;
    public static MyThread t4;



    static {

        t1 = new MyThread(MyThread.State.on) {
            @Override
            public void run() {
                while (true) {
                    if (t1Temp == true) {

                        if(是否基础技能) {
                            robot.mouseRelease(BUTTON1_DOWN_MASK);
                            robot.mousePress(BUTTON1_DOWN_MASK);

                        }
                        robot.keyRelease(VK_5);
                        robot.keyPress(VK_5);

                        t1Temp1=true;

                    } else {
                        if(t1Temp1==true){
                        robot.keyRelease(VK_5);
                        robot.mouseRelease(BUTTON1_DOWN_MASK);
                        t1Temp1=false;
                        }
                    }
                    pause(baseDelay);
                }
            }
        };

        t2 = new MyThread(MyThread.State.on) {
            @Override
            public void run() {
                while (true) {
//
                    if (t2Temp == true) {
                        robot.keyPress(VK_G);
                        robot.keyRelease(VK_G);
                    }
                    pause(baseDelay);

                }
            }
        };


        new MyThread(MyThread.State.on) {
            @Override
            public void run() {
                while (true) {
                    if (t1Temp == true) {
                        robot.keyPress(VK_V);
                        robot.keyRelease(VK_V);
                    } else {
                    }
                    pause(baseDelay);

                }
            }
        };



        t3 = new MyThread(MyThread.State.on) {
            @Override
            public void run() {
                while (true) {

                    if (t1Temp == true ) {
                        robot.keyPress(KeyEvent.VK_6);
                        robot.keyRelease(KeyEvent.VK_6);
//                        robot.keyPress(VK_7);
//                        robot.keyRelease(VK_7);
                    } else {
                    }
                    pause(1000);

                }
            }
        };

        t4 = new MyThread(MyThread.State.off) {
            @Override
            public void run() {
                while (true) {
                    筛选装备.run( robot, 筛选装备_游侠);
                    this.mySuspend();
                }
            }
        };

    }



    @ListenMouseKeyboard(value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w() {

        暂停t1时是否松开左键 = false;
//        t1Temp1=false;
        t1Temp = false;

        t2Temp = false;
    }



    @ListenMouseKeyboard(value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {
        是否基础技能=false;
        t1Temp = true;
        t2Temp = false;
    }

    @ListenMouseKeyboard(value = 69,press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e1() {
        是否基础技能=true;
        t1Temp = true;
        t2Temp = false;
    }

    @ListenMouseKeyboard(value = 82, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void R() {
//        robot.keyRelease(VK_5);
//        robot.keyRelease(BUTTON1_DOWN_MASK);

        t1Temp = false;
        t2Temp = true;
    }


    @ListenMouseKeyboard(value = 523, keyboardOrMouse =     ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard )
    public static void 侧键_f() {
        t1Temp = false;
        t2Temp = true;
    }

    @ListenMouseKeyboard(value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false)
    public static void 侧键_f_1() {
        t1Temp = true;
        t2Temp = false;
    }




    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
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
    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1_1() {
        if (右键或者1234在t1运行时按下 == true) {
            t1Temp = true;
//            t1.myResume();
        }
        右键或者1234在t1运行时按下 = false;

    }

    @ListenMouseKeyboard(note = "3",value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "4",value = 52, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四() {
        t1Temp = false;
        t2Temp = true;
    }

    @ListenMouseKeyboard(note = "3",value = 51, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "4",value = 52, press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 四1() {
        t1Temp = true;
        t2Temp = false;
    }


    @ListenMouseKeyboard(value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    @ListenMouseKeyboard(value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键() {
        是否基础技能 = false;
    }

    @ListenMouseKeyboard(value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false, intercept = true)
    @ListenMouseKeyboard(value = 517, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键1() {
        是否基础技能 = true;
    }

    @ListenMouseKeyboard(value = 112, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备() {
        筛选装备.是否筛选装备 = true;
        筛选装备.鼠标是否回到原点 = true;
        t4.myResume();
    }

    @ListenMouseKeyboard(value = 114, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备1() {
        筛选装备.是否筛选装备 = true;
        筛选装备.鼠标是否回到原点 = false;
        t4.myResume();
    }

    @ListenMouseKeyboard(value = 113, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 图像识别_装备_终止() {
        筛选装备.是否筛选装备 = false;
    }


}
