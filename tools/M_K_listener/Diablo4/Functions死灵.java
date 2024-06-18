package custom;

import addition.FunctionsAddition;
import base.CommonUtil;
import base.ListenMouseKeyboard;
import base.MyThread;
import base.enty.TaskResult;

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



//    @ListenMouseKeyboard(key = "右键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
//    @ListenMouseKeyboard(key = "3", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult 尸体() {
        if(battle==true) {
            b1 = true;
            t1.myResume();
            return new TaskResult(true);
        }else {
            return new TaskResult(false);
        }
    }

//    @ListenMouseKeyboard(key = "3", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, intercept = true)
//    @ListenMouseKeyboard(key = "左键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,timeInterval = 500L)
//    @ListenMouseKeyboard(key="滚轮",keyboardOrMouse=CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=-7864320")
//    @ListenMouseKeyboard(key="滚轮",keyboardOrMouse=CommonUtil.KeyboardOrMouse.Mouse,otherCondition = "mouseData=7864320")
//    @ListenMouseKeyboard(key="4",keyboardOrMouse=CommonUtil.KeyboardOrMouse.Keyboard)
//    @ListenMouseKeyboard(key="3",press = false,keyboardOrMouse=CommonUtil.KeyboardOrMouse.Keyboard)
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
//                        robot.keyPress(VK_5);
//                        robot.keyRelease(VK_5);
//                        t1b2=false;
//                    }







                    if (判断骷髅()) {

                        robot.keyPress(VK_6);
                        robot.keyRelease(VK_6);
                        pause(100L);
                    } else {


                    }
                    robot.keyPress(VK_7);
                    robot.keyRelease(VK_7);

                    robot.keyPress(VK_8);
                    robot.keyRelease(VK_8);


//                    pause(100L);
//                    robot.keyPress(VK_9);
//                    robot.keyRelease(VK_9);

//                    pause(100L);

//                    if(space==false) {
//                        robot.keyPress(VK_5);
//                        robot.keyRelease(VK_5);
//
//                    }


//                    pause(100L);
                    robot.keyPress(VK_SPACE);
                    robot.keyPress(VK_W);
                    robot.keyRelease(VK_W);
                    robot.keyRelease(VK_SPACE);
//                    pause(100L);


                } else {
                    t1b2=true;
                    this.mySuspend();
                }
                pause(BaseDelay);
            }
        }
    };


    public static boolean t2b=false;
//    public static MyThread t2 = new MyThread(MyThread.State.on) {
//        @Override
//        public void run() {
//            while (true) {
//
//
//                if(t2b==true){
//                    robot.keyPress(VK_7);
//                    robot.keyRelease(VK_7);
//                }
//                pause(3000L);
//            }
//        }
//    };









    public static boolean battle=false;
    @ListenMouseKeyboard(key = "q", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,extend = true,timeInterval = 200L)
    public static void f1() {
        b拾取=true;
        t2b=true;
        自动喝药开始(null, null, false);
        battle=true;
    }
    @ListenMouseKeyboard(key = "w", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,extend = true)
    @ListenMouseKeyboard(key = "t", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,extend = true)
    public static void R() {
        b拾取=false;
        t2b=false;
        自动喝药结束();

        battle=false;
    }


    public static boolean space=false;
    @ListenMouseKeyboard(key = "space", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,timeInterval = 200L)
    public static void space() {
        space=true;
    }

    @ListenMouseKeyboard(key = "space", press = false,keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,timeInterval = 200L)
    public static void space1() {
        space=false;
    }






}
