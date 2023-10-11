import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Functions extends IFunctions {

    @ListenBar(off = false)
    public static int on = 36;

    @ListenBar
    public static int off = 35;
    @ListenBar(threadList = true)
    public static List<Thread> list=new ArrayList<>();

    static Boolean temp1=false;
    static Boolean temp2=false;
    static Boolean temp3=false;
    static Thread t1;
    static Thread t2;

    static {
        t1=new CreateThread() {
            @Override
            public void myFunction() {
                while (true) {
                    if (temp1 == true) {

                        robot.keyPress(KeyEvent.VK_F);
                        pause(10);
                        robot.keyRelease(KeyEvent.VK_F);
                        pause(110);
                    }
                    else{
                        t1.suspend();
                    }
                }
            }
        }.thread;

        t2=new CreateThread() {
            @Override
            public void myFunction() {
                while (true) {
                    if (temp2 == true) {
                        robot.mousePress(MouseEvent.BUTTON1_MASK);
                        pause(120);
                        robot.mouseRelease(MouseEvent.BUTTON1_MASK);
                        pause(10);
                    }
                    else{
                        t2.suspend();
                    }
                }
            }
        }.thread;




        list.add(t1);
        list.add(t2);
    }

    @ListenMouseKeyboard(value = 523)
    private static void 侧键() {
        temp1 = true;
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_SHIFT);
        t1.resume();
    }

    @ListenMouseKeyboard(value = 70)
    @ListenMouseKeyboard(value = 86)
    @ListenMouseKeyboard(value = 9)
    @ListenMouseKeyboard(value = 27)
    private static void f() {
        temp1 = false;
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    @ListenMouseKeyboard(value = 513)
    private static void 左键连点() {
        if(temp3==true){
        temp2 = true;
        t2.resume();}
    }

    @ListenMouseKeyboard(value = 514)
    private static void 左键连点1() {
        temp2 = false;
    }


    @ListenMouseKeyboard(value = 187)
    private static void 连点开关() {
        temp3 = true;
    }

    @ListenMouseKeyboard(value = 189)
    private static void 连点开关1() {
        temp3 = false;
    }

}
