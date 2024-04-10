package custom;

import base.CommonUtil.Active;

import base.JsonUtil;
import addition.MouseMoveFix;
import base.*;
import base.enty.TaskResult;
import com.fasterxml.jackson.core.type.TypeReference;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static base.CommonUtil.keyCodeMap;
import static java.awt.event.KeyEvent.*;

class Run extends MainClass {


}

public class Functions extends IFunctions {

    static {
//        Controller.printKey = true;
        active=(Integer.parseInt(Config.read("active")));
    }


    @ListenMouseKeyboard(key = "pause", intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult reOpen(InputInfo inputInfo) {

//        if(inputInfo.value==keyCodeMap.get("pause")) {
//            Config.write("active", String.valueOf(Active.jna));
//        }else if(inputInfo.value==keyCodeMap.get("ins")) {
//            Config.write("active", String.valueOf(Active.jnativehook));
//        }

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
        if (inputInfo.userInput == true && inputInfo.value != keyCodeMap.get("`") && inputInfo.value != keyCodeMap.get("菜单键")) {
            alt_tab_右键次数 = 0;
        }
        return null;
    }


    public static boolean prtsc期间做了什么 = false;

    @ListenMouseKeyboard(key = "prtsc", intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void prtsc(InputInfo inputInfo) {
        if (getKeyStatus(VK_PRINTSCREEN) == false) {
            prtsc期间做了什么 = false;
        }
        setKeyStatus(VK_PRINTSCREEN, true);
    }

    @ListenMouseKeyboard(key = "prtsc", intercept = true, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void prtsc_1(InputInfo inputInfo) {
        setKeyStatus(VK_PRINTSCREEN, false);
        if (prtsc期间做了什么 == false) {
            robot.keyPress(VK_PRINTSCREEN);
            robot.keyRelease(VK_PRINTSCREEN);
        }
    }


    //    public static boolean alt期间做了什么 = false;
    @ListenMouseKeyboard(key = "alt左", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void alt(InputInfo inputInfo) {
        setKeyStatus(VK_ALT, true);
    }

    @ListenMouseKeyboard(key = "alt左", press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void alt1(InputInfo inputInfo) {
        setKeyStatus(VK_ALT, false);
    }

    public static double screen_scale = Double.parseDouble(Config.read("screen_scale"));

    public static Long baseDelay = Long.parseLong(Config.read("base_delay"));

    public static boolean t3Temp = false;


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

    public static MyThread t3;
    public static MyThread t4;
    public static boolean ctrl按下 = false;
    public static int 滚轮次数 = 0;
    public static int 滚轮方向 = 1;

    static {


        t3 = new MyThread() {
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

        t4 = new MyThread() {
            @Override
            public void run() {
                while (true) {

                    if (滚轮次数 > 0) {
                        System.out.println(滚轮方向);
                        robot.mouseWheel(滚轮方向);
                        pause(10);
                        滚轮次数--;
                    } else {
                        this.mySuspend();
                    }
                }
            }
        };
    }

    //---基础功能

    private static boolean 判断win按下() {
        return getKeyStatus(VK_WINDOWS);
    }

    public static TaskResult result左键 = new TaskResult();

    @ListenMouseKeyboard(key = "esc", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "侧键按下", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(key = "alt右", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult 模拟左键(InputInfo inputInfo) {
        if (判断win按下()) {
            win期间做了什么 = true;
            result左键.intercept = false;
        } else {
            t左键b = true;
            t左键.myResume();
            result左键.intercept = true;
        }
        return result左键;


    }

    @ListenMouseKeyboard(key = "esc", press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "侧键松开", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(press = false, key = "alt右", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult 模拟左键1(InputInfo inputInfo) {
        if (判断win按下()) {
            win期间做了什么 = true;
            result左键.intercept = false;
        } else {
            t左键b = false;
            result左键.intercept = true;
        }
        return result左键;
    }

    public static TaskResult result右键 = new TaskResult();

    @ListenMouseKeyboard(key = "f1", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult f1键按下(InputInfo inputInfo) {
        if (判断win按下()) {
            result右键.intercept = false;
            win期间做了什么 = true;
        } else {
            t右键b = true;
            t右键.myResume();
            result右键.intercept = true;
        }
        return result右键;
    }

    @ListenMouseKeyboard(key = "f1", press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult f1键松开(InputInfo inputInfo) {
        if (判断win按下()) {
            result右键.intercept = false;
            win期间做了什么 = true;
        } else {
            t右键b = false;
            result右键.intercept = true;
        }
        return result右键;
    }


    //---


    public static boolean b替换 = Boolean.parseBoolean(Config.read("reverse"));

    @ListenMouseKeyboard(key = "n", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void m() {
        if (getKeyStatus(VK_ALT) == true) {
            b替换 = false;
            Config.write("reverse", String.valueOf(b替换));
        }
    }

    @ListenMouseKeyboard(key = "m", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void n() {
        if (getKeyStatus(VK_ALT) == true) {
            b替换 = true;
            Config.write("reverse", String.valueOf(b替换));

        }
    }

    @ListenMouseKeyboard(key = "右键按下", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse, active = Active.jna)
    public static TaskResult 替换(InputInfo inputInfo) {
        if (b替换 == false) {
            result右键.intercept = false;
        } else {
            t左键b = true;
            t左键.myResume();
            result右键.intercept = true;
        }
        return result右键;
    }

    @ListenMouseKeyboard(key = "右键松开", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse, active = Active.jna)
    public static TaskResult 替换1() {
        if (b替换 == false) {
            result右键.intercept = false;
        } else {
            t左键b = false;
            result右键.intercept = true;
        }
        return result右键;


    }

    @ListenMouseKeyboard(key = "左键按下", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse, active = Active.jna)
    public static TaskResult 替换2() {
        if (b替换 == false) {
            result左键.intercept = false;
        } else {
            t右键b = true;
            t右键.myResume();
            result左键.intercept = true;
        }

        return result左键;

    }

    @ListenMouseKeyboard(key = "左键松开", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse, active = Active.jna)
    public static TaskResult 替换3(InputInfo inputInfo) {
        if (b替换 == false) {
            result左键.intercept = false;
        } else {
            t右键b = false;
            result右键.intercept = true;
        }
        return result左键;
    }

    //---

    @ListenMouseKeyboard(key = "f2", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult f2键(InputInfo inputInfo) {
        if (判断win按下()) {

            win期间做了什么 = true;
            return new TaskResult(false);
        } else {
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            return new TaskResult(true);
        }


    }

    @ListenMouseKeyboard(key = "f3", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult f3键(InputInfo inputInfo) {
        if (判断win按下()) {

            win期间做了什么 = true;
            return new TaskResult(false);
        } else {
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            return new TaskResult(true);
        }


    }

    @ListenMouseKeyboard(key = "f4", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult f4键(InputInfo inputInfo) {
        if (判断win按下()) {

            win期间做了什么 = true;
            return new TaskResult(false);
        } else {
            robot.keyRelease(KeyEvent.VK_DELETE);
            robot.keyPress(KeyEvent.VK_DELETE);
            robot.keyRelease(KeyEvent.VK_DELETE);
            return new TaskResult(true);
        }


    }

    @ListenMouseKeyboard(key = "f2", press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "f3", press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "f4", press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult 松开(InputInfo inputInfo) {
        if (判断win按下()) {
            win期间做了什么 = true;
            return new TaskResult(false);
        } else {

            return new TaskResult(true);
        }


    }

    //---大写锁
    @ListenMouseKeyboard(key = "大写", intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 大写锁() {
    }

    @ListenMouseKeyboard(key = "大写", press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 大写锁1() {

        Point tempPoint = MouseInfo.getPointerInfo().getLocation();
        MouseMoveFix.run(0, 0, screen_scale);

        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(winWithValue);
        pause(50);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.keyRelease(winWithValue);

        MouseMoveFix.run(tempPoint.x, tempPoint.y, screen_scale);


    }


    //---win功能
    public static boolean win期间做了什么 = false;

    @ListenMouseKeyboard(key = "win", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void win按下() {
        setKeyStatus(VK_WINDOWS, true);
    }

    @ListenMouseKeyboard(key = "win", press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void win按下1() {
        setKeyStatus(VK_WINDOWS, false);
        //重置
        win期间做了什么 = false;
    }


//    @ListenMouseKeyboard(value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse, extend = true)
//    @ListenMouseKeyboard(userInput = false, value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse, extend = true)
//    @ListenMouseKeyboard(value = 522, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse, extend = true)
//    @ListenMouseKeyboard(userInput = false, value = 522, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse, extend = true)
//    public static void 停止alt_tab() {
//        alt_tab_右键次数 = 0;
//    }


    public static String winWithValueName = "custom/winWithValue.json";
    public static Integer winWithValue;

    static {
        TypeReference<Integer> typeReference1 = new TypeReference<Integer>() {
        };
        winWithValue = JsonUtil.readJsonFile(winWithValueName, typeReference1);
    }


    @ListenMouseKeyboard(key = "1", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, extend = true)
    @ListenMouseKeyboard(key = "2", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, extend = true)
    @ListenMouseKeyboard(key = "3", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, extend = true)
    @ListenMouseKeyboard(key = "4", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, extend = true)
    @ListenMouseKeyboard(key = "5", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, extend = true)
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


            win期间做了什么 = true;
        }

    }
    //---菜单键

//    @ListenMouseKeyboard(value = 93, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 1000L)
//    public static void 菜单键(InputInfo inputInfo) {
//        if (getKeyStatus(inputInfo.value) == false) {
//            setKeyStatus(inputInfo.value, true);
//            robot.keyPress(VK_WINDOWS);
//            robot.keyPress(VK_TAB);
//            pause(200L);
//            robot.keyRelease(VK_TAB);
//            robot.keyRelease(VK_WINDOWS);
//        }
//    }
//
//    @ListenMouseKeyboard(value = 93, press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 菜单键1(InputInfo inputInfo) {
//        setKeyStatus(inputInfo.value, false);
//        robot.mousePress(BUTTON1_DOWN_MASK);
//        robot.mouseRelease(BUTTON1_DOWN_MASK);
//    }

    //---波浪键相关


    public static boolean 波浪键按住 = false;
    public static boolean 波浪键按住期间做了什么 = false;


    @ListenMouseKeyboard(key = "`", intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "菜单键", intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void 波浪键0() {
        波浪键按住 = true;
    }


    @ListenMouseKeyboard(key = "`", intercept = true, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "菜单键", press = false, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void 波浪键1() {
        波浪键按住 = false;

        if (波浪键按住期间做了什么 == false) {
            t2.myResume();
        }

        波浪键按住期间做了什么 = false;
    }

//    @ListenMouseKeyboard(value = 192, intercept = true, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 波浪键1() {
//        波浪键按住 = false;
//        if (波浪键按住期间做了什么 == true) {
//        } else {
//            Point tempPoint = MouseInfo.getPointerInfo().getLocation();
//            MouseMoveFix.run(0, 0, screen_scale);
//
//            robot.keyPress(KeyEvent.VK_WINDOWS);
//            robot.keyPress(winWithValue);
//            pause(50);
//            robot.keyRelease(KeyEvent.VK_WINDOWS);
//            robot.keyRelease(winWithValue);
//
//            MouseMoveFix.run(tempPoint.x, tempPoint.y, screen_scale);
//        }
//    }


    //---模拟alt+tab

    public static Integer alt_tab_右键次数 = 0;
    public static MyThread t2 = new MyThread() {
        @Override
        public void run() {
            while (true) {

                Point tempPoint = MouseInfo.getPointerInfo().getLocation();
                MouseMoveFix.run(0, 0, screen_scale);

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

                MouseMoveFix.run(tempPoint.x, tempPoint.y, screen_scale);

                t2.mySuspend();
            }
        }
    };

//    @ListenMouseKeyboard(value = 9, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void tab键() {
//        if (波浪键按住 == true) {
//            波浪键按住期间做了什么 = true;
//            t2.myResume();
//        } else {
//            robot.keyPress(KeyEvent.VK_TAB);
//        }
//    }

    @ListenMouseKeyboard(key = "3", intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字3() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;
            robot.keyPress(VK_ALT);
            robot.keyPress(VK_F4);
            pause(100L);
            robot.keyRelease(VK_F4);
            robot.keyRelease(VK_ALT);
        } else {
            robot.keyPress(KeyEvent.VK_3);
        }
    }


    @ListenMouseKeyboard(key = "1", intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字1() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;

            滚轮方向 = 1;
            t3Temp = true;
            t3.myResume();

        } else {
            robot.keyPress(VK_1);
        }
    }


    @ListenMouseKeyboard(key = "1", intercept = true, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字1_1() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;

            t3Temp = false;
        } else {
            robot.keyRelease(VK_1);
        }
    }

    @ListenMouseKeyboard(key = "2", intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字2() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;

            滚轮方向 = -1;
            t3Temp = true;
            t3.myResume();

        } else {
            robot.keyPress(KeyEvent.VK_2);
        }
    }

    @ListenMouseKeyboard(key = "2", intercept = true, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 数字2_1() {
        if (波浪键按住 == true) {
            波浪键按住期间做了什么 = true;

            t3Temp = false;

        } else {
            robot.keyRelease(KeyEvent.VK_2);
        }
    }


    @ListenMouseKeyboard(key = "ctrl左", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void ctrl() {
        ctrl按下 = true;
    }

    @ListenMouseKeyboard(key = "ctrl左", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false)
    public static void ctrl_1() {
        ctrl按下 = false;
    }


//    @ListenMouseKeyboard(key = "v", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void v() {
//        CommonUtil.switchActive(Active.jna);
//    }
//
//    @ListenMouseKeyboard(key = "b", keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void b() {
//        CommonUtil.switchActive(Active.jnativehook);
//    }




//    @ListenMouseKeyboard(value = 522, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.MouseWithMouseData, mouseData = -7864320)
//    public static void 滚轮() {
//
//
//        if (ctrl按下 == false) {
//            滚轮方向 = 1;
//            滚轮次数++;
//            t4.myResume();
//        }
//
//    }

//    @ListenMouseKeyboard(value = 522, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.MouseWithMouseData, mouseData = 7864320)
//    public static void 滚轮_1() {
//
//        if (ctrl按下 == false) {
//            滚轮方向 = -1;
//            滚轮次数++;
//            t4.myResume();
//        }
//    }


}
