import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import java.awt.*;

public class MainClass {

    public static Robot robot;

    public static int s=20;
    public static int ss=3;

    public static int mod=JIntellitype.MOD_ALT;

    public static void main(String[] strings){



        try {
            robot=new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        JIntellitype.getInstance().registerHotKey(1, mod, (int) 'I');
    	JIntellitype.getInstance().registerHotKey(2, mod, (int) 'J');
    	JIntellitype.getInstance().registerHotKey(3, mod, (int) 'K');
    	JIntellitype.getInstance().registerHotKey(4, mod, (int) 'L');

    	JIntellitype.getInstance().registerHotKey(5, mod, (int) 'Q');
    	JIntellitype.getInstance().registerHotKey(6, mod, (int) 'E');

        JIntellitype.getInstance().registerHotKey(7, mod, (int) 'D');
        JIntellitype.getInstance().registerHotKey(8, mod, (int) 'A');
        JIntellitype.getInstance().registerHotKey(9, mod, (int) 'W');
        JIntellitype.getInstance().registerHotKey(10, mod, (int) 'S');

        // 添加热键监听器
		JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
        public void onHotKey(int markCode) {
            int x = (int)MouseInfo.getPointerInfo().getLocation().getX();
            int y =(int)MouseInfo.getPointerInfo().getLocation().getY();

            switch (markCode) {
                case 1:
                    robot.mouseMove(x,y-s);
                    break;
                case 2:
                    robot.mouseMove(x-s,y);
                    break;
                case 3:
                    robot.mouseMove(x,y+s);
                    break;
                case 4:
                    robot.mouseMove(x+s,y);
                    break;
                case 5:
                    s-=ss;
                    System.out.println(s);
                    break;
                case 6:
                    s+=ss;
                    System.out.println(s);
                    break;
                case 7:
                    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    break;
                case 8:
                    robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
                    robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
                    break;
                case 9:
                    robot.mouseWheel(3);
                    break;
                case 10:
                    robot.mouseWheel(-3);
                    break;


            }
        }

        });
    }

}
