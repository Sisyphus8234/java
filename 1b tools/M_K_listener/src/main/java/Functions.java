import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions extends IFunctions {
    public static Long time1 = Long.parseLong(Config.read("Time1"));
    public static Thread t1;

    static {
        t1 = new MyThread() {
            @Override
            public void run() {
                while (true) {
                    pause(time1);
                    //todo
                    System.out.println("todo");
                }

            }
        };
    }

    //按下鼠标左键触发
    @ListenMouseKeyboard(value = 513, immediately = true, keyboardOrMouse = 1)
    private static void sample1() {
        System.out.println("程序模拟键盘依次按下h，i");
        // TODO Auto-generated method stub
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);

        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);

    }

    //按下键盘空格键触发
    @ListenMouseKeyboard(value = 32, immediately = true, keyboardOrMouse = 0)
    private static void sample2() {
        // TODO Auto-generated method stub
        System.out.println("程序模拟鼠标右键一次");
        robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);

    }

    //按下键盘空格键触发
    @JintellitypeListen(modifier = 0, keycode = 32)
    private static void sample3() {
        // TODO Auto-generated method stub
        System.out.println("Jintellitype监听到了空格");
    }

    /**
     * 把文本设置到剪贴板（复制）
     */
    private static void setClipboardString(String text) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 封装文本内容
        Transferable trans = new StringSelection(text);
        // 把文本内容设置到系统剪贴板
        clipboard.setContents(trans, null);
    }

}
