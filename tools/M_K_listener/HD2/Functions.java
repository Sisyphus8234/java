package custom;

import base.*;
import base.enty.TaskResult;

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
        CommonUtil.customConditionSet.add(String.valueOf(inputInfo.value));
    }

    @ListenMouseKeyboard(key = "w", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "a", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "s", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "d", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void asd1(InputInfo inputInfo) {
        CommonUtil.customConditionSet.remove(String.valueOf(inputInfo.value));
    }

    @ListenMouseKeyboard(key = "w", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 阻止w松开)
    public static TaskResult w1(InputInfo inputInfo) {
        CommonUtil.customConditionSet.remove(阻止w松开);
        return new TaskResult(true);
    }


    public static final String shift松开生效 = "shift松开生效";

    @ListenMouseKeyboard(key = "shift左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult shift() {

        return new TaskResult(false);
    }

    @ListenMouseKeyboard(press = false, key = "shift左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult shift1() {

        return new TaskResult(false);
    }


    @ListenMouseKeyboard(press = false, key = "shift左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "87," + "!" + shift松开生效)
    @ListenMouseKeyboard(press = false, key = "shift左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "65," + "!" + shift松开生效)
    @ListenMouseKeyboard(press = false, key = "shift左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "83," + "!" + shift松开生效)
    @ListenMouseKeyboard(press = false, key = "shift左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "68," + "!" + shift松开生效)
    public static TaskResult shift2() {
        return new TaskResult(true);
    }


    @ListenMouseKeyboard(key = "e", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "f", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void e() {
        CommonUtil.customConditionSet.add(shift松开生效);
    }

    @ListenMouseKeyboard(key = "e", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "f", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void e1() {
        CommonUtil.customConditionSet.remove(shift松开生效);
    }


    public static final String 阻止w松开 = "阻止w松开";

    @ListenMouseKeyboard(key = "win", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win() {
        CommonUtil.customConditionSet.add(阻止w松开);
    }

    @ListenMouseKeyboard(key = "win", intercept = true, press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win1() {
    }


//    @ListenMouseKeyboard(key = "space", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,extend = true)
//    @ListenMouseKeyboard(key = "space", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,extend = true)
//    public static void space(InputInfo inputInfo) {
//        i1 = 0;
//    }


    public static List<Integer> kg500 = new ArrayList<>(Arrays.asList(VK_UP, VK_RIGHT, VK_DOWN, VK_DOWN, VK_DOWN));
    public static List<Integer> 轨道炮攻击 = new ArrayList<>(Arrays.asList(VK_RIGHT, VK_UP, VK_DOWN, VK_DOWN, VK_RIGHT));
    public static List<Integer> 轨道加特林 = new ArrayList<>(Arrays.asList(VK_RIGHT, VK_DOWN, VK_LEFT, VK_UP, VK_UP));
    public static List<Integer> 飞鹰机枪 = new ArrayList<>(Arrays.asList(VK_UP, VK_RIGHT, VK_RIGHT));
    public static List<Integer> l1 = kg500;
    public static int i1 = 0;

//    @ListenMouseKeyboard(key = "1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 手动shift)
//    @ListenMouseKeyboard(key = "2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "4", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void f1(InputInfo inputInfo) {
//        if(getKeyStatus(VK_SPACE)==true) {
//            手动 = false;
//            switch (inputInfo.value) {
//                case VK_1:
//                    l1 = 轨道炮攻击;
//                    break;
//                case VK_2:
//                    l1 = 轨道加特林;
//                    break;
//                case VK_3:
//                    l1 = 飞鹰机枪;
//                    break;
//            }
//        }
//    }
//
//
//    public static String 手动="手动";
//    @ListenMouseKeyboard(key = "up", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "down", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "right", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "left", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static TaskResult fsxzy(InputInfo inputInfo) {
//        if (手动 == false) {
//            if (inputInfo.value != l1.get(i1)) {
//                return (new TaskResult(true));
//            } else {
//                if (i1 <= l1.size() - 2) {
//                    i1++;
//                }
//
//                return (new TaskResult(false));
//            }
//        } else {
//            return new TaskResult(false);
//        }
//
//    }


    @ListenMouseKeyboard(key = "space", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void space() {
        CommonUtil.customConditionSet.add("space");

    }

    @ListenMouseKeyboard(key = "space", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void space1() {
        CommonUtil.customConditionSet.remove("space");
    }





}
