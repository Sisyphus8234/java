package custom;

import base.FunctionsAddition;
import base.IFunctions;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

public class Functions公共 extends IFunctions {
    public static boolean 自动喝药 = false;
    public static MyThread t1;
    public static boolean t1Temp1 = false;
    public static boolean dTemp = false;
    public static boolean dTemp1 = false;
    public static float[] myHSB血量;
    public static FunctionsAddition.PixelColor pixelColor =new FunctionsAddition.PixelColor();




    static {

//        File directory = new File(folderName);
//        if (!directory.exists()) {
//            directory.mkdirs(); // 创建目标文件夹及其父文件夹（如果不存在）
//        }



        t1 = new MyThread(MyThread.State.off) {
            @Override
            public void run() {
                while (true) {
                    if (自动喝药 == true) {
                        myHSB血量= pixelColor.getPixelColor(625,990);
                        if (
                                myHSB血量[1]<0.5F
                        ) {

//                            try {
//
//                                // 指定要捕捉的区域
//                                Rectangle screenRect = new Rectangle( 1920, 1080); // (x, y, width, height)
//
//                                // 捕捉屏幕区域的图像
//                                BufferedImage screenshot = robot.createScreenCapture(screenRect);
//
//                                // 保存图像为文件
//                                File output = new File(folderName+"/"+ LocalTime.now().format(DateTimeFormatter.ofPattern("HHmmss")) + ".png");
//                                ImageIO.write(screenshot, "png", output);
//
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }







                            robot.keyRelease(VK_0);
                            robot.keyPress(VK_0);
                            robot.keyRelease(VK_0);
                            t1Temp1=true;

                            if(t1Temp1==true){
                                pause(800L);
                                t1Temp1=false;
                            }

                        }
                    } else {
                        this.mySuspend();
                    }


                    pause(400L);
                }
            }
        };
    }

    @ListenMouseKeyboard(value = 88, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 扔装备() {
        Point point = MouseInfo.getPointerInfo().getLocation();
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(1085, 699);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(point.x, point.y);
    }

    @ListenMouseKeyboard(note = "f5",value = 116,intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 自动喝药() {
        自动喝药 = true;
        t1.myResume();
    }

    @ListenMouseKeyboard(note = "f6",value = 117,intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "t",value = 84, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(note = "c",value = 67, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 自动喝药1() {
        自动喝药 = false;
    }

//    @ListenMouseKeyboard(note = "q",value = 81, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 自动喝药2() {
//        t1Temp1=true;
//    }


    @ListenMouseKeyboard(note = "`", value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 人物详情() {
        robot.keyPress(VK_C);
        robot.keyRelease(VK_C);
        Point point = MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(1355, 264);
        robot.mousePress(BUTTON1_DOWN_MASK);
        robot.mouseRelease(BUTTON1_DOWN_MASK);
        robot.mouseMove(point.x, point.y);
    }
//
//    @ListenMouseKeyboard(note = "d", value = 68,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard,intercept = true)
//    public static void d() {
//        if(t1.state==MyThread.State.on){
//            dTemp1=true;
//        }
//
//        if(dTemp==false){
//            robot.keyPress(VK_TAB);
//            robot.keyRelease(VK_TAB);
//            dTemp=true;
//            自动喝药 =false;
//        }
//
//
//    }
//
//    @ListenMouseKeyboard(note = "d", value = 68,press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard,intercept = true)
//    public static void d1() {
//        robot.keyPress(VK_TAB);
//        robot.keyRelease(VK_TAB);
//        if(dTemp1==true) {
//            自动喝药 = true;
//            t1.myResume();
//        }
//        dTemp=false;
//    }

    @ListenMouseKeyboard(note = "f7", value = 118, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void f() {
        pixelColor.threadOn(801,982);
    }

    @ListenMouseKeyboard(note = "f8", value = 119, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)
    public static void f1() {
        pixelColor.threadOff();
    }


}