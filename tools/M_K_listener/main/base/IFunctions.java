package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import java.awt.Toolkit;
import java.util.Map;


public class IFunctions {

    public static int active = Controller.Active.jna;

    public static Robot robot;

    @ListenBar(onOrOff = ListenBar.OnOrOff.on)
    public static Integer on = 33;

    @ListenBar(onOrOff = ListenBar.OnOrOff.off)
    public static Integer off = 34;

    @ListenBar(threadList = true)
    public static List<MyThread> threadList = new ArrayList<>();

    static {
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

    public static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static Toolkit toolkit = Toolkit.getDefaultToolkit();
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

    private static Map<Integer,Boolean> keyStatusMap=new HashMap<>();

    public static void myKeyPress(int key){
        robot.keyPress(key);
        keyStatusMap.put(key,true);
    }
    public static void myKeyRelease(int key){
        robot.keyRelease(key);
        keyStatusMap.put(key,false);
    }

    public static void myMousePress(int key){
        robot.mousePress(key);
        keyStatusMap.put(key,true);
    }
    public static void myMouseRelease(int key){
        robot.mouseRelease(key);
        keyStatusMap.put(key,false);
    }

    public static boolean getKeyStatus(int key){
        return keyStatusMap.getOrDefault(key, false);
    }
    public static void setKeyStatus(int key,boolean b){
        keyStatusMap.put(key, b);
    }

}


