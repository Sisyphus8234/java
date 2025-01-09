package custom;

import base.*;
import base.CommonUtil.Active;
import base.enty.TaskResult;
import com.fasterxml.jackson.core.type.TypeReference;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static base.CommonUtil.customConditionSet;
import static base.CommonUtil.keyCodeMap;
import static java.awt.event.KeyEvent.*;

class Run extends MainClass {


}

public class Functions extends IFunctions {


    static {
//        Controller.printKey = true;
        active = (Integer.parseInt(Config.read("active")));
    }

    @ListenMouseKeyboard(key = "pause", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "scrlk", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult reOpen(InputInfo inputInfo) {


        if (inputInfo.value == keyCodeMap.get("pause")) {
            Config.write("active", String.valueOf(Active.jna));
        } else if (inputInfo.value == keyCodeMap.get("scrlk")) {
            Config.write("active", String.valueOf(Active.jnativehook));
        }

        String batchFilePath = Config.read("self_path");
        System.out.println(batchFilePath);
        try {
            // 使用Runtime类的exec方法执行批处理文件
            Process process = Runtime.getRuntime().exec(batchFilePath);

            // 可以选择等待批处理文件执行完成
            process.waitFor();

            // 打印批处理文件的执行结果（可选）
            int exitCode = process.exitValue();
            System.out.println("批处理文件执行完成，退出码：" + exitCode);
            System.exit(0);

        } catch (Exception e) {

        }

        return null;
    }


    //    public static ArrayList<Integer> tempList = new ArrayList<>(Arrays.asList(keyCodeMap.get("`"), keyCodeMap.get("菜单键"), keyCodeMap.get("right"), keyCodeMap.get("alt左"), keyCodeMap.get("tab")));
    public static boolean bRec = true;

    @ListenMouseKeyboard()
    public static TaskResult rec(InputInfo inputInfo) {

        ArrayList<Integer> tempList = new ArrayList<>(Arrays.asList(keyCodeMap.get("`"), keyCodeMap.get("菜单键"), keyCodeMap.get("right"), keyCodeMap.get("alt左"), keyCodeMap.get("tab")));


        if (inputInfo.userInput == true && !tempList.contains(inputInfo.value) && bRec == true) {
            alt_tab_右键次数 = 0;
        }
        return null;
    }




    public static int 滚轮方向 = 100;
    public static MyThread t3 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                this.getBlock();


                robot.mouseWheel(滚轮方向);
                pause(50);

                this.block();

            }
        }
    };


    //---基础功能



    public static final String 屏蔽 ="屏蔽";
    public static final String 左键="左键";
    @ListenMouseKeyboard(key = "esc", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!"+ 屏蔽)
    @ListenMouseKeyboard(key = "alt右", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult 模拟左键(InputInfo inputInfo) {
        if(!customConditionSet.contains(左键)){
            threadPressOrRelease(MouseEvent.BUTTON1_DOWN_MASK,true,true);
            customConditionSet.add(左键);
        }
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "esc", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!win")
    @ListenMouseKeyboard(key = "alt右", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult 模拟左键1(InputInfo inputInfo) {

        customConditionSet.remove(左键);
        threadPressOrRelease(MouseEvent.BUTTON1_DOWN_MASK,true,false);


        return new TaskResult(true);
    }

    public static final String 右键="右键";
    @ListenMouseKeyboard(key = "f1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!"+ 屏蔽 +",!"+右键)
    public static TaskResult f1键按下(InputInfo inputInfo) {
        if(!customConditionSet.contains(右键)) {
            customConditionSet.add(右键);
            threadPressOrRelease(MouseEvent.BUTTON3_DOWN_MASK,true,true);
        }
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "f1", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!"+屏蔽)
    public static TaskResult f1键松开(InputInfo inputInfo) {
        customConditionSet.remove(右键);
        threadPressOrRelease(MouseEvent.BUTTON3_DOWN_MASK,true,false);
        return new TaskResult(true);
    }

    //---
    @ListenMouseKeyboard(key = "f2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!"+屏蔽)
    public static TaskResult f2键(InputInfo inputInfo) {
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "f3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!"+屏蔽)
    public static TaskResult f3键(InputInfo inputInfo) {

        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "f4", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!"+屏蔽)
    public static TaskResult f4键(InputInfo inputInfo) {

        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        return new TaskResult(true);

    }

    @ListenMouseKeyboard(key = "f2", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!"+屏蔽)
    @ListenMouseKeyboard(key = "f3", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!"+屏蔽)
    @ListenMouseKeyboard(key = "f4", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!"+屏蔽)
    public static TaskResult 松开(InputInfo inputInfo) {
        return new TaskResult(true);
    }


    //---大写锁

    public static MyThread tWin数字 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                this.getBlock();

                Point tempPoint = MouseInfo.getPointerInfo().getLocation();
                myMouseMove(1, screenHeight - 1);
                pause(100L);
                robot.keyPress(KeyEvent.VK_WINDOWS);
                robot.keyPress(winWithValue);
                pause(50L);
                robot.keyRelease(winWithValue);
                robot.keyRelease(KeyEvent.VK_WINDOWS);
                pause(50L);
                robot.mouseMove(tempPoint.x, tempPoint.y);

                pause(500L);
                this.block();
            }
        }
    };

    @ListenMouseKeyboard(key = "大写", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "大写", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "菜单键", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void 大写锁() {
    }

    @ListenMouseKeyboard(key = "大写", press = false, intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "大写", press = false, intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(press = false, key = "菜单键", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "侧键按下", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(key = "侧键按下1", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    public static void 大写锁1() {
        tWin数字.nonBlock();
    }


    //---win功能

    public static String winWithValueName = "custom/winWithValue.json";
    public static Integer winWithValue;

    static {
        TypeReference<Integer> typeReference1 = new TypeReference<Integer>() {
        };
        winWithValue = JsonUtil.readJsonFile(winWithValueName, typeReference1);
    }


    @ListenMouseKeyboard(key = "1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true,customCondition = win)
    @ListenMouseKeyboard(key = "2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true,customCondition = win)
    @ListenMouseKeyboard(key = "3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true,customCondition = win)
    @ListenMouseKeyboard(key = "4", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true,customCondition = win)
    @ListenMouseKeyboard(key = "5", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true,customCondition = win)
    public static void win3(InputInfo inputInfo) {


        if (inputInfo.value == keyCodeMap.get("1")) {
            winWithValue = VK_1;
        } else if (inputInfo.value == keyCodeMap.get("2")) {
            winWithValue = VK_2;
        } else if (inputInfo.value == keyCodeMap.get("3")) {
            winWithValue = VK_3;
        } else if (inputInfo.value == keyCodeMap.get("4")) {
            winWithValue = VK_4;
        } else if (inputInfo.value == keyCodeMap.get("5")) {
            winWithValue = VK_5;
        }

        JsonUtil.writeJsonFile(winWithValueName, winWithValue);
    }


    //---波浪键相关

    public static final String 反单引号="反单引号";
    public static final String 波浪键按住期间做了什么="波浪键按住期间做了什么";
    @ListenMouseKeyboard(key = "`", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(userInput = false, key = "`", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void 波浪键0() {
        customConditionSet.add(反单引号);
    }


    @ListenMouseKeyboard(key = "`", intercept = true, press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "`", intercept = true, press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void 波浪键1() {
        customConditionSet.remove(反单引号);

        if(!customConditionSet.contains(波浪键按住期间做了什么)){
            t2.nonBlock();
        }

        customConditionSet.remove(波浪键按住期间做了什么);

    }


    //---模拟alt+tab
    public static Integer alt_tab_右键次数 = 0;
    public static MyThread t2 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                this.getBlock();

                if (alt_tab_右键次数 > 0) {
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_TAB);
                    //重要延时
                    pause(50L);
                    robot.keyRelease(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    pause(100L);
                }

                robot.keyPress(KeyEvent.VK_ALT);
                robot.keyPress(KeyEvent.VK_TAB);
                pause(50L);
                robot.keyRelease(KeyEvent.VK_TAB);
                pause(50L);


                for (int i = 0; i < alt_tab_右键次数; i++) {

                    robot.keyPress(KeyEvent.VK_RIGHT);
                    robot.keyRelease(KeyEvent.VK_RIGHT);
                    pause(50L);

                }
                pause(50L);
                robot.keyRelease(KeyEvent.VK_ALT);
                alt_tab_右键次数++;

//                robot.mouseMove(tempPoint.x, tempPoint.y);

                this.block();
            }
        }
    };

    @ListenMouseKeyboard(key = "3",extend = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard
//            , active = Active.jna
    )
    public static TaskResult 数字3() {
        customConditionSet.add(屏蔽);

        robot.keyPress(VK_ALT);
        robot.keyPress(VK_F4);
        pause(100L);
        robot.keyRelease(VK_F4);
        robot.keyRelease(VK_ALT);

        customConditionSet.add(波浪键按住期间做了什么);
        customConditionSet.remove(屏蔽);

        return new TaskResult(true);

    }

    @ListenMouseKeyboard(key = "1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 反单引号)
    public static TaskResult 数字1() {
        customConditionSet.add(波浪键按住期间做了什么);

        滚轮方向 = 1;

        t3.nonBlock();

        return new TaskResult(true);

    }


    @ListenMouseKeyboard(key = "1", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 反单引号)
    public static TaskResult 数字1_1() {
        customConditionSet.add(波浪键按住期间做了什么);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = 反单引号)
    public static TaskResult 数字2() {
        customConditionSet.add(波浪键按住期间做了什么);

        滚轮方向 = -1;

        t3.nonBlock();
        return new TaskResult(true);
    }

    public static final String 反单引号期间做了什么="反单引号期间做了什么";
    @ListenMouseKeyboard(key = "2", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 反单引号)
    public static TaskResult 数字2_1() {

        customConditionSet.add(波浪键按住期间做了什么);

        return new TaskResult(true);
    }


    public static int 移动距离 = Integer.parseInt(Config.read("移动距离"));


    @ListenMouseKeyboard(key = "=", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "ctrl")
    public static TaskResult 加(InputInfo inputInfo) {
        移动距离 = 移动距离 + 2;
        Config.write("移动距离", String.valueOf(移动距离));
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "-", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "ctrl")
    public static TaskResult 减去(InputInfo inputInfo) {
        移动距离 = 移动距离 - 2;
        Config.write("移动距离", String.valueOf(移动距离));

        return new TaskResult(true);
    }

    public static float 倍率 = 1;



    public static MyThread 移动 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            Point point;

            while (true) {

                this.getBlock();

                point = MouseInfo.getPointerInfo().getLocation();
                int 移动距离_倍率 = (int) (移动距离 * 倍率);
                if (up) {
                    point.y = point.y - 移动距离_倍率;
                }
                if (down) {
                    point.y = point.y + 移动距离_倍率;
                }
                if (left) {
                    point.x = point.x - 移动距离_倍率;
                }
                if (right) {
                    point.x = point.x + 移动距离_倍率;
                }
                robot.mouseMove(point.x, point.y);


                up = right = left = down = false;
                pause(50L);

                this.block();

            }
        }


    };
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    @ListenMouseKeyboard(key = "滚轮", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = "!ctrl")
    @ListenMouseKeyboard(userInput = false, key = "滚轮", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = "!ctrl")
    public static TaskResult 滚轮(InputInfo inputInfo) {
        int temp = -1;

        if (IFunctions.active == Active.jna) {
            if (inputInfo.otherCondition.get("mouseData").equals("7864320")) {
                temp = 0;
            } else {
                temp = 1;
            }
        }
        if (IFunctions.active == Active.jnativehook) {
            if (inputInfo.otherCondition.get("wheelRotation").equals("-1")) {
                temp = 0;
            } else {
                temp = 1;
            }
        }

        if (temp == 0) {

            up = true;
            left = true;
        } else if (temp == 1) {

            right = true;
            down = true;
        }
        移动.nonBlock();
        return new TaskResult(false);
    }

    public static final String win="win";
    @ListenMouseKeyboard(key = "win", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win按下() {
        CommonUtil.customConditionSet.add(win);
        CommonUtil.customConditionSet.add(屏蔽);
    }

    @ListenMouseKeyboard(key = "win", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win按下1() {
        CommonUtil.customConditionSet.remove(win);
        CommonUtil.customConditionSet.remove(屏蔽);
    }



//    @ListenMouseKeyboard(key = "prtsc",extend = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void 释放所有() {
//        for (Map.Entry<String, Integer> entry : keyCodeMap.entrySet()) {
//
//            try {
//                robot.keyRelease(entry.getValue());
//            } catch (Exception e) {
//                //---
//                System.out.println("1111111111");
//                System.out.println(e.getMessage());
//            }
//
//            try {
//                robot.mouseRelease(entry.getValue());
//            } catch (Exception e) {
//                //---
//                System.out.println("1111111111");
//                System.out.println(e.getMessage());
//            }
//
//            pause(50L);
//
//        }
//    }




}
