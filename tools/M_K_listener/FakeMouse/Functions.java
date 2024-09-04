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
import java.util.concurrent.atomic.AtomicReference;

import static base.CommonUtil.customConditionSet;
import static base.CommonUtil.keyCodeMap;
import static base.Config.prop;
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


    @Recorder
    public static TaskResult rec(InputInfo inputInfo) {


        ArrayList<Integer> tempList = new ArrayList<>(Arrays.asList(keyCodeMap.get("`"), keyCodeMap.get("菜单键"), keyCodeMap.get("right"), keyCodeMap.get("alt左"), keyCodeMap.get("tab")));

        if (inputInfo.userInput == true && !tempList.contains(inputInfo.value)) {
            alt_tab_右键次数 = 0;
        }
        return null;
    }


    public static Long baseDelay = Long.parseLong(Config.read("base_delay"));

    public static boolean t3Temp = false;


    public static Point pointS = new Point(-1, -1);
    public static Point pointD = new Point(-1, -1);
    public static Point pointF = new Point(-1, -1);
    public static AtomicReference<Point> pointTemp = new AtomicReference<>();
    public static boolean 拖动 = false;

    //    @ListenMouseKeyboard(key = "s", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 200L,customCondition = "tab")
//    @ListenMouseKeyboard(key = "d", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 200L,customCondition = "tab")
//    @ListenMouseKeyboard(key = "f", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 200L,customCondition = "tab")
    public static TaskResult aaa1(InputInfo inputInfo) {

        switch (inputInfo.value) {
            case VK_S:
                pointTemp.set(pointS);
                break;
            case VK_D:
                pointTemp.set(pointD);
                break;
            case VK_F:
                pointTemp.set(pointF);
                break;
        }

        Point point = pointTemp.get();
        point.x = MouseInfo.getPointerInfo().getLocation().x;
        point.y = MouseInfo.getPointerInfo().getLocation().y;
        System.out.println(point.x);
        return new TaskResult(true);
    }


    //    @ListenMouseKeyboard(key = "s", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 200L,customCondition = "alt")
//    @ListenMouseKeyboard(key = "d", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 200L,customCondition = "alt")
//    @ListenMouseKeyboard(key = "f", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 200L,customCondition = "alt")
    public static TaskResult bbb(InputInfo inputInfo) {

        switch (inputInfo.value) {
            case VK_S:
                pointTemp.set(pointS);
                break;
            case VK_D:
                pointTemp.set(pointD);
                break;
            case VK_F:
                pointTemp.set(pointF);
                break;
        }

        if (拖动 == false) {
            if (pointTemp.get().x != -1) {
                robot.mouseMove(pointTemp.get().x, pointTemp.get().y);
                robot.mousePress(BUTTON1_DOWN_MASK);
            }
        }
        拖动 = true;
        return new TaskResult(true);
    }

    //    @ListenMouseKeyboard(key = "s", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "alt")
//    @ListenMouseKeyboard(key = "d", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "alt")
//    @ListenMouseKeyboard(key = "f", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = "alt")
    public static TaskResult bbb1(InputInfo inputInfo) {

        拖动 = false;
        Point point = pointTemp.get();
        point.x = MouseInfo.getPointerInfo().getLocation().x;
        point.y = MouseInfo.getPointerInfo().getLocation().y;
        pause(100L);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        return new TaskResult(true);
    }


    public static boolean t左键b = false;
    public static MyThread t左键 = new MyThread() {
        @Override
        public void run() {
            pause(1000L);
            while (true) {
                if (getKeyStatus(MouseEvent.BUTTON1_DOWN_MASK) == false) {
                    myMousePress(MouseEvent.BUTTON1_DOWN_MASK);
                } else if (t左键b == false) {
                    myMouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    t左键.mySuspend();
                }
                pause(baseDelay);
            }
        }
    };
    public static boolean t右键b = false;
    public static MyThread t右键 = new MyThread() {
        @Override
        public void run() {
            pause(2000L);
            while (true) {
                if (getKeyStatus(MouseEvent.BUTTON3_DOWN_MASK) == false) {
                    myMousePress(MouseEvent.BUTTON3_DOWN_MASK);
                } else if (t右键b == false) {
                    myMouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
                    t右键.mySuspend();
                }
                pause(baseDelay);
            }
        }
    };

    public static int 滚轮方向 = 1;
    public static MyThread t3 = new MyThread() {
        @Override
        public void run() {
            while (true) {

                if (t3Temp == true) {
                    robot.mouseWheel(滚轮方向);
                    pause(50);
                } else {
                    this.mySuspend();
                }
            }
        }
    };


    //---基础功能


