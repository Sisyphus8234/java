package custom;

import addition.FunctionsAddition;
import base.CommonUtil;
import base.ListenMouseKeyboard;
import base.MyThread;
import base.enty.TaskResult;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.awt.event.KeyEvent.*;


public class Functions左右键 extends Functions公共 {
    static {
    }


    private static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();


    public static boolean b1 = false;
    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {

            while (true) {
                if (b1 == true) {


                    robot.keyRelease(BUTTON3_DOWN_MASK);

                    robot.keyPress(BUTTON1_DOWN_MASK);
                    robot.keyRelease(BUTTON1_DOWN_MASK);

                    robot.keyPress(BUTTON3_DOWN_MASK);


                } else {
                    robot.keyRelease(BUTTON3_DOWN_MASK);
                }
                pause(BaseDelay);
            }
        }
    };


    @ListenMouseKeyboard(key = "e",intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 200L)
    public void e() {
        b1 = true;
    }



    @ListenMouseKeyboard(key = "e",intercept = true, press = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public void e1() {
        b1 = false;
    }

}
