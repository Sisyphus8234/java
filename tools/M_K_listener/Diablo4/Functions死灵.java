package custom;

import addition.FunctionsAddition;
import base.CommonUtil;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.event.MouseEvent;

import static java.awt.event.KeyEvent.*;


public class Functions死灵 extends Functions公共 {
    static {
    }


    private static FunctionsAddition.PixelColor pixelColor = new FunctionsAddition.PixelColor();


    public static boolean 需要骷髅祭司 = false;
    public static boolean 需要骷髅法师 = false;
    public static boolean 需要骷髅战士 = false;

    public static boolean 判断骷髅() {
//        需要骷髅战士 = pixelColor.getPixelColorHSB(1376, 997)[1] < 0.06F;
        需要骷髅战士 = pixelColor.getPixelColorHSB(1394, 976)[1] < 0.11333F;
        需要骷髅法师 = pixelColor.getPixelColorHSB(1400, 1025)[1] < 0.11F;
        需要骷髅祭司 = pixelColor.getPixelColorHSB(776, 969)[1] < 0.61F;


        return 需要骷髅祭司 || 需要骷髅法师 || 需要骷髅战士;
    }


    public static boolean b1 = false;


    @ListenMouseKeyboard(key = "1", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 尸体() {
        b1=true;
        t1.myResume();
    }

    @ListenMouseKeyboard(key = "1", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
    public static void 尸体1() {
        b1=false;
    }

    public static boolean t1b2;
    public static MyThread t1 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                if (b1 == true) {



//                    if(t1b2==true){
//                        robot.keyPress(VK_4);
//                        robot.keyRelease(VK_4);
//                        t1b2=false;
//                    }

                    robot.keyPress(VK_7);
                    robot.keyRelease(VK_7);




                    if (判断骷髅()) {
                        robot.keyPress(VK_6);
                        robot.keyRelease(VK_6);
                    } else {



                    }
                    robot.keyPress(VK_8);
                    robot.keyRelease(VK_8);

                    robot.keyPress(VK_9);
                    robot.keyRelease(VK_9);
                } else {
                    t1b2=true;
                    this.mySuspend();
                }
                pause(BaseDelay);
            }
        }
    };


    public static boolean t2b=false;
    public static MyThread t2 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            while (true) {


                if(t2b==true){
                    robot.keyPress(VK_2);
                    robot.keyRelease(VK_2);
                }
                pause(17000L);
            }
        }
    };
//    public static MyThread t2 = new MyThread(MyThread.State.on) {
//        @Override
//        public void run() {
//            while (true) {
//                if (b2 == true) {
//                    if (判断骷髅()) {
//
//                        myKeyPress(VK_1);
//                        myKeyRelease(VK_1);
//
//                    }
//                } else {
//                    if(getKeyStatus(VK_1)) {
//                        robot.keyRelease(VK_1);
//                    }
//                }
//                pause(BaseDelay);
//            }
//        }
//    };




    public static boolean b2=false;
    @ListenMouseKeyboard(key = "1", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,extend = true,timeInterval = 200L)
    public static void f1() {


    }


    @ListenMouseKeyboard(key = "w", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,extend = true)
    public static void R() {


    }



    @ListenMouseKeyboard(key="滚轮",keyboardOrMouse=CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
    public static void gunlun() {
        b拾取=true;
        t2b=true;

        自动喝药开始(null, null, false);

    }

    @ListenMouseKeyboard(key="滚轮",keyboardOrMouse=CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320")
    public static void gunlun1() {
        b拾取=false;
        t2b=false;

        自动喝药结束();

    }





}
