package custom;

import base.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static java.awt.event.KeyEvent.*;

class Run extends MainClass {


}

public class Functions extends IFunctions {
    static {
        Controller.printKey = true;
    }


    @ListenMouseKeyboard(note = "shift", value = 160, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    private static void 奔跑() {
        myKeyRelease(VK_SHIFT);
        myKeyPress(VK_SHIFT);
    }

    @ListenMouseKeyboard(note = "shift", press = false, value = 160, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void 奔跑1() {
    }

    @ListenMouseKeyboard(note = "左键", value = 513, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(note = "右键", value = 516, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    @ListenMouseKeyboard(note = "滚轮", value = 522, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Mouse)
    private static void 松开shift() {
        if (getKeyStatus(VK_SHIFT) == true) {
            myKeyRelease(VK_SHIFT);
        }
    }


}
