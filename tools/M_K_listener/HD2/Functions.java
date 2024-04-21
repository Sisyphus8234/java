package custom;

import base.*;
import base.enty.TaskResult;

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
//        Controller.printKey = true;
    }

    @ListenMouseKeyboard(key = "w", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "a", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "s", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    @ListenMouseKeyboard(key = "d", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard, timeInterval = 500L)
    public static void wasd(InputInfo inputInfo) {
        setKeyStatus(inputInfo.value, true);

    }

    @ListenMouseKeyboard(key = "w", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult w1(InputInfo inputInfo) {
        if (阻断下个w弹起 == true) {
            阻断下个w弹起 = false;
            return new TaskResult(true);
        } else {
            setKeyStatus(inputInfo.value, false);
            return null;
        }
    }

//    @ListenMouseKeyboard(key = "s", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void s(InputInfo inputInfo) {
//        if(getKeyStatus(VK_W)==true){
//            强制下个shift弹起 = true;
//        }
//        setKeyStatus(inputInfo.value, false);
//
//    }

    @ListenMouseKeyboard(key = "a", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "s", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "d", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void asd1(InputInfo inputInfo) {
        setKeyStatus(inputInfo.value, false);
    }


//    public static LocalDateTime shiftStart = LocalDateTime.now();

    @ListenMouseKeyboard(key = "shift左", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult shift() {
        setKeyStatus(VK_SHIFT, true);
        return null;
    }

    @ListenMouseKeyboard(key = "shift左", press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static TaskResult shift1() {
        setKeyStatus(VK_SHIFT, false);

        boolean temp = getKeyStatus(VK_W) || getKeyStatus(VK_A) || getKeyStatus(VK_S) || getKeyStatus(VK_D);


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

    //    @ListenMouseKeyboard(key = "侧键按下", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "e", keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,timeInterval = 500L)
    public static void e() {
        强制下个shift弹起 = true;
    }

    @ListenMouseKeyboard(key = "e",press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void e1() {
        强制下个shift弹起 = false;
    }


    private static boolean 强制下个shift弹起 = false;

    @ListenMouseKeyboard(key = "win", intercept = true, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win() {
        阻断下个w弹起 = true;
    }

    @ListenMouseKeyboard(key = "win", intercept = true, press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
    public static void win1() {
    }

//    @ListenMouseKeyboard(key = "space",  keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard,timeInterval = 500L)
//    public static void space() {
//        setKeyStatus(VK_SPACE ,true);
//    }
//
//    @ListenMouseKeyboard(key = "space",press = false, keyboardOrMouse = CommonUtil.KeyboardOrMouse.Keyboard)
//    public static void space1() {
//        setKeyStatus(VK_SPACE ,false);
//    }
//
//    @ListenMouseKeyboard(key = "左键松开",keyboardOrMouse = CommonUtil.KeyboardOrMouse.Mouse)
//    public static TaskResult 左键() {
//        if(getKeyStatus(VK_SPACE)==true){
//            return new TaskResult(true);
//        }else {
//            return new TaskResult(false);
//        }
//    }


    public static void f() {
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
            File file = new File(timestamp + "_screenshot.png");
            ImageIO.write(screenCapture, "png", file);
            System.out.println("截屏成功，保存为: " + file.getAbsolutePath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
