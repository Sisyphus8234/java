package custom;

import addition.FunctionsAddition;
import base.CommonUtil;
import base.ListenMouseKeyboard;
import base.MyThread;
import base.enty.TaskResult;

import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.awt.event.KeyEvent.*;


public class Functions死灵 extends Functions公共 {
    static {
    }


    private static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();


    public static boolean 需要骷髅祭司 = false;
    public static boolean 需要骷髅法师 = false;
    public static boolean 需要骷髅战士 = false;

    public static boolean 判断骷髅() {
//        需要骷髅战士 = pixelColor.getPixelColorHSB(1376, 997)[1] < 0.06F;
        需要骷髅战士 = pixelColor.getPixelColorHSB(1394, 976)[1] < 0.11333F;
        需要骷髅法师 = pixelColor.getPixelColorHSB(1400, 1025)[1] < 0.11F;
        需要骷髅祭司 = pixelColor.getPixelColorHSB(776, 969)[1] < 0.61F;


        return 需要骷髅祭司 || 需要骷髅法师 || 需要骷髅战士;
    }


    public static boolean 可以放消耗技能() {
        boolean b;
        b = pixelColor.getPixelColorHSB(1318, 1000)[1] > 0.35F;

        return b;
    }


    public static List<Integer> list = new ArrayList<>(Arrays.asList(VK_6, VK_7, VK_8, VK_6, VK_5, VK_E));
    //    public static List<Integer> list = new ArrayList<>(Arrays.asList(VK_6,VK_E));
    public static int len = list.size();


    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            int i = 0;
            boolean b = false;
            while (true) {
                if (战斗 == true) {
                    b = true;
                    if (状态 == 0) {
                        robot.keyRelease(VK_5);

                        robot.keyRelease(VK_G);
                        robot.keyPress(VK_G);

                    } else if (状态 == 1) {
                        robot.keyRelease(VK_5);

                        robot.keyRelease(VK_G);
                    } else {
                        robot.keyRelease(VK_G);

                        if (list.get(i) == VK_E) {
                            robot.keyPress(VK_SPACE);
                            robot.keyPress(list.get(i));
                            robot.keyRelease(list.get(i));
                            robot.keyRelease(VK_SPACE);

                        } else if (list.get(i) == VK_6) {
                            robot.keyPress(list.get(i));
                            robot.keyRelease(list.get(i));
                            pause(50L);
                        } else if (list.get(i) == VK_5) {
                            robot.keyPress(list.get(i));
                            pause(1400L);
                            robot.keyRelease(list.get(i));
                        } else {
                            robot.keyPress(list.get(i));
                            robot.keyRelease(list.get(i));
                        }


                        i++;
                        if (i >= len) {
                            i = 0;
                        }
                        pause(50L);
//                        }


                    }
                } else {
                    if (b == true) {
                        b = false;
                        robot.keyRelease(VK_G);
                        robot.keyRelease(VK_5);
                    }
                }
                pause(BaseDelay);
            }
        }
    };

//    public static MyThread t2 = new MyThread(MyThread.State.on) {
//        @Override
//        public void run() {
//            while (true) {
//                if (战斗 == true && 状态 == 2) {
//                    robot.keyPress(VK_6);
//                    robot.keyRelease(VK_6);
//                }
//                pause(600L);
//            }
//        }
//    };


    public static LocalDateTime 右键time = LocalDateTime.now();

    @ListenMouseKeyboard(key = "w", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "w", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void w() {
        状态 = 0;
        战斗 = true;

        自动拾取start();
        自动喝药开始(null, null, true);
    }


    public static int 状态 = 0;

    @ListenMouseKeyboard(key = "左键按下", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L)
    @ListenMouseKeyboard(key = "左键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L)
    public static TaskResult g() {

        状态 = 0;

//        if (战斗 == true) {
//            return new TaskResult(true);
//        } else {
        return new TaskResult(false);
//        }
    }

    @ListenMouseKeyboard(key = "左键松开", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(key = "左键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    public static void g111() {
//        time=LocalDateTime.now().plus(2000L, ChronoUnit.MILLIS);
        状态 = 2;
    }


    @ListenMouseKeyboard(key = "右键按下", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L)
    @ListenMouseKeyboard(key = "右键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L)
    public static TaskResult 右键() {

        状态 = 0;
        if (战斗 == true) {
            return new TaskResult(true);
        } else {
            return new TaskResult(false);
        }
    }


    @ListenMouseKeyboard(key = "滚轮", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L)
    @ListenMouseKeyboard(key = "滚轮", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L)
    public static void gl() {

        状态 = 1;
    }


    public static boolean 战斗 = false;


    @ListenMouseKeyboard(key = "c", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "c", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "d", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "d", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "t", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "t", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "r", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "r", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void t() {
        自动喝药结束();
        战斗 = false;
        自动拾取stop();
    }


//    @ListenMouseKeyboard(key = "space", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "space", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void space() {
//        setKeyStatus(VK_SPACE, true);
//    }
//
//    @ListenMouseKeyboard(key = "space", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "space", userInput = false, press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void space1() {
//        setKeyStatus(VK_SPACE, false);
//    }


}
