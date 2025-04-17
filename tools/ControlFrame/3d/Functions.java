package custom;

import base.*;
import base.CommonUtil.Active;
import base.enty.TaskResult;
import com.fasterxml.jackson.core.type.TypeReference;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static base.CommonUtil.customConditionSet;
import static base.CommonUtil.keyCodeMap;
import static java.awt.event.KeyEvent.*;

class Run extends MainClass {


}

public class Functions extends IFunctions {

    //region base
    @ListenBar(onOrOff = ListenBar.OnOrOff.on)
    public static String on = "home";

    @ListenBar(onOrOff = ListenBar.OnOrOff.off)
    public static String off = "end";

    static final String zbrush="zbrush";

    static {
        active = (Integer.parseInt(Config.read("active")));
        customConditionSet.add(zbrush);
    }

    static final String 移动="yd";
    static final String 旋转="xz";
    static final String 缩放="sf";
    //endregion

    //region zbrush
    @ListenMouseKeyboard(intercept = true, key = "left", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,customConditionReverse = 移动, extend = true)
    public static void 移动() {
        threadPressOrReleaseWithDelay(VK_ALT,false,true,50);
        threadPressOrReleaseWithDelay(BUTTON3_DOWN_MASK,true,true,0);
        customConditionSet.add(移动);
    }

    @ListenMouseKeyboard(intercept = true, key = "left", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,extend = true)
    public static void 移动1() {
        customConditionSet.remove(移动);
        threadPressOrReleaseWithDelay(BUTTON3_DOWN_MASK,true,false,50);
        threadPressOrReleaseWithDelay(VK_ALT,false,false,0);
    }



    @ListenMouseKeyboard(intercept = true, key = "down", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,customConditionReverse = 旋转,extend = true)
    public static void 旋转() {
        threadPressOrRelease(BUTTON3_DOWN_MASK,true,true);
        customConditionSet.add(旋转);
    }

    @ListenMouseKeyboard(intercept = true, key = "down", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,extend = true)
    public static void 旋转1() {
        customConditionSet.remove(旋转);
        threadPressOrRelease(BUTTON3_DOWN_MASK,true,false);
    }




    @ListenMouseKeyboard(intercept = true, key = "right", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,customConditionReverse = 缩放,extend = true)
    public static void right() {

        threadPressOrReleaseWithDelay(VK_CONTROL,false,true,50);
        threadPressOrReleaseWithDelay(BUTTON3_DOWN_MASK,true,true,0);

        customConditionSet.add(缩放);
    }

    @ListenMouseKeyboard(intercept = true, key = "right", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,extend = true)
    public static void right1() {
        customConditionSet.remove(缩放);

        threadPressOrReleaseWithDelay(BUTTON3_DOWN_MASK,true,false,50);
        threadPressOrReleaseWithDelay(VK_CONTROL,false,false,0);
    }
    //endregion
}
