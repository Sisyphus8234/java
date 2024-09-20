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

    public static List<Integer> 救人 = new ArrayList<>(Arrays.asList(VK_UP, VK_DOWN, VK_RIGHT,VK_LEFT,VK_UP));
    public static List<Integer> 补给 = new ArrayList<>(Arrays.asList(VK_DOWN, VK_DOWN, VK_UP,VK_RIGHT));
    public static List<Integer> kg500 = new ArrayList<>(Arrays.asList(VK_UP, VK_RIGHT, VK_DOWN, VK_DOWN, VK_DOWN));
    public static List<Integer> 轨道炮攻击 = new ArrayList<>(Arrays.asList(VK_RIGHT, VK_UP, VK_DOWN, VK_DOWN, VK_RIGHT));
    public static List<Integer> 轨道加特林 = new ArrayList<>(Arrays.asList(VK_RIGHT, VK_DOWN, VK_LEFT, VK_UP, VK_UP));
    public static List<Integer> 飞鹰机枪 = new ArrayList<>(Arrays.asList(VK_UP, VK_RIGHT, VK_RIGHT));
    public static List<Integer> 火箭哨戒炮 = new ArrayList<>(Arrays.asList(VK_DOWN,VK_UP, VK_RIGHT, VK_RIGHT,VK_LEFT));
    public static List<Integer> 自动哨戒炮 = new ArrayList<>(Arrays.asList(VK_DOWN,VK_UP, VK_RIGHT,VK_UP,VK_LEFT,VK_UP));



    @ListenMouseKeyboard(key = "space", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void space() {
        CommonUtil.customConditionSet.add("space");
    }

    @ListenMouseKeyboard(key = "`", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void a() {
        CommonUtil.customConditionSet.add("`");
    }


    @ListenMouseKeyboard(key = "1", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "`",timeInterval = 1000L)
    @ListenMouseKeyboard(key = "2", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "`",timeInterval = 1000L)
    @ListenMouseKeyboard(key = "3", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "`",timeInterval = 1000L)
    @ListenMouseKeyboard(key = "4", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "`",timeInterval = 1000L)
    public static void a1(InputInfo inputInfo) {
        switch (inputInfo.value){
            case 49:
                doList=自动哨戒炮;
                break;
            case 50:
                doList=火箭哨戒炮;
                break;
            case 51:

                break;
            case 52:

                break;
        }

        t1.myResume();
        CommonUtil.customConditionSet.remove("`");

    }

//    @ListenMouseKeyboard(key = "1", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "space",timeInterval = 1000L)
//    @ListenMouseKeyboard(key = "2", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "space",timeInterval = 1000L)
//    @ListenMouseKeyboard(key = "3", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "space",timeInterval = 1000L)
//    @ListenMouseKeyboard(key = "4", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "space",timeInterval = 1000L)
//    public static void a2(InputInfo inputInfo) {
//        int temp=0;
//        switch (inputInfo.value){
//            case 49:
//
//                break;
//            case 50:
//                temp=1;
//                break;
//            case 51:
//                temp=2;
//                break;
//            case 52:
//                temp=3;
//                break;
//        }
//
//    }

    public static List<Integer> doList = new ArrayList<>();
    @ListenMouseKeyboard(key = "f1", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "f2", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "f3", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "f4", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void f1(InputInfo inputInfo) {
        if(inputInfo.value==CommonUtil.keyCodeMap.get("f1")){
            doList=救人;
        }else if(inputInfo.value==CommonUtil.keyCodeMap.get("f2")){
            doList=补给;
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

}
