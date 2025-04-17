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

    static final String left="left";
    static final String down="down";
    static final String right="right";
    //endregion

    //region zbrush
    @ListenMouseKeyboard(intercept = true, key = "left", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,customConditionReverse = left, extend = true)
    public static void left() {
        threadPressOrRelease(BUTTON3_DOWN_MASK,true,true);
        customConditionSet.add(left);
    }

    @ListenMouseKeyboard(intercept = true, key = "left", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,extend = true)
    public static void left1() {
        customConditionSet.remove(left);
        threadPressOrRelease(BUTTON3_DOWN_MASK,true,false);
    }

    @ListenMouseKeyboard(intercept = true, key = "down", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,customConditionReverse = down,extend = true)
    public static void down() {

        threadPressOrReleaseWithDelay(VK_ALT,false,true,50);
        threadPressOrReleaseWithDelay(BUTTON3_DOWN_MASK,true,true,0);

        customConditionSet.add(down);
    }

    @ListenMouseKeyboard(intercept = true, key = "down", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,extend = true)
    public static void down1() {
        customConditionSet.remove(down);
        threadPressOrReleaseWithDelay(BUTTON3_DOWN_MASK,true,false,50);
        threadPressOrReleaseWithDelay(VK_ALT,false,false,0);
    }

    @ListenMouseKeyboard(intercept = true, key = "right", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,customConditionReverse = right,extend = true)
    public static void right() {

        threadPressOrReleaseWithDelay(VK_CONTROL,false,true,50);
        threadPressOrReleaseWithDelay(BUTTON3_DOWN_MASK,true,true,0);

        customConditionSet.add(right);
    }

    @ListenMouseKeyboard(intercept = true, key = "right", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,customCondition = zbrush,extend = true)
    public static void right1() {
        customConditionSet.remove(right);

        threadPressOrReleaseWithDelay(BUTTON3_DOWN_MASK,true,false,50);
        threadPressOrReleaseWithDelay(VK_CONTROL,false,false,0);
    }
    //endregion
}
