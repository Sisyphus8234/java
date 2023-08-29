package custom;

import base.Config;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Functions野蛮人 extends Functions公共 {

    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static Long baseDelayT1 = Long.parseLong(Config.read("BaseDelay"))+120;
    public static Long baseDelayT1_1 = Long.parseLong(Config.read("BaseDelay"))-30;
    public static Long baseDelayT3 = Long.parseLong(Config.read("BaseDelay"))*2;



    public static boolean t1Temp = false;
    public static boolean t2Temp = false;
    public static boolean 用哪个基础技能 = true;
    public static boolean 随机用哪个基础技能 = true;
    //    public static boolean t2Temp = false;
    public static boolean 右键或者1234在t1运行时按下 = false;
    public static boolean 之前已经有右键或者1234在t1运行时按下 = false;
    public static boolean 暂停t1时是否松开左键 = true;
    public static boolean 攻击型加移动 = true;

    public static boolean 是否基础技能 = true;
    public static boolean 是否核心技能 = true;

    public static Random r = new Random();
    public static int i = 0;


    public static MyThread t1;
    public static MyThread t1_1;
    public static MyThread t2;
    public static MyThread t3;
    public static MyThread t4;

    public static 筛选装备_野蛮人 筛选装备_野蛮人 = new 筛选装备_野蛮人();
    private static Color pixelColor资源;


    public static void fTemp(){
        pixelColor资源 = robot.getPixelColor(1318, 965);
//                    System.out.println(pixelColor);
//                    200,128,55
//                            32,35,39
//                            if (pixelColor.getRed() +
//                                    pixelColor.getGreen() +
//                                    pixelColor.getBlue() >= 260
//                            ) {
//                                robot.keyPress(KeyEvent.VK_4);
//                                robot.keyRelease(KeyEvent.VK_4);
//                            }
        if (pixelColor资源.getRed() +
                pixelColor资源.getGreen() +
                pixelColor资源.getBlue() < 130
        ) {
        }else {
            robot.keyPress(KeyEvent.VK_4);
            robot.keyRelease(KeyEvent.VK_4);
        }
    }
    static {
        t1 = new MyThread(MyThread.State.on) {
            @Override
            public void run() {
                while (true) {
                    if (t1Temp == true) {
                        if (是否基础技能 == true) {
                            robot.keyPress(KeyEvent.VK_5);
                            robot.keyRelease(KeyEvent.VK_5);
                        }
                        if (是否核心技能) {
                            fTemp();
                        }
                        if (是否基础技能 == true) {
                            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        }
                        if (是否核心技能) {
                            fTemp();
                        }

                    } else {

                    }
                    pause(baseDelay);
                }
            }
        };

//        t1_1=new MyThread(MyThread.State.on) {
//            @Override
//            public void run() {
//                while (true) {
//                    if (t1Temp == true) {
//                        if (是否核心技能) {
//                            pixelColor = robot.getPixelColor(1318, 965);
////                    System.out.println(pixelColor);
////                    200,128,55
////                            32,35,39
////                            if (pixelColor.getRed() +
////                                    pixelColor.getGreen() +
////                                    pixelColor.getBlue() >= 260
////                            ) {
////                                robot.keyPress(KeyEvent.VK_4);
////                                robot.keyRelease(KeyEvent.VK_4);
////                            }
//                            if (pixelColor.getRed() +
//                                    pixelColor.getGreen() +
//                                    pixelColor.getBlue() < 130
//                            ) {
//                            }else {
//                                robot.keyPress(KeyEvent.VK_4);
//                                robot.keyRelease(KeyEvent.VK_4);
//                            }
//                        }
//
//                    } else {
//                    }
//                    pause(baseDelayT1_1);
//                }
//            }
//        };




        t2 = new MyThread(MyThread.State.on) {
            @Override
            public void run() {
                while (true) {
//
                    if (t2Temp == true) {
                        robot.keyPress(KeyEvent.VK_G);
                        robot.keyRelease(KeyEvent.VK_G);
                    }
                    pause(baseDelay);

                }
            }
        };


        t3=new MyThread(MyThread.State.on) {
            @Override
            public void run() {
                while (true) {
                    if (t1Temp == true) {
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                    } else {
                    }
                    pause(baseDelayT3);

                }
            }
        };

        t4 = new MyThread(MyThread.State.off) {
            @Override
            public void run() {
                while (true) {
                    筛选装备.run( robot, 筛选装备_野蛮人);
                    this.mySuspend();
                }
            }
        };


//        t4=new MyThread(MyThread.State.off){
//            @Override
//            public void run() {
//                while (true) {
//                    int x= (int) MouseInfo.getPointerInfo().getLocation().getX();
//                    int y= (int) MouseInfo.getPointerInfo().getLocation().getY();
//
//                    String pythonScript = "C:\\Users\\aaa\\Desktop\\python_project\\get_words_of_picture.py"; // 替换为实际的Python脚本路径
//                    String pythonInterpreter = "C:\\Users\\aaa\\.conda\\envs\\paddle_env\\python.exe"; // Python解释器
//                    String arg1 = String.valueOf(x-437); // 传递给方法的参数
//                    String arg2 = String.valueOf(91); // 传递给方法的参数
//                    String arg3 = "390"; // 传递给方法的参数
//                    String arg4 = "736"; // 传递给方法的参数
//                    try {
//                        ProcessBuilder processBuilder = new ProcessBuilder(
//                                pythonInterpreter, pythonScript, arg1, arg2,arg3,arg4);
//                        Process process = processBuilder.start();
//
//                        InputStream inputStream = process.getInputStream();
//                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
//                        BufferedReader reader = new BufferedReader(inputStreamReader);
//                        String result="";
//                        String line;
//                        while ((line = reader.readLine()) != null) {
//                            System.out.println(line); // 输出Python方法的返回值
//                            result=line;
//                        }
//
//                        int exitCode = process.waitFor();
//                        System.out.println("Python process exited with code " + exitCode);
//
//                        if(result.equals("False")){
//                            robot.keyPress(VK_SPACE);
//                            robot.keyRelease(VK_SPACE);
//
//                            System.out.println("------------------------------space");
//                        }
//
//
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    this.mySuspend();
//                }
//            }
//        };


    }

//    @ListenMouseKeyboard(value = 82, intercept = true,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void r() {
//
//        t1Temp =true;
//        t1.myResume();
//
//    }
//    @ListenMouseKeyboard(value = 82,press = false, intercept = true,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void r1() {
//    }

    @ListenMouseKeyboard(value = 69, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e() {
//        攻击型加移动 = true;
//        是否核心技能=false;

        t1Temp = true;
        t2Temp = false;


//                robot.keyRelease(KeyEvent.VK_G);
//        robot.keyPress(KeyEvent.VK_G);
    }

    @ListenMouseKeyboard(value = 82, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void R() {
//        攻击型加移动 = false;
        t1Temp = false;
        t2Temp = true;

    }


    @ListenMouseKeyboard(value = 514, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void w() {
//        暂停t1时是否松开左键 = false;
        t1Temp = false;
        t2Temp = false;
    }


    @ListenMouseKeyboard(value = 523, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 侧键_f() {
        t1Temp = false;
        t2Temp = true;
    }

    @ListenMouseKeyboard(value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false)
    public static void 侧键_f_1() {
        t1Temp = true;
        t2Temp = false;
    }


    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 49, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 50, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 51, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1() {
//        if(右键或者1234在t1运行时按下==true){
//            之前已经有右键或者1234在t1运行时按下=true;
//        }else {
//            之前已经有右键或者1234在t1运行时按下=false;
//        }

//        暂停t1时是否松开左键 =false;

        if (t1Temp == true) {
            右键或者1234在t1运行时按下 = true;
        }
        t1Temp = false;

    }

    //    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(value = 49, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 键盘1_1() {
        if (右键或者1234在t1运行时按下 == true) {
            t1Temp = true;
//            t1.myResume();
        }
        右键或者1234在t1运行时按下 = false;
    }


    @ListenMouseKeyboard(value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, intercept = true)

    @ListenMouseKeyboard(value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键() {
        是否核心技能 = true;
        是否基础技能 = false;
    }

    @ListenMouseKeyboard(value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, press = false, intercept = true)
    @ListenMouseKeyboard(value = 517, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    public static void 右键1() {
        是否基础技能 = true;
    }

//    @ListenMouseKeyboard(value = 32, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 空格() {
//        是否核心技能=true;
//    }


//    @ListenMouseKeyboard(value = 523, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    public static void 侧键() {
//        是否核心技能 = false;
//    }
//
//
//    @ListenMouseKeyboard(value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
//    public static void 侧键1() {
//        是否核心技能 = true;
//    }


}
