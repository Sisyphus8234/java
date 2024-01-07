package custom;

import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class Functions判官正火 extends Functions公共 {
    public static Thread t2 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {

                if (running == true) {
                    if (放陷阱 == true) {
                        放陷阱 = false;
                        pause(200);
                    } else {
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        pause(140);
                    }
                } else {
                    t2.suspend();
                }

            }
        }
    };


    // public static Integer 水银药剂 = 0;
    // public static HashMap<Integer,Integer> 水银药剂map=new HashMap<>();
    // static {
    //     水银药剂map.put(0,KeyEvent.VK_5);
    //     水银药剂map.put(1,KeyEvent.VK_4);
    //     水银药剂map.put(2,KeyEvent.VK_3);
    // }
    // @ListenMouseKeyboard(value = 52, intercept = true)
    // private static void 喝水银药剂() {
    //     robot.keyPress(水银药剂map.get(水银药剂));
    //     robot.keyRelease(水银药剂map.get(水银药剂));
    //     水银药剂++;
    //     if(水银药剂>=3){水银药剂=0;}

    // }




    //基础功能
    //---------------------------------------------------------------



    public static boolean 放陷阱 = false;



    @ListenMouseKeyboard(note = "space", value = 32, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void 奔跑() {
        running = true;
        t2.resume();
    }

    @ListenMouseKeyboard(note = "r", value = 82, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "左键", value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    private static void 奔跑2() {
        running = false;
    }

    @ListenMouseKeyboard(note = "e", value = 69, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "q", value = 81, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "右键", value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    private static void 放技能() {
        放陷阱 = true;

    }


}
