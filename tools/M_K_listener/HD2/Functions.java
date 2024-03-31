package custom;

import base.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.awt.event.KeyEvent.*;

class Run extends MainClass {


}

public class Functions extends IFunctions {
    static {
        Controller.printKey = true;
    }

    @ListenMouseKeyboard(note = "w", value = 87, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "", value = 83, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "", value = 65, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "", value = 68, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void wasd(InputInfo inputInfo) {
        setKeyStatus(inputInfo.value, true);

    }

    @ListenMouseKeyboard(note = "w", value = 87, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult w1(InputInfo inputInfo) {

        if (阻断下个w弹起 == true) {
            阻断下个w弹起 = false;
            return new TaskResult(true);
        } else {
            setKeyStatus(inputInfo.value, false);
            return null;
        }
    }

    @ListenMouseKeyboard(note = "", value = 83, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "", value = 65, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(note = "", value = 68, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void asd1(InputInfo inputInfo) {
        setKeyStatus(inputInfo.value, false);
    }


//    public static LocalDateTime shiftStart = LocalDateTime.now();

    @ListenMouseKeyboard(note = "shift", value = 160, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult shift() {
//        if (getKeyStatus(VK_SHIFT) == false) {
//            shiftStart = LocalDateTime.now();
//        }
        setKeyStatus(VK_SHIFT, true);
        return null;
    }

    @ListenMouseKeyboard(note = "shift", value = 160, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static TaskResult shift1() {
        setKeyStatus(VK_SHIFT, false);

        boolean temp = getKeyStatus(VK_W) || getKeyStatus(VK_A) || getKeyStatus(VK_S) || getKeyStatus(VK_D);

//        if (Duration.between(shiftStart, LocalDateTime.now()).toMillis() >= 500L) {
//            return new TaskResult(false);
//        } else if (getKeyStatus(VK_E) == true) {
//            return new TaskResult(false);
//        } else

        if (强制下个shift弹起 == true) {
            强制下个shift弹起 = false;
            return new TaskResult(false);
        } else if (temp == true) {
            return new TaskResult(true);
        } else {
            return null;
        }

    }

    private static boolean 阻断下个w弹起 = false;

    @ListenMouseKeyboard(note = "侧键", value = 523, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 侧键() {
        强制下个shift弹起 = true;
    }

//    @ListenMouseKeyboard(note = "侧键", value = 524, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void 侧键1() {
//        阻断下个w弹起 = false;
//    }

    private static boolean 强制下个shift弹起 = false;

    @ListenMouseKeyboard(note = "大写锁", value = 20, press = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void 大写锁() {
        阻断下个w弹起 = true;
    }

//    @ListenMouseKeyboard(note = "esc", value = 27, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
//    public static void esc() {
//        f();
//    }

    public static void f(){
        try {
            // 获取屏幕尺寸
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRect = new Rectangle(screenSize);

            // 创建一个Robot对象
            Robot robot = new Robot(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());

            // 截取屏幕
            BufferedImage screenCapture = robot.createScreenCapture(screenRect);


            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String timestamp = now.format(formatter);

            // 保存截图到文件
            File file = new File(timestamp+"_screenshot.png");
            ImageIO.write(screenCapture, "png", file);
            System.out.println("截屏成功，保存为: " + file.getAbsolutePath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
