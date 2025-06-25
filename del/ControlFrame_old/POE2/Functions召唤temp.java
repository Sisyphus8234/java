package custom;

import base.CommonUtil;
import base.InputInfo;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;

import static addition.PixelColor.getPixelColorHSB;
import static base.CommonUtil.customConditionSet;
import static java.awt.event.KeyEvent.*;

public class Functions召唤temp extends Functions公共 {

    static {
        初始化set.add(回蓝开启);
        初始化set.add(回血开启);
        初始化set.add(start);
        初始化set.add(移动);
        初始化set.add(左键连点);
    }


    public static MyThread t滚轮 = new MyThread(MyThread.State.on) {
        @Override
        public void run() {


            while (true) {

                if (this.checkBlock() == false) {
                    myKeyRelease(VK_F);
                    myKeyRelease(VK_6);
                }

                this.getBlock();

                myKeyPress(VK_F);


                pause(300L);

            }
        }
    };


    @ListenMouseKeyboard(key = "滚轮", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "-7864320,-15728640", customCondition = start, timeInterval = 800L)
    @ListenMouseKeyboard(key = "滚轮", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "-7864320,-15728640", customCondition = start, timeInterval = 800L)
    public static void 滚轮下() {
        customConditionSet.remove(左键连点);

        wasd = 2;

        customConditionSet.add(滚轮);


        t滚轮.nonBlock();


    }


    @ListenMouseKeyboard(key = "滚轮", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "7864320,15728640", customCondition = start, timeInterval = 800L)
    @ListenMouseKeyboard(key = "滚轮", userInput = false, intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "7864320,15728640", customCondition = start, timeInterval = 800L)
    public static void 滚轮上(InputInfo inputInfo) {
        customConditionSet.add(左键连点);


        customConditionSet.remove(滚轮);
        t滚轮.block();

        wasd = 0;

        threadPressOrRelease(VK_F, false, false);
        threadPressOrRelease(VK_T, false, false);
    }

    public static boolean b=true;
    @ListenMouseKeyboard(key = "右键按下",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = start)
    @ListenMouseKeyboard(key = "右键按下", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "7864320,15728640", customCondition = start)
    public static void 右键(InputInfo inputInfo) {
        if(customConditionSet.contains(移动)){
            b=true;
        }else {
            b=false;
        }
        customConditionSet.remove(移动);
    }

    @ListenMouseKeyboard(key = "右键松开",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse,customCondition = start)
    @ListenMouseKeyboard(key = "右键松开", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "7864320,15728640", customCondition = start)
    public static void 右键1(InputInfo inputInfo) {
        if(b==true){
            customConditionSet.add(移动);
        }

    }


}