package base;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import base.CommonUtil.Active;


import java.util.Map;


public class IFunctions {

    public static int active = Active.jna;

    public static Robot robot;

    @ListenBar(onOrOff = ListenBar.OnOrOff.on)
    public static String on = "pgup";

    @ListenBar(onOrOff = ListenBar.OnOrOff.off)
    public static String off = "pgdn";

    @ListenBar(threadList = true)
    public static List<MyThread> threadList = new ArrayList<>();

    static {
        System.out.print("current path is:");
        System.out.println(System.getProperty("user.dir"));


        System.out.println("IFunctions class loading");
        try {
            robot = new Robot();
            System.out.println("Robot instance created");
        } catch (AWTException e) {
            e.printStackTrace();
        }

        String currentDir = System.getProperty("user.dir");
        System.out.println("currentDir: " + currentDir);

    }

//    public static double screen_scale = Double.parseDouble(Config.read("screen_scale"));

    public static Toolkit toolkit = Toolkit.getDefaultToolkit();

    //缩放比例
    public static AffineTransform affineTransform = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getDefaultTransform();
    public static double scaleX = affineTransform.getScaleX();
    public static double scaleY = affineTransform.getScaleY();
    public static double screen_scale;
    static {
        if(scaleX==scaleY){
            screen_scale=scaleX;
        }else {
            throw new RuntimeException("屏幕缩放吧比例x与y不相等");
        }
        System.out.println(screen_scale);
    }

    //屏幕尺寸
    public static Dimension screenSize = toolkit.getScreenSize();
    public static int screenWidth = (int) (screenSize.getWidth()*screen_scale);
    public static int screenHeight = (int) (screenSize.getHeight()*screen_scale);
    static{
        System.out.println(screenWidth);
        System.out.println(screenHeight);

    }

    public static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static Clipboard clipboard = toolkit.getSystemClipboard();


    public static String readClipboard() {
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            try {
                Transferable contents = clipboard.getContents(null);
                String clipboardText = (String) contents.getTransferData(DataFlavor.stringFlavor);

                return clipboardText;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return "no content";
        }
        return "fail";
    }

    public static void writeClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        clipboard.setContents(stringSelection, null);
    }


    public static boolean clipboardIsString() {
        // 获取剪贴板中的数据
        Transferable transferable = clipboard.getContents(null);

        // 判断是否包含文本
        if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return true;
        } else {
            return false;
        }
    }

    private static Map<Integer, Boolean> keyStatusMap = new HashMap<>();

    public static void myKeyPress(int key) {
        robot.keyPress(key);
        keyStatusMap.put(key, true);
    }

    public static void myKeyRelease(int key) {
        robot.keyRelease(key);
        keyStatusMap.put(key, false);
    }

    public static void myMousePress(int key) {
        robot.mousePress(key);
        keyStatusMap.put(key, true);
    }

    public static void myMouseRelease(int key) {
        robot.mouseRelease(key);
        keyStatusMap.put(key, false);
    }

    public static boolean getKeyStatus(int key) {
        return keyStatusMap.getOrDefault(key, false);
    }

    public static void setKeyStatus(int key, boolean b) {
        keyStatusMap.put(key, b);
    }

}


