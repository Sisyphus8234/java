package custom;

import base.*;
import base.CommonUtil.Active;
import base.enty.TaskResult;
import com.fasterxml.jackson.core.type.TypeReference;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static base.CommonUtil.customConditionSet;
import static base.CommonUtil.keyCodeMap;
import static java.awt.event.KeyEvent.*;



public class Functions extends IFunctions{


    static {
//        Controller.printKey = true;
        active = (Integer.parseInt(Config.read("active")));
    }


    //region 录制

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

    //endregion

    //region 左键等
    public static final String 屏蔽 = "屏蔽";
    public static final String 左键 = "左键";

    @ListenMouseKeyboard(key = "esc", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!" + 屏蔽)
    @ListenMouseKeyboard(key = "alt右", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult 模拟左键(InputInfo inputInfo) {
        if (!customConditionSet.contains(左键)) {
            threadPressOrRelease(MouseEvent.BUTTON1_DOWN_MASK, true, true);
            customConditionSet.add(左键);
        }
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "esc", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!" + 屏蔽)
    @ListenMouseKeyboard(key = "alt右", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult 模拟左键1(InputInfo inputInfo) {

        customConditionSet.remove(左键);
        threadPressOrRelease(MouseEvent.BUTTON1_DOWN_MASK, true, false);


        return new TaskResult(true);
    }

    public static final String 右键 = "右键";

    @ListenMouseKeyboard(key = "f1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!" + 屏蔽)
    public static TaskResult f1键按下(InputInfo inputInfo) {
        if (!customConditionSet.contains(右键)) {
            customConditionSet.add(右键);
            threadPressOrRelease(MouseEvent.BUTTON3_DOWN_MASK, true, true);
        }
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "f1", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!" + 屏蔽)
    public static TaskResult f1键松开(InputInfo inputInfo) {
        customConditionSet.remove(右键);
        threadPressOrRelease(MouseEvent.BUTTON3_DOWN_MASK, true, false);
        return new TaskResult(true);
    }

    //---
    @ListenMouseKeyboard(key = "f2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!" + 屏蔽)
    public static TaskResult f2键(InputInfo inputInfo) {
        robot.keyRelease(VK_ENTER);
        robot.keyPress(VK_ENTER);
        robot.keyRelease(VK_ENTER);

        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "f3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!" + 屏蔽)
    public static TaskResult f3键(InputInfo inputInfo) {

        robot.keyRelease(VK_BACK_SPACE);
        robot.keyPress(VK_BACK_SPACE);
        robot.keyRelease(VK_BACK_SPACE);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "f4", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!" + 屏蔽)
    public static TaskResult f4键(InputInfo inputInfo) {

        robot.keyRelease(VK_DELETE);
        robot.keyPress(VK_DELETE);
        robot.keyRelease(VK_DELETE);
        return new TaskResult(true);

    }

    @ListenMouseKeyboard(key = "f2", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!" + 屏蔽)
    @ListenMouseKeyboard(key = "f3", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!" + 屏蔽)
    @ListenMouseKeyboard(key = "f4", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!" + 屏蔽)
    public static TaskResult 松开(InputInfo inputInfo) {
        return new TaskResult(true);
    }



    @ListenMouseKeyboard(key = "x", extend = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customConditionReverse = 屏蔽,customCondition = alt左,timeInterval = 800L)
    public static TaskResult x(InputInfo inputInfo) {
        threadPressOrRelease(MouseEvent.BUTTON2_DOWN_MASK, true, true);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "x", press = false, extend = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customConditionReverse = 屏蔽)
    public static TaskResult x1(InputInfo inputInfo) {
        threadPressOrRelease(MouseEvent.BUTTON2_DOWN_MASK, true, false);
        return new TaskResult(false);
    }
    //endregion

    //region 大写
    public static MyThread tWin数字 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                this.getBlock();

                Point tempPoint = MouseInfo.getPointerInfo().getLocation();
                mouseMoveFix(1, screenHeight - 1);
                pause(100L);
                robot.keyPress(VK_WINDOWS);
                robot.keyPress(winWithValue);
                pause(50L);
                robot.keyRelease(winWithValue);
                robot.keyRelease(VK_WINDOWS);
                pause(50L);
                robot.mouseMove(tempPoint.x, tempPoint.y);

                pause(500L);
                this.block();
            }
        }
    };

    @ListenMouseKeyboard(key = "大写", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "大写", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "菜单键", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void 大写锁() {
    }

    @ListenMouseKeyboard(key = "大写", press = false, intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "大写", press = false, intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(press = false, key = "菜单键", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
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


    @ListenMouseKeyboard(key = "1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true, customCondition = win)
    @ListenMouseKeyboard(key = "2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true, customCondition = win)
    @ListenMouseKeyboard(key = "3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true, customCondition = win)
    @ListenMouseKeyboard(key = "4", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true, customCondition = win)
    @ListenMouseKeyboard(key = "5", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true, customCondition = win)
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
    //endregion

    //region 波浪键

    public static final String 反单引号 = "反单引号";
    public static final String 波浪键按住期间做了什么 = "波浪键按住期间做了什么";
    public static boolean 是否回左下角 = Boolean.parseBoolean(Config.read("alt_tab_from"));


    @ListenMouseKeyboard(key = "`", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(userInput = false, key = "`", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "菜单键", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void 波浪键0() {
        customConditionSet.add(反单引号);
    }


    @ListenMouseKeyboard(key = "`", intercept = true, press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(userInput = false, key = "`", intercept = true, press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
        @ListenMouseKeyboard(press = false, key = "菜单键", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void 波浪键1() {
        customConditionSet.remove(反单引号);

        if (!customConditionSet.contains(波浪键按住期间做了什么)) {
            t2.nonBlock();
        }

        customConditionSet.remove(波浪键按住期间做了什么);

    }


    //模拟alt+tab
    public static Integer alt_tab_右键次数 = 0;
    public static MyThread t2 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {
                this.getBlock();
                
                Point tempPoint = null;
                if(是否回左下角) {
                    tempPoint = MouseInfo.getPointerInfo().getLocation();
                    mouseMoveFix(1, screenHeight - 1);
                }

                if (alt_tab_右键次数 > 0) {
                    robot.keyPress(VK_ALT);
                    robot.keyPress(VK_TAB);
                    //重要延时
                    pause(50L);
                    robot.keyRelease(VK_TAB);
                    robot.keyRelease(VK_ALT);
                    pause(100L);
                }

                robot.keyPress(VK_ALT);
                robot.keyPress(VK_TAB);
                pause(50L);
                robot.keyRelease(VK_TAB);
                pause(50L);


                for (int i = 0; i < alt_tab_右键次数; i++) {

                    robot.keyPress(VK_RIGHT);
                    robot.keyRelease(VK_RIGHT);
                    pause(50L);

                }
                pause(50L);
                robot.keyRelease(VK_ALT);
                alt_tab_右键次数++;
//                pause(50L);

                if(是否回左下角) {
                    robot.mouseMove(tempPoint.x, tempPoint.y);
                }

                this.block();
            }
        }
    };

    @ListenMouseKeyboard(key = "1", extend = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 反单引号)
    public static TaskResult esc() {
        customConditionSet.add(屏蔽);

        robot.keyPress(VK_ESCAPE);
        robot.keyRelease(VK_ESCAPE);

        customConditionSet.add(波浪键按住期间做了什么);
        customConditionSet.remove(屏蔽);

        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "2", extend = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 反单引号)
    public static TaskResult altf4() {
        customConditionSet.add(屏蔽);

        robot.keyPress(VK_F2);
        robot.keyRelease(VK_F2);

        customConditionSet.add(波浪键按住期间做了什么);
        customConditionSet.remove(屏蔽);

        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "3", extend = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = 反单引号)
    public static TaskResult 反单引号和3() {
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

    //endregion

    //region 滚轮带动移动
    public static int 移动距离 = Integer.parseInt(Config.read("移动距离"));

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
//    @ListenMouseKeyboard(userInput = false, key = "滚轮", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, customCondition = "!ctrl")
    public static TaskResult 滚轮(InputInfo inputInfo) {
        int temp = -1;

        if (IFunctions.active == Active.jna) {
            if (inputInfo.otherCondition.contains("7864320")) {
                temp = 0;
            } else {
                temp = 1;
            }
        }
        if (IFunctions.active == Active.jnativehook) {
            if (inputInfo.otherCondition.contains("-1")||inputInfo.otherCondition.contains("-2")) {
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

    //endregion

    //region 状态键
    public static final String win = "win";

    @ListenMouseKeyboard(key = "win", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win按下() {
        customConditionSet.add(win);

    }

    @ListenMouseKeyboard(key = "win", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win按下1() {
        customConditionSet.remove(win);

    }

    public static final String alt左 = "alt左";

    @ListenMouseKeyboard(key = "alt左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void alt() {
        customConditionSet.add(alt左);

    }

    @ListenMouseKeyboard(key = "alt左", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void alt1() {
        customConditionSet.remove(alt左);
    }

    public static final String ctrl左 = "ctrl左";

    @ListenMouseKeyboard(key = "ctrl左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void ctrl左() {
        customConditionSet.add(ctrl左);

    }

    @ListenMouseKeyboard(key = "ctrl左", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void ctrl左1() {
        customConditionSet.remove(ctrl左);
    }
    //endregion

    //region 清除
    @ListenMouseKeyboard(immediately = false, key = "prtsc", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void prtsc() {
        robot.keyPress(VK_PAGE_DOWN);
        robot.keyRelease(VK_PAGE_DOWN);
        pause(50L);
        robot.keyPress(VK_ALT);
        robot.keyRelease(VK_ALT);
        pause(50L);
        robot.keyPress(VK_PAGE_UP);
        robot.keyRelease(VK_PAGE_UP);

    }
    //endregion


}
