package custom;

import base.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.event.KeyEvent.*;

class Run extends MainClass{



}

public class Functions extends IFunctions {
    static {
//        Controller.printKey=true;
    }
    public static Thread t1;
    public static boolean t1Temp = false;
    public static Long time1 = Long.valueOf(Config.read("Time1"));

    static {
        t1 = new MyThread(MyThread.State.off) {
            @Override
            public void run() {
                while (true) {
                    if (t1Temp == true) {
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//						robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        pause(time1);
                    } else {
                        t1.suspend();
                    }
                }
            }
        };
    }

//    public static boolean b暂停奔跑=false;
//    public static boolean b暂停奔跑1=false;
//    public static MyThread t暂停奔跑=new MyThread(){
//
//        @Override
//        public void run(){
//            while (true){
//                if(b暂停奔跑=true){
//                    b暂停奔跑1=true;
//                    robot.keyRelease(VK_SHIFT);
//                    robot.keyPress(VK_SHIFT);
//
//
//
//                }
//
//                robot.keyPress(VK_SHIFT);
//           }
//        }
//
//    };

    @ListenMouseKeyboard(value = 516, intercept = true,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    private static void 奔跑() {
        robot.keyRelease(VK_SHIFT);
    }

    @ListenMouseKeyboard(value = 517, intercept = true,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    private static void 奔跑_1() {
        robot.keyPress(VK_SHIFT);
    }

    @ListenMouseKeyboard(value = 71, keyboardOrMouse = 0)
    private static void 修机() {
        robot.keyRelease(KeyEvent.VK_F);
        robot.keyPress(KeyEvent.VK_F);
    }

    // @ListenMouseKeyboard(value=160,immediately=true)
    // private static void 奔跑2() {
    // 	robot.keyRelease(KeyEvent.VK_F);
    // 	}

//	@ListenMouseKeyboard(value=70,immediately=true,userInput = false)
//	@ListenMouseKeyboard(value=70,immediately=true)
//	private static void 修机2() {
//		// TODO Auto-generated method stub
//		robot.keyRelease(KeyEvent.VK_SHIFT);
//		}

//	@ListenMouseKeyboard(value=192,immediately=true)
//	@ListenMouseKeyboard(value=191,immediately=true)
//	private static void 点血网() {
//		robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//		robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//	}


    @ListenMouseKeyboard(value = 191, keyboardOrMouse = 0)
    private static void 点血网() {
        t1Temp = true;
        t1.resume();
    }

    @ListenMouseKeyboard(value = 190, keyboardOrMouse = 0)
    private static void 点血网1() {
        t1Temp = false;
    }

    @ListenMouseKeyboard(value = 84, keyboardOrMouse = 0)
    private static void 能力键1_space() {
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.keyPress(KeyEvent.VK_SPACE);
    }
}
