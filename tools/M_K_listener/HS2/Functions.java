package custom;

import base.*;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static base.CommonUtil.keyCodeMap;

public class Functions extends IFunctions {
    static {
//        Controller.printKey = true;
    }


    public static long time0 = Long.parseLong(Config.read("time0"));
    public static int sliderChange = 4;
    public static boolean 加 = true;


    public static boolean b0 = false;
    public static MyThread t1 = new MyThread() {
        @Override
        public void run() {
            while (true) {
                if (b0 == true) {


                    changeValue();


                    b0 = false;
                }

                pause(time0);
            }

        }
    };


    public static Point pointTarget = new Point();
    public static Point pointOriginal = new Point();
    public static Integer valueTarget;

    @ListenMouseKeyboard(key = "q", intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void q() {
        pointTarget = MouseInfo.getPointerInfo().getLocation();

    }


    @ListenMouseKeyboard(key = "w", intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    @ListenMouseKeyboard(key = "e", intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    public static void e_w(InputInfo inputInfo) {

        if (inputInfo.value == keyCodeMap.get("w")) {
            加 = true;
        } else if (inputInfo.value == keyCodeMap.get("e")) {
            加 = false;
        }
        b0 = true;
    }


    public static long time1 = Long.parseLong(Config.read("time1"));

    public static void changeValue() {
        pointOriginal = MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(pointTarget.x, pointTarget.y);
        pause(time1);

        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);

        pause(time1);

        CTRLCOrV(KeyEvent.VK_C);



        // 检查剪贴板中是否有文本内容
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            try {
                // 获取剪贴板内容

                System.out.println(clipboard.getData(DataFlavor.stringFlavor));
                valueTarget = Integer.valueOf((String) clipboard.getData(DataFlavor.stringFlavor));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (加 == true) {
            valueTarget += sliderChange;
        } else {
            valueTarget -= sliderChange;
        }




        // 封装文本内容
        Transferable trans = new StringSelection(String.valueOf(valueTarget));
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);


        CTRLCOrV(KeyEvent.VK_V);
        pause(time1);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        robot.mouseMove(pointOriginal.x, pointOriginal.y);

    }




    public static void CTRLCOrV(Integer COrV) {

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(COrV);
        pause(time1);
        robot.keyRelease(COrV);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        pause(time1);
    }


}
