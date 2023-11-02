package custom;

import base.*;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.MouseEvent.*;

class a extends MainClass {

}

public class Functions extends IFunctions {


    static {
        Controller.printKey = true;
    }

    public static boolean t1B = false;
    public static boolean 是否攻击 = false;
    public static boolean 是否正在右键连点 = false;
    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {

                if (t1B == true) {
                        robot.mouseRelease(BUTTON3_DOWN_MASK);
                        robot.keyPress(VK_V);
                        robot.keyRelease(VK_V);
                        是否正在右键连点=true;


                }
                else {
                    if(是否正在右键连点==true) {
                        robot.mousePress(BUTTON3_DOWN_MASK);
                        是否正在右键连点=false;
                    }

                }

                pause(200L);
            }
        }
    };


    @ListenMouseKeyboard(note = "z", value = 90, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void alt() {
        robot.mousePress(BUTTON3_DOWN_MASK);
//        t1B = true;
    }

//    @ListenMouseKeyboard(note = "右键", value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
////    @ListenMouseKeyboard(note = "左键", value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    public static void alt_2() {
//
//        t1B = false;
//    }

    @ListenMouseKeyboard(note = "f", intercept = true,value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void r() {

        t1B = true;
    }

    @ListenMouseKeyboard(note = "f",press = false,intercept = true, value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void r_1() {
        t1B = false;
    }


}