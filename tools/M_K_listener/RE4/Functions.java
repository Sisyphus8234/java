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
    static Thread t1;

    static {

        t1=new CreateThread() {
            @Override
            public void myFunction() {
                while (true) {
                    if (temp1 == true) {

                        robot.keyPress(KeyEvent.VK_F);
                        pause(10);
                        robot.keyRelease(KeyEvent.VK_F);
                        pause(120);
                    }
                    else{
                        t1.suspend();
                    }
                }
            }
        }.thread;
list.add(t1);
    }

    @ListenMouseKeyboard(value = 523)
    private static void 侧键() {
        temp1 = true;
        t1.resume();
    }

    @ListenMouseKeyboard(value = 70)
    @ListenMouseKeyboard(value = 86)
    @ListenMouseKeyboard(value = 9)
    @ListenMouseKeyboard(value = 27)
    private static void f() {
        temp1 = false;
    }




}
