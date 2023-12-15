package custom;
import base.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

import static java.awt.event.KeyEvent.*;

class MainClass extends base.MainClass {

}

public class Functions extends IFunctions {
    static {
//        Controller.printKey=true;
    }
    public static Long baseDelay = Long.parseLong(Config.read("base_delay"));
    public static boolean temp1 = false;
    public static boolean temp2 = false;
    public static boolean t3Temp = false;
    public static MyThread t1;
    public static MyThread t2;
    public static MyThread t3;
    public static MyThread t4;


    public static int x = Integer.parseInt(Config.read("x"));
    public static int y = Integer.parseInt(Config.read("y"));

    public static boolean 滚轮变成左键 = true;
    public static boolean ctrl按下 = false;
    public static int 滚轮次数 = 0;

    public static int 滚轮方向 = 1;
    public static Long time = new Date().getTime();

    public static Point point = new Point();

    public static int WhichProgram = Integer.parseInt(Config.read("which_program"));

    static {


        t1 = new MyThread() {
            @Override
            public void run() {
                while (true) {
                    if (temp2 == false) {
                        temp2 = true;
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    } else if (temp1 == false) {

                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        temp2 = false;
//                        temp2 =false;
                        t1.mySuspend();
                    }
                    pause(baseDelay);
                }

            }
        };


        t2 = new MyThread() {
            @Override
            public void run() {
                while (true) {
                    if (切换次数 > 0) {
                        robot.keyPress(KeyEvent.VK_ALT);
                        robot.keyPress(KeyEvent.VK_TAB);
                        pause(50);
                        robot.keyRelease(KeyEvent.VK_TAB);
                        robot.keyRelease(KeyEvent.VK_ALT);
                        pause(200);
                    }


                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_TAB);

                    robot.keyRelease(KeyEvent.VK_TAB);
                    pause(100);
                    if (切换次数 > 0) {

                        for (Integer i = 0; i < 切换次数; i++) {
                            pause(100);
                            robot.keyPress(KeyEvent.VK_RIGHT);
                            pause(100);
                            robot.keyRelease(KeyEvent.VK_RIGHT);
//                                System.out.println("----执行了右箭头");

                        }

                    }

                    robot.keyRelease(KeyEvent.VK_ALT);
                    切换次数 += 1;
                    t2.mySuspend();
                }
            }
        };


        t3 = new MyThread() {
            @Override
            public void run() {
                while (true) {

                    if (t3Temp == true) {
                        robot.mouseWheel(滚轮方向);
                        pause(50);
                    } else {
                        this.mySuspend();
                    }
                }
            }
        };

