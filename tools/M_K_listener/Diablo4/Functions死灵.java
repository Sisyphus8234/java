package custom;

import addition.FunctionsAddition;
import base.CommonUtil;
import base.ListenMouseKeyboard;
import base.MyThread;
import base.enty.TaskResult;

import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalDateTime;
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


    public static List<Integer> list = new ArrayList<>(Arrays.asList(VK_6, VK_7, VK_8, VK_9, VK_E, VK_5));
    public static int len = list.size();


    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            int i = 0;
            boolean b;
            while (true) {
                if (战斗 == true && b拾取 == false) {


//                    if(可以放消耗技能()==false){
//                        t=LocalDateTime.now().plusSeconds(3);
//                    }
//
//                    if(LocalDateTime.now().isBefore(t)&&(list.get(i)==VK_7||list.get(i)==VK_E)
//                    ){
//                        i++;
//                        if (i >= len) {
//                            i = 0;
//                        }
//                    }
//
//
                    boolean temp = getKeyStatus(VK_SPACE);

                    if (list.get(i) == VK_5) {
                        if (temp == true) {
                            robot.keyPress(list.get(i));
                            robot.keyRelease(list.get(i));
                        } else {
                            i++;
                            if (i >= len) {
                                i = 0;
                            }
                        }
                    }


                    if (list.get(i) == VK_E && temp == false) {
                        robot.keyPress(VK_SPACE);
                    }
                    robot.keyPress(list.get(i));
                    robot.keyRelease(list.get(i));
                    if (list.get(i) == VK_E && temp == false) {
                        pause(100L);
                        robot.keyRelease(VK_SPACE);
                    }


                    i++;
                    if (i >= len) {
                        i = 0;
                    }


                    pause(50L);


                } else {
//                    i=0;
                }
                pause(BaseDelay);
            }
        }
    };

//    public static MyThread t2= new MyThread(MyThread.State.on) {
//        @Override
//        public void run() {
//            while (true) {
//                if (战斗 == true && b拾取 == false) {
//                    robot.keyPress(VK_9);
//                    robot.keyRelease(VK_9);
//                }
//                pause(500L);
//            }
//        }
//    };


    public static LocalDateTime 右键time = LocalDateTime.now();

    @ListenMouseKeyboard(key = "右键按下", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L)
    @ListenMouseKeyboard(key = "右键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L)
    public static TaskResult 右键() {
        if (getKeyStatus(VK_CONTROL) == true) {
            return new TaskResult(false);
        }


        if (战斗 == true) {
            robot.keyPress(VK_G);
            return new TaskResult(true);
        } else {
            return new TaskResult(false);
        }
    }


    @ListenMouseKeyboard(key = "右键松开", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(key = "右键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    public static TaskResult 右键1() {
        if (getKeyStatus(VK_CONTROL) == true) {
            return new TaskResult(false);
        }


        if (战斗 == true) {
            robot.keyRelease(VK_G);
            return new TaskResult(true);
        } else {
            return new TaskResult(false);
        }

    }


    @ListenMouseKeyboard(key = "g", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 200L)
    @ListenMouseKeyboard(key = "g", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 200L)
    @ListenMouseKeyboard(key = "左键按下", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L)
    @ListenMouseKeyboard(key = "左键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, timeInterval = 200L)
    public static void g() {
        if (战斗 == true) {
            b拾取 = true;
        }
    }

    @ListenMouseKeyboard(key = "g", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "g", userInput = false, press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void g1() {
        if (战斗 == true) {

            b拾取 = false;
        }
    }

    public static boolean 战斗 = false;

    @ListenMouseKeyboard(key = "q", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "q", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "中键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(key = "中键按下", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    public static void q() {
        自动喝药开始(null, null, false);
        战斗 = true;
        b拾取 = true;
    }


    @ListenMouseKeyboard(key = "t", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "t", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void t() {
        自动喝药结束();
        战斗 = false;
        b拾取 = false;
    }

    @ListenMouseKeyboard(key = "ctrl", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "ctrl", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void ctrl() {
        setKeyStatus(VK_CONTROL, true);
    }

    @ListenMouseKeyboard(key = "ctrl", press = false, userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "ctrl", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void ctrl1() {
        setKeyStatus(VK_CONTROL, false);
    }

    @ListenMouseKeyboard(key = "滚轮", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(key = "滚轮", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    public static void 滚轮() {
        if (战斗 == true) {
            robot.keyPress(VK_5);
            robot.keyRelease(VK_5);
        }
    }

    @ListenMouseKeyboard(key = "space", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "space", userInput = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void space() {
        setKeyStatus(VK_SPACE, true);
    }

    @ListenMouseKeyboard(key = "space", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "space", userInput = false,press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void space1() {
        setKeyStatus(VK_SPACE, false);
    }


}
