package custom;

import base.*;
import base.enty.TaskResult;

import javax.imageio.ImageIO;
import javax.swing.text.TabSet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.awt.event.KeyEvent.*;

class Run extends MainClass {


}

public class Functions extends IFunctions {
    static {
//        Controller.printKey = true;
    }

    @ListenMouseKeyboard(key = "w", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "a", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "s", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "d", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void wasd(InputInfo inputInfo) {
        setKeyStatus(inputInfo.value, true);

    }

    @ListenMouseKeyboard(key = "w", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult w1(InputInfo inputInfo) {
        if (阻断下个w弹起 == true) {
            阻断下个w弹起 = false;
            return new TaskResult(true);
        } else {
            setKeyStatus(inputInfo.value, false);
            return null;
        }
    }

//    @ListenMouseKeyboard(key = "s", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void s(InputInfo inputInfo) {
//        if(getKeyStatus(VK_W)==true){
//            强制下个shift弹起 = true;
//        }
//        setKeyStatus(inputInfo.value, false);
//
//    }

    @ListenMouseKeyboard(key = "a", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "s", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "d", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void asd1(InputInfo inputInfo) {
        setKeyStatus(inputInfo.value, false);
    }


//    public static LocalDateTime shiftStart = LocalDateTime.now();

    @ListenMouseKeyboard(key = "shift左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult shift() {
        setKeyStatus(VK_SHIFT, true);
        return null;
    }

    @ListenMouseKeyboard(key = "shift左", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult shift1() {
        setKeyStatus(VK_SHIFT, false);

        boolean temp = getKeyStatus(VK_W) || getKeyStatus(VK_A) || getKeyStatus(VK_S) || getKeyStatus(VK_D);


        if (强制下个shift弹起 == true) {
            强制下个shift弹起 = false;
            return new TaskResult(false);
        } else if (temp == true) {
            return new TaskResult(true);
        } else {
            return null;
        }

    }

    private static boolean 阻断下个w弹起 = false;

    //    @ListenMouseKeyboard(key = "侧键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "e", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void e() {
        强制下个shift弹起 = true;
    }

    @ListenMouseKeyboard(key = "e", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void e1() {
        强制下个shift弹起 = false;
    }


    private static boolean 强制下个shift弹起 = false;

    @ListenMouseKeyboard(key = "win", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win() {
        阻断下个w弹起 = true;
    }

    @ListenMouseKeyboard(key = "win", intercept = true, press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win1() {
    }


    @ListenMouseKeyboard(key = "space", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,extend = true)
    @ListenMouseKeyboard(key = "space", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,extend = true)
    public static void space(InputInfo inputInfo) {
        i1 = 0;
    }

    public static boolean 手动 = true;

    @ListenMouseKeyboard(key = "`", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "e", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true)
    public static void f(InputInfo inputInfo) {
        手动 = true;
    }

    public static List<Integer> kg500 = new ArrayList<>(Arrays.asList(VK_UP, VK_RIGHT, VK_DOWN, VK_DOWN, VK_DOWN));
    public static List<Integer> 轨道炮攻击 = new ArrayList<>(Arrays.asList(VK_RIGHT, VK_UP, VK_DOWN, VK_DOWN, VK_RIGHT));
    public static List<Integer> 轨道加特林 = new ArrayList<>(Arrays.asList(VK_RIGHT, VK_DOWN, VK_LEFT, VK_UP, VK_UP));
    public static List<Integer> 飞鹰机枪 = new ArrayList<>(Arrays.asList(VK_UP,VK_RIGHT, VK_RIGHT));
    public static List<Integer> l1 = kg500;
    public static int i1 = 0;

    @ListenMouseKeyboard(key = "1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "4", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void f1(InputInfo inputInfo) {
        if(getKeyStatus(VK_SPACE)==true) {
            手动 = false;
            switch (inputInfo.value) {
                case VK_1:
                    l1 = 轨道炮攻击;
                    break;
                case VK_2:
                    l1 = 轨道加特林;
                    break;
                case VK_3:
                    l1 = 飞鹰机枪;
                    break;
            }
        }
    }


    @ListenMouseKeyboard(key = "up", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "down", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "right", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "left", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult fsxzy(InputInfo inputInfo) {
        if (手动 == false) {
            if (inputInfo.value != l1.get(i1)) {
                return (new TaskResult(true));
            } else {
                if (i1 <= l1.size() - 2) {
                    i1++;
                }

                return (new TaskResult(false));
            }
        } else {
            return new TaskResult(false);
        }

    }


    @ListenMouseKeyboard(key = "space",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,timeInterval = 500L)
    public static void space() {
        setKeyStatus(VK_SPACE ,true);
    }

    @ListenMouseKeyboard(key = "space",press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void space1() {
        setKeyStatus(VK_SPACE ,false);
    }
//
//    @ListenMouseKeyboard(key = "左键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
//    public static TaskResult 左键() {
//        if(getKeyStatus(VK_SPACE)==true){
//            return new TaskResult(true);
//        }else {
//            return new TaskResult(false);
//        }
//    }

    @ListenMouseKeyboard(key = "`",press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void      test() {
        robot.keyPress(VK_1);
        robot.keyRelease(VK_1);
    }


}
