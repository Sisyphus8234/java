import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {

    public static Robot robot;
    static {
        try {
            robot = new Robot();
            System.out.println("robot ready");
        } catch (AWTException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static int s = 27;
    public static int ss = 6;
    public static int delay = 60;

    public static boolean boolean1 = false;

    public static int int1=0;

    public static List<String> taskList1=new ArrayList();

    public static int mod1 = JIntellitype.MOD_SHIFT;
    public static int mod2 = JIntellitype.MOD_ALT;


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
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.mousePress(mouseKey);
        robot.keyRelease(modKey);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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



//        JIntellitype.getInstance().registerHotKey(1, mod1, (int) 'I');
//        JIntellitype.getInstance().registerHotKey(2, mod1, (int) 'J');
//        JIntellitype.getInstance().registerHotKey(3, mod1, (int) 'K');
//        JIntellitype.getInstance().registerHotKey(4, mod1, (int) 'L');
//
//        JIntellitype.getInstance().registerHotKey(5, mod1, (int) 'Q');
//        JIntellitype.getInstance().registerHotKey(6, mod1, (int) 'E');
//
//        JIntellitype.getInstance().registerHotKey(7, mod1, (int) 'D');
//        JIntellitype.getInstance().registerHotKey(8, mod1, (int) 'A');
//        JIntellitype.getInstance().registerHotKey(9, mod1, (int) 'W');
//        JIntellitype.getInstance().registerHotKey(10, mod1, (int) 'S');
//
//        JIntellitype.getInstance().registerHotKey(11, mod2, (int) 'I');
//        JIntellitype.getInstance().registerHotKey(12, mod2, (int) 'J');
//        JIntellitype.getInstance().registerHotKey(13, mod2, (int) 'K');
//        JIntellitype.getInstance().registerHotKey(14, mod2, (int) 'L');
//
//        JIntellitype.getInstance().registerHotKey(15, mod2, (int) 'Q');
//        JIntellitype.getInstance().registerHotKey(16, mod2, (int) 'E');
//
//        JIntellitype.getInstance().registerHotKey(17, mod2, (int) 'D');
//        JIntellitype.getInstance().registerHotKey(18, mod2, (int) 'A');
//        JIntellitype.getInstance().registerHotKey(19, mod2, (int) 'W');
//        JIntellitype.getInstance().registerHotKey(20, mod2, (int) 'S');
//
//
//        JIntellitype.getInstance().registerHotKey(21, 0, (int) '9');
//        JIntellitype.getInstance().registerHotKey(22, 0, (int) '0');

        JIntellitype.getInstance().registerHotKey(1, 0, 112 );
        JIntellitype.getInstance().registerHotKey(2, 0, 113);
        JIntellitype.getInstance().registerHotKey(3, 0, 114);
        JIntellitype.getInstance().registerHotKey(4, 0, 115);
        JIntellitype.getInstance().registerHotKey(5, 0, 27);


        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(70);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String task1="";
                    if(taskList1.size()>0) {

                        try {
                            task1=taskList1.get(0);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        taskList1.remove(0);
                    }


                    switch (task1){
                        case "leftMouseClick":
                            System.out.println("start task: "+task1+" "+(++int1));
                            try {
                                Robot robot1=new Robot();
                                robot1.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                                robot1.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                            } catch (AWTException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "rightMouseClick":
                            System.out.println("start task: "+task1+" "+(++int1));
                            try {
                                Robot robot1=new Robot();
                                robot1.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
                                robot1.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
                            } catch (AWTException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                    task1="";

                }
            }
        }.start();


        // 添加热键监听器
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
            public void onHotKey(int markCode) {
                switch (markCode) {
//                    case 1:
//                    case 11:
//                        mouseMove1("up");
//                        break;
//                    case 2:
//                    case 12:
//                        mouseMove1("left");
//                        break;
//                    case 3:
//                    case 13:
//                        mouseMove1("down");
//                        break;
//                    case 4:
//                    case 14:
//                        mouseMove1("right");
//                        break;
//                    case 5:
//                    case 15:
//                        s -= ss;
//                        System.out.println(s);
//                        break;
//                    case 6:
//                    case 16:
//                        s += ss;
//                        System.out.println(s);
//                        break;
//                    case 7:
//                        mouseClick(MouseEvent.BUTTON1_DOWN_MASK, KeyEvent.VK_SHIFT);
//                        break;
//                    case 8:
//                        mouseClick(MouseEvent.BUTTON3_DOWN_MASK, KeyEvent.VK_SHIFT);
//                        break;
//                    case 9:
//                        mouseWheel(-3, KeyEvent.VK_SHIFT);
//                        break;
//                    case 10:
//                        mouseWheel(3, KeyEvent.VK_SHIFT);
//                        break;
//
//                    case 17:
//                        mouseClick(MouseEvent.BUTTON1_DOWN_MASK, KeyEvent.VK_ALT);
//                        break;
//                    case 18:
//                        mouseClick(MouseEvent.BUTTON3_DOWN_MASK, KeyEvent.VK_ALT);
//                        break;
//                    case 19:
//                        mouseWheel(-3, KeyEvent.VK_ALT);
//                        break;
//                    case 20:
//                        mouseWheel(3, KeyEvent.VK_ALT);
//                        break;
//                    case 21:
//                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//                        break;
//                    case 22:
//                        robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
//                        robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
//                        break;
                    case 1:
                    case 5:
//                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
////                        try {
////                            Thread.sleep(20);
////                        } catch (InterruptedException e) {
////                            e.printStackTrace();
////                        }
//                        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
////                        try {
////                            Thread.sleep(20);
////                        } catch (InterruptedException e) {
////                            e.printStackTrace();
////                        }
//                        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
////                        try {
////                            Thread.sleep(60);
////                        } catch (InterruptedException e) {
////                            e.printStackTrace();
////                        }
                        taskList1.add("leftMouseClick");
                        break;
                    case 2:
                        taskList1.add("rightMouseClick");
                        break;
                    case 3:
                        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                        break;
                    case 4:
                        robot.keyRelease(KeyEvent.VK_DELETE);
                        robot.keyPress(KeyEvent.VK_DELETE);
                        robot.keyRelease(KeyEvent.VK_DELETE);
                        break;

                }
            }

        });
    }

}
