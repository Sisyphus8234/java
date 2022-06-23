import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;

public class Functions extends IFunctions {

    public static Long time1=Long.parseLong(Config.read("Time1"));
    public static Long time2 = Long.parseLong(Config.read("Time2"));

    public static long temp1=0;
    public static long temp2=0;

    public static Thread t1;
    public static Thread t2;
	static {
        t1=new CreateThread(){
            @Override
            public void myFunction(){
                while (true) {
                    if(new Date().getTime() - temp1 <= time2) {
                        robot.keyPress(KeyEvent.VK_T);
                        robot.keyRelease(KeyEvent.VK_T);
                        pause(time1);
                    } else {
                        robot.keyPress(KeyEvent.VK_E);
                        robot.keyRelease(KeyEvent.VK_E);
                        pause(time1);
                    }
                }
            }
        }.thread;
        t1.suspend();

        t2=new CreateThread(){
            @Override
            public void myFunction(){
                while (true) {
                    if(new Date().getTime() - temp2 <= time2) {
                        robot.keyPress(KeyEvent.VK_T);
                        robot.keyRelease(KeyEvent.VK_T);
                        pause(time1);
                    } else {
                        robot.keyPress(KeyEvent.VK_W);
                        robot.keyRelease(KeyEvent.VK_W);
                        pause(time1);
                    }
                }
            }
        }.thread;
        t2.suspend();
	}


    @ListenMouseKeyboard(value = 69, immediately = true, intercept = true)
    private static void f1() {

        temp1 = new Date().getTime();
        t2.suspend();
        t1.resume();

    }

    @ListenMouseKeyboard(value = 87, immediately = true, intercept = true)
    private static void f2() {

        temp2 = new Date().getTime();
        t1.suspend();
        t2.resume();

    }

    @ListenMouseKeyboard(value = 513, immediately = true)
    @ListenMouseKeyboard(value = 82, immediately = true)
    @ListenMouseKeyboard(value = 32, immediately = true)
    private static void f3() {
        // TODO Auto-generated method stub
        t1.suspend();

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
        writeProp("Time2", 50L);
        time2=Long.parseLong(Config.read("Time2"));
    }

}
