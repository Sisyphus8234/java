package custom;

import base.*;
import base.enty.TaskResult;

import java.util.*;

import static java.awt.event.KeyEvent.*;

class Run extends MainClass {


}

public class Functions extends IFunctions {
    static {
//        Controller.printKey = true;
    }


    @ListenMouseKeyboard(intercept = true, key = "ctrl左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "e", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void ctrl左(InputInfo inputInfo) {
        threadPressOrRelease(VK_SHIFT, false, false);
    }

    @ListenMouseKeyboard(intercept = true, press = false, key = "shift左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void shift左(InputInfo inputInfo) {
        threadPressOrRelease(VK_SHIFT, false, false);
        threadPressOrRelease(VK_SHIFT, false, true);
    }

    @ListenMouseKeyboard(intercept = true, key = "win", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win(InputInfo inputInfo) {
        threadPressOrRelease(VK_W, false, true);
    }


    //region 搓技能

    public static List<Integer> 救人 = new ArrayList<>(Arrays.asList(VK_UP, VK_DOWN, VK_RIGHT, VK_LEFT, VK_UP));
    public static List<Integer> 补给 = new ArrayList<>(Arrays.asList(VK_DOWN, VK_DOWN, VK_UP, VK_RIGHT));
    public static List<Integer> kg500 = new ArrayList<>(Arrays.asList(VK_UP, VK_RIGHT, VK_DOWN, VK_DOWN, VK_DOWN));
    public static List<Integer> 轨道炮攻击 = new ArrayList<>(Arrays.asList(VK_RIGHT, VK_UP, VK_DOWN, VK_DOWN, VK_RIGHT));
    public static List<Integer> 轨道加特林 = new ArrayList<>(Arrays.asList(VK_RIGHT, VK_DOWN, VK_LEFT, VK_UP, VK_UP));
    public static List<Integer> 飞鹰机枪 = new ArrayList<>(Arrays.asList(VK_UP, VK_RIGHT, VK_RIGHT));
    public static List<Integer> 火箭哨戒炮 = new ArrayList<>(Arrays.asList(VK_DOWN, VK_UP, VK_RIGHT, VK_RIGHT, VK_LEFT));
    public static List<Integer> 自动哨戒炮 = new ArrayList<>(Arrays.asList(VK_DOWN, VK_UP, VK_RIGHT, VK_UP, VK_LEFT, VK_UP));

    public static List<Integer> 迫击炮 = new ArrayList<>(Arrays.asList(VK_DOWN, VK_UP, VK_RIGHT, VK_RIGHT, VK_DOWN));

    public static List<Integer> 加特林哨戒炮 = new ArrayList<>(Arrays.asList(VK_DOWN, VK_UP, VK_RIGHT, VK_LEFT));
    public static List<Integer> 突击兵 = new ArrayList<>(Arrays.asList(VK_DOWN, VK_LEFT, VK_UP, VK_DOWN, VK_RIGHT));
    public static List<Integer> 补给背包 = new ArrayList<>(Arrays.asList(VK_DOWN, VK_LEFT, VK_DOWN, VK_UP, VK_UP, VK_DOWN));

    public static List<Integer> tempList = new ArrayList<>();


    public static List<Integer> doList = new ArrayList<>();

    @ListenMouseKeyboard(key = "f1", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "f2", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "f3", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "f4", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "f5", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "f6", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void f1(InputInfo inputInfo) {
        if (inputInfo.value == CommonUtil.keyCodeMap.get("f1")) {
            doList = 救人;
        } else if (inputInfo.value == CommonUtil.keyCodeMap.get("f2")) {
            doList = 补给;
        } else if (inputInfo.value == CommonUtil.keyCodeMap.get("f3")) {
            doList = 补给背包;
        }
        t1.myResume();
    }

    public static MyThread t1 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                robot.keyPress(VK_SPACE);
                pause(50L);
                doList.stream().forEach(s -> {
                    robot.keyPress(s);
                    pause(50L);
                    robot.keyRelease(s);
                    pause(150L);
                });
                robot.keyRelease(VK_SPACE);
                this.mySuspend();
            }
        }
    };


    //endregion

    //region 保存技能
    @ListenMouseKeyboard(key = "up", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "down", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "right", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "left", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void sxzy(InputInfo inputInfo) {
        tempList.add(inputInfo.value);
    }

    @ListenMouseKeyboard(key = "space", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void space3(InputInfo inputInfo) {
        tempList.clear();
    }

    @ListenMouseKeyboard(press = false, key = "space", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void space4(InputInfo inputInfo) {
        JsonUtil.writeJsonFile("skill",tempList);
    }

    //endregion


    //region 状态键
    public static final String space = "space";

    @ListenMouseKeyboard(key = "space", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void space(InputInfo inputInfo) {
        CommonUtil.customConditionSet.add(space);
    }

    @ListenMouseKeyboard(press = false, key = "space", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void space1(InputInfo inputInfo) {
        CommonUtil.customConditionSet.remove(space);
    }
    //endregion

}
