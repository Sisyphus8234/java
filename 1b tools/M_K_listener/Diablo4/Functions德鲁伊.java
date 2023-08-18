import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

public class Functions德鲁伊 extends IFunctions {

    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static boolean t1Temp = false;
//    public static boolean t2Temp = false;
    public static boolean 右键或者1234在t1运行时按下 = false;
    public static boolean 之前已经有右键或者1234在t1运行时按下 = false;
    public static boolean 暂停t1时是否松开左键 = true;
    public static boolean 攻击型加移动 = true;

    public static boolean b0 = true;
    public static Date time = new Date();


    public static MyThread t1;
    public static MyThread t2;
    public static MyThread t3;

    static {
        t1 = new MyThread("on") {
            @Override
            public void run() {
                while (true) {

                    if(t1Temp ==true){

                        if(攻击型加移动==true) {

//                            robot.keyPress(KeyEvent.VK_D);
//                            robot.keyRelease(KeyEvent.VK_D);


                            robot.keyPress(KeyEvent.VK_5);
                            robot.keyRelease(KeyEvent.VK_5);

                            if(b0==true) {

                                robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                                robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//                                robot.keyPress(KeyEvent.VK_G);
//                                robot.keyRelease(KeyEvent.VK_G);
                            }

                        }else {
                            robot.keyPress(KeyEvent.VK_G);
                            robot.keyRelease(KeyEvent.VK_G);
//                            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                        }


                        pause(baseDelay);

                    }
                    else
                     {

//                         robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                         pause(baseDelay);

                    }
                }
            }
        };
        t1.myResume();

//        t2 = new MyThread("on") {
//            @Override
//            public void run() {
//                while (true) {
//
//                    if(t1Temp==true){
//                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//                    }
//                    else {
//
//                    }
//                pause(baseDelay);
//
//                }
//            }
//        };

        t3 = new MyThread("on") {
            @Override
            public void run() {
                while (true) {

                    if(t1Temp==true&&攻击型加移动==true){

                        robot.keyPress(KeyEvent.VK_1);
                        robot.keyRelease(KeyEvent.VK_1);
                        time=new Date();
                    }
                    else {

                    }
                    pause(1000);

                }
            }
        };


    }

//    @ListenMouseKeyboard(value = 82, intercept = true,keyboardOrMouse = 0)
//    public static void r() {
//
//攻击型加移动=false;
//        t1Temp =true;
//        t1.myResume();
//
//    }
//    @ListenMouseKeyboard(value = 82,press = false, intercept = true,keyboardOrMouse = 0)
//    public static void r1() {
//    }

    @ListenMouseKeyboard(value = 69, intercept = true,keyboardOrMouse = 0)
    public static void e() {
        攻击型加移动=true;
        t1Temp =true;
        t1.myResume();

//        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//        robot.keyRelease(KeyEvent.VK_G);
//        robot.keyPress(KeyEvent.VK_G);


    }

    @ListenMouseKeyboard(value = 82, intercept = true,keyboardOrMouse = 0)
    public static void R() {
        攻击型加移动=false;
        t1Temp =true;
        t1.myResume();
    }


    @ListenMouseKeyboard(value = 523,keyboardOrMouse = 1)
    public static void a() {
        攻击型加移动=false;
    }

    @ListenMouseKeyboard(value = 524,keyboardOrMouse = 1)
    public static void a1() {
        攻击型加移动=true;
    }

    @ListenMouseKeyboard(value = 192,keyboardOrMouse = 0,intercept = true)
    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = 1)
    public static void 右键() {
        b0=false;
    }

    @ListenMouseKeyboard(value = 192,keyboardOrMouse = 0,press = false,intercept = true)
    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = 1)
    public static void 右键1() {
        b0=true;
    }



    @ListenMouseKeyboard(value = 514 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 87 ,keyboardOrMouse = 0)
    public static void w() {
        暂停t1时是否松开左键 =false;
        t1Temp = false;

//        robot.keyRelease(KeyEvent.VK_G);

    }

//    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 49 ,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 50 ,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 51 ,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 70 ,keyboardOrMouse = 0)
    public static void f1234() {
//        if(右键或者1234在t1运行时按下==true){
//            之前已经有右键或者1234在t1运行时按下=true;
//        }else {
//            之前已经有右键或者1234在t1运行时按下=false;
//        }

//        暂停t1时是否松开左键 =false;

        if(t1Temp==true){
            右键或者1234在t1运行时按下 =true;
        }
        t1Temp = false;

    }

//    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 49 ,press = false,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 50 ,press = false,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 51 ,press = false,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 70 ,press = false,keyboardOrMouse = 0)
    public static void f12341() {
        if(右键或者1234在t1运行时按下 ==true){
            t1Temp = true;
//            t1.myResume();
        }
        右键或者1234在t1运行时按下 =false;

    }











}
