package custom;

import base.IFunctions;
import base.ListenMouseKeyboard;
import base.MyThread;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class Functions公共 extends IFunctions {
    public static boolean running = false;

    //按ctrl并连点左键
    public static Thread t1 = new MyThread(MyThread.State.off) {
        @Override
        public void run() {
            while (true) {
                robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                pause(110);

            }
        }
    };

    /**
     * 把文本设置到剪贴板（复制）
     */
    public static void setClipboardString(String text) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(text);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }


    public static boolean trade = false;
    public static Integer count1 = 0;
    public static Integer count2 = 0;
    public static HashMap<Integer, String> map1 = new HashMap<>();

    static {
        map1.put(0, "头");
        map1.put(1, "胸");
        map1.put(2, "手套");
        map1.put(3, "鞋");
        map1.put(4, "腰带");
        map1.put(5, "戒指");
//        map1.put(6,"戒指");
        map1.put(6, "护身符");
        map1.put(7, "武器|格挡几率");

//        map1.put(100,"\"物品等级: [0-5][0-9]|普通|魔法|传奇|\"!未鉴定\"\"");
        map1.put(100, "物品等级:[0-5][0-9]|普通|魔法|传奇");
        map1.put(101, "!未鉴定");
        map1.put(102, "\"物品等级: ([6][0-9]|[7][0-4])\"");
    }

    public static void 在搜索框粘贴(Integer integer, String s) {
        if (trade == true) {

            setClipboardString(map1.get(integer) + s);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_F);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_F);

            pause(50);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
        }
    }






    //f1
    @ListenMouseKeyboard(note="f1",value = 112, intercept = true,keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void 按xxx开始处理成套装备模式() {
        trade = true;
        count1 = 0;
        count2 = 0;

        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(491, 105);
        pause(50);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        pause(50);
        robot.mouseMove(x, y);
    }

    //f2
    @ListenMouseKeyboard(note = "f2", value = 113, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    //esc
    @ListenMouseKeyboard(note = "esc", value = 27, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)

    @ListenMouseKeyboard(note = "`", value = 192, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void 按xxx结束处理成套装备模式() {
        trade = false;
    }

    @ListenMouseKeyboard(value = 50, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void 整套装备预筛选() {
        if (trade == true) {
            在搜索框粘贴(count1 + 100, "");
            count1++;
            if (count1 >= 3) {
                count1 = 0;
            }
        } else {
            robot.keyPress(KeyEvent.VK_2);
            robot.keyRelease(KeyEvent.VK_2);
        }

    }

    @ListenMouseKeyboard(value = 51, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void 顺序获取整套装备() {

        if (trade == true) {
            在搜索框粘贴(count2, "");
            count2++;
            if (count2 >= 8) {
                count2 = 0;
            }
        } else {
            robot.keyPress(KeyEvent.VK_3);
            robot.keyRelease(KeyEvent.VK_3);
        }
    }

    @ListenMouseKeyboard(value = 53, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void 顺序获取整套装备60到74级() {

        在搜索框粘贴(count2, " 物品等级:\\s([6][0-9]|[7][0-4])");
        count2++;
        if (count2 >= 8) {
            count2 = 0;
        }

        if (trade == false) {
            robot.keyPress(KeyEvent.VK_5);
            robot.keyRelease(KeyEvent.VK_5);
        }
    }

    @ListenMouseKeyboard(value = 54, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void 顺序获取整套装备大于74级() {

        在搜索框粘贴(count2, " 物品等级:\\s([8-9][0-9]|[7][5-9])");
        count2++;
        if (count2 >= 8) {
            count2 = 0;
        }

        if (trade == false) {
            robot.keyPress(KeyEvent.VK_6);
            robot.keyRelease(KeyEvent.VK_6);
        }
    }


    @ListenMouseKeyboard(note = "1", value = 49, intercept = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void ctrl加左键连点() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        t1.resume();
    }

    @ListenMouseKeyboard(note = "1", value = 49, press = false, intercept = false, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void 退出ctrl加左键连点() {
        robot.keyRelease(KeyEvent.VK_CONTROL);
        t1.suspend();
    }


    @ListenMouseKeyboard(note = ".", value = 190, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void 市集下一页() {
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(541, 177);
        pause(50);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        pause(50);
        robot.mouseMove(x, y);
    }


    //y
    @ListenMouseKeyboard(note = "y", value = 89, intercept = true, keyboardOrMouse = ListenMouseKeyboard.KeyboardOrMouse.Keyboard)
    private static void 回城卷轴() {

        robot.keyPress(192);
        robot.keyRelease(192);

        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(1228, 824);
        pause(50);
        robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
        pause(50);

        robot.keyPress(192);
        robot.keyRelease(192);
        robot.mouseMove(x, y);
    }

}
