package custom;

import base.*;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalDateTime;

import static java.awt.event.KeyEvent.*;

class Run extends MainClass {


}

public class Functions extends IFunctions {
    static {
//        Controller.printKey = true;
    }

    @ListenMouseKeyboard(note = "w", value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "", value = 83, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "", value = 65, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "", value = 68, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 按下w(InputInfo inputInfo) {
        setKeyStatus(inputInfo.value, true);

    }

    @ListenMouseKeyboard(note = "w", value = 87, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult 按下w1(InputInfo inputInfo) {
        setKeyStatus(inputInfo.value, false);
        if (b1 == true) {
            return new TaskResult(true);
        } else {
            return null;
        }
    }

    @ListenMouseKeyboard(note = "", value = 83, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "", value = 65, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "", value = 68, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void aa(InputInfo inputInfo) {
        setKeyStatus(inputInfo.value, false);
    }


    public static LocalDateTime shiftStart = LocalDateTime.now();

    @ListenMouseKeyboard(note = "shift", value = 160, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult shift() {
        if (getKeyStatus(VK_SHIFT) == false) {
            shiftStart = LocalDateTime.now();
        }
        setKeyStatus(VK_SHIFT, true);
        return null;
    }

    @ListenMouseKeyboard(note = "shift", value = 160, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult shift1() {
        setKeyStatus(VK_SHIFT, false);

        boolean temp = getKeyStatus(VK_W) || getKeyStatus(VK_A) || getKeyStatus(VK_S) || getKeyStatus(VK_D);
        if (Duration.between(LocalDateTime.now(), shiftStart).toMillis() >= 1000L) {
            return null;
        } else if (temp == true) {
            return new TaskResult(true);
        } else {
            return null;
        }

    }

    private static boolean b1 = false;

    @ListenMouseKeyboard(note = "侧键", value = 523, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 侧键() {
        b1 = true;
    }

    @ListenMouseKeyboard(note = "侧键", value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 侧键1() {
        b1 = false;
    }


}
