import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions extends IFunctions {

    // @ListenBar(off = false)
    // public static Integer on=44;

    // @ListenBar(off = true)
    // public static Integer off=19;

    // @ListenBar(threadList = true)
    // public static List<Thread> threadList=new ArrayList<>();

    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));

    public static boolean temp1 = false;
    public static boolean temp2 = false;

    public static boolean 波浪键按住 = false;
    public static Integer 切换次数 = 0;
    public static int y1 = 0;
    public static int y2 = 0;

    public static Thread t1;
    public static Thread t2;

    static {
        t1 = new CreateThread() {
            @Override
            public void myFunction() {
                while (true) {

                    if (temp1 == false) {

                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                        temp1 =true;

                    } else if (temp2 ==true) {
                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        temp1=false;
                        temp2 =false;
                        t1.suspend();
                    }
                    pause(baseDelay);
                }

            }
        }.thread;
        t1.suspend();
        threadList.add(t1);


        t2 = new CreateThread() {
            @Override
            public void myFunction() {
                while (true) {
                        if (切换次数 > 0) {
                            robot.keyPress(KeyEvent.VK_ALT);
                            robot.keyPress(KeyEvent.VK_TAB);
                            robot.keyRelease(KeyEvent.VK_TAB);
                            robot.keyRelease(KeyEvent.VK_ALT);
                            pause(100);
                        }


                        robot.keyPress(KeyEvent.VK_ALT);
                        robot.keyPress(KeyEvent.VK_TAB);

                        robot.keyRelease(KeyEvent.VK_TAB);
                        if (切换次数 > 0) {

                            for (Integer i = 0; i < 切换次数; i++) {
                                pause(100);
                                robot.keyPress(KeyEvent.VK_RIGHT);
                                pause(100);
                                robot.keyRelease(KeyEvent.VK_RIGHT);
//                                System.out.println("----执行了右箭头");

                            }

                        }

                        robot.keyRelease(KeyEvent.VK_ALT);
                        切换次数+=1;
                        t2.suspend();


                }

            }
        }.thread;
        t2.suspend();

    }


    @ListenMouseKeyboard(value = 27, intercept = true)
    @ListenMouseKeyboard(value = 523, intercept = true)
    public static void f() {
        t1.resume();
    }

    @ListenMouseKeyboard(value = 27, press = false, intercept = true)
    @ListenMouseKeyboard(value = 524, intercept = true)
    public static void f2() {
        temp2 = true;
    }

    @ListenMouseKeyboard(value = 112, intercept = true)
    public static void f3() {
        robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);

    }

    @ListenMouseKeyboard(value = 112,press = false, intercept = true)
    public static void f4() {

        robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
    }

    @ListenMouseKeyboard(value = 113,intercept = true)
    public static void f5() {
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @ListenMouseKeyboard(value = 114,intercept = true)
    public static void f6() {
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
    }

    @ListenMouseKeyboard(value = 115,intercept = true)
    public static void f7() {
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
    }



    @ListenMouseKeyboard(value = 192,intercept = true)
    public static void 波浪键0() {

        波浪键按住 =true;
        切换次数=0;
//        t2.resume();

    }


    @ListenMouseKeyboard(value = 192,intercept = true,press = false)
    public static void 波浪键1() {
        System.out.println("-------------------");
        波浪键按住 =false;
//        切换次数=0;
//        System.out.println("切换次数=0-------------------");

    }



    @ListenMouseKeyboard(value = 9,intercept = true)
    public static void tab键() {


        if(波浪键按住 ==true) {


            t2.resume();

//            if (切换次数 > 0) {
//                robot.keyPress(KeyEvent.VK_ALT);
//                robot.keyPress(KeyEvent.VK_TAB);
//                robot.keyRelease(KeyEvent.VK_TAB);
//                robot.keyRelease(KeyEvent.VK_ALT);
//                pause(100);
//            }
//
//
//            robot.keyPress(KeyEvent.VK_ALT);
//            robot.keyPress(KeyEvent.VK_TAB);
//
//            robot.keyRelease(KeyEvent.VK_TAB);
//            if (切换次数 > 0) {
//
//            for (Integer i = 0; i < 切换次数; i++) {
//                pause(100);
//                robot.keyPress(KeyEvent.VK_RIGHT);
//                pause(100);
//                robot.keyRelease(KeyEvent.VK_RIGHT);
//                System.out.println("----执行了右箭头");
//
//            }
//
//            }
//
//            robot.keyRelease(KeyEvent.VK_ALT);
//            切换次数+=1;

        }else {
            robot.keyPress(KeyEvent.VK_TAB);
        }
    }



    @ListenMouseKeyboard(value = 50,intercept = true)
    public static void 数字2() {
        if(波浪键按住 ==true){
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_ALT);
//            robot.keyPress(KeyEvent.VK_HOME);
//            pause(100);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            robot.keyRelease(KeyEvent.VK_ALT);
//            robot.keyRelease(KeyEvent.VK_HOME);
//            pause(100);

            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_D);
            pause(50);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            robot.keyRelease(KeyEvent.VK_D);
        }else {
            robot.keyPress(KeyEvent.VK_2);
        }
    }



    public static boolean leftBotton =false;
    public static boolean rightBotton =false;

    //功能:切屏
    @ListenMouseKeyboard(value = 513)
    public static void f16() {
        leftBotton =true;
        if(rightBotton ==true) {
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_TAB);

            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
    }

    @ListenMouseKeyboard(value = 514)
    public static void f15() {
        leftBotton =false;
    }

    @ListenMouseKeyboard(value = 516)
    public static void f16_2() {
        rightBotton =true;
        if(leftBotton ==true) {
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_TAB);

            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_TAB);
        }

    }

    @ListenMouseKeyboard(value = 517)
    public static void f19() {
        rightBotton =false;
    }



    @ListenMouseKeyboard(value = 93,intercept = true)

    //win
//    @ListenMouseKeyboard(value = 91,intercept = true)

    public static void f16_3() {
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_TAB);

            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_TAB);

    }


//    @ListenMouseKeyboard(value = 91,press = false,intercept = true)
    @ListenMouseKeyboard(value = 93,press = false,intercept = true)
    public static void f17() {
    }
}
