import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class Functions extends IFunctions {

    @ListenBar(off = true)
    public static Integer on1=189;

    @ListenBar(off = false)
    public static Integer on2=187;

    public static Long time1=Long.parseLong(Config.read("Time1"));
    public static Long time2 = Long.parseLong(Config.read("Time2"));


    public static Thread t1;
    public static Thread t2;
    public static Thread t3;
	static {
        t1=new CreateThread(){
            @Override
            public void myFunction(){
                while (true) {
                        robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
//                        pause(50);
                        robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
                        pause(time1);

                }
            }
        }.thread;
        t1.suspend();

        t2=new CreateThread(){
            @Override
            public void myFunction(){
                while (true) {
                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    pause(time2);

                }
            }
        }.thread;
        t2.suspend();

        t3=new CreateThread(){
            @Override
            public void myFunction(){
                while (true) {
                    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    pause(200);

                }
            }
        }.thread;
        t3.suspend();

	}


    public static boolean trade = false;

    public static Integer count1 = 0;
    public static Integer count2 = 0;


    public static HashMap<Integer, String> map1=new HashMap<>();
    static {
        map1.put(0,"头");
        map1.put(1,"胸");
        map1.put(2,"手套");
        map1.put(3,"鞋");
        map1.put(4,"腰带");
        map1.put(5,"戒指");
        map1.put(6,"戒指");
        map1.put(7,"饰品");


        map1.put(100,"物品等级:[0-5][0-9]|普通|魔法|传奇");
        map1.put(101,"!未鉴定");
    }
    public static void t0(Integer integer){
        if(trade==true){
            setClipboardString(map1.get(integer));

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


    };


    @ListenMouseKeyboard(value = 112,intercept = true)
    private static void lock1(){
        trade=true;
        count2 = 0;

        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y =MouseInfo.getPointerInfo().getLocation().y;
        robot.mouseMove(427,105);
        pause(50);
        robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        pause(50);
        robot.mouseMove(x,y);
    }

    @ListenMouseKeyboard(value = 27,intercept = false)
    @ListenMouseKeyboard(value = 113,intercept = true)
    private static void lock2(){
        trade=false;
    }

    @ListenMouseKeyboard(value = 50,intercept = true)
    private static void t1(){
        t0(count1+100);
        count1++;
        if(count1>=2){
            count1=0;
        }

        if(trade==false){
            robot.keyPress(KeyEvent.VK_2);
            robot.keyRelease(KeyEvent.VK_2);}

    }

    @ListenMouseKeyboard(value = 51,intercept = true)
    private static void t2(){

        t0(count2);
        count2++;
        if(count2>=8){
            count2=0;
        }

        if(trade==false){
            robot.keyPress(KeyEvent.VK_3);
            robot.keyRelease(KeyEvent.VK_3);}
    }



    @ListenMouseKeyboard(value = 84, immediately = true, intercept = true)
    private static void f1() {
        t1.resume();
        t2.resume();
    }

    @ListenMouseKeyboard(value = 513, immediately = true,userInput = true)
    @ListenMouseKeyboard(value = 82, immediately = true)
//    @ListenMouseKeyboard(value = 32, immediately = true)
    private static void f3() {
        t1.suspend();
        t2.suspend();
    }


    @ListenMouseKeyboard(value = 49,intercept = false)
    @ListenMouseKeyboard(value = 91,intercept = true)
    private static void F4(){
        robot.keyPress(KeyEvent.VK_CONTROL);
        t3.resume();
    }
    @ListenMouseKeyboard(value = 49,press = false,intercept = false)
    @ListenMouseKeyboard(value = 91,press = false,intercept = true)
    private static void F5(){
        robot.keyRelease(KeyEvent.VK_CONTROL);
        t3.suspend();
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

    @ListenMouseKeyboard(value = 57)
    private static void adjustTime1(){
        writeProp("Time1", 50L);
        time1=Long.parseLong(Config.read("Time1"));
    }

    @ListenMouseKeyboard(value = 56)
    private static void adjustTime2(){
        writeProp("Time2", 50L);
        time2=Long.parseLong(Config.read("Time2"));
    }




    //基础功能
    //---------------------------------------------------------------
    //各职业



//    @ListenMouseKeyboard(value = 87, immediately = true, intercept = true)
//    private static void f2() {
//        robot.keyPress(KeyEvent.VK_E);
//        robot.keyRelease(KeyEvent.VK_E);
//
//        pause(50);
//
//        robot.keyPress(KeyEvent.VK_W);
//        robot.keyRelease(KeyEvent.VK_W);
//
//        robot.keyPress(KeyEvent.VK_5);
//        robot.keyRelease(KeyEvent.VK_5);
//
//        pause(50);
//
//        robot.keyPress(KeyEvent.VK_Q);
//        robot.keyRelease(KeyEvent.VK_Q);
//
//        pause(50);
//
//        robot.keyPress(KeyEvent.VK_5);
//        robot.keyRelease(KeyEvent.VK_5);
//
//    }


}