        t4 = new MyThread() {
            @Override
            public void run() {
                while (true) {

                    if (滚轮次数 > 0) {
                        System.out.println(滚轮方向);
                        robot.mouseWheel(滚轮方向);
                        pause(10);
                        滚轮次数--;
                    } else {
                        this.mySuspend();
                    }
                }
            }
        };
    }


    @ListenMouseKeyboard(note = "esc",value = 27, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "菜单键",value = 93, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "侧键",value = 523, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void esc和菜单键() {
        temp1 = true;
        t1.myResume();
    }

    @ListenMouseKeyboard(note = "esc",value = 27, press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "菜单键",value = 93, press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "侧键",value = 524, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void esc和菜单键1() {
        temp1 = false;
    }

    @ListenMouseKeyboard(note = "f1",value = 112, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void f1键按下() {
        robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);

    }

    @ListenMouseKeyboard(note = "f1",value = 112, press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void f1键松开() {
        robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
    }

    @ListenMouseKeyboard(value = 113, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void f2键() {
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @ListenMouseKeyboard(value = 114, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void f3键() {
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
    }

    @ListenMouseKeyboard(value = 115, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void f4键() {
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
    }

    @ListenMouseKeyboard(value = 113, press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 114, press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 115, press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 松开() {

    }

    public static boolean 波浪键按住 = false;
    public static boolean 波浪键按住期间做了什么 = false;
    public static Integer 切换次数 = 0;
    @ListenMouseKeyboard(note = "`",value = 192, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 波浪键0() {
        波浪键按住期间做了什么 = false;
        波浪键按住 = true;
        切换次数 = 0;
    }


    @ListenMouseKeyboard(note = "`",value = 192, intercept = true, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 波浪键1() {
        波浪键按住 = false;
        if (波浪键按住期间做了什么 == true) {
        } else {
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(WhichProgram);
            pause(50);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            robot.keyRelease(WhichProgram);

//            robot.keyPress(KeyEvent.VK_BACK_QUOTE);
//            robot.keyRelease(KeyEvent.VK_BACK_QUOTE);
        }
    }


    public static float screenScale= Float.parseFloat(Config.read("screen_scale"));
    @ListenMouseKeyboard(note="q",value = 81, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void q(InputInfo inputInfo) {
        tempQW(new Point(845,418),inputInfo);
    }

    @ListenMouseKeyboard(note="w",value = 87, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w(InputInfo inputInfo) {
        tempQW(new Point(845,498),inputInfo);
    }

    public static void tempQW(Point point,InputInfo inputInfo){
        波浪键按住期间做了什么=true;
        if(波浪键按住==true){
            robot.keyPress(VK_WINDOWS);
            robot.keyPress(VK_1);
            robot.keyRelease(VK_1);
            robot.keyRelease(VK_WINDOWS);

            robot.mouseMove((int) (point.x/screenScale), (int) (point.y/screenScale));
            pause(100L);
            robot.mousePress(BUTTON1_DOWN_MASK);
            robot.mouseRelease(BUTTON1_DOWN_MASK);
            pause(100L);

            robot.keyPress(VK_WINDOWS);
            robot.keyPress(VK_1);
            robot.keyRelease(VK_1);
            robot.keyRelease(VK_WINDOWS);
        }else {
            robot.keyPress(inputInfo.value);
        }
    }




    @ListenMouseKeyboard(value = 9, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void tab键() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;
            t2.myResume();
        } else {
            robot.keyPress(KeyEvent.VK_TAB);
        }
    }


    @ListenMouseKeyboard(value = 51, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字3() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;




            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(VK_1);
            pause(50);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            robot.keyRelease(VK_1);

//            Point point1=MouseInfo.getPointerInfo().getLocation();
//
//            pause(200);
//
//            robot.mouseMove(520,364);
//            pause(200);
//            System.out.println(point1);

        } else {
            robot.keyPress(KeyEvent.VK_3);
        }
    }


    public static boolean leftBotton = false;
    public static boolean rightBotton = false;

    //功能:切屏
    @ListenMouseKeyboard(value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void f16() {
        leftBotton = true;
        if (rightBotton == true) {
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_TAB);

            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
    }

    @ListenMouseKeyboard(value = 514, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void f15() {
        leftBotton = false;
    }

    @ListenMouseKeyboard(value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void f16_2() {
        rightBotton = true;
        if (leftBotton == true) {
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_TAB);

            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

    }

    @ListenMouseKeyboard(value = 517, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void f19() {
        rightBotton = false;
    }

    @ListenMouseKeyboard(value = 106, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字键盘星号() {
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(WhichProgram);
        pause(50);
        robot.keyRelease(WhichProgram);
        robot.keyRelease(KeyEvent.VK_WINDOWS);

    }

    @ListenMouseKeyboard(value = 107, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字键盘减号() {
        滚轮方向 = 1;
        t3Temp = true;
        t3.myResume();
    }

    @ListenMouseKeyboard(value = 107, press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字键盘减号1() {
        t3Temp = false;
    }


    @ListenMouseKeyboard(value = 109, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字键盘加号() {
        滚轮方向 = -1;
        t3Temp = true;
        t3.myResume();
    }

    @ListenMouseKeyboard(value = 109, press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字键盘加号1() {
        t3Temp = false;
    }


    @ListenMouseKeyboard(value = 49, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字1() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;

            滚轮方向 = 1;
            t3Temp = true;
            t3.myResume();

        } else {
            robot.keyPress(VK_1);
        }
    }


    @ListenMouseKeyboard(value = 49, intercept = true, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字1_1() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;

            t3Temp = false;
        } else {
            robot.keyRelease(VK_1);
        }
    }

    @ListenMouseKeyboard(value = 50, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字2() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;

            滚轮方向 = -1;
            t3Temp = true;
            t3.myResume();

        } else {
            robot.keyPress(KeyEvent.VK_2);
        }
    }

    @ListenMouseKeyboard(value = 50, intercept = true, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字2_1() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;

            t3Temp = false;

        } else {
            robot.keyRelease(KeyEvent.VK_2);
        }
    }


    @ListenMouseKeyboard(value = 162, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void ctrl() {
        ctrl按下 = true;
    }

    @ListenMouseKeyboard(value = 162, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false)
    public static void ctrl_1() {
        ctrl按下 = false;
    }

//    @ListenMouseKeyboard(value = 522, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.MouseWithMouseData, mouseData = -7864320)
//    public static void 滚轮() {
//
//
//        if (ctrl按下 == false) {
//            滚轮方向 = 1;
//            滚轮次数++;
//            t4.myResume();
//        }
//
//    }

//    @ListenMouseKeyboard(value = 522, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.MouseWithMouseData, mouseData = 7864320)
//    public static void 滚轮_1() {
//
//        if (ctrl按下 == false) {
//            滚轮方向 = -1;
//            滚轮次数++;
//            t4.myResume();
//        }
//    }


}
