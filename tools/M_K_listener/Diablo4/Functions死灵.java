package custom;

import addition.FunctionsAddition;
import base.CommonUtil;
import base.ListenMouseKeyboard;
import base.MyThread;
import base.enty.TaskResult;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    public static List<Integer> list = new ArrayList<>(Arrays.asList(VK_7, VK_8, VK_9, VK_W));
    public static int len = list.size();

    public static MyThread t1 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {
            int i = 0;

            while (true) {
                if (战斗 == true && 移动 == false) {


                    if (判断骷髅()) {
                        robot.keyPress(VK_6);
                        robot.keyRelease(VK_6);
                    } else {
                        if(i==len){
                            robot.keyPress(VK_SPACE);
                        }
                        robot.keyPress(list.get(i));
                        robot.keyRelease(list.get(i));
                        if(i==len){
                            robot.keyRelease(VK_SPACE);
                        }

                        if(i>=len){
                            i=0;
                        }else {
                            i++;
                        }
                    }



                    pause(800L);


                } else {
                }
                pause(BaseDelay);
            }
        }
    };


    public static boolean 移动 = false;

    @ListenMouseKeyboard(key = "左键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(key = "g", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void 左键1() {
        移动 = true;
    }

    @ListenMouseKeyboard(key = "左键松开", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(key = "g", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void 左键2() {
        移动 = false;
    }

    public static boolean 战斗 = false;

    @ListenMouseKeyboard(key = "q", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void q1() {
        自动喝药开始(null, null, false);
        战斗 = true;
    }


    @ListenMouseKeyboard(key = "w", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true)
    @ListenMouseKeyboard(key = "t", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, extend = true)
    public static void R() {

        自动喝药结束();
        战斗 = false;
    }


}
