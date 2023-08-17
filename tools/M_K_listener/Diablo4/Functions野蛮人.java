import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

import static java.awt.event.KeyEvent.VK_Q;

public class Functions野蛮人 extends Functions公共 {

    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
//    public static Long weight = Long.parseLong(Config.read("Weight"));
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
    public static MyThread t2;
    public static MyThread t3;

    static {
        t1 = new MyThread("on") {
            @Override
            public void run() {
                while (true) {
                    if (t1Temp == true) {

//                        if(随机用哪个基础技能==true) {
//                            用哪个基础技能 = r.nextBoolean();
//                        }else {
//                            用哪个基础技能=false;
//                        }
                        if (是否基础技能 == true) {

                            robot.keyPress(KeyEvent.VK_5);
                            robot.keyRelease(KeyEvent.VK_5);
                            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);


//                            if (用哪个基础技能==true) {

//                            } else {
//                                robot.keyPress(KeyEvent.VK_9);
//                                robot.keyRelease(KeyEvent.VK_9);
//                            }

                        }
                        if(是否核心技能) {

                            pixelColor = robot.getPixelColor(1318, 965);
//                    System.out.println(pixelColor);
//                    200,128,55
                            if(pixelColor.getRed()+
                                    pixelColor.getGreen()+
                                    pixelColor.getBlue()>=270

                            ){


                                robot.keyPress(KeyEvent.VK_4);
                                robot.keyRelease(KeyEvent.VK_4);}
                        }




                    } else {
//                         robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);

                    }
                    pause(baseDelay);
                }
            }
        };


        t2 = new MyThread("on") {
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


//        t3 = new MyThread("on") {
//            @Override
//            public void run() {
//                while (true) {
//
//                    if (t1Temp == true && 是否核心技能 == true) {
//                        robot.keyPress(KeyEvent.VK_4);
//                        robot.keyRelease(KeyEvent.VK_4);
//                    } else {
//                    }
//                    pause(300);
//
//                }
//            }
//        };

//        new MyThread("off") {
//            @Override
//            public void run() {
//                while (true) {
//
//                    pixelColor = robot.getPixelColor(1318, 965);
////                    System.out.println(pixelColor);
////                    200,128,55
//                    if(pixelColor.getRed()+
//                    pixelColor.getGreen()+
//                    pixelColor.getBlue()>=333
//
//                    )
//
////                    Math.abs(pixelColor.getRed()-237)<=10
////                    &&Math.abs(pixelColor.getGreen()-28)<=10
////                    &&Math.abs(pixelColor.getBlue()-36)<=10
//                    {
//
//是否核心技能=true;
//                    }else {
//                        是否核心技能=false;
//                    }
//
//
//                    pause(200);
//                }
//            }
//        };

    }

//    @ListenMouseKeyboard(value = 82, intercept = true,keyboardOrMouse = 0)
//    public static void r() {
//
//        t1Temp =true;
//        t1.myResume();
//
//    }
//    @ListenMouseKeyboard(value = 82,press = false, intercept = true,keyboardOrMouse = 0)
//    public static void r1() {
//    }

    @ListenMouseKeyboard(value = 69, intercept = true, keyboardOrMouse = 0)
    public static void e() {
//        攻击型加移动 = true;
//        是否核心技能=false;

        t1Temp = true;
        t2Temp = false;


//                robot.keyRelease(KeyEvent.VK_G);
//        robot.keyPress(KeyEvent.VK_G);
    }

    @ListenMouseKeyboard(value = 82, intercept = true, keyboardOrMouse = 0)
    public static void R() {
//        攻击型加移动 = false;
        t1Temp = false;
        t2Temp = true;

    }


    @ListenMouseKeyboard(value = 514, keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 87, keyboardOrMouse = 0)
    public static void w() {
//        暂停t1时是否松开左键 = false;
        t1Temp = false;
        t2Temp = false;
    }


    @ListenMouseKeyboard(value = 523, keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = 0)
    public static void 侧键_f() {
        t1Temp=false;
        t2Temp=true;
    }

    @ListenMouseKeyboard(value = 524, keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = 0, press = false)
    public static void 侧键_f_1() {
        t1Temp = true;
        t2Temp=false;
    }


    //    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 49, keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 50, keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 51, keyboardOrMouse = 0)
//    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = 0)
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

    //    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 49, press = false, keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 50, press = false, keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 51, press = false, keyboardOrMouse = 0)
//    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = 0)
    public static void 键盘1_1() {
        if (右键或者1234在t1运行时按下 == true) {
            t1Temp = true;
//            t1.myResume();
        }
        右键或者1234在t1运行时按下 = false;
    }



    @ListenMouseKeyboard(value = 192, keyboardOrMouse = 0, intercept = true)

    @ListenMouseKeyboard(value = 516, keyboardOrMouse = 1)
    public static void 右键() {
        是否核心技能=true;
        是否基础技能 = false;
    }

    @ListenMouseKeyboard(value = 192, keyboardOrMouse = 0, press = false, intercept = true)
    @ListenMouseKeyboard(value = 517, keyboardOrMouse = 1)
    public static void 右键1() {
        是否基础技能 = true;
    }

//    @ListenMouseKeyboard(value = 32, keyboardOrMouse = 0)
//    public static void 空格() {
//        是否核心技能=true;
//    }


//    @ListenMouseKeyboard(value = 523, keyboardOrMouse = 1)
//    public static void 侧键() {
//        是否核心技能 = false;
//    }
//
//
//    @ListenMouseKeyboard(value = 524, keyboardOrMouse = 1)
//    public static void 侧键1() {
//        是否核心技能 = true;
//    }


}
