import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions extends IFunctions {

    public static Long time1=Long.parseLong(Config.read("Time1"));

    public static Thread t1;
	static {
        t1=new CreateThread(){
            @Override
            public void myFunction(){
                while (true) {
                    pause(time1);
                    //todo
                    System.out.println("todo");
                }

            }
        }.thread;
	}

    //按下鼠标左键触发
    @ListenMouseKeyboard(value = 513, immediately = true)
    private static void sample1() {
        System.out.println("程序模拟键盘依次按下h，i");
        // TODO Auto-generated method stub
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);

        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);

    }

    //按下键盘空格键触发
    @ListenMouseKeyboard(value = 32, immediately = true)
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



    public static boolean ctrl=false;
    @ListenMouseKeyboard(value = 162)
    private static void ctrl(){
        ctrl=true;
    }
    @ListenMouseKeyboard(value = 162,press = false)
    private static void ctrl2(){
        ctrl=false;
    }


    private static void writeProp(String s1,Long l1){
        if(ctrl==false){
            Config.write(s1,""+(Long.parseLong(Config.prop.getProperty(s1))+l1));}
        else{
            Config.write(s1,""+(Long.parseLong(Config.prop.getProperty(s1))-l1));
        }
        setClipboardString(Config.prop.toString());
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

    //9
    @ListenMouseKeyboard(value = 57)
    private static void adjustTime1(){
        writeProp("Time1", 50L);
        time1=Long.parseLong(Config.read("Time1"));
    }

}
