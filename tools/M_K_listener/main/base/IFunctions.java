package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.*;
import java.util.ArrayList;
import java.util.List;


import java.awt.Toolkit;
import java.io.IOException;


public class IFunctions {

    public static boolean Jna = true;

    public static boolean jintellitype = false;

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



}

