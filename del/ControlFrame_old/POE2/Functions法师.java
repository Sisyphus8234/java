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

public class Functions法师 extends Functions公共 {

    static {
        初始化set.add(回蓝开启);
		初始化set.add(回血开启);
        初始化set.add(start);
        初始化set.add(移动);
        初始化set.add(左键连点);
    }






    @ListenMouseKeyboard(key = "滚轮", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "-7864320,-15728640", customCondition = start, timeInterval = 800L)
    @ListenMouseKeyboard(key = "滚轮", userInput = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "-7864320,-15728640", customCondition = start, timeInterval = 800L)
    public static void 滚轮下() {

        wasd = KeyWASD.后退;

        customConditionSet.add(滚轮);

        threadPressOrRelease(VK_Q,false,true);

    }



    @ListenMouseKeyboard(key = "滚轮", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "7864320,15728640", customCondition = start, timeInterval = 800L)
    @ListenMouseKeyboard(key = "滚轮", userInput = false, intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse, otherCondition = "7864320,15728640", customCondition = start, timeInterval = 800L)
    public static void 滚轮上(InputInfo inputInfo) {

            customConditionSet.remove(滚轮);

            wasd = KeyWASD.前进;

        threadPressOrRelease(VK_Q,false,false);

    }







}