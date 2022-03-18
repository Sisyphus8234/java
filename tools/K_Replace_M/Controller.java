import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Controller {

    public static Robot robot;

    public static int s = 26;
    public static int ss = 3;

    public static int mod1 = JIntellitype.MOD_SHIFT;
    public static int mod2 = JIntellitype.MOD_ALT;

//    public static long leftButton=0;
//    public static long rightButton=0;
//    public static long wheelUp=0;
//    public static long wheelDown=0;

    public static void mouseMove1(String direction) {
        int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
        int y = (int) MouseInfo.getPointerInfo().getLocation().getY();
        switch (direction) {
            case "up":
                robot.mouseMove(x, y - s);
                break;
            case "left":
                robot.mouseMove(x - s, y);
                break;
            case "down":
                robot.mouseMove(x, y + s);
                break;
            case "right":
                robot.mouseMove(x + s, y);
                break;
        }
    }


    public static void mouseClick(int mouseKey, int modKey) {
        robot.keyRelease(modKey);
        robot.mousePress(mouseKey);
        robot.mouseRelease(mouseKey);
        robot.keyPress(modKey);
    }

    public static void mouseWheel(int speed, int modKey) {
        robot.keyRelease(modKey);
        robot.mouseWheel(speed);
        robot.keyPress(modKey);
    }


    public static void run() {

        MyJFrame.setJFrame();

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        JIntellitype.getInstance().registerHotKey(1, mod1, (int) 'I');
        JIntellitype.getInstance().registerHotKey(2, mod1, (int) 'J');
        JIntellitype.getInstance().registerHotKey(3, mod1, (int) 'K');
        JIntellitype.getInstance().registerHotKey(4, mod1, (int) 'L');

        JIntellitype.getInstance().registerHotKey(5, mod1, (int) 'Q');
        JIntellitype.getInstance().registerHotKey(6, mod1, (int) 'E');

        JIntellitype.getInstance().registerHotKey(7, mod1, (int) 'D');
        JIntellitype.getInstance().registerHotKey(8, mod1, (int) 'A');
        JIntellitype.getInstance().registerHotKey(9, mod1, (int) 'W');
        JIntellitype.getInstance().registerHotKey(10, mod1, (int) 'S');

//        JIntellitype.getInstance().registerHotKey(1, mod2, (int) 'I');
//        JIntellitype.getInstance().registerHotKey(2, mod2, (int) 'J');
//        JIntellitype.getInstance().registerHotKey(3, mod2, (int) 'K');
//        JIntellitype.getInstance().registerHotKey(4, mod2, (int) 'L');
//
//        JIntellitype.getInstance().registerHotKey(5, mod2, (int) 'Q');
//        JIntellitype.getInstance().registerHotKey(6, mod2, (int) 'E');
//
//        JIntellitype.getInstance().registerHotKey(7, mod2, (int) 'D');
//        JIntellitype.getInstance().registerHotKey(8, mod2, (int) 'A');
//        JIntellitype.getInstance().registerHotKey(9, mod2, (int) 'W');
//        JIntellitype.getInstance().registerHotKey(10, mod2, (int) 'S');

        // 添加热键监听器
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
            public void onHotKey(int markCode) {
                switch (markCode) {
                    case 1:
                        mouseMove1("up");
                        break;
                    case 2:
                        mouseMove1("left");
                        break;
                    case 3:
                        mouseMove1("down");
                        break;
                    case 4:
                        mouseMove1("right");
                        break;
                    case 5:
                        s -= ss;
                        System.out.println(s);
                        break;
                    case 6:
                        s += ss;
                        System.out.println(s);
                        break;
                    case 7:
                        mouseClick(MouseEvent.BUTTON1_DOWN_MASK, KeyEvent.VK_SHIFT);
                        break;
                    case 8:
                        mouseClick(MouseEvent.BUTTON3_DOWN_MASK, KeyEvent.VK_SHIFT);
                        break;
                    case 9:
                        mouseWheel(-3, KeyEvent.VK_SHIFT);
                        break;
                    case 10:
                        mouseWheel(3, KeyEvent.VK_SHIFT);
                        break;


                }
            }

        });
    }

}
