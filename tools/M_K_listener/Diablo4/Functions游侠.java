import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions游侠 extends IFunctions {

    public static Long baseDelay = Long.parseLong(Config.read("BaseDelay"));
    public static boolean t1Temp = false;
//    public static boolean t2Temp = false;
    public static boolean 右键或者1234在t1运行时按下 = false;
    public static boolean 之前已经有右键或者1234在t1运行时按下 = false;
    public static boolean 暂停t1时是否松开左键 = true;
    public static boolean 攻击型加移动 = true;


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

                            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);

                            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);

                            robot.keyPress(KeyEvent.VK_5);
                            robot.keyRelease(KeyEvent.VK_5);

                        }else {
                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                            robot.keyPress(KeyEvent.VK_G);
                            robot.keyRelease(KeyEvent.VK_G);
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

//        t2 = new MyThread() {
//            @Override
//            public void run() {
//                while (true) {
////                    robot.keyPress(KeyEvent.VK_R);
//                    if(t2Temp==true){
//                    robot.keyPress(KeyEvent.VK_G);}
//                    if(t2Temp==false){
//
//
//                    }
//
//                    pause(200);
////                    this.mySuspend();
//
//
//                }
//            }
//        };
//        t2.myResume();

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



    @ListenMouseKeyboard(value = 514 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 87 ,keyboardOrMouse = 0)
    public static void w() {
        暂停t1时是否松开左键 =false;
        t1Temp = false;

    }

    @ListenMouseKeyboard(value = 516 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 49 ,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 50 ,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 51 ,keyboardOrMouse = 0)
//    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = 0)
    public static void 右键() {
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

    @ListenMouseKeyboard(value = 517 ,keyboardOrMouse = 1)
    @ListenMouseKeyboard(value = 49 ,press = false,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 50 ,press = false,keyboardOrMouse = 0)
    @ListenMouseKeyboard(value = 51 ,press = false,keyboardOrMouse = 0)
//    @ListenMouseKeyboard(value = 52 ,press = false,keyboardOrMouse = 0)
    public static void 右键1() {
        if(右键或者1234在t1运行时按下 ==true){
            t1Temp = true;
//            t1.myResume();
        }
        右键或者1234在t1运行时按下 =false;

    }

    @ListenMouseKeyboard(value = 52 ,keyboardOrMouse = 0)
    public static void 四() {
        攻击型加移动 = false;

    }










}