//    public static TaskResult result左键 = new TaskResult();

    @ListenMouseKeyboard(key = "esc", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!win")
    @ListenMouseKeyboard(key = "alt右", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult 模拟左键(InputInfo inputInfo) {
        t左键b = true;
        t左键.myResume();
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "esc", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!win")
    @ListenMouseKeyboard(key = "alt右", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult 模拟左键1(InputInfo inputInfo) {
        t左键b = false;
        return new TaskResult(true);
    }

//    public static TaskResult result右键 = new TaskResult();

    @ListenMouseKeyboard(key = "f1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!win")
    public static TaskResult f1键按下(InputInfo inputInfo) {

        t右键b = true;
        t右键.myResume();
        return new TaskResult(true);


    }

    @ListenMouseKeyboard(key = "f1", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!win")
    public static TaskResult f1键松开(InputInfo inputInfo) {
        t右键b = false;
        return new TaskResult(true);
    }


    //---


    public static boolean b替换 = Boolean.parseBoolean(Config.read("reverse"));

    @ListenMouseKeyboard(key = "n", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "alt")
    public static void m() {
        b替换 = false;
        Config.write("reverse", String.valueOf(b替换));
    }

    @ListenMouseKeyboard(key = "m", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "alt")
    public static void n() {
        b替换 = true;
        Config.write("reverse", String.valueOf(b替换));

    }

    @ListenMouseKeyboard(key = "右键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, active = Active.jna)
    public static TaskResult 替换(InputInfo inputInfo) {
        if (b替换 == false) {
            return new TaskResult(false);
        } else {
            t左键b = true;
            t左键.myResume();
            return new TaskResult(true);
        }
    }

    @ListenMouseKeyboard(key = "右键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, active = Active.jna)
    public static TaskResult 替换1() {
        if (b替换 == false) {
            return new TaskResult(false);
        } else {
            t左键b = false;
            return new TaskResult(true);
        }
    }

    @ListenMouseKeyboard(key = "左键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, active = Active.jna)
    public static TaskResult 替换2() {

        if (b替换 == false) {
            return new TaskResult(false);
        } else {
            t右键b = true;
            t右键.myResume();
            return new TaskResult(true);
        }
    }

    @ListenMouseKeyboard(key = "左键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, active = Active.jna)
    public static TaskResult 替换3(InputInfo inputInfo) {
        if (b替换 == false) {
            return new TaskResult(false);
        } else {
            t右键b = false;
            return new TaskResult(true);
        }
    }

    //---

    @ListenMouseKeyboard(key = "f2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!win")
    public static TaskResult f2键(InputInfo inputInfo) {
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "f3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!win")
    public static TaskResult f3键(InputInfo inputInfo) {

        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(key = "f4", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!win")
    public static TaskResult f4键(InputInfo inputInfo) {

        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        return new TaskResult(true);

    }

    @ListenMouseKeyboard(key = "f2", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!win")
    @ListenMouseKeyboard(key = "f3", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!win")
    @ListenMouseKeyboard(key = "f4", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!win")
    public static TaskResult 松开(InputInfo inputInfo) {
        return new TaskResult(true);
    }


    //---大写锁

    public static MyThread tWin数字 = new MyThread() {
        @Override
        public void run() {
            while (true) {

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
                this.mySuspend();
            }
        }
    };

    @ListenMouseKeyboard(key = "大写", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void 大写锁() {
    }

    @ListenMouseKeyboard(key = "大写", press = false, intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "侧键按下", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(key = "侧键按下1", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    public static void 大写锁1() {
        tWin数字.myResume();
    }


    //---win功能


    public static String winWithValueName = "custom/winWithValue.json";
    public static Integer winWithValue;

    static {
        TypeReference<Integer> typeReference1 = new TypeReference<Integer>() {
        };
        winWithValue = JsonUtil.readJsonFile(winWithValueName, typeReference1);
    }


    @ListenMouseKeyboard(key = "1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true)
    @ListenMouseKeyboard(key = "2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true)
    @ListenMouseKeyboard(key = "3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true)
    @ListenMouseKeyboard(key = "4", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true)
    @ListenMouseKeyboard(key = "5", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true)
    public static void win3(InputInfo inputInfo) {

        if (getKeyStatus(VK_WINDOWS) == true) {
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


//            win期间做了什么 = true;
        }

    }


    //---波浪键相关


    public static boolean 波浪键按住 = false;
    public static boolean 波浪键按住期间做了什么 = false;


    @ListenMouseKeyboard(key = "`", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "菜单键", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void 波浪键0() {
        波浪键按住 = true;
    }


    @ListenMouseKeyboard(key = "`", intercept = true, press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "菜单键", press = false, intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void 波浪键1() {
        波浪键按住 = false;

        if (波浪键按住期间做了什么 == false) {
            t2.myResume();
        }

        波浪键按住期间做了什么 = false;
    }


    //---模拟alt+tab
    public static Integer alt_tab_右键次数 = 0;
    public static MyThread t2 = new MyThread() {
        @Override
        public void run() {
            while (true) {

                Point tempPoint = MouseInfo.getPointerInfo().getLocation();
                myMouseMove(1, screenHeight - 1);
                pause(100L);

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

                robot.mouseMove(tempPoint.x, tempPoint.y);

                t2.mySuspend();
            }
        }
    };

    @ListenMouseKeyboard(key = "3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, active = Active.jna)
    public static TaskResult 数字3() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;
            robot.keyPress(VK_ALT);
            robot.keyPress(VK_F4);
            pause(100L);
            robot.keyRelease(VK_F4);
            robot.keyRelease(VK_ALT);

            return new TaskResult(true);
        } else {
            return new TaskResult(false);
        }
    }


    @ListenMouseKeyboard(key = "1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult 数字1() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;

            滚轮方向 = 1;
            t3Temp = true;
            t3.myResume();

            return new TaskResult(true);

        } else {
            return new TaskResult(false);
        }
    }


    @ListenMouseKeyboard(key = "1", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult 数字1_1() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;

            t3Temp = false;

            return new TaskResult(true);
        } else {
            return new TaskResult(false);
        }
    }

    @ListenMouseKeyboard(key = "2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult 数字2() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;

            滚轮方向 = -1;
            t3Temp = true;
            t3.myResume();
            return new TaskResult(true);

        } else {
            return new TaskResult(false);
        }
    }

    @ListenMouseKeyboard(key = "2", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult 数字2_1() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;
            t3Temp = false;
            return new TaskResult(true);
        } else {
            return new TaskResult(false);
        }
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

    public static float 倍率=1;

    @ListenMouseKeyboard(key = "a", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(press = false,key = "a", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "s", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(press = false,key = "s", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "d", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(press = false,key = "d", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult a(InputInfo inputInfo) {
        if(inputInfo.press==false) {
            倍率=1;
        }else {
            if (inputInfo.value == keyCodeMap.get("a")) {
                倍率 = 0.5F;
            } else if (inputInfo.value == keyCodeMap.get("s")) {
                倍率 = 2;
            } else if (inputInfo.value == keyCodeMap.get("d")) {
                倍率 = 3;
            }
        }
        if(b移动==true){
            System.out.println(1111);
            return new TaskResult(true);
        }else {
            return new TaskResult(false);
        }
    }



    public static boolean b移动;

    public static MyThread 移动 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            Point point;

            while (true) {
                b移动 = up || down || left || right;
                if (b移动 == true) {
                    point = MouseInfo.getPointerInfo().getLocation();
                    int 移动距离_倍率= (int) (移动距离*倍率);
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
                    pause(50L);
                } else {
                    this.mySuspend();
                }
            }
        }


    };
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    @ListenMouseKeyboard(key = "up", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!ctrl")
    @ListenMouseKeyboard(key = "down", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!ctrl")
    @ListenMouseKeyboard(key = "left", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!ctrl")
    @ListenMouseKeyboard(key = "right", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!ctrl")
    public static TaskResult up(InputInfo inputInfo) {

        if (inputInfo.value == keyCodeMap.get("up")) {
            up = true;
        } else if (inputInfo.value == keyCodeMap.get("down")) {
            down = true;
        } else if (inputInfo.value == keyCodeMap.get("left")) {
            left = true;
        } else if (inputInfo.value == keyCodeMap.get("right")) {
            right = true;
        }
        移动.myResume();
        return new TaskResult(true);
    }

    @ListenMouseKeyboard(press = false, key = "up", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!ctrl")
    @ListenMouseKeyboard(press = false, key = "down", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!ctrl")
    @ListenMouseKeyboard(press = false, key = "left", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!ctrl")
    @ListenMouseKeyboard(press = false, key = "right", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, customCondition = "!ctrl")
    public static TaskResult up2(InputInfo inputInfo) {
        if (inputInfo.value == keyCodeMap.get("up")) {
            up = false;
        } else if (inputInfo.value == keyCodeMap.get("down")) {
            down = false;
        } else if (inputInfo.value == keyCodeMap.get("left")) {
            left = false;
        } else if (inputInfo.value == keyCodeMap.get("right")) {
            right = false;
        }
        return new TaskResult(true);
    }


    @ListenMouseKeyboard(key = "alt左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void alt(InputInfo inputInfo) {
        CommonUtil.customConditionSet.add(String.valueOf("alt"));
    }

    @ListenMouseKeyboard(key = "alt左", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void alt1(InputInfo inputInfo) {
        CommonUtil.customConditionSet.remove(String.valueOf("alt"));
    }

    @ListenMouseKeyboard(key = "tab", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void tab(InputInfo inputInfo) {
        CommonUtil.customConditionSet.add(String.valueOf("tab"));
    }

    @ListenMouseKeyboard(key = "tab", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void tab1(InputInfo inputInfo) {
        CommonUtil.customConditionSet.remove(String.valueOf("tab"));
    }

    static {
        CommonUtil.customConditionSet.add("!ctrl");
    }

    @ListenMouseKeyboard(key = "ctrl左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void ctrl左() {
        CommonUtil.customConditionSet.add("ctrl左");
        CommonUtil.customConditionSet.add("ctrl");
        CommonUtil.customConditionSet.remove("!ctrl");
    }

    @ListenMouseKeyboard(key = "ctrl左", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void ctrl左2() {
        CommonUtil.customConditionSet.remove("ctrl左");
        CommonUtil.customConditionSet.remove("ctrl");
        CommonUtil.customConditionSet.add("!ctrl");
    }

    @ListenMouseKeyboard(intercept = true,key = "ctrl右", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void ctrl右() {
        CommonUtil.customConditionSet.add("ctrl右");
        CommonUtil.customConditionSet.add("ctrl");
        CommonUtil.customConditionSet.remove("!ctrl");
    }

    @ListenMouseKeyboard(intercept = true,key = "ctrl右", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void ctrl右2() {
        CommonUtil.customConditionSet.remove("ctrl右");
        CommonUtil.customConditionSet.remove("ctrl");
        CommonUtil.customConditionSet.add("!ctrl");
    }

//    public static boolean win期间做了什么 = false;

    static {
        CommonUtil.customConditionSet.add("!win");
    }

    @ListenMouseKeyboard(key = "win", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win按下() {
        CommonUtil.customConditionSet.add("win");
        CommonUtil.customConditionSet.remove("!win");
    }

    @ListenMouseKeyboard(key = "win", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win按下1() {
        CommonUtil.customConditionSet.remove("win");
        CommonUtil.customConditionSet.add("!win");
        //重置
//        win期间做了什么 = false;
    }

//    @ListenMouseKeyboard(key = "ctrl左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
//    public static void ctrl左() {
//        CommonUtil.customConditionSet.add(String.valueOf("ctrl左"));
//    }
//
//    @ListenMouseKeyboard(key = "ctrl左", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void ctrl左2() {
//        CommonUtil.customConditionSet.remove(String.valueOf("ctrl左"));
//    }


}
