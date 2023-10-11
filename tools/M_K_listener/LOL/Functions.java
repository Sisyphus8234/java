package custom;

import base.*;

import static java.awt.event.InputEvent.BUTTON3_DOWN_MASK;
import static java.awt.event.KeyEvent.VK_R;

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

                    if (是否攻击 == false) {
                        robot.mouseRelease(BUTTON3_DOWN_MASK);
                        robot.mousePress(BUTTON3_DOWN_MASK);
                        是否正在右键连点=true;
                    } else {
                        if(是否正在右键连点==true) {
                            robot.mouseRelease(BUTTON3_DOWN_MASK);
                        }

                        robot.keyPress(VK_R);
                        robot.keyRelease(VK_R);
                    }
                }else {
                    if(是否正在右键连点==true) {
                        robot.mouseRelease(BUTTON3_DOWN_MASK);
                    }
                }

                pause(200L);
            }
        }
    };


    @ListenMouseKeyboard(note = "alt", value = 164, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void alt() {
        t1B = true;
    }

    @ListenMouseKeyboard(note = "右键", value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void alt_2() {

        t1B = false;
    }

    @ListenMouseKeyboard(note = "r", intercept = true, value = 82, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void r() {
        是否攻击 = true;
    }

    @ListenMouseKeyboard(note = "r", press = false, intercept = true, value = 82, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)

    public static void r_1() {

        是否攻击 = false;
    }


}