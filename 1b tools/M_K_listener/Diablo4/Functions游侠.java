import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions游侠 extends Functions公共 {

//    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static Long baseDelay = 200L;
    public static boolean t1Temp = false;
    public static boolean t2Temp = false;

    public static boolean 右键或者1234在t1运行时按下 = false;
    public static boolean 之前已经有右键或者1234在t1运行时按下 = false;
    public static boolean 暂停t1时是否松开左键 = true;
    public static boolean 是否基础技能 = true;
    public static boolean 是否核心技能 = true;
    public static 筛选装备_游侠 筛选装备_游侠 = new 筛选装备_游侠();


    public static MyThread t1;
    public static MyThread t2;
    public static MyThread t3;
    public static MyThread t4;

    static {
//        t1 = new MyThread("on") {
//            @Override
//            public void run() {
//                while (true) {
//
//                    if (t1Temp == true) {
//                        if (攻击型加移动 == true) {
//                            if (是否连点左键 == true) {
//                                robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//                                robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//                            }
//                            robot.keyPress(KeyEvent.VK_5);
//                            robot.keyRelease(KeyEvent.VK_5);
//
//                        } else {
////                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//                            robot.keyPress(KeyEvent.VK_G);
//                            robot.keyRelease(KeyEvent.VK_G);
//                        }
//
//                        pause(baseDelay);
//
//                    } else {
//
////                         robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//                        pause(baseDelay);
//
//                    }
//                }
//            }
//        };

        t1 = new MyThread("on") {
            @Override
            public void run() {
                while (true) {
                    if (t1Temp == true) {

                        if(是否基础技能) {
                            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        }

                        robot.keyPress(KeyEvent.VK_5);
                        robot.keyRelease(KeyEvent.VK_5);
                    } else {
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


        new MyThread("on") {
            @Override
            public void run() {
                while (true) {
                    if (t1Temp == true) {
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                    } else {
                    }
                    pause(baseDelay);

                }
            }
        };



        t3 = new MyThread("on") {
            @Override
            public void run() {
                while (true) {

                    if (t1Temp == true ) {
                        robot.keyPress(KeyEvent.VK_1);
                        robot.keyRelease(KeyEvent.VK_1);
                    } else {
                    }
                    pause(1000);

                }
            }
        };

        t4 = new MyThread("off") {
            @Override
            public void run() {
                while (true) {
                    筛选装备.run( robot, 筛选装备_游侠, 筛选装备_游侠.要的词缀, 筛选装备_游侠.不要的词缀, 筛选装备_游侠.有效词条要求);
                    this.mySuspend();
                }
            }
        };

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
        是否基础技能=false;
        t1Temp = true;
        t2Temp = false;
    }

    @ListenMouseKeyboard(value = 69,press = false, intercept = true, keyboardOrMouse = 0)
    public static void e1() {
        是否基础技能=true;
        t1Temp = true;
        t2Temp = false;
    }

    @ListenMouseKeyboard(value = 82, intercept = true, keyboardOrMouse = 0)
    public static void R() {
        t1Temp = false;
        t2Temp = true;
    }


    @ListenMouseKeyboard(value = 523, keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = 0 )
    public static void 侧键_f() {
        t1Temp = false;
        t2Temp = true;
    }

    @ListenMouseKeyboard(value = 524, keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 70, keyboardOrMouse = 0, press = false)
    public static void 侧键_f_1() {
        t1Temp = true;
        t2Temp = false;
    }


    @ListenMouseKeyboard(value = 514, keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 87, keyboardOrMouse = 0)
    public static void w() {
        暂停t1时是否松开左键 = false;
        t1Temp = false;
        t2Temp = false;

//                robot.keyRelease(KeyEvent.VK_G);


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

    @ListenMouseKeyboard(value = 52, keyboardOrMouse = 0)
    public static void 四() {
        t1Temp = false;
        t2Temp = true;

    }


    @ListenMouseKeyboard(value = 192, keyboardOrMouse = 0, intercept = true)
    @ListenMouseKeyboard(value = 516, keyboardOrMouse = 1)
    public static void 右键() {
        是否基础技能 = false;
    }

    @ListenMouseKeyboard(value = 192, keyboardOrMouse = 0, press = false, intercept = true)
    @ListenMouseKeyboard(value = 517, keyboardOrMouse = 1)
    public static void 右键1() {
        是否基础技能 = true;
    }

    @ListenMouseKeyboard(value = 112, keyboardOrMouse = 0, intercept = true)
    public static void 图像识别_装备() {
        筛选装备.是否筛选装备 = true;
        筛选装备.鼠标是否回到原点 = true;
        t4.myResume();
    }

    @ListenMouseKeyboard(value = 114, keyboardOrMouse = 0, intercept = true)
    public static void 图像识别_装备1() {
        筛选装备.是否筛选装备 = true;
        筛选装备.鼠标是否回到原点 = false;
        t4.myResume();
    }

    @ListenMouseKeyboard(value = 113, keyboardOrMouse = 0, intercept = true)
    public static void 图像识别_装备_终止() {
        筛选装备.是否筛选装备 = false;
    }


}
