import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

public class Functions extends IFunctions {

//     @ListenBar(off = false)
//     public static Integer on=44;
//
//     @ListenBar(off = true)
//     public static Integer off=19;

    // @ListenBar(threadList = true)
    // public static List<Thread> threadList=new ArrayList<>();

    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));

    public static boolean temp1 = false;

    public static boolean temp2 = false;

    public static boolean 波浪键按住 = false;
    public static boolean 波浪键按住期间做了什么 = false;
    public static boolean 波浪键功能执行了 = false;
    public static Integer 切换次数 = 0;
    public static int y1 = 0;
    public static int y2 = 0;

    public static MyThread t1;
    public static MyThread t2;
    public static MyThread t3;
    public static MyThread t4;
    public static MyThread t5;

    public static int x= Integer.parseInt(Config.read("x"));
    public static int y= Integer.parseInt(Config.read("y"));

    public static boolean 滚轮变成左键=true;
    public static int 滚轮次数 =0;
    public static int 滚轮方向 =1;
    public static Long time= new Date().getTime();

    public static Point point=new Point();

    static {



        t1 = new MyThread() {
            @Override
            public void run() {
                while (true) {
                    if (temp2 == false) {
                        temp2 =true;
                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    } else if (temp1 ==false) {

                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        temp2 =false;
//                        temp2 =false;
                        t1.mySuspend();
                    }
                    pause(baseDelay);
                }

            }
        };



        t2 = new MyThread() {
            @Override
            public void run() {
                while (true) {
                        if (切换次数 > 0) {
                            robot.keyPress(KeyEvent.VK_ALT);
                            robot.keyPress(KeyEvent.VK_TAB);
                            pause(50);
                            robot.keyRelease(KeyEvent.VK_TAB);
                            robot.keyRelease(KeyEvent.VK_ALT);
                            pause(200);
                        }


                        robot.keyPress(KeyEvent.VK_ALT);
                        robot.keyPress(KeyEvent.VK_TAB);

                        robot.keyRelease(KeyEvent.VK_TAB);
                        pause(100);
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
                        t2.mySuspend();
                }
            }
        };

//        t3 = new MyThread() {
//            @Override
//            public void run() {
//                while (true) {
//                    if (MouseInfo.getPointerInfo().getLocation().x!=x) {
//                        滚轮变成左键=true;
//
//                    } else if (MouseInfo.getPointerInfo().getLocation().x==x) {
//                        滚轮变成左键=false;
//
//                    }
//                    pause(100);
//                }
//            }
//        };
//        t3.myResume();

//        t4 = new MyThread() {
//            @Override
//            public void run() {
//                while (true) {
//
//                            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//                            pause(50);
//                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//                            pause(1000);
//
//
//
//                        t4.mySuspend();
//
//
//
//
//                }
//            }
//        };
//
//        t5 = new MyThread() {
//            @Override
//            public void run() {
//                while (true) {
//
//                    if(滚轮次数>0) {
//                        robot.mouseMove(point.x,point.y);
//
//                            robot.mouseWheel(滚轮方向);
//
//
//
//                        滚轮次数-=1;
//                        pause(200);
//                    }else {
//                        t4.mySuspend();
//                    }
//                }
//            }
//        };
    }


    @ListenMouseKeyboard(value = 27, intercept = true,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 93,intercept = true,keyboardOrMouse = 0)
    public static void esc和菜单键() {
        temp1 =true;
        t1.myResume();
    }

    @ListenMouseKeyboard(value = 27, press = false, intercept = true,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 93,press = false,intercept = true,keyboardOrMouse = 0)
    public static void esc和菜单键1() {
        temp1 = false;
    }

    @ListenMouseKeyboard(value = 112, intercept = true,keyboardOrMouse = 0)
    public static void f1键按下() {
        robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);

    }

    @ListenMouseKeyboard(value = 112,press = false, intercept = true,keyboardOrMouse = 0)
    public static void f1键松开() {
        robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
    }

    @ListenMouseKeyboard(value = 113,intercept = true,keyboardOrMouse = 0)
    public static void f2键() {
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @ListenMouseKeyboard(value = 114,intercept = true,keyboardOrMouse = 0)
    public static void f3键() {
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
    }

    @ListenMouseKeyboard(value = 115,intercept = true,keyboardOrMouse = 0)
    public static void f4键() {
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
    }



    @ListenMouseKeyboard(value = 192,intercept = true,keyboardOrMouse = 0)
    public static void 波浪键0() {
        波浪键按住期间做了什么=false;
        波浪键按住 =true;
        切换次数=0;
//        t2.myResume();
    }


//     @ListenMouseKeyboard(value = 192,intercept = true,press = false)
//     public static void 波浪键1() {

//         波浪键按住 =false;

//         if(波浪键按住期间做了什么==false) {
//             if (波浪键功能执行了 == false) {
//                 robot.keyPress(KeyEvent.VK_CONTROL);
//                 robot.keyPress(KeyEvent.VK_SHIFT);
//                 robot.keyPress(KeyEvent.VK_1);
// //                pause(100);

//                 robot.keyRelease(KeyEvent.VK_1);
//                 pause(100);
//                 robot.keyRelease(KeyEvent.VK_CONTROL);
//                 robot.keyRelease(KeyEvent.VK_SHIFT);

//                 波浪键功能执行了 = true;
//             }else {
//                 robot.keyPress(KeyEvent.VK_CONTROL);
//                 robot.keyPress(KeyEvent.VK_SHIFT);
//                 robot.keyPress(KeyEvent.VK_0);
// //                pause(100);

//                 robot.keyRelease(KeyEvent.VK_0);
//                 pause(100);
//                 robot.keyRelease(KeyEvent.VK_CONTROL);
//                 robot.keyRelease(KeyEvent.VK_SHIFT);
//                 波浪键功能执行了 = false;
//             }

//         }


//     }

    @ListenMouseKeyboard(value = 192,intercept = true,press = false,keyboardOrMouse = 0)
    public static void 波浪键1() {

        波浪键按住 =false;

        if(波浪键按住期间做了什么==true) {


        }else{
            robot.keyPress(KeyEvent.VK_BACK_QUOTE);
            robot.keyRelease(KeyEvent.VK_BACK_QUOTE);
        }


    }



    @ListenMouseKeyboard(value = 9,intercept = true,keyboardOrMouse = 0)
    public static void tab键() {


        if(波浪键按住 ==true) {
            波浪键按住期间做了什么=true;


            t2.myResume();

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

//    @ListenMouseKeyboard(value = 49,intercept = true)
//    public static void 数字1() {
//        if(波浪键按住 ==true){
//
//            波浪键按住期间做了什么=true;
//
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_SHIFT);
//            robot.keyPress(KeyEvent.VK_0);
//            pause(50);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            robot.keyRelease(KeyEvent.VK_SHIFT);
//            robot.keyRelease(KeyEvent.VK_0);
//
//
//
//        }else{
//
//            robot.keyPress(KeyEvent.VK_1);
//        }
//    }

    @ListenMouseKeyboard(value = 50,intercept = true,keyboardOrMouse = 0)
    public static void 数字2() {
        if(波浪键按住 ==true){
            波浪键按住期间做了什么=true;
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
    @ListenMouseKeyboard(value = 513,keyboardOrMouse = 1)
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

    @ListenMouseKeyboard(value = 514,keyboardOrMouse = 1)
    public static void f15() {
        leftBotton =false;
    }

    @ListenMouseKeyboard(value = 516,keyboardOrMouse = 1)
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

    @ListenMouseKeyboard(value = 517,keyboardOrMouse = 1)
    public static void f19() {
        rightBotton =false;
    }



//    @ListenMouseKeyboard(value = 93,intercept = true,keyboardOrMouse = 0)
//    public static void 菜单键按下() {
//            robot.keyPress(KeyEvent.VK_ALT);
//            robot.keyPress(KeyEvent.VK_SHIFT);
//            robot.keyPress(KeyEvent.VK_TAB);
//
//            robot.keyRelease(KeyEvent.VK_ALT);
//            robot.keyRelease(KeyEvent.VK_SHIFT);
//            robot.keyRelease(KeyEvent.VK_TAB);
//    }

//    @ListenMouseKeyboard(value = 93,press = false,intercept = true,keyboardOrMouse = 0)
//    public static void 菜单键松开() {
//    }

//    @ListenMouseKeyboard(value = 522,intercept = true,keyboardOrMouse = 2,mouseData = -7864320)
//    public static void 鼠标滚轮下() {
//        滚轮方向=1;
//
//        if(滚轮变成左键==true) {
////            滚轮次数++;
//            if(t1.state.equals("myResume")){
//                temp2=true;
//            }else {
//                t4.myResume();
//            }
//
//
//
//        }else {
//            滚轮次数++;
//            t5.myResume();
//        }
//    }
//    @ListenMouseKeyboard(value = 522,intercept = true,keyboardOrMouse = 2,mouseData = 7864320)
//    public static void 鼠标滚轮上() {
//        滚轮方向=-1;
//        if(滚轮变成左键==true){
//
//        t1.myResume();
//        }else{
//            滚轮次数++;
//            t5.myResume();
//        }
//    }

//    @ListenMouseKeyboard(value = 523,intercept = true,keyboardOrMouse = 1)
//    public static void 侧键() {
//        point=MouseInfo.getPointerInfo().getLocation();
//        System.out.println(point);
//    }

}
