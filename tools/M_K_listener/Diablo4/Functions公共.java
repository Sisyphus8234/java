package custom;

import addition.FunctionsAddition;
import base.*;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public class Functions公共 extends IFunctions {
    static {
        Controller.refreshtime = 200L;
    }

    public static long BaseDelay = 200L;

    public static boolean b拾取 = false;
    public static MyThread t拾取 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {

            while (true) {
                if (b拾取 == true) {


                    robot.keyPress(VK_ALT);
                    robot.keyRelease(VK_ALT);

                    robot.keyPress(VK_V);
                    robot.keyRelease(VK_V);


                    pause(300L);
                } else {
                    this.mySuspend();
                }


            }
        }
    };

    public static void 自动拾取start() {
        b拾取 = true;
        t拾取.myResume();
    }

    public static void 自动拾取stop() {
        b拾取 = false;
    }


    //-----------------------------


    public static List<Integer> 要按的key = new ArrayList();
    public static MyThread 要暂停的t;
    public static boolean b无干扰按键 = false;
    public static boolean b无干扰按键进行中 = false;
    public static LocalDateTime start = LocalDateTime.now();
    public static MyThread t无干扰按键 = new MyThread() {

        @Override
        public void run() {

            while (true) {
                if (b无干扰按键 == true) {
//                    if(LocalDateTime.now().getNano()-start.getNano()<2000) {
//                    if (Duration.between(start, LocalDateTime.now()).toMillis() < 1100) {
//                        System.out.println(Duration.between(start,LocalDateTime.now()).toMillis());
//                    要暂停的t.mySuspend();
//                    pause(50L);
                    b无干扰按键进行中 = true;
                    try {
                        start = LocalDateTime.now();
                        while (Duration.between(start, LocalDateTime.now()).toMillis() < 要按的key.size() * 500L) {
                            int i = 0;
                            int size = 要按的key.size();
                            while (i < size) {
                                robot.keyPress(要按的key.get(i));
                                robot.keyRelease(要按的key.get(i));
                                pause(100L);
                                i++;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    b无干扰按键进行中 = false;
                    要按的key.clear();


//                    pause(100L);
//                    要暂停的t.myResume();

//                    pause(500L);

//                    b无干扰按键=false;
//                    }


                }
                this.mySuspend();

                pause(BaseDelay);
            }
        }
    };


    //    @ListenMouseKeyboard(key = "1", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
//    @ListenMouseKeyboard(key = "2", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
//    @ListenMouseKeyboard(key = "3", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
//    @ListenMouseKeyboard(key = "4", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void 无干扰按键(InputInfo inputInfo) {

        要按的key.add(inputInfo.value);


        b无干扰按键 = true;
        t无干扰按键.myResume();
    }

    //-----------------------------

    public static Point p自动喝药_在中间位置 = new Point(625, 990);
    public static Point p自动喝药_在上方位置_长时间损失少量0血量就恢复 = new Point(625, 950);


    public static boolean b自动喝药 = false;

    public static boolean b自动喝药2 = true;

    public static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();
    public static MyThread t自动喝药 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            LocalDateTime tempTIme = LocalDateTime.now();
            boolean tempB=false;
            while (true) {
                if (b自动喝药 == true) {
                    if (pixelColor.getPixelColorHSB(p自动喝药_在中间位置.x, p自动喝药_在中间位置.y)[1] < 0.5F) {
                        robot.keyRelease(VK_0);
                        robot.keyPress(VK_0);
                        robot.keyRelease(VK_0);
                        tempB = true;
                        if (tempB == true) {
                            pause(800L);
                            tempB = false;
                        }
                    } else if (b自动喝药2 == true) {
                        if (pixelColor.getPixelColorHSB(p自动喝药_在上方位置_长时间损失少量0血量就恢复.x, p自动喝药_在上方位置_长时间损失少量0血量就恢复.y)[1] < 0.5F && LocalDateTime.now().isAfter(tempTIme)) {

                            robot.keyRelease(VK_0);
                            robot.keyPress(VK_0);
                            robot.keyRelease(VK_0);
//                            tempB = true;
//                            if (tempB == true) {
//                                pause(1200L);
//                                tempB = false;
//                            }
                        } else {
                            tempTIme = LocalDateTime.now().plusSeconds(5);
                        }
                    }
                } else {
                    this.mySuspend();
                }
                pause(300L);
            }
        }
    };


    public static void 自动喝药开始() {
        b自动喝药 = true;
        t自动喝药.myResume();
    }


    public static void 自动喝药开始(Point point, Point point1, boolean b) {
        if (point != null) {
            p自动喝药_在中间位置 = point;
        }
        if (point1 != null) {
            p自动喝药_在上方位置_长时间损失少量0血量就恢复 = point1;
        }
        b自动喝药2 = b;
        自动喝药开始();
    }

    public static void 自动喝药结束() {
        b自动喝药 = false;
    }

    //------------------------------------------------


    //---------------------------------------------------


    @ListenMouseKeyboard(key = "x", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void 扔装备() {
        Point point = MouseInfo.getPointerInfo().getLocation();
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(1085, 699);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(point.x, point.y);
    }

    @ListenMouseKeyboard(key = "b", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 人物详情() {
        long time = 150L;
        robot.keyPress(VK_C);
        robot.keyRelease(VK_C);
        pause(time);
        Point point = MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(1355, 264);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        pause(time);
        robot.mouseMove(1089, 115);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);


        robot.mouseMove(point.x, point.y);
    }

    @ListenMouseKeyboard(key = "c", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void 去掉括号() {
        if (clipboardIsString()) {
            String text = readClipboard().replaceAll(" ", "").replaceAll("\\[", "").replaceAll("\\]", "");
            writeClipboard(text);
        }
    }


    //------------------


    @ListenMouseKeyboard(key = "f7", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
    @ListenMouseKeyboard(key = "f7", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
    @ListenMouseKeyboard(key = "f8", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
    @ListenMouseKeyboard(key = "f8", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 读取颜色(InputInfo inputInfo) {
        if (inputInfo.value == VK_F7) {
            pixelColor.active = true;
        } else if (inputInfo.value == VK_F8) {
            pixelColor.active = false;
        }


        if (clipboardIsString()) {
            String text = readClipboard().replaceAll(" ", "");
            String[] parts = text.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            pixelColor.threadOn(x, y);
            writeClipboard(x + "," + y);
        }
    }


    @ListenMouseKeyboard(key = "f9", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
    @ListenMouseKeyboard(key = "f9", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 读取颜色_2() {
        pixelColor.threadOff();
    }

    //------------------------------------------------


    //-------------------------------------------------------

    public static boolean t右键连点是否左键 = false;
    public static LocalDateTime 计时器 = LocalDateTime.MIN;
    public static MyThread t鼠标连点 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (t右键连点是否左键 == false) {
                    robot.mousePress(BUTTON3_DOWN_MASK);
                    robot.mouseRelease(BUTTON3_DOWN_MASK);
                } else {
                    robot.mousePress(BUTTON1_DOWN_MASK);
                    robot.mouseRelease(BUTTON1_DOWN_MASK);
                }
                pause(200L);
            }
        }
    };

    @ListenMouseKeyboard(key = "=", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void 右键连点() {
        if (LocalDateTime.now().getSecond() - 计时器.getSecond() < 2) {
            t右键连点是否左键 = true;
        } else {
            t右键连点是否左键 = false;
        }
        计时器 = LocalDateTime.now();
        t鼠标连点.myResume();
    }

    @ListenMouseKeyboard(key = "-", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void 右键连点_1() {
        t鼠标连点.mySuspend();
    }


    //-------------


//    public static MyThread t筛选装备 = new MyThread(MyThread.State.off) {
//        @Override
//        public void run() {
//            while (true) {
//                if (筛选装备.是否标记 == true) {
//                    筛选装备.run1();
//                } else if (筛选装备.是否扫描和筛选 == true) {
//                    筛选装备.run(筛选装备_子类);
//                }
//
//                this.mySuspend();
//            }
//        }
//    };
//
//    public static 筛选装备_子类 筛选装备_子类;
//
//    @ListenMouseKeyboard(key = "f1",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
//    public static void 图像识别_装备() {
//        筛选装备.标记起点();
//    }
//
//    @ListenMouseKeyboard(key = "f2", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void 图像识别_装备1() {
//        筛选装备.是否扫描和筛选 = true;
//        筛选装备.是否标记 = false;
//        t筛选装备.myResume();
//    }
//
//    @ListenMouseKeyboard(key = "f3",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
//    public static void 图像识别_装备2() {
//        筛选装备.是否扫描和筛选 = false;
//        筛选装备.是否标记 = true;
//        t筛选装备.myResume();
//    }
//
//    @ListenMouseKeyboard(key = "f4",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
//    public static void 图像识别_装备_终止() {
//        筛选装备.是否扫描和筛选 = false;
//        筛选装备.是否标记 = false;
//    }
//
//    @ListenMouseKeyboard(key = "f5",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
//    public static void 图像识别_标记传奇() {
////        robot.keyPress(VK_C);
////        robot.keyRelease(VK_C);
//        筛选装备.显示传奇标记();
//    }
//
//    @ListenMouseKeyboard(key = "f6",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
//    public static void 图像识别_标记传奇_1() {
////        robot.keyPress(VK_ESCAPE);
////        robot.keyRelease(VK_ESCAPE);
//        筛选装备.关闭传奇标记();
//    }


//    public static DisplayImageOnTop displayImageOnTop = new DisplayImageOnTop();
//    public static boolean 图片状态 = false;
//    public static boolean 是否打开图片 = false;
//
//
//    public static String 图片路径 = Config.read("top_picture_path");
//
//    static {
//        displayImageOnTop.scale = Double.parseDouble((Config.read("scale")));
//    }
//
//    public static Point 图片标记点 = new Point(0, 0);
//
//    @ListenMouseKeyboard(key = "h",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void 打开半透明图片() {
//        if (是否打开图片 == false) {
//            是否打开图片 = true;
//        } else {
//            是否打开图片 = false;
//        }
//    }
//
//    @ListenMouseKeyboard(key = "g",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void 涂改(InputInfo inputInfo) {
//        if (是否打开图片 == true) {
//            Point mouse=MouseInfo.getPointerInfo().getLocation();
//            displayImageOnTop.draw(new Point((int) ((mouse.x - displayImageOnTop.location.x)/displayImageOnTop.scale), (int) ((mouse.y - displayImageOnTop.location.y)/displayImageOnTop.scale)));
//
//        } else {
//            robot.keyPress(inputInfo.value);
//        }
//    }
//
//    @ListenMouseKeyboard(key = "a", intercept = true,  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void 标记点(InputInfo inputInfo) {
//        if (是否打开图片 == true) {
//            Point mouse=MouseInfo.getPointerInfo().getLocation();
//            图片标记点.x = (int) ((mouse.x - displayImageOnTop.location.x) / displayImageOnTop.scale);
//            图片标记点.y = (int) ((mouse.y - displayImageOnTop.location.y) / displayImageOnTop.scale);
//        } else {
//            robot.keyPress(inputInfo.value);
//        }
//    }
//
//    @ListenMouseKeyboard(key = "up", intercept = true,  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key = "down", intercept = true,  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void 缩放(InputInfo inputInfo) {
//        double 幅度 = 0.01D;
//        if (inputInfo.value == 40) {
//            displayImageOnTop.scale = displayImageOnTop.scale - 幅度;
//        } else {
//            displayImageOnTop.scale = displayImageOnTop.scale + 幅度;
//        }
//        System.out.println(displayImageOnTop.scale);
//        Config.write("scale", String.valueOf(displayImageOnTop.scale));
//
//
//        displayImageOnTop.changeImageScale();
//    }
//
//
//    @ListenMouseKeyboard(key = "s", intercept = true,  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void 打开半透明图片_1(InputInfo inputInfo) {
//        if (是否打开图片 == true) {
//            if (图片状态 == false) {
//
//                displayImageOnTop.newPicture();
//
//                displayImageOnTop.location.x = (int) (MouseInfo.getPointerInfo().getLocation().x - 图片标记点.x * displayImageOnTop.scale);
//                displayImageOnTop.location.y = (int) (MouseInfo.getPointerInfo().getLocation().y - 图片标记点.y * displayImageOnTop.scale);
//
//
//                displayImageOnTop.imagePath = 图片路径;
//
//                displayImageOnTop.opacity = 0.7F;
//
//
//                displayImageOnTop.openImage();
//
//                图片状态 = true;
//            } else {
//                if (!Objects.isNull(displayImageOnTop)) {
//                    displayImageOnTop.closeWindow();
//                }
//                图片状态 = false;
//            }
//        } else {
//            robot.keyPress(inputInfo.value);
//            if (!Objects.isNull(displayImageOnTop)) {
//                displayImageOnTop.closeWindow();
//            }
//
//        }
//    }


}