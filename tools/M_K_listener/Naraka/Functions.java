import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Functions extends IFunctions {

    public static boolean temp1 = false;
    public static boolean temp2 = false;
    public static boolean temp3 = false;


    public static Thread t1;
    public static Thread t2;

    public static Long spaceDelay=Long.parseLong(Config.read("SpaceDelay"));

    static {
        t1=new CreateThread() {
            @Override
            public void myFunction() {
                while (true) {

//                    pause(Long.parseLong(Config.prop.getProperty("TotalDelay")));
                    if (temp1 == true) {
                        robot.keyRelease(KeyEvent.VK_SPACE);
                        robot.keyPress(KeyEvent.VK_SPACE);
                        pause(spaceDelay);
                    }
                    else{
                        t1.suspend();
                    }
                }
            }
        }.thread;

        t2=new CreateThread(){
            @Override
            public void myFunction() {
                while (true) {
//                    pause(Long.parseLong(Config.prop.getProperty("TotalDelay")));
					if (temp2 == true) {
						robot.keyRelease(KeyEvent.VK_E);
						robot.keyPress(KeyEvent.VK_E);
						robot.keyRelease(KeyEvent.VK_E);
						pause(200);
					}else if(temp3==true){
                        robot.keyRelease(KeyEvent.VK_5);
                        robot.keyPress(KeyEvent.VK_5);
                        robot.keyRelease(KeyEvent.VK_5);
                        pause(20);
                        robot.keyRelease(KeyEvent.VK_4);
                        robot.keyPress(KeyEvent.VK_4);
                        robot.keyRelease(KeyEvent.VK_4);
                        pause(300);
                    }
					else{
                        t2.suspend();
                    }

				}
			}
        }.thread;
    }

    @ListenMouseKeyboard(value = 32, intercept = true)
    private static void space() {
        temp1 = true;
        t1.resume();

        temp3=false;
    }

    @ListenMouseKeyboard(value = 32, intercept = true, press = false)
    private static void space2() {
        temp1 = false;
    }



    //拾取物品
    @ListenMouseKeyboard(value = 69, intercept = true)
    private static void e() {
        temp2 = true;
        t2.resume();
    }
    @ListenMouseKeyboard(value = 69, press = false, intercept = true)
    private static void e2() {
        temp2 = false;
    }

    //拉人 T
    @ListenMouseKeyboard(value = 84, intercept = true)
    private static void t() {
        robot.keyPress(KeyEvent.VK_E);
    }
    @ListenMouseKeyboard(value = 84, press = false, intercept = true)
    private static void t2() {
        robot.keyRelease(KeyEvent.VK_E);
    }

    //换武器 G
    @ListenMouseKeyboard(value = 71, intercept = true)
    private static void g() {
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        pause(40);
        robot.mouseMove(1794,622);
//        pause(1000);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);

        pause(40);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
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


    private static void changeProp(String s1,Long l1){
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
    @ListenMouseKeyboard(value = 47)
    private static void TotalDelay(){
        changeProp("SpaceDelay", 50L);
        spaceDelay=Long.parseLong(Config.read("SpaceDelay"));
    }

    @ListenMouseKeyboard(value = 52,intercept = true)
    @ListenMouseKeyboard(value = 53,intercept = true)
    private static void yao(){
        temp3=true;
        t2.resume();
    }

//    @ListenMouseKeyboard(value = 18)
//    private static void yao2(){
//        System.out.println(1234);
//        temp3=false;
//    }


//    @ListenMouseKeyboard(value = 81)
//    private static void test(){
//        robot.keyPress(KeyEvent.VK_1);
//        robot.keyRelease(KeyEvent.VK_1);
//    }





}
