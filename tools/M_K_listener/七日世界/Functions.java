package custom;

import base.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.event.KeyEvent.*;

class Run extends MainClass {


}

public class Functions extends IFunctions {
    static {
//        Controller.printKey = true;
    }

    public static MyThread t1 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (t1Temp == true) {
                    robot.keyPress(VK_Q);
                    robot.keyRelease(VK_Q);
                    pause(1000L);
                } else {
                    t1.mySuspend();
                }

            }
        }
    };


    public static MyThread t2 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (t1Temp == true) {

                    robot.keyPress(VK_F);
                    robot.keyRelease(VK_F);
                    pause(200L);
                } else {
                    t2.mySuspend();
                }

            }
        }
    };


    public static boolean t1Temp = true;
    public static Long time1 = Long.valueOf(Config.read("Time1"));


    public static void t1Start() {
        t1Temp = true;
        t1.myResume();
        t2.myResume();
    }

    public static void t1Stop() {
        t1Temp = false;
    }


    @ListenMouseKeyboard(key = "q", intercept = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void q() {
        t1Start();
    }

    @ListenMouseKeyboard(key = "tab", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "f", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "右键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(key = "左键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    public static void 取消() {
        t1Stop();
    }

    @ListenMouseKeyboard(key = "win", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void alt() {
        t1Stop();

        robot.keyPress(VK_ESCAPE);
        robot.keyRelease(VK_ESCAPE);
    }

    @ListenMouseKeyboard(key = "shift左", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,timeInterval = 1000L)
    public static void shift() {
        robot.keyRelease(VK_SHIFT);

    }

    @ListenMouseKeyboard(key = "shift左", press = false, intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void shift1() {
        robot.keyPress(VK_SHIFT);
    }

    @ListenMouseKeyboard(key = "c", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void c() {
        robot.keyRelease(VK_SHIFT);
    }



}
