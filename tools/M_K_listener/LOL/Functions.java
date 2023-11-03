package custom;

import base.*;

import static java.awt.event.KeyEvent.*;

class a extends MainClass {

}

public class Functions extends IFunctions {


    static {
        Controller.printKey = true;
    }

    public static boolean t1B = false;
    public static boolean t1B1 = false;
    public static int t1Key = 0;
    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {

                if (t1B == true) {
                        robot.mouseRelease(BUTTON3_DOWN_MASK);
                        robot.keyPress(t1Key);
                        robot.keyRelease(t1Key);
                        t1B1 =true;


                }
                else {
                    if(t1B1 ==true) {
                        robot.mousePress(BUTTON3_DOWN_MASK);
                        t1B1 =false;
                    }

                }

                pause(200L);
            }
        }
    };


    @ListenMouseKeyboard(note = "z", value = 90, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void z() {
        robot.mousePress(BUTTON3_DOWN_MASK);
    }


    @ListenMouseKeyboard(note = "f", intercept = true,value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void r() {
        t1Key=VK_V;
        t1B = true;
    }

    @ListenMouseKeyboard(note = "r", intercept = true,value = 82, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void f() {
        t1Key=VK_R;
        t1B = true;
    }

    @ListenMouseKeyboard(note = "f",press = false,intercept = true, value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "r",press = false,intercept = true, value = 82, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void r_1() {
        t1B = false;
    }





}